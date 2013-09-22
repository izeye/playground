package com.izeye.playground.support.naver.service;

import java.util.List;

import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogRequest;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;

public interface NaverOpenApiService {

	List<NaverSearchRankItem> getSearchRanks(NaverSearchRankType type);

	NaverSearchBlogResponse search(NaverSearchBlogRequest request);

}
