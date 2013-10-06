package com.izeye.playground.support.naver.service.search.book;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookItem;
import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookResponse;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchResponseParser;

@Service("naverSearchBookResponseParser")
public class NaverSearchBookResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchBookResponse> {

	@Resource
	private NaverSearchBookItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchBookResponse response) {
		List<NaverSearchBookItem> items = new ArrayList<NaverSearchBookItem>();
		for (Element itemElement : itemElements) {
			NaverSearchBookItem item = new NaverSearchBookItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
