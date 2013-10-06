package com.izeye.playground.support.naver.service.search.encyclopedia;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.encyclopedia.NaverSearchEncyclopediaItem;
import com.izeye.playground.support.naver.domain.search.encyclopedia.NaverSearchEncyclopediaResponse;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchResponseParser;

@Service("naverSearchEncyclopediaResponseParser")
public class NaverSearchEncyclopediaResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchEncyclopediaResponse> {

	@Resource
	private NaverSearchEncyclopediaItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchEncyclopediaResponse response) {
		List<NaverSearchEncyclopediaItem> items = new ArrayList<NaverSearchEncyclopediaItem>();
		for (Element itemElement : itemElements) {
			NaverSearchEncyclopediaItem item = new NaverSearchEncyclopediaItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
