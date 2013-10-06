package com.izeye.playground.support.naver.service.search.news;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_NEWS_PUBLISHED_DATE;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_ORIGINAL_LINK;

import java.util.Date;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsItem;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchItemParser;
import com.izeye.playground.support.naver.util.NaverDateUtils;

@Service("naverSearchNewsItemParser")
public class NaverSearchNewsItemParser extends
		AbstractNaverSearchItemParser<NaverSearchNewsItem> {

	@Override
	protected void parseSpecific(Element itemElement, NaverSearchNewsItem item) {
		String originalLink = itemElement.getChildText(ELEMENT_ORIGINAL_LINK);
		Date publishedDate = NaverDateUtils.parseDateTime(itemElement
				.getChildText(ELEMENT_NEWS_PUBLISHED_DATE));

		item.setOriginalLink(originalLink);
		item.setPublishedDate(publishedDate);
	}

}
