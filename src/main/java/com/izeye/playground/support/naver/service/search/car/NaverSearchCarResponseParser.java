package com.izeye.playground.support.naver.service.search.car;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarItem;
import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarResponse;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchResponseParser;

@Service("naverSearchCarResponseParser")
public class NaverSearchCarResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchCarResponse> {

	@Resource
	private NaverSearchCarItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchCarResponse response) {
		List<NaverSearchCarItem> items = new ArrayList<NaverSearchCarItem>();
		for (Element itemElement : itemElements) {
			NaverSearchCarItem item = new NaverSearchCarItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
