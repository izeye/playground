package com.izeye.playground.support.naver.service.search.blog;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_BLOGGER_LINK;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_BLOGGER_NAME;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogItem;
import com.izeye.playground.support.naver.service.AbstractNaverSearchItemParser;

@Service("naverSearchBlogItemParser")
public class NaverSearchBlogItemParser extends
		AbstractNaverSearchItemParser<NaverSearchBlogItem> {

	@Override
	protected void parseSpecific(Element itemElement, NaverSearchBlogItem item) {
		String bloggerName = itemElement.getChildText(ELEMENT_BLOGGER_NAME);
		String bloggerLink = itemElement.getChildText(ELEMENT_BLOGGER_LINK);

		item.setBloggerName(bloggerName);
		item.setBloggerLink(bloggerLink);
	}

}
