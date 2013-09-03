package com.izeye.playground.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_LOTTO;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_KOREAN_LOTTO_PATH;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.support.lotto.service.KoreanLottoService;
import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class PlaygroundEntertainmentController extends
		AbstractPlaygroundController {

	@Resource
	private KoreanLottoService koreanLottoService;

	@RequestMapping(SUB_MENU_ITEM_KOREAN_LOTTO_PATH)
	public String koreanLotto(Model model) {
		model.addAttribute("API_PATH_KOREAN_LOTTO", API_PATH_KOREAN_LOTTO);
		
		return SubMenuItem.PLAYGROUND_ENTERTAINMENT_KOREAN_LOTTO.getViewName();
	}

	@RequestMapping(API_PATH_KOREAN_LOTTO)
	@ResponseBody
	public List<Integer> koreanLottoApi() {
		return koreanLottoService.getLuckyNumbers();
	}

}
