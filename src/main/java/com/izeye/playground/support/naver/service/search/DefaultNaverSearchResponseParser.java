package com.izeye.playground.support.naver.service.search;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.BaseNaverSearchItem;
import com.izeye.playground.support.naver.domain.search.DefaultNaverSearchResponse;

@Service("defaultNaverSearchResponseParser")
public class DefaultNaverSearchResponseParser extends
		AbstractNaverSearchResponseParser<DefaultNaverSearchResponse> {

	@Resource
	private DefaultNaverSearchItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			DefaultNaverSearchResponse response) {
		List<BaseNaverSearchItem> items = new ArrayList<BaseNaverSearchItem>();
		for (Element itemElement : itemElements) {
			BaseNaverSearchItem item = new BaseNaverSearchItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
