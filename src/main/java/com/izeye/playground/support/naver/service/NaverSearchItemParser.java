package com.izeye.playground.support.naver.service;

import org.jdom.Element;

import com.izeye.playground.support.naver.domain.search.NaverSearchItem;

public interface NaverSearchItemParser<T extends NaverSearchItem> {

	void parse(Element itemElement, T item);

}
