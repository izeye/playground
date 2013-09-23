package com.izeye.playground.support.naver.service;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_DESCRIPTION;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_LINK;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_TITLE;

import org.jdom.Element;

import com.izeye.playground.support.naver.domain.search.NaverSearchItem;

public abstract class AbstractNaverSearchItemParser<T extends NaverSearchItem>
		implements NaverSearchItemParser<T> {

	@Override
	public void parse(Element itemElement, T item) {
		String title = itemElement.getChildText(ELEMENT_TITLE);
		String link = itemElement.getChildText(ELEMENT_LINK);
		String description = itemElement.getChildText(ELEMENT_DESCRIPTION);

		item.setTitle(title);
		item.setLink(link);
		item.setDescription(description);

		parseSpecific(itemElement, item);
	}

	protected abstract void parseSpecific(Element itemElement, T item);

}
