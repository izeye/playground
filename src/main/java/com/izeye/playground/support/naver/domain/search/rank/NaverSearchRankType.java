package com.izeye.playground.support.naver.domain.search.rank;

import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_BOOK;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_BROADCAST;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_DRAMA;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_FOREIGN_ACTOR;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_MOVIE;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_PEOPLE;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_PERFORMANCE;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_SEARCH;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.TARGET_RANK;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.TARGET_RANK_THEME;

public enum NaverSearchRankType {

	SEARCH("Search", TARGET_RANK, QUERY_SEARCH), //
	MOVIE("Movie", TARGET_RANK_THEME, QUERY_MOVIE), //
	PEOPLE("People", TARGET_RANK_THEME, QUERY_PEOPLE), //
	FOREIGN_ACTOR("Foreign actor", TARGET_RANK_THEME, QUERY_FOREIGN_ACTOR), //
	PERFORMANCE("Performance", TARGET_RANK_THEME, QUERY_PERFORMANCE), //
	DRAMA("Drama", TARGET_RANK_THEME, QUERY_DRAMA), //
	BROADCAST("Broadcast", TARGET_RANK_THEME, QUERY_BROADCAST), //
	BOOK("Book", TARGET_RANK_THEME, QUERY_BOOK);

	private final String name;
	private final String target;
	private final String query;

	private NaverSearchRankType(String name, String target, String query) {
		this.name = name;
		this.target = target;
		this.query = query;
	}

	public String getName() {
		return name;
	}

	public String getTarget() {
		return target;
	}

	public String getQuery() {
		return query;
	}

}
