package com.izeye.playground.admin.controller;

import static com.izeye.playground.web.menu.domain.MenuConstants.MENU_NAME_ADMIN;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.analytics.audience.service.AudienceAnalyticsService;
import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.IPCount;
import com.izeye.playground.log.access.domain.UserAgentCount;
import com.izeye.playground.log.access.service.AccessLogService;
import com.izeye.playground.support.ip.service.IPAnalyzer;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationLog;
import com.izeye.playground.support.qrcode.service.QRCodeService;
import com.izeye.playground.support.ua.service.UserAgentAnalyzer;
import com.izeye.playground.web.menu.domain.SubMenuSection;
import com.izeye.playground.web.menu.service.MenuService;

@Controller
public class AdminController {

	@Resource
	private MenuService menuService;

	@Resource
	private AudienceAnalyticsService audienceAnalyticsService;

	@Resource
	private AccessLogService accessLogService;

	@Resource
	private QRCodeService qrCodeService;

	@Resource
	private IPAnalyzer ipAnalyzer;

	@Resource
	private UserAgentAnalyzer userAgentAnalyzer;

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

	// private static final int DEFAULT_ACCESS_LOG_PAGE_SIZE = 100;
	private static final int DEFAULT_ACCESS_LOG_PAGE_SIZE = 500;

	@RequestMapping("/admin/analytics/audience/access_logs")
	public String analyticsAudienceAccessLogs(Model model) {
		model.addAttribute("subMenuSections", subMenuSections);

		// List<AccessLog> allAccessLogs = accessLogService.getAllAccessLogs();
		// model.addAttribute("allAccessLogs", allAccessLogs);
		List<AccessLog> latestAccessLogs = accessLogService
				.getLatestAccessLogs(DEFAULT_ACCESS_LOG_PAGE_SIZE);
		model.addAttribute("latestAccessLogs", latestAccessLogs);

		// TODO: Implement more button.

		model.addAttribute("ipAnalyzer", ipAnalyzer);
		model.addAttribute("userAgentAnalyzer", userAgentAnalyzer);

		return "admin/analytics/audience/access_logs";
	}

	@RequestMapping("/admin/analytics/audience/user_agents")
	public String analyticsAudienceUserAgents(Model model) {
		model.addAttribute("subMenuSections", subMenuSections);

		List<UserAgentCount> userAgentCounts = audienceAnalyticsService
				.getUserAgentCounts();
		model.addAttribute("userAgentCounts", userAgentCounts);

		return "admin/analytics/audience/user_agents";
	}

	@RequestMapping("/admin/analytics/audience/user_agent_spam_ips")
	public String analyticsAudienceUserAgentSpamIPs(Model model) {
		model.addAttribute("subMenuSections", subMenuSections);

		List<IPCount> userAgentSpamIPCounts = audienceAnalyticsService
				.getUserAgentSpamIPCounts();
		model.addAttribute("userAgentSpamIPCounts", userAgentSpamIPCounts);

		return "admin/analytics/audience/user_agent_spam_ips";
	}

	@RequestMapping("/admin/analytics/qrcode/qrcode_generation_logs")
	public String analyticsQRCodeGenerationLogs(Model model) {
		model.addAttribute("subMenuSections", subMenuSections);

		List<QRCodeGenerationLog> allQRCodeGenerationLogs = qrCodeService
				.getAllQRCodeGenerationLogs();
		model.addAttribute("allQRCodeGenerationLogs", allQRCodeGenerationLogs);

		return "admin/analytics/qrcode/qrcode_generation_logs";
	}

}
