package com.izeye.playground.home.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_HOME_PATH;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.analytics.audience.domain.VisitStat;
import com.izeye.playground.analytics.audience.service.AudienceAnalyticsService;
import com.izeye.playground.controller.AbstractController;
import com.izeye.playground.support.menu.domain.MenuItem;
import com.izeye.playground.support.menu.domain.SubMenu;

@Controller
public class HomeController extends AbstractController {

	@Resource
	private AudienceAnalyticsService audienceAnalyticsService;

	@RequestMapping(MENU_ITEM_HOME_PATH)
	public String home(Model model) {
		VisitStat todayVisitStat = audienceAnalyticsService.getTodayVisitStat();
		model.addAttribute("todayVisitStat", todayVisitStat);

		VisitStat yesterdayVisitStat = audienceAnalyticsService
				.getYesterdayVisitStat();
		model.addAttribute("yesterdayVisitStat", yesterdayVisitStat);

		return MenuItem.HOME.getViewName();
	}

	@Override
	public SubMenu subMenu() {
		return SubMenu.HOME;
	}

}
