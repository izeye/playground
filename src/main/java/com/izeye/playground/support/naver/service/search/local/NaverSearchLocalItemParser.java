package com.izeye.playground.support.naver.service.search.local;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_ADDRESS;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_MAP_X;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_MAP_Y;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_TELEPHONE;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.local.NaverSearchLocalItem;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchItemParser;

@Service("naverSearchLocalItemParser")
public class NaverSearchLocalItemParser extends
		AbstractNaverSearchItemParser<NaverSearchLocalItem> {

	@Override
	protected void parseSpecific(Element itemElement, NaverSearchLocalItem item) {
		String telephone = itemElement.getChildText(ELEMENT_TELEPHONE);
		String address = itemElement.getChildText(ELEMENT_ADDRESS);
		int mapX = Integer.parseInt(itemElement.getChildText(ELEMENT_MAP_X));
		int mapY = Integer.parseInt(itemElement.getChildText(ELEMENT_MAP_Y));

		item.setTelephone(telephone);
		item.setAddress(address);
		item.setMapX(mapX);
		item.setMapY(mapY);
	}

}
