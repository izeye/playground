package com.izeye.playground.home.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.analytics.audience.domain.VisitStat;
import com.izeye.playground.analytics.audience.service.AudienceAnalyticsService;

@Controller
public class HomeController {

	@Resource
	private AudienceAnalyticsService audienceAnalyticsService;

	@RequestMapping("/")
	public String home(Model model) {
		VisitStat todayVisitStat = audienceAnalyticsService.getTodayVisitStat();
		model.addAttribute("todayVisitStat", todayVisitStat);

		VisitStat yesterdayVisitStat = audienceAnalyticsService
				.getYesterdayVisitStat();
		model.addAttribute("yesterdayVisitStat", yesterdayVisitStat);

		return "home/home";
	}

}
