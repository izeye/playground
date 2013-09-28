package com.izeye.playground.support.naver.service.search.movie;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieItem;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieResponse;
import com.izeye.playground.support.naver.service.AbstractNaverSearchResponseParser;

@Service("naverSearchMovieResponseParser")
public class NaverSearchMovieResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchMovieResponse> {

	@Resource
	private NaverSearchMovieItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchMovieResponse response) {
		List<NaverSearchMovieItem> items = new ArrayList<NaverSearchMovieItem>();
		for (Element itemElement : itemElements) {
			NaverSearchMovieItem item = new NaverSearchMovieItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
