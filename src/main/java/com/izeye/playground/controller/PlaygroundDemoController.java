package com.izeye.playground.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.*;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.support.menu.domain.SubMenuItem;
import com.izeye.playground.support.naver.domain.NaverSearchRank;
import com.izeye.playground.support.naver.domain.NaverSearchRankType;
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
	public List<NaverSearchRank> naverSearchRankApi(NaverSearchRankType rankType) {
		return naverOpenApiService.getSearchRanks(rankType);
	}

}
