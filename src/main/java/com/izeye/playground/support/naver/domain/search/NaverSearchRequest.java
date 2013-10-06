package com.izeye.playground.support.naver.domain.search;

public class NaverSearchRequest {

	private final NaverSearchType searchType;
	private final String query;
	private final Integer display;
	private final Integer start;
	private final NaverSearchSortType sortType;

	public NaverSearchRequest(NaverSearchType searchType, String query,
			Integer display, Integer start, NaverSearchSortType sortType) {
		this.searchType = searchType;
		this.query = query;
		this.display = display;
		this.start = start;
		this.sortType = sortType;
	}

	public NaverSearchRequest(NaverSearchType searchType, String query,
			Integer display, Integer start) {
		this(searchType, query, display, start, searchType.getDefaultSortType());
	}

	public NaverSearchRequest(NaverSearchType searchType, String query) {
		this(searchType, query, null, null);
	}

	public NaverSearchType getSearchType() {
		return searchType;
	}

	public String getQuery() {
		return query;
	}

	public Integer getDisplay() {
		return display;
	}

	public Integer getStart() {
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
