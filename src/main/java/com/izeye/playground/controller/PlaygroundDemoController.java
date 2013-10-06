package com.izeye.playground.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.*;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_NAVER_SEARCH_BLOG;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_NAVER_SEARCH_BOOK;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_NAVER_SEARCH_CAFE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_NAVER_SEARCH_CAFE_ARTICLE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_NAVER_SEARCH_ENCYCLOPEDIA;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_NAVER_SEARCH_MOVIE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_NAVER_SEARCH_MOVIE_ACTOR;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_NAVER_SEARCH_NEWS;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_NAVER_SEARCH_RANK;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_NAVER_SEARCH_RECOMMEND;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_KAKAO_LINK_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_ADULT_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_BLOG_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_BOOK_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_CAFE_ARTICLE_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_CAFE_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_ENCYCLOPEDIA_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_ACTOR_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_NEWS_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_RANK_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NAVER_SEARCH_RECOMMEND_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_WEBCAM_LIVE_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_WEBCAM_SNAPSHOTS_PATH;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.support.menu.domain.SubMenuItem;
import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.NaverSearchType;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeArticleResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeResponse;
import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarRequest;
import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarResponse;
import com.izeye.playground.support.naver.domain.search.encyclopedia.NaverSearchEncyclopediaResponse;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieActorResponse;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieRequest;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieResponse;
import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;
import com.izeye.playground.support.naver.service.NaverOpenApiService;

@Controller
public class PlaygroundDemoController extends AbstractPlaygroundController {

	@Resource
	private NaverOpenApiService naverOpenApiService;

	@RequestMapping(SUB_MENU_ITEM_WEBCAM_LIVE_PATH)
	public String webcamLive() {
		return SubMenuItem.PLAYGROUND_DEMO_WEBCAM_LIVE.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_WEBCAM_SNAPSHOTS_PATH)
	public String webcamSnapshots() {
		return SubMenuItem._PLAYGROUND_DEMO_WEBCAM_SNAPSHOTS.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_KAKAO_LINK_PATH)
	public String kakaoLink() {
		return SubMenuItem.PLAYGROUND_DEMO_KAKAO_LINK.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_RANK_PATH)
	public String naverSearchRank(Model model) {
		model.addAttribute("rankTypes", NaverSearchRankType.values());

		model.addAttribute("API_PATH_NAVER_SEARCH_RANK",
				API_PATH_NAVER_SEARCH_RANK);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_RANK.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_RANK)
	@ResponseBody
	public List<NaverSearchRankItem> naverSearchRankApi(
			NaverSearchRankType rankType) {
		return naverOpenApiService.getSearchRanks(rankType);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_BLOG_PATH)
	public String naverSearchBlog(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_BLOG",
				API_PATH_NAVER_SEARCH_BLOG);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_BLOG.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_BLOG)
	@ResponseBody
	public NaverSearchBlogResponse naverSearchBlogApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.BLOG, query, display, start);
		return naverOpenApiService.searchBlog(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_NEWS_PATH)
	public String naverSearchNews(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_NEWS",
				API_PATH_NAVER_SEARCH_NEWS);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_NEWS.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_NEWS)
	@ResponseBody
	public NaverSearchNewsResponse naverSearchNewsApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.NEWS, query, display, start);
		return naverOpenApiService.searchNews(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_BOOK_PATH)
	public String naverSearchBook(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_BOOK",
				API_PATH_NAVER_SEARCH_BOOK);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_BOOK.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_BOOK)
	@ResponseBody
	public NaverSearchBookResponse naverSearchBookApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.BOOK, query, display, start);
		return naverOpenApiService.searchBook(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_RECOMMEND_PATH)
	public String naverSearchRecommend(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_RECOMMEND",
				API_PATH_NAVER_SEARCH_RECOMMEND);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_RECOMMEND.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_RECOMMEND)
	@ResponseBody
	public List<String> naverSearchRecommendApi(@RequestParam String query) {
		return naverOpenApiService.getSearchRecommendations(query);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_CAFE_PATH)
	public String naverSearchCafe(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_CAFE",
				API_PATH_NAVER_SEARCH_CAFE);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_CAFE.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_CAFE)
	@ResponseBody
	public NaverSearchCafeResponse naverSearchCafeApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.CAFE, query, display, start);
		return naverOpenApiService.searchCafe(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_ADULT_PATH)
	public String naverSearchAdult(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_ADULT",
				API_PATH_NAVER_SEARCH_ADULT);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_ADULT.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_ADULT)
	@ResponseBody
	public boolean naverSearchAdultApi(@RequestParam String query) {
		return naverOpenApiService.checkForAdults(query);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_ENCYCLOPEDIA_PATH)
	public String naverSearchEncyclopedia(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_ENCYCLOPEDIA",
				API_PATH_NAVER_SEARCH_ENCYCLOPEDIA);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_ENCYCLOPEDIA
				.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_ENCYCLOPEDIA)
	@ResponseBody
	public NaverSearchEncyclopediaResponse naverSearchEncyclopediaApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.ENCYCLOPEDIA, query, display, start);
		return naverOpenApiService.searchEncyclopedia(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_PATH)
	public String naverSearchMovie(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_MOVIE",
				API_PATH_NAVER_SEARCH_MOVIE);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_MOVIE.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_MOVIE)
	@ResponseBody
	public NaverSearchMovieResponse naverSearchMovieApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchMovieRequest request = new NaverSearchMovieRequest(query,
				display, start);
		return naverOpenApiService.searchMovie(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_CAFE_ARTICLE_PATH)
	public String naverSearchCafeArticle(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_CAFE_ARTICLE",
				API_PATH_NAVER_SEARCH_CAFE_ARTICLE);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_CAFE_ARTICLE
				.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_CAFE_ARTICLE)
	@ResponseBody
	public NaverSearchCafeArticleResponse naverSearchCafeArticleApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.CAFE_ARTICLE, query, display, start);
		return naverOpenApiService.searchCafeArticle(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_ACTOR_PATH)
	public String naverSearchMovieActor(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_MOVIE_ACTOR",
				API_PATH_NAVER_SEARCH_MOVIE_ACTOR);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_MOVIE_ACTOR
				.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_MOVIE_ACTOR)
	@ResponseBody
	public NaverSearchMovieActorResponse naverSearchMovieActorApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.MOVIE_ACTOR, query, display, start);
		return naverOpenApiService.searchMovieActor(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_CAR_PATH)
	public String naverSearchCar(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_CAR",
				API_PATH_NAVER_SEARCH_CAR);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_CAR.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_CAR)
	@ResponseBody
	public NaverSearchCarResponse naverSearchCarApi(@RequestParam String query,
			@RequestParam int display, @RequestParam int start) {
		NaverSearchCarRequest request = new NaverSearchCarRequest(query,
				display, start);
		return naverOpenApiService.searchCar(request);
	}

}
