package com.izeye.playground.support.naver.domain.search;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.DEFAULT_DISPLAY;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.DEFAULT_START;

public class NaverSearchRequest {

	private final NaverSearchType searchType;
	private final String query;
	private final int display;
	private final int start;
	private final NaverSearchSortType sortType;

	public NaverSearchRequest(NaverSearchType searchType, String query,
			int display, int start, NaverSearchSortType sortType) {
		this.searchType = searchType;
		this.query = query;
		this.display = display;
		this.start = start;
		this.sortType = sortType;
	}

	public NaverSearchRequest(NaverSearchType searchType, String query,
			int display, int start) {
		this(searchType, query, display, start, searchType.getDefaultSortType());
	}

	public NaverSearchRequest(NaverSearchType searchType, String query) {
		this(searchType, query, DEFAULT_DISPLAY, DEFAULT_START);
	}

	public NaverSearchType getSearchType() {
		return searchType;
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

	public NaverSearchSortType getSortType() {
		return sortType;
	}

	@Override
	public String toString() {
		return "NaverSearchRequest [searchType=" + searchType + ", query="
				+ query + ", display=" + display + ", start=" + start
				+ ", sortType=" + sortType + "]";
	}

}
