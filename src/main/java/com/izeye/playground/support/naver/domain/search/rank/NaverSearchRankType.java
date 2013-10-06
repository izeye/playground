package com.izeye.playground.support.naver.domain.search.rank;

import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_BOOK;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_BROADCAST;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_DRAMA;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_FOREIGN_ACTOR;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_MOVIE;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_PEOPLE;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_PERFORMANCE;
import static com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankConstants.QUERY_SEARCH;

import com.izeye.playground.support.naver.domain.search.NaverSearchType;

public enum NaverSearchRankType {

	SEARCH("Search", NaverSearchType.RANK, QUERY_SEARCH), //
	MOVIE("Movie", NaverSearchType.RANK_THEME, QUERY_MOVIE), //
	PEOPLE("People", NaverSearchType.RANK_THEME, QUERY_PEOPLE), //
	FOREIGN_ACTOR("Foreign actor", NaverSearchType.RANK_THEME,
			QUERY_FOREIGN_ACTOR), //
	PERFORMANCE("Performance", NaverSearchType.RANK_THEME, QUERY_PERFORMANCE), //
	DRAMA("Drama", NaverSearchType.RANK_THEME, QUERY_DRAMA), //
	BROADCAST("Broadcast", NaverSearchType.RANK_THEME, QUERY_BROADCAST), //
	BOOK("Book", NaverSearchType.RANK_THEME, QUERY_BOOK);

	private final String name;
	private final NaverSearchType searchType;
	private final String query;

	private NaverSearchRankType(String name, NaverSearchType searchType,
			String query) {
		this.name = name;
		this.searchType = searchType;
		this.query = query;
	}

	public String getName() {
		return name;
	}

	public NaverSearchType getSearchType() {
		return searchType;
	}

	public String getQuery() {
		return query;
	}

}
