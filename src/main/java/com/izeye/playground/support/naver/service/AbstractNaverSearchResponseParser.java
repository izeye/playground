package com.izeye.playground.support.naver.service;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_CHANNEL;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_DISPLAY;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_ITEM;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_LAST_BUILD_DATE;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_START;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_TOTAL;

import java.util.Date;
import java.util.List;

import org.jdom.Element;

import com.izeye.playground.support.naver.domain.search.NaverSearchResponse;
import com.izeye.playground.support.naver.util.NaverDateUtils;

public abstract class AbstractNaverSearchResponseParser<T extends NaverSearchResponse<?>>
		implements NaverSearchResponseParser<T> {

	@Override
	public void parse(Element root, T response) {
		Element channel = root.getChild(ELEMENT_CHANNEL);
		Date lastBuildDate = NaverDateUtils.parseDateTime(channel
				.getChildText(ELEMENT_LAST_BUILD_DATE));
		int total = Integer.parseInt(channel.getChildText(ELEMENT_TOTAL));
		int start = Integer.parseInt(channel.getChildText(ELEMENT_START));
		int display = Integer.parseInt(channel.getChildText(ELEMENT_DISPLAY));

		response.setLastBuildDate(lastBuildDate);
		response.setTotal(total);
		response.setStart(start);
		response.setDisplay(display);

		@SuppressWarnings("unchecked")
		List<Element> itemElements = channel.getChildren(ELEMENT_ITEM);

		parseItems(itemElements, response);
	}

	protected abstract void parseItems(List<Element> itemElements, T response);

}
