package com.izeye.playground.support.naver.domain.search.blog;

import com.izeye.playground.support.naver.domain.search.AbstractNaverSearchItem;

public class NaverSearchBlogItem extends AbstractNaverSearchItem {

	private static final String HTTP_PREFIX = "http://";

	private String bloggerName;
	private String bloggerLink;

	public String getBloggerName() {
		return bloggerName;
	}

	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}

	public String getBloggerLink() {
		return bloggerLink.startsWith(HTTP_PREFIX) ? bloggerLink : HTTP_PREFIX
				+ bloggerLink;
	}

	public void setBloggerLink(String bloggerLink) {
		this.bloggerLink = bloggerLink;
	}

	@Override
	public String toString() {
		return "NaverSearchBlogItem [bloggerName=" + bloggerName
				+ ", bloggerLink=" + bloggerLink + ", toString()="
				+ super.toString() + "]";
	}

}
