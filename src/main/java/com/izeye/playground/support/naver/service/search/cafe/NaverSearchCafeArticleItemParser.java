package com.izeye.playground.support.naver.service.search.cafe;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_CAFE_NAME;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_CAFE_URL;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeArticleItem;
import com.izeye.playground.support.naver.service.AbstractNaverSearchItemParser;

@Service("naverSearchCafeArticleItemParser")
public class NaverSearchCafeArticleItemParser extends
		AbstractNaverSearchItemParser<NaverSearchCafeArticleItem> {

	@Override
	protected void parseSpecific(Element itemElement,
			NaverSearchCafeArticleItem item) {
		String cafeName = itemElement.getChildText(ELEMENT_CAFE_NAME);
		String cafeUrl = itemElement.getChildText(ELEMENT_CAFE_URL);

		item.setCafeName(cafeName);
		item.setCafeUrl(cafeUrl);
	}

}
