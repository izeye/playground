package com.izeye.playground.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.*;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.support.daum.domain.MypeopleBotCallbackAction;
import com.izeye.playground.support.daum.service.MypeopleBotService;
import com.izeye.playground.support.menu.domain.SubMenuItem;
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
import com.izeye.playground.support.naver.service.NaverOpenApiService;

@Controller
public class PlaygroundDemoController extends AbstractPlaygroundController {

	@Resource
	private NaverOpenApiService naverOpenApiService;

	@Resource
	private MypeopleBotService mypeopleBotService;

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
			@RequestParam NaverSearchRankType rankType) {
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
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.RECOMMENDATION, query);
		return naverOpenApiService.getSearchRecommendations(request);
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
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.ADULT, query);
		return naverOpenApiService.checkForAdults(request);
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

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_SHORTCUT_PATH)
	public String naverSearchShortcut(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_SHORTCUT",
				API_PATH_NAVER_SEARCH_SHORTCUT);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_SHORTCUT.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_SHORTCUT)
	@ResponseBody
	public NaverSearchSiteResponse naverSearchShortcutApi(
			@RequestParam String query) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.SHORTCUT, query);
		return naverOpenApiService.searchShortcut(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_KIN_PATH)
	public String naverSearchKin(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_KIN",
				API_PATH_NAVER_SEARCH_KIN);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_KIN.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_KIN)
	@ResponseBody
	public DefaultNaverSearchResponse naverSearchKinApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.KIN, query, display, start);
		return naverOpenApiService.searchKin(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_LOCAL_PATH)
	public String naverSearchLocal(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_LOCAL",
				API_PATH_NAVER_SEARCH_LOCAL);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_LOCAL.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_LOCAL)
	@ResponseBody
	public NaverSearchLocalResponse naverSearchLocalApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.LOCAL, query, display, start);
		return naverOpenApiService.searchLocal(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_WEB_PATH)
	public String naverSearchWeb(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_WEB",
				API_PATH_NAVER_SEARCH_WEB);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_WEB.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_WEB)
	@ResponseBody
	public DefaultNaverSearchResponse naverSearchWebApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchWebRequest request = new NaverSearchWebRequest(query,
				display, start);
		return naverOpenApiService.searchWeb(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_TYPO_PATH)
	public String naverSearchTypo(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_TYPO",
				API_PATH_NAVER_SEARCH_TYPO);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_TYPO.getViewName();
	}

	@RequestMapping(value = API_PATH_NAVER_SEARCH_TYPO, produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String naverSearchTypoApi(@RequestParam String query) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.TYPO, query);
		return naverOpenApiService.fixTypo(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_IMAGE_PATH)
	public String naverSearchImage(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_IMAGE",
				API_PATH_NAVER_SEARCH_IMAGE);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_IMAGE.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_IMAGE)
	@ResponseBody
	public NaverSearchImageResponse naverSearchImageApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchImageRequest request = new NaverSearchImageRequest(query,
				display, start);
		return naverOpenApiService.searchImage(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_SHOPPING_PATH)
	public String naverSearchShopping(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_SHOPPING",
				API_PATH_NAVER_SEARCH_SHOPPING);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_SHOPPING.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_SHOPPING)
	@ResponseBody
	public NaverSearchShoppingResponse naverSearchShoppingApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.SHOPPING, query, display, start);
		return naverOpenApiService.searchShopping(request);
	}

	@RequestMapping(SUB_MENU_ITEM_NAVER_SEARCH_DOCUMENT_PATH)
	public String naverSearchDocument(Model model) {
		model.addAttribute("API_PATH_NAVER_SEARCH_DOCUMENT",
				API_PATH_NAVER_SEARCH_DOCUMENT);

		return SubMenuItem.PLAYGROUND_DEMO_NAVER_SEARCH_DOCUMENT.getViewName();
	}

	@RequestMapping(API_PATH_NAVER_SEARCH_DOCUMENT)
	@ResponseBody
	public DefaultNaverSearchResponse naverSearchDocumentApi(
			@RequestParam String query, @RequestParam int display,
			@RequestParam int start) {
		NaverSearchRequest request = new NaverSearchRequest(
				NaverSearchType.DOCUMENT, query, display, start);
		return naverOpenApiService.searchDocument(request);
	}

	@RequestMapping(SUB_MENU_ITEM_DAUM_MYPEOPLE_BOT_PATH)
	public String daumMypeopleBot() {
		return SubMenuItem.PLAYGROUND_DEMO_DAUM_MYPEOPLE_BOT.getViewName();
	}

	@RequestMapping(CALLBACK_PATH_DAUM_MYPEOPLE_BOT)
	@ResponseBody
	public String daumMyPeopleBotCallback(@RequestParam String action,
			@RequestParam(required = false) String groupId,
			@RequestParam String buddyId,
			@RequestParam(required = false) String content) {
		mypeopleBotService.handleCallback(
				MypeopleBotCallbackAction.getByValue(action), groupId, buddyId,
				content);
		return "";
	}

	@RequestMapping(SUB_MENU_ITEM_FIREBASE_CHAT_PATH)
	public String firebaseChat() {
		return SubMenuItem.PLAYGROUND_DEMO_FIREBASE_CHAT.getViewName();
	}

}
