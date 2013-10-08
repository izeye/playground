package com.izeye.playground.support.naver.domain.search;

import com.izeye.playground.common.domain.StringConstants;

public enum NaverSearchSortType {

	NOT_AVAILABLE(StringConstants.NOT_AVAILABLE), //
	DATE("date"), //
	SIMILARITY("sim"), //
	MEMBER("member"), //
	NEW_ARTICLES("newarticles"), //
	RANK("rank"), //
	READ_COUNT("count"), //
	POINT("point"), //
	RANDOM("random"), //
	COMMENT_COUNT("comment"), //
	VOTE("vote"), //
	PRICE_ASCENDING("asc"), //
	PRICE_DESCENDING("dsc");

	private final String value;

	private NaverSearchSortType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
