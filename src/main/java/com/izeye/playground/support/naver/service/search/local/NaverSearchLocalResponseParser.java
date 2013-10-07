package com.izeye.playground.support.naver.service.search.local;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.local.NaverSearchLocalItem;
import com.izeye.playground.support.naver.domain.search.local.NaverSearchLocalResponse;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchResponseParser;

@Service("naverSearchLocalResponseParser")
public class NaverSearchLocalResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchLocalResponse> {

	@Resource
	private NaverSearchLocalItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchLocalResponse response) {
		List<NaverSearchLocalItem> items = new ArrayList<NaverSearchLocalItem>();
		for (Element itemElement : itemElements) {
			NaverSearchLocalItem item = new NaverSearchLocalItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
