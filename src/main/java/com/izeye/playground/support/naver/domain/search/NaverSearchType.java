package com.izeye.playground.support.naver.domain.search;

public enum NaverSearchType {

	BLOG("blog", NaverSearchSortType.SIMILARITY), //
	NEWS("news", NaverSearchSortType.DATE), //
	BOOK("book", NaverSearchSortType.NOT_AVAILABLE), //
	CAFE("cafe", NaverSearchSortType.SIMILARITY), //
	ENCYCLOPEDIA("encyc", NaverSearchSortType.NOT_AVAILABLE), //
	MOVIE("movie", NaverSearchSortType.NOT_AVAILABLE), //
	CAFE_ARTICLE("cafearticle", NaverSearchSortType.SIMILARITY);

	private final String target;
	private final NaverSearchSortType defaultSortType;

	private NaverSearchType(String target, NaverSearchSortType defaultSortType) {
		this.target = target;
		this.defaultSortType = defaultSortType;
	}

	public String getTarget() {
		return target;
	}

	public NaverSearchSortType getDefaultSortType() {
		return defaultSortType;
	}

}
