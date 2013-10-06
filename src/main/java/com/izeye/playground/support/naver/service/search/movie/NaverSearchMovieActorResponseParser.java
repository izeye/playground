package com.izeye.playground.support.naver.service.search.movie;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieActorItem;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieActorResponse;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchResponseParser;

@Service("naverSearchMovieActorResponseParser")
public class NaverSearchMovieActorResponseParser extends
		AbstractNaverSearchResponseParser<NaverSearchMovieActorResponse> {

	@Resource
	private NaverSearchMovieActorItemParser itemParser;

	@Override
	protected void parseItems(List<Element> itemElements,
			NaverSearchMovieActorResponse response) {
		List<NaverSearchMovieActorItem> items = new ArrayList<NaverSearchMovieActorItem>();
		for (Element itemElement : itemElements) {
			NaverSearchMovieActorItem item = new NaverSearchMovieActorItem();
			itemParser.parse(itemElement, item);
			items.add(item);
		}
		response.setItems(items);
	}

}
