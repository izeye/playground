package com.izeye.playground.support.naver.service.search.image;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.*;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.image.NaverSearchImageItem;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchItemParser;

@Service("naverSearchImageItemParser")
public class NaverSearchImageItemParser extends
		AbstractNaverSearchItemParser<NaverSearchImageItem> {

	@Override
	protected void parseSpecific(Element itemElement, NaverSearchImageItem item) {
		String thumbnail = itemElement.getChildText(ELEMENT_THUMBNAIL);
		int sizeHeight = Integer.parseInt(itemElement
				.getChildText(ELEMENT_SIZE_HEIGHT));
		int sizeWidth = Integer.parseInt(itemElement
				.getChildText(ELEMENT_SIZE_WIDTH));

		item.setThumbnail(thumbnail);
		item.setSizeHeight(sizeHeight);
		item.setSizeWidth(sizeWidth);
	}

}
