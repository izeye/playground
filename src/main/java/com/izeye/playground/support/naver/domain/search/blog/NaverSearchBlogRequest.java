package com.izeye.playground.support.naver.domain.search.blog;

import static com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogConstants.*;

public class NaverSearchBlogRequest {

	private final String query;
	private final int display;
	private final int start;
	private final String sort;

	public NaverSearchBlogRequest(String query, int display, int start,
			String sort) {
		this.query = query;
		this.display = display;
		this.start = start;
		this.sort = sort;
	}

	public NaverSearchBlogRequest(String query, int display, int start) {
		this(query, display, start, DEFAULT_SORT);
	}

	public NaverSearchBlogRequest(String query) {
		this(query, DEFAULT_DISPLAY, DEFAULT_START, DEFAULT_SORT);
	}

	public String getQuery() {
		return query;
	}

	public int getDisplay() {
		return display;
	}

	public int getStart() {
		return start;
	}

	public String getSort() {
		return sort;
	}

	@Override
	public String toString() {
		return "NaverSearchBlogRequest [query=" + query + ", display="
				+ display + ", start=" + start + ", sort=" + sort + "]";
	}

}
