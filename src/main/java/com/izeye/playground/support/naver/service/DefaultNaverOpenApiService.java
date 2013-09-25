package com.izeye.playground.support.naver.service;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_ITEM;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_K;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_S;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_V;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.TARGET_RECOMMENDATION;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.izeye.playground.common.util.HttpUtils;
import com.izeye.playground.common.util.JDOMUtils;
import com.izeye.playground.common.util.UrlUtils;
import com.izeye.playground.support.naver.domain.NaverOpenApiFailException;
import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.NaverSearchResponseCallback;
import com.izeye.playground.support.naver.domain.search.NaverSearchSortType;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeResponse;
import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankStatus;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;
import com.izeye.playground.support.naver.service.search.blog.NaverSearchBlogResponseParser;
import com.izeye.playground.support.naver.service.search.book.NaverSearchBookResponseParser;
import com.izeye.playground.support.naver.service.search.cafe.NaverSearchCafeResponseParser;
import com.izeye.playground.support.naver.service.search.news.NaverSearchNewsResponseParser;

@Service("naverOpenApiService")
public class DefaultNaverOpenApiService implements NaverOpenApiService {

	private static final String NAVER_SEARCH_RANK_API_URL_PREFIX = "http://openapi.naver.com/search?";

	private static final String PARAM_KEY = "key";
	private static final String PARAM_TARGET = "target";
	private static final String PARAM_QUERY = "query";

	private static final String PARAM_DISPLAY = "display";
	private static final String PARAM_START = "start";
	private static final String PARAM_SORT = "sort";

	@Value("${naver.search.api.key}")
	private String searchApiKey;

	@Resource
	private NaverSearchBlogResponseParser blogResponseParser;

	@Resource
	private NaverSearchNewsResponseParser newsResponseParser;

	@Resource
	private NaverSearchBookResponseParser bookResponseParser;

	@Resource
	private NaverSearchCafeResponseParser cafeResponseParser;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List<NaverSearchRankItem> getSearchRanks(NaverSearchRankType type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_KEY, searchApiKey);
		params.put(PARAM_TARGET, type.getTarget());
		params.put(PARAM_QUERY, type.getQuery());

		String apiUrl = UrlUtils.createUrl(NAVER_SEARCH_RANK_API_URL_PREFIX,
				params);
		log.debug(apiUrl);

		final List<NaverSearchRankItem> ranks = new ArrayList<NaverSearchRankItem>();
		search(apiUrl, new NaverSearchResponseCallback() {
			@Override
			public void callback(Element root) {
				Element item = root.getChild(ELEMENT_ITEM);
				@SuppressWarnings("unchecked")
				List<Element> children = item.getChildren();
				for (int i = 0; i < children.size(); i++) {
					Element child = children.get(i);
					String keyword = child.getChildText(ELEMENT_K);
					String status = child.getChildText(ELEMENT_S);
					String variance = child.getChildText(ELEMENT_V);
					NaverSearchRankItem rank = new NaverSearchRankItem(i + 1,
							keyword, NaverSearchRankStatus
									.getStatusByValue(status), Integer
									.parseInt(variance));
					ranks.add(rank);
				}
			}
		});
		return ranks;
	}

	@Override
	public NaverSearchBlogResponse searchBlog(NaverSearchRequest request) {
		final NaverSearchBlogResponse response = new NaverSearchBlogResponse();
		search(request, new NaverSearchResponseCallback() {
			@Override
			public void callback(Element root) {
				blogResponseParser.parse(root, response);
			}
		});
		return response;
	}

	@Override
	public NaverSearchNewsResponse searchNews(NaverSearchRequest request) {
		final NaverSearchNewsResponse response = new NaverSearchNewsResponse();
		search(request, new NaverSearchResponseCallback() {
			@Override
			public void callback(Element root) {
				newsResponseParser.parse(root, response);
			}
		});
		return response;
	}

	@Override
	public NaverSearchBookResponse searchBook(NaverSearchRequest request) {
		final NaverSearchBookResponse response = new NaverSearchBookResponse();
		search(request, new NaverSearchResponseCallback() {
			@Override
			public void callback(Element root) {
				bookResponseParser.parse(root, response);
			}
		});
		return response;
	}

	@Override
	public List<String> getSearchRecommendations(String query) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_KEY, searchApiKey);
		params.put(PARAM_TARGET, TARGET_RECOMMENDATION);
		params.put(PARAM_QUERY, query);

		String apiUrl = UrlUtils.createUrl(NAVER_SEARCH_RANK_API_URL_PREFIX,
				params);
		log.debug(apiUrl);

		final List<String> searchRecommendations = new ArrayList<String>();
		search(apiUrl, new NaverSearchResponseCallback() {
			@Override
			public void callback(Element root) {
				@SuppressWarnings("unchecked")
				List<Element> itemElements = root.getChildren(ELEMENT_ITEM);
				for (Element itemElement : itemElements) {
					searchRecommendations.add(itemElement.getText());
				}
			}
		});
		return searchRecommendations;
	}

	@Override
	public NaverSearchCafeResponse searchCafe(NaverSearchRequest request) {
		final NaverSearchCafeResponse response = new NaverSearchCafeResponse();
		search(request, new NaverSearchResponseCallback() {
			@Override
			public void callback(Element root) {
				cafeResponseParser.parse(root, response);
			}
		});
		return response;
	}

	private void search(NaverSearchRequest request,
			NaverSearchResponseCallback callback) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_KEY, searchApiKey);
		params.put(PARAM_TARGET, request.getSearchType().getTarget());
		params.put(PARAM_QUERY, request.getQuery());
		params.put(PARAM_DISPLAY, request.getDisplay());
		params.put(PARAM_START, request.getStart());
		NaverSearchSortType sortType = request.getSortType();
		if (sortType != NaverSearchSortType.NOT_AVAILABLE) {
			params.put(PARAM_SORT, sortType.getValue());
		}

		String apiUrl = UrlUtils.createUrl(NAVER_SEARCH_RANK_API_URL_PREFIX,
				params);
		log.debug(apiUrl);

		search(apiUrl, callback);
	}

	private void search(String apiUrl, NaverSearchResponseCallback callback) {
		InputStream is = null;
		try {
			is = HttpUtils.urlToInputStream(apiUrl);
			Element root = JDOMUtils.inputStreamToRootElement(is);
			callback.callback(root);
		} catch (IOException e) {
			e.printStackTrace();
			throw new NaverOpenApiFailException(e);
		} catch (JDOMException e) {
			e.printStackTrace();
			throw new NaverOpenApiFailException(e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
