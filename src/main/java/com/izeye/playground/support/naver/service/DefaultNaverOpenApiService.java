package com.izeye.playground.support.naver.service;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.*;

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
import com.izeye.playground.support.naver.domain.search.encyclopedia.NaverSearchEncyclopediaResponse;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieRequest;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieResponse;
import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankStatus;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;
import com.izeye.playground.support.naver.service.search.blog.NaverSearchBlogResponseParser;
import com.izeye.playground.support.naver.service.search.book.NaverSearchBookResponseParser;
import com.izeye.playground.support.naver.service.search.cafe.NaverSearchCafeResponseParser;
import com.izeye.playground.support.naver.service.search.encyclopedia.NaverSearchEncyclopediaResponseParser;
import com.izeye.playground.support.naver.service.search.movie.NaverSearchMovieResponseParser;
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

	@Resource
	private NaverSearchEncyclopediaResponseParser encyclopediaResponseParser;

	@Resource
	private NaverSearchMovieResponseParser movieResponseParser;

	private final Logger log = LoggerFactory.getLogger(getClass());

	// FIXME:
	// How can I remove these warnings?
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<NaverSearchRankItem> getSearchRanks(NaverSearchRankType type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_KEY, searchApiKey);
		params.put(PARAM_TARGET, type.getTarget());
		params.put(PARAM_QUERY, type.getQuery());

		String apiUrl = UrlUtils.createUrl(NAVER_SEARCH_RANK_API_URL_PREFIX,
				params);
		log.debug(apiUrl);

		return search(apiUrl, new NaverSearchResponseCallback<List>() {
			@Override
			public List<NaverSearchRankItem> callback(Element root) {
				List<NaverSearchRankItem> ranks = new ArrayList<NaverSearchRankItem>();

				Element item = root.getChild(ELEMENT_ITEM);
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
				return ranks;
			}
		}, List.class);
	}

	@Override
	public NaverSearchBlogResponse searchBlog(NaverSearchRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchBlogResponse>() {
					@Override
					public NaverSearchBlogResponse callback(Element root) {
						NaverSearchBlogResponse response = new NaverSearchBlogResponse();
						blogResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchBlogResponse.class);
	}

	@Override
	public NaverSearchNewsResponse searchNews(NaverSearchRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchNewsResponse>() {
					@Override
					public NaverSearchNewsResponse callback(Element root) {
						NaverSearchNewsResponse response = new NaverSearchNewsResponse();
						newsResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchNewsResponse.class);
	}

	@Override
	public NaverSearchBookResponse searchBook(NaverSearchRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchBookResponse>() {
					@Override
					public NaverSearchBookResponse callback(Element root) {
						NaverSearchBookResponse response = new NaverSearchBookResponse();
						bookResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchBookResponse.class);
	}

	// FIXME:
	// How can I remove these warnings?
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<String> getSearchRecommendations(String query) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_KEY, searchApiKey);
		params.put(PARAM_TARGET, TARGET_RECOMMENDATION);
		params.put(PARAM_QUERY, query);

		String apiUrl = UrlUtils.createUrl(NAVER_SEARCH_RANK_API_URL_PREFIX,
				params);
		log.debug(apiUrl);

		return search(apiUrl, new NaverSearchResponseCallback<List>() {
			@Override
			public List<String> callback(Element root) {
				List<String> searchRecommendations = new ArrayList<String>();

				List<Element> itemElements = root.getChildren(ELEMENT_ITEM);
				for (Element itemElement : itemElements) {
					searchRecommendations.add(itemElement.getText());
				}
				return searchRecommendations;
			}
		}, List.class);
	}

	@Override
	public NaverSearchCafeResponse searchCafe(NaverSearchRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchCafeResponse>() {
					@Override
					public NaverSearchCafeResponse callback(Element root) {
						NaverSearchCafeResponse response = new NaverSearchCafeResponse();
						cafeResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchCafeResponse.class);
	}

	@Override
	public boolean checkForAdults(String query) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_KEY, searchApiKey);
		params.put(PARAM_TARGET, TARGET_ADULT);
		params.put(PARAM_QUERY, query);

		String apiUrl = UrlUtils.createUrl(NAVER_SEARCH_RANK_API_URL_PREFIX,
				params);
		log.debug(apiUrl);

		return search(apiUrl, new NaverSearchResponseCallback<Boolean>() {
			@Override
			public Boolean callback(Element root) {
				Element itemElement = root.getChild(ELEMENT_ITEM);
				return Integer.parseInt(itemElement.getChildText(ELEMENT_ADULT)) == TRUE_AS_INT;
			}
		}, Boolean.class);
	}

	@Override
	public NaverSearchEncyclopediaResponse searchEncyclopedia(
			NaverSearchRequest request) {
		return search(
				request,
				new NaverSearchResponseCallback<NaverSearchEncyclopediaResponse>() {
					@Override
					public NaverSearchEncyclopediaResponse callback(Element root) {
						NaverSearchEncyclopediaResponse response = new NaverSearchEncyclopediaResponse();
						encyclopediaResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchEncyclopediaResponse.class);
	}

	@Override
	public NaverSearchMovieResponse searchMovie(NaverSearchMovieRequest request) {
		// FIXME:
		// Doesn't handle the movie-specific parameters.
		return search(request,
				new NaverSearchResponseCallback<NaverSearchMovieResponse>() {
					@Override
					public NaverSearchMovieResponse callback(Element root) {
						NaverSearchMovieResponse response = new NaverSearchMovieResponse();
						movieResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchMovieResponse.class);
	}

	private <T> T search(NaverSearchRequest request,
			NaverSearchResponseCallback<T> callback, Class<T> returnType) {
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

		return search(apiUrl, callback, returnType);
	}

	private <T> T search(String apiUrl,
			NaverSearchResponseCallback<T> callback, Class<T> returnType) {
		InputStream is = null;
		try {
			is = HttpUtils.urlToInputStream(apiUrl);
			Element root = JDOMUtils.inputStreamToRootElement(is);
			return returnType.cast(callback.callback(root));
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
