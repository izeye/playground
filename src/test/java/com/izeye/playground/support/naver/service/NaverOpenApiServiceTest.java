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

import com.izeye.playground.support.naver.domain.search.DefaultNaverSearchResponse;
import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.NaverSearchType;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeArticleResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeResponse;
import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarRequest;
import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarResponse;
import com.izeye.playground.support.naver.domain.search.encyclopedia.NaverSearchEncyclopediaResponse;
import com.izeye.playground.support.naver.domain.search.image.NaverSearchImageRequest;
import com.izeye.playground.support.naver.domain.search.image.NaverSearchImageResponse;
import com.izeye.playground.support.naver.domain.search.local.NaverSearchLocalResponse;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieActorResponse;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieRequest;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieResponse;
import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;
import com.izeye.playground.support.naver.domain.search.shopping.NaverSearchShoppingResponse;
import com.izeye.playground.support.naver.domain.search.site.NaverSearchSiteResponse;
import com.izeye.playground.support.naver.domain.search.web.NaverSearchWebRequest;

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
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.RECOMMENDATION, query);
		List<String> searchRecommendations = naverOpenApiService
				.getSearchRecommendations(request);
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
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.ADULT, query);
		assertThat(naverOpenApiService.checkForAdults(request), is(false));

		query = "단란주점";
		request = new NaverSearchRequest(NaverSearchType.ADULT, query);
		assertThat(naverOpenApiService.checkForAdults(request), is(true));
	}

	@Test
	public void searchEncyclopedia() {
		String query = "독도";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.ENCYCLOPEDIA, query);
		NaverSearchEncyclopediaResponse response = naverOpenApiService
				.searchEncyclopedia(request);
		System.out.println(response);
	}

	@Test
	public void searchMovie() {
		String query = "벤허";
		int display = 10;
		int start = 1;
		NaverSearchMovieRequest request = new NaverSearchMovieRequest(query,
				display, start);
		NaverSearchMovieResponse response = naverOpenApiService
				.searchMovie(request);
		System.out.println(response);
	}

	@Test
	public void searchCafeArticle() {
		String query = "요리";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.CAFE_ARTICLE, query);
		NaverSearchCafeArticleResponse response = naverOpenApiService
				.searchCafeArticle(request);
		System.out.println(response);
	}

	@Test
	public void searchMovieActor() {
		String query = "안성기";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.MOVIE_ACTOR, query);
		NaverSearchMovieActorResponse response = naverOpenApiService
				.searchMovieActor(request);
		System.out.println(response);
	}

	@Test
	public void searchCar() {
		String query = "porsche";
		int display = 10;
		int start = 1;
		NaverSearchCarRequest request = new NaverSearchCarRequest(query,
				display, start);
		NaverSearchCarResponse response = naverOpenApiService
				.searchCar(request);
		System.out.println(response);
	}

	@Test
	public void searchShortcut() {
		// NOTE:
		// I guess this is not a real-time data.
		// I can't find my site!
		String query = "개발자의 하루";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.SHORTCUT, query);
		NaverSearchSiteResponse response = naverOpenApiService
				.searchShortcut(request);
		System.out.println(response);

		query = "naver";
		request = new NaverSearchRequest(NaverSearchType.SHORTCUT, query);
		response = naverOpenApiService.searchShortcut(request);
		System.out.println(response);

		// NOTE:
		// Space-tolerable by Naver open API.
		query = "n aver";
		request = new NaverSearchRequest(NaverSearchType.SHORTCUT, query);
		response = naverOpenApiService.searchShortcut(request);
		System.out.println(response);
	}

	@Test
	public void searchKin() {
		String query = "test";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.KIN, query);
		DefaultNaverSearchResponse response = naverOpenApiService
				.searchKin(request);
		System.out.println(response);
	}

	@Test
	public void searchLocal() {
		String query = "갈비집";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.LOCAL, query);
		NaverSearchLocalResponse response = naverOpenApiService
				.searchLocal(request);
		System.out.println(response);
	}

	@Test
	public void searchWeb() {
		String query = "test";
		NaverSearchWebRequest request = new NaverSearchWebRequest(query);
		DefaultNaverSearchResponse response = naverOpenApiService
				.searchWeb(request);
		System.out.println(response);
	}

	@Test
	public void fixTypo() {
		String expected = "네이버";
		String query = "spdlqj";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.TYPO, query);
		String fixedTypo = naverOpenApiService.fixTypo(request);
		assertThat(fixedTypo, is(expected));

		expected = "";
		query = "aaa";
		request = new NaverSearchRequest(NaverSearchType.TYPO, query);
		fixedTypo = naverOpenApiService.fixTypo(request);
		assertThat(fixedTypo, is(expected));
	}

	@Test
	public void searchImage() {
		String query = "triangle";
		NaverSearchImageRequest request = new NaverSearchImageRequest(query);
		NaverSearchImageResponse response = naverOpenApiService
				.searchImage(request);
		System.out.println(response);
	}

	@Test
	public void searchShopping() {
		String query = "test";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.SHOPPING, query);
		NaverSearchShoppingResponse response = naverOpenApiService
				.searchShopping(request);
		System.out.println(response);
	}

	@Test
	public void searchDocument() {
		String query = "test";
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.DOCUMENT, query);
		DefaultNaverSearchResponse response = naverOpenApiService
				.searchDocument(request);
		System.out.println(response);
	}

}
