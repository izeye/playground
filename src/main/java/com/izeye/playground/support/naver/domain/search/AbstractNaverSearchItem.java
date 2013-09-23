package com.izeye.playground.support.naver.domain.search;

import com.izeye.playground.common.util.UrlUtils;

public abstract class AbstractNaverSearchItem implements NaverSearchItem {

	private String title;
	private String link;
	private String description;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getLink() {
		return link;
	}

	@Override
	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String getRedirectedLink() {
		return UrlUtils.getRedirectedUrl(link);
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AbstractNaverSearchItem [title=" + title + ", link=" + link
				+ ", description=" + description + "]";
	}

}
