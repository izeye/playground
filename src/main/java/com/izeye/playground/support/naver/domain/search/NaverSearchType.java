package com.izeye.playground.support.naver.domain.search;

public enum NaverSearchType {

	RANK("rank", NaverSearchSortType.NOT_AVAILABLE), //
	RANK_THEME("ranktheme", NaverSearchSortType.NOT_AVAILABLE), //
	BLOG("blog", NaverSearchSortType.SIMILARITY), //
	NEWS("news", NaverSearchSortType.DATE), //
	BOOK("book", NaverSearchSortType.NOT_AVAILABLE), //
	RECOMMENDATION("recmd", NaverSearchSortType.NOT_AVAILABLE), //
	CAFE("cafe", NaverSearchSortType.SIMILARITY), //
	ADULT("adult", NaverSearchSortType.NOT_AVAILABLE), //
	ENCYCLOPEDIA("encyc", NaverSearchSortType.NOT_AVAILABLE), //
	MOVIE("movie", NaverSearchSortType.NOT_AVAILABLE), //
	CAFE_ARTICLE("cafearticle", NaverSearchSortType.SIMILARITY), //
	MOVIE_ACTOR("movieman", NaverSearchSortType.NOT_AVAILABLE), //
	CAR("car", NaverSearchSortType.NOT_AVAILABLE), //
	SHORTCUT("shortcut", NaverSearchSortType.NOT_AVAILABLE), //
	KIN("kin", NaverSearchSortType.SIMILARITY), //
	LOCAL("local", NaverSearchSortType.RANDOM), //
	WEB("webkr", NaverSearchSortType.NOT_AVAILABLE), //
	TYPO("errata", NaverSearchSortType.NOT_AVAILABLE), //
	IMAGE("image", NaverSearchSortType.SIMILARITY), //
	SHOPPING("shop", NaverSearchSortType.SIMILARITY), //
	DOCUMENT("doc", NaverSearchSortType.NOT_AVAILABLE);

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
