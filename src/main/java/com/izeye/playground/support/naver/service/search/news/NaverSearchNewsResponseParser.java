package com.izeye.playground.support.naver.service.search.news;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsItem;
import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsResponse;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchResponseParser;

@Service("naverSearchNewsResponseParser")
public class NaverSearchNewsResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchNewsResponse> {

	@Resource
	private NaverSearchNewsItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchNewsResponse response) {
		List<NaverSearchNewsItem> items = new ArrayList<NaverSearchNewsItem>();
		for (Element itemElement : itemElements) {
			NaverSearchNewsItem item = new NaverSearchNewsItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
