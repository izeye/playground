package com.izeye.playground.support.naver.domain.search.blog;

import com.izeye.playground.common.util.UrlUtils;

public class NaverSearchBlogItem {

	private static final String HTTP_PREFIX = "http://";

	private final String title;
	private final String link;
	private final String description;
	private final String bloggerName;
	private final String bloggerLink;

	public NaverSearchBlogItem(String title, String link, String description,
			String bloggerName, String bloggerLink) {
		this.title = title;
		this.link = link;
		this.description = description;
		this.bloggerName = bloggerName;
		this.bloggerLink = bloggerLink;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getRedirectedLink() {
		return UrlUtils.getRedirectedUrl(link);
	}

	public String getDescription() {
		return description;
	}

	public String getBloggerName() {
		return bloggerName;
	}

	public String getBloggerLink() {
		return bloggerLink.startsWith(HTTP_PREFIX) ? bloggerLink : HTTP_PREFIX
				+ bloggerLink;
	}

	@Override
	public String toString() {
		return "NaverSearchBlogItem [title=" + title + ", link=" + link
				+ ", description=" + description + ", bloggerName="
				+ bloggerName + ", bloggerLink=" + bloggerLink + "]";
	}

}
