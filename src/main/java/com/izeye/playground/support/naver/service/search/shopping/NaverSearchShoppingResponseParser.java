package com.izeye.playground.support.naver.service.search.shopping;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.shopping.NaverSearchShoppingItem;
import com.izeye.playground.support.naver.domain.search.shopping.NaverSearchShoppingResponse;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchResponseParser;

@Service("naverSearchShoppingResponseParser")
public class NaverSearchShoppingResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchShoppingResponse> {

	@Resource
	private NaverSearchShoppingItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchShoppingResponse response) {
		List<NaverSearchShoppingItem> items = new ArrayList<NaverSearchShoppingItem>();
		for (Element itemElement : itemElements) {
			NaverSearchShoppingItem item = new NaverSearchShoppingItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
