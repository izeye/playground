package com.izeye.playground.support.naver.domain.search.news;

import java.util.Date;

import com.izeye.playground.support.naver.domain.search.BaseNaverSearchItem;

public class NaverSearchNewsItem extends BaseNaverSearchItem {

	private String originalLink;
	private Date publishedDate;

	public String getOriginalLink() {
		return originalLink;
	}

	public void setOriginalLink(String originalLink) {
		this.originalLink = originalLink;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "NaverSearchNewsItem [originalLink=" + originalLink
				+ ", publishedDate=" + publishedDate + ", toString()="
				+ super.toString() + "]";
	}

}
