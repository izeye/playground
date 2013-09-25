package com.izeye.playground.support.naver.domain.search;

import org.jdom.Element;

public interface NaverSearchResponseCallback<T> {

	T callback(Element root);

}
