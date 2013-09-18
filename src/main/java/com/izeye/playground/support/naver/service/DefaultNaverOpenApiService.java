package com.izeye.playground.support.naver.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.izeye.playground.support.naver.domain.NaverSearchRank;
import com.izeye.playground.support.naver.domain.NaverSearchRankStatus;
import com.izeye.playground.support.naver.domain.NaverSearchRankType;

@Service("naverOpenApiService")
public class DefaultNaverOpenApiService implements NaverOpenApiService {

	private static final String NAVER_SEARCH_RANK_API_URL_PREFIX = "http://openapi.naver.com/search?";

	private static final String PARAM_KEY = "key";
	private static final String PARAM_TARGET = "target";
	private static final String PARAM_QUERY = "query";

	private static final String ELEMENT_ITEM = "item";
	private static final String ELEMENT_KEYWORD = "K";
	private static final String ELEMENT_STATUS = "S";
	private static final String ELEMENT_VARIANCE = "V";

	@Value("${naver.search.rank.api.key}")
	private String searchRankApiKey;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List<NaverSearchRank> getSearchRanks(NaverSearchRankType type) {
		List<NaverSearchRank> ranks = new ArrayList<NaverSearchRank>();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_KEY, searchRankApiKey);
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
				String keyword = child.getChild(ELEMENT_KEYWORD).getText();
				String status = child.getChild(ELEMENT_STATUS).getText();
				String variance = child.getChild(ELEMENT_VARIANCE).getText();
				NaverSearchRank rank = new NaverSearchRank(i + 1, keyword,
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

}
