package com.izeye.playground.support.naver.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.NaverSearchType;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeResponse;
import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsResponse;
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
		String query = "리뷰";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.BLOG, query);
		NaverSearchBlogResponse response = naverOpenApiService
				.searchBlog(request);
		System.out.println(response);
	}

	@Test
	public void searchNews() {
		String query = "주식";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.NEWS, query);
		NaverSearchNewsResponse response = naverOpenApiService
				.searchNews(request);
		System.out.println(response);
	}

	@Test
	public void searchBook() {
		String query = "삼국지";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.BOOK, query);
		NaverSearchBookResponse response = naverOpenApiService
				.searchBook(request);
		System.out.println(response);
	}

	@Test
	public void getSearchRecommendations() {
		String query = "nhn";
		List<String> searchRecommendations = naverOpenApiService
				.getSearchRecommendations(query);
		System.out.println(searchRecommendations);
	}

	@Test
	public void searchCafe() {
		String query = "스포츠";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.CAFE, query);
		NaverSearchCafeResponse response = naverOpenApiService
				.searchCafe(request);
		System.out.println(response);
	}

	@Test
	public void checkForAdults() {
		String query = "소녀";
		assertThat(naverOpenApiService.checkForAdults(query), is(false));

		query = "단란주점";
		assertThat(naverOpenApiService.checkForAdults(query), is(true));
	}

}
