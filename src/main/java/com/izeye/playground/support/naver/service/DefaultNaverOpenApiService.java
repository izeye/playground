package com.izeye.playground.support.naver.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogItem;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogRequest;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankStatus;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;

@Service("naverOpenApiService")
public class DefaultNaverOpenApiService implements NaverOpenApiService {

	private static final String NAVER_SEARCH_RANK_API_URL_PREFIX = "http://openapi.naver.com/search?";

	private static final String PARAM_KEY = "key";
	private static final String PARAM_TARGET = "target";
	private static final String PARAM_QUERY = "query";

	private static final String PARAM_DISPLAY = "display";
	private static final String PARAM_START = "start";
	private static final String PARAM_SORT = "sort";

	private static final String TARGET_BLOG = "blog";

	private static final String ELEMENT_ITEM = "item";
	private static final String ELEMENT_K = "K";
	private static final String ELEMENT_S = "S";
	private static final String ELEMENT_V = "V";

	private static final String ELEMENT_CHANNEL = "channel";
	private static final String ELEMENT_LAST_BUILD_DATE = "lastBuildDate";
	private static final String ELEMENT_TOTAL = "total";
	private static final String ELEMENT_START = "start";
	private static final String ELEMENT_DISPLAY = "display";
	private static final String ELEMENT_TITLE = "title";
	private static final String ELEMENT_LINK = "link";
	private static final String ELEMENT_DESCRIPTION = "description";
	private static final String ELEMENT_BLOGGER_NAME = "bloggername";
	private static final String ELEMENT_BLOGGER_LINK = "bloggerlink";

	@Value("${naver.search.api.key}")
	private String searchApiKey;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List<NaverSearchRankItem> getSearchRanks(NaverSearchRankType type) {
		List<NaverSearchRankItem> ranks = new ArrayList<NaverSearchRankItem>();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_KEY, searchApiKey);
		params.put(PARAM_TARGET, type.getTarget());
		params.put(PARAM_QUERY, type.getQuery());

		String apiUrl = UrlUtils.createUrl(NAVER_SEARCH_RANK_API_URL_PREFIX,
				params);
		log.debug(apiUrl);
		InputStream is = null;
		try {
			is = HttpUtils.urlToInputStream(apiUrl);
			Element root = JDOMUtils.inputStreamToRootElement(is);
			Element item = root.getChild(ELEMENT_ITEM);
			@SuppressWarnings("unchecked")
			List<Element> children = item.getChildren();
			for (int i = 0; i < children.size(); i++) {
				Element child = children.get(i);
				String keyword = child.getChildText(ELEMENT_K);
				String status = child.getChildText(ELEMENT_S);
				String variance = child.getChildText(ELEMENT_V);
				NaverSearchRankItem rank = new NaverSearchRankItem(i + 1,
						keyword,
						NaverSearchRankStatus.getStatusByValue(status),
						Integer.parseInt(variance));
				ranks.add(rank);
			}
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
		return ranks;
	}

	@Override
	public NaverSearchBlogResponse search(NaverSearchBlogRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_KEY, searchApiKey);
		params.put(PARAM_TARGET, TARGET_BLOG);
		params.put(PARAM_QUERY, request.getQuery());
		params.put(PARAM_DISPLAY, request.getDisplay());
		params.put(PARAM_START, request.getStart());
		params.put(PARAM_SORT, request.getSort());

		String apiUrl = UrlUtils.createUrl(NAVER_SEARCH_RANK_API_URL_PREFIX,
				params);
		log.debug(apiUrl);

		Date lastBuildDate;
		int total;
		int start;
		int display;
		List<NaverSearchBlogItem> items = new ArrayList<NaverSearchBlogItem>();

		InputStream is = null;
		try {
			is = HttpUtils.urlToInputStream(apiUrl);
			Element root = JDOMUtils.inputStreamToRootElement(is);
			Element channel = root.getChild(ELEMENT_CHANNEL);
			lastBuildDate = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z",
					Locale.US).parse(channel
					.getChildText(ELEMENT_LAST_BUILD_DATE));
			total = Integer.parseInt(channel.getChildText(ELEMENT_TOTAL));
			start = Integer.parseInt(channel.getChildText(ELEMENT_START));
			display = Integer.parseInt(channel.getChildText(ELEMENT_DISPLAY));
			@SuppressWarnings("unchecked")
			List<Element> itemElements = channel.getChildren(ELEMENT_ITEM);
			for (int i = 0; i < itemElements.size(); i++) {
				Element itemElement = itemElements.get(i);
				String title = itemElement.getChildText(ELEMENT_TITLE);
				String link = itemElement.getChildText(ELEMENT_LINK);
				String description = itemElement
						.getChildText(ELEMENT_DESCRIPTION);
				String bloggerName = itemElement
						.getChildText(ELEMENT_BLOGGER_NAME);
				String bloggerLink = itemElement
						.getChildText(ELEMENT_BLOGGER_LINK);
				items.add(new NaverSearchBlogItem(title, link, description,
						bloggerName, bloggerLink));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new NaverOpenApiFailException(e);
		} catch (JDOMException e) {
			e.printStackTrace();
			throw new NaverOpenApiFailException(e);
		} catch (ParseException e) {
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

		return new NaverSearchBlogResponse(lastBuildDate, total, start,
				display, items);
	}

}
