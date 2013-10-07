package com.izeye.playground.support.naver.service.search.image;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.image.NaverSearchImageItem;
import com.izeye.playground.support.naver.domain.search.image.NaverSearchImageResponse;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchResponseParser;

@Service("naverSearchImageResponseParser")
public class NaverSearchImageResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchImageResponse> {

	@Resource
	private NaverSearchImageItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchImageResponse response) {
		List<NaverSearchImageItem> items = new ArrayList<NaverSearchImageItem>();
		for (Element itemElement : itemElements) {
			NaverSearchImageItem item = new NaverSearchImageItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
