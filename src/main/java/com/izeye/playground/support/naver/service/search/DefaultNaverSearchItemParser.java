package com.izeye.playground.support.naver.service.search;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.BaseNaverSearchItem;

@Service("defaultNaverSearchItemParser")
public class DefaultNaverSearchItemParser extends
		AbstractNaverSearchItemParser<BaseNaverSearchItem> {

	@Override
	protected void parseSpecific(Element itemElement, BaseNaverSearchItem item) {
	}

}
