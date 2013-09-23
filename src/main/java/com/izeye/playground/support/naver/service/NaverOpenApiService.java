package com.izeye.playground.support.naver.service;

import java.util.List;

import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookResponse;
import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;

public interface NaverOpenApiService {

	List<NaverSearchRankItem> getSearchRanks(NaverSearchRankType type);

	NaverSearchBlogResponse searchBlog(NaverSearchRequest request);

	NaverSearchNewsResponse searchNews(NaverSearchRequest request);

	NaverSearchBookResponse searchBook(NaverSearchRequest request);

	List<String> getSearchRecommendations(String query);

}
