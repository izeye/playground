package com.izeye.playground.support.naver.service.blog;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogItem;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.service.AbstractNaverSearchResponseParser;

@Service("naverSearchBlogResponseParser")
public class NaverSearchBlogResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchBlogResponse> {

	@Resource
	private NaverSearchBlogItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchBlogResponse response) {
		List<NaverSearchBlogItem> items = new ArrayList<NaverSearchBlogItem>();
		for (Element itemElement : itemElements) {
			NaverSearchBlogItem item = new NaverSearchBlogItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
