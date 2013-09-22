package com.izeye.playground.support.naver.domain.search.blog;

import java.util.Date;
import java.util.List;

public class NaverSearchBlogResponse {

	private final Date lastBuildDate;
	private final int total;

	// NOTE:
	// Redundant with request.
	private final int start;
	private final int display;

	private final List<NaverSearchBlogItem> items;

	public NaverSearchBlogResponse(Date lastBuildDate, int total, int start,
			int display, List<NaverSearchBlogItem> items) {
		this.lastBuildDate = lastBuildDate;
		this.total = total;
		this.start = start;
		this.display = display;
		this.items = items;
	}

	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	public int getTotal() {
		return total;
	}

	public int getStart() {
		return start;
	}

	public int getDisplay() {
		return display;
	}

	public List<NaverSearchBlogItem> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "NaverSearchBlogResponse [lastBuildDate=" + lastBuildDate
				+ ", total=" + total + ", start=" + start + ", display="
				+ display + ", items=" + items + "]";
	}

}
