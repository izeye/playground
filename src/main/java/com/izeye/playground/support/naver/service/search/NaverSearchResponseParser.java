package com.izeye.playground.support.naver.service.search;

import org.jdom.Element;

import com.izeye.playground.support.naver.domain.search.NaverSearchResponse;

public interface NaverSearchResponseParser<T extends NaverSearchResponse<?>> {

	void parse(Element root, T response);

}
