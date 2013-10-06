package com.izeye.playground.support.naver.service.search.cafe;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeArticleItem;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeArticleResponse;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchResponseParser;

@Service("naverSearchCafeArticleResponseParser")
public class NaverSearchCafeArticleResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchCafeArticleResponse> {

	@Resource
	private NaverSearchCafeArticleItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchCafeArticleResponse response) {
		List<NaverSearchCafeArticleItem> items = new ArrayList<NaverSearchCafeArticleItem>();
		for (Element itemElement : itemElements) {
			NaverSearchCafeArticleItem item = new NaverSearchCafeArticleItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
