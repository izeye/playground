package com.izeye.playground.support.naver.service.search.car;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.*;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarItem;
import com.izeye.playground.support.naver.service.AbstractNaverSearchItemParser;

@Service("naverSearchCarItemParser")
public class NaverSearchCarItemParser extends
		AbstractNaverSearchItemParser<NaverSearchCarItem> {

	@Override
	protected void parseSpecific(Element itemElement, NaverSearchCarItem item) {
		String publishedDate = itemElement
				.getChildText(ELEMENT_CAR_PUBLISHED_DATE);
		String maker = itemElement.getChildText(ELEMENT_MAKER);
		String image = itemElement.getChildText(ELEMENT_IMAGE);
		String type = itemElement.getChildText(ELEMENT_TYPE);

		item.setPublishedDate(publishedDate);
		item.setMaker(maker);
		item.setImage(image);
		item.setType(type);
	}

}
