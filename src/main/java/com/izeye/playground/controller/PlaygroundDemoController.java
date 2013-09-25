package com.izeye.playground.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.*;

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
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeResponse;
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

}
