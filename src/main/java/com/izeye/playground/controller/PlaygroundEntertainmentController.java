package com.izeye.playground.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_LOTTO_GENERATE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_LOTTO_HISTORY;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_KOREAN_LOTTO_PATH;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationRequest;
import com.izeye.playground.support.lotto.service.KoreanLottoService;
import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class PlaygroundEntertainmentController extends
		AbstractPlaygroundController {

	@Resource
	private KoreanLottoService koreanLottoService;

	@RequestMapping(SUB_MENU_ITEM_KOREAN_LOTTO_PATH)
	public String koreanLotto(Model model) {
		List<KoreanLottoGenerationLog> allKoreanLottoLogs = koreanLottoService
				.getAllKoreanLottoLogs();
		model.addAttribute("allKoreanLottoLogs", allKoreanLottoLogs);

		model.addAttribute("API_PATH_KOREAN_LOTTO_GENERATE",
				API_PATH_KOREAN_LOTTO_GENERATE);
		model.addAttribute("API_PATH_KOREAN_LOTTO_HISTORY",
				API_PATH_KOREAN_LOTTO_HISTORY);

		return SubMenuItem.PLAYGROUND_ENTERTAINMENT_KOREAN_LOTTO.getViewName();
	}

	@RequestMapping(API_PATH_KOREAN_LOTTO_GENERATE)
	@ResponseBody
	public List<Integer> koreanLottoGenerateApi(HttpServletRequest request) {
		return koreanLottoService.getLuckyNumbers(
				new KoreanLottoGenerationRequest(request.getRemoteAddr())).getNumbers();
	}

	@RequestMapping(API_PATH_KOREAN_LOTTO_HISTORY)
	@ResponseBody
	public List<KoreanLottoGenerationLog> koreanLottoHistoryApi() {
		return koreanLottoService.getAllKoreanLottoLogs();
	}

}
