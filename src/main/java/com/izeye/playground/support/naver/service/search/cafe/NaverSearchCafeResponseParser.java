package com.izeye.playground.support.naver.service.search.cafe;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeItem;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeResponse;
import com.izeye.playground.support.naver.service.AbstractNaverSearchResponseParser;

@Service("naverSearchCafeResponseParser")
public class NaverSearchCafeResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchCafeResponse> {

	@Resource
	private NaverSearchCafeItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchCafeResponse response) {
		List<NaverSearchCafeItem> items = new ArrayList<NaverSearchCafeItem>();
		for (Element itemElement : itemElements) {
			NaverSearchCafeItem item = new NaverSearchCafeItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
