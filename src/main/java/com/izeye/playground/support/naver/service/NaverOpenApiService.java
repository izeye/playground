package com.izeye.playground.support.naver.service;

import java.util.List;

import com.izeye.playground.support.naver.domain.NaverSearchRank;
import com.izeye.playground.support.naver.domain.NaverSearchRankType;

public interface NaverOpenApiService {

	List<NaverSearchRank> getSearchRanks(NaverSearchRankType type);

}
