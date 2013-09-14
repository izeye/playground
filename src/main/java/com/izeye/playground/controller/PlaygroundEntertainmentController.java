package com.izeye.playground.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_LOTTO_GENERATION_GENERATE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_LOTTO_GENERATION_HISTORY;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_LOTTO_WINNING_HISTORY;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_KOREAN_LOTTO_GENERATION_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_KOREAN_LOTTO_WINNING_HISTORY_PATH;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.common.util.DateUtils;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;
import com.izeye.playground.support.lotto.service.KoreanLottoService;
import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class PlaygroundEntertainmentController extends
		AbstractPlaygroundController {

	@Resource
	private KoreanLottoService koreanLottoService;

	@RequestMapping(SUB_MENU_ITEM_KOREAN_LOTTO_GENERATION_PATH)
	public String koreanLotto(Model model) {
		KoreanLottoWinningLog latestWinningLog = koreanLottoService
				.getLatestWinningLog();
		List<KoreanLottoGenerationLog> latestGenerationLogs = koreanLottoService
				.getLatestGenerationLogs();

		model.addAttribute("latestSequence", latestWinningLog.getSequence());
		model.addAttribute("latestGenerationLogs", latestGenerationLogs);

		model.addAttribute("API_PATH_KOREAN_LOTTO_GENERATION_GENERATE",
				API_PATH_KOREAN_LOTTO_GENERATION_GENERATE);
		model.addAttribute("API_PATH_KOREAN_LOTTO_GENERATION_HISTORY",
				API_PATH_KOREAN_LOTTO_GENERATION_HISTORY);

		return SubMenuItem.PLAYGROUND_ENTERTAINMENT_KOREAN_LOTTO_GENERATION
				.getViewName();
	}

	@RequestMapping(API_PATH_KOREAN_LOTTO_GENERATION_GENERATE)
	@ResponseBody
	public List<Integer> koreanLottoGenerateApi(HttpServletRequest request) {
		return koreanLottoService.generate(
				new KoreanLottoGenerationRequest(request.getRemoteAddr()))
				.getNumbers();
	}

	@RequestMapping(API_PATH_KOREAN_LOTTO_GENERATION_HISTORY)
	@ResponseBody
	public List<KoreanLottoGenerationLog> koreanLottoHistoryApi(
			@RequestParam(required = false) Integer sequence) {
		if (sequence == null) {
			return koreanLottoService.getLatestGenerationLogs();
		} else {
			return koreanLottoService.getGenerationLogs(sequence);
		}
	}

	@RequestMapping(SUB_MENU_ITEM_KOREAN_LOTTO_WINNING_HISTORY_PATH)
	public String koreanLottoWinningHistory(Model model) {
		String thisYear = String.valueOf(DateUtils.getThisYear());
		List<KoreanLottoWinningLog> winningLogs = koreanLottoService
				.getWinningLogsInSpecificYear(thisYear);
		model.addAttribute("thisYear", thisYear);
		model.addAttribute("winningLogs", winningLogs);

		model.addAttribute("API_PATH_KOREAN_LOTTO_WINNING_HISTORY",
				API_PATH_KOREAN_LOTTO_WINNING_HISTORY);

		return SubMenuItem._PLAYGROUND_ENTERTAINMENT_KOREAN_LOTTO_WINNING_HISTORY
				.getViewName();
	}

	@RequestMapping(API_PATH_KOREAN_LOTTO_WINNING_HISTORY)
	@ResponseBody
	public List<KoreanLottoWinningLog> koreanLottoWinningHistoryApi(
			@RequestParam String year) {
		return koreanLottoService.getWinningLogsInSpecificYear(year);
	}

}
