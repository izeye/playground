package com.izeye.playground.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_KAKAO_LINK_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_WEBCAM_LIVE_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_WEBCAM_SNAPSHOTS_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class PlaygroundDemoController extends AbstractPlaygroundController {

	@RequestMapping(SUB_MENU_ITEM_WEBCAM_LIVE_PATH)
	public String demoWebcamLive(Model model) {
		return SubMenuItem.PLAYGROUND_DEMO_WEBCAM_LIVE.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_WEBCAM_SNAPSHOTS_PATH)
	public String demoWebcamSnapshots(Model model) {
		return SubMenuItem._PLAYGROUND_DEMO_WEBCAM_SNAPSHOTS.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_KAKAO_LINK_PATH)
	public String demoKakaoLink(Model model) {
		return SubMenuItem.PLAYGROUND_DEMO_KAKAO_LINK.getViewName();
	}

}
