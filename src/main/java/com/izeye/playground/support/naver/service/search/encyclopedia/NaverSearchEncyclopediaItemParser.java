package com.izeye.playground.support.naver.service.search.encyclopedia;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.*;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.encyclopedia.NaverSearchEncyclopediaItem;
import com.izeye.playground.support.naver.service.AbstractNaverSearchItemParser;

@Service("naverSearchEncyclopediaItemParser")
public class NaverSearchEncyclopediaItemParser extends
		AbstractNaverSearchItemParser<NaverSearchEncyclopediaItem> {

	@Override
	protected void parseSpecific(Element itemElement,
			NaverSearchEncyclopediaItem item) {
		String thumbnail = itemElement.getChildText(ELEMENT_THUMBNAIL);

		item.setThumbnail(thumbnail);
	}

}
