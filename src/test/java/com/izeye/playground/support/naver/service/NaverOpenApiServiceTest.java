package com.izeye.playground.support.naver.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogRequest;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class NaverOpenApiServiceTest {

	@Resource
	private NaverOpenApiService naverOpenApiService;

	@Test
	public void getSearchRanks() {
		List<NaverSearchRankItem> ranks = naverOpenApiService
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

	@Test
	public void searchBlog() {
		String query = "izeye";
		NaverSearchBlogRequest request = new NaverSearchBlogRequest(query);
		NaverSearchBlogResponse response = naverOpenApiService.search(request);
		System.out.println(response);
	}

}
