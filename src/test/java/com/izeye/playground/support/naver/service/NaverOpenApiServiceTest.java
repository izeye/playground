package com.izeye.playground.support.naver.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.naver.domain.NaverSearchRank;
import com.izeye.playground.support.naver.domain.NaverSearchRankType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class NaverOpenApiServiceTest {

	@Resource
	private NaverOpenApiService naverOpenApiService;

	@Test
	public void getSearchRanks() {
		List<NaverSearchRank> ranks = naverOpenApiService
				.getSearchRanks(NaverSearchRankType.SEARCH);
		System.out.println(ranks);

		ranks = naverOpenApiService.getSearchRanks(NaverSearchRankType.MOVIE);
		System.out.println(ranks);

		ranks = naverOpenApiService.getSearchRanks(NaverSearchRankType.PEOPLE);
		System.out.println(ranks);

		ranks = naverOpenApiService
				.getSearchRanks(NaverSearchRankType.FOREIGN_ACTOR);
		System.out.println(ranks);

		ranks = naverOpenApiService
				.getSearchRanks(NaverSearchRankType.PERFORMANCE);
		System.out.println(ranks);

		ranks = naverOpenApiService.getSearchRanks(NaverSearchRankType.DRAMA);
		System.out.println(ranks);

		ranks = naverOpenApiService
				.getSearchRanks(NaverSearchRankType.BROADCAST);
		System.out.println(ranks);

		ranks = naverOpenApiService.getSearchRanks(NaverSearchRankType.BOOK);
		System.out.println(ranks);
	}

}
