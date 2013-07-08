package com.izeye.playground.admin.controller;

import static com.izeye.playground.web.menu.domain.MenuConstants.MENU_NAME_ADMIN;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.analytics.audience.service.AudienceAnalyticsService;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.web.menu.domain.SubMenuSection;
import com.izeye.playground.web.menu.service.MenuService;

@Controller
public class AdminController {

	@Resource
	private MenuService menuService;

	@Resource
	private AudienceAnalyticsService audienceAnalyticsService;

	private List<SubMenuSection> subMenuSections;

	@PostConstruct
	void init() {
		subMenuSections = menuService.getSubMenu(MENU_NAME_ADMIN);
	}

	@RequestMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("subMenuSections", subMenuSections);

		return "admin/admin";
	}

	@RequestMapping("/admin/analytics/audience/overview")
	public String analyticsAudienceOverview(Model model) {
		model.addAttribute("subMenuSections", subMenuSections);

		List<DailyCount> dailyCounts = audienceAnalyticsService
				.getDailyCounts();
		model.addAttribute("dailyCounts", dailyCounts);

		return "admin/analytics/audience/overview";
	}

}
