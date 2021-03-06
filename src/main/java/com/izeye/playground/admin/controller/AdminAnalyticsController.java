package com.izeye.playground.admin.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_AUDIENCE_ACCESS_LOGS;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_AUDIENCE_ACCESS_LOGS_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_AUDIENCE_OVERVIEW_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_AUDIENCE_USER_AGENTS_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_AUDIENCE_USER_AGENT_SPAM_IPS_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_QR_CODE_GENERATION_LOGS_PATH;

import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.admin.analytics.audience.service.AudienceAnalyticsService;
import com.izeye.playground.common.util.DateUtils;
import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.IpCount;
import com.izeye.playground.log.access.domain.UserAgentCount;
import com.izeye.playground.log.access.service.AccessLogService;
import com.izeye.playground.support.menu.domain.SubMenuItem;
import com.izeye.playground.support.qrcode.domain.QrCodeGenerationLog;
import com.izeye.playground.support.qrcode.service.QrCodeService;

@Controller
public class AdminAnalyticsController extends AbstractAdminController {

	@Resource
	private AudienceAnalyticsService audienceAnalyticsService;

	@Resource
	private AccessLogService accessLogService;

	@Resource
	private QrCodeService qrCodeService;

	@RequestMapping(SUB_MENU_ITEM_AUDIENCE_OVERVIEW_PATH)
	public String audienceOverview(Model model) {
		List<DailyCount> dailyCounts = audienceAnalyticsService
				.getDailyCounts();
		model.addAttribute("dailyCounts", dailyCounts);

		return SubMenuItem.ADMIN_ANALYTICS_AUDIENCE_OVERVIEW.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_AUDIENCE_ACCESS_LOGS_PATH)
	public String audienceAccessLogs(Model model) {
		String today = DateUtils.getToday();

		List<AccessLog> accessLogs = accessLogService
				.getAccessLogsInSpecificDate(today);

		model.addAttribute("today", today);
		model.addAttribute("accessLogs", accessLogs);

		model.addAttribute("API_PATH_AUDIENCE_ACCESS_LOGS",
				API_PATH_AUDIENCE_ACCESS_LOGS);

		return SubMenuItem.ADMIN_ANALYTICS_AUDIENCE_ACCESS_LOGS.getViewName();
	}

	@RequestMapping(API_PATH_AUDIENCE_ACCESS_LOGS)
	@ResponseBody
	public List<AccessLog> audienceAccessLogsApi(@RequestParam String today,
			@RequestParam int nDaysBefore) {
		String date = DateUtils.formatDate(DateTime.parse(today)
				.minusDays(nDaysBefore).toDate());
		return accessLogService.getAccessLogsInSpecificDate(date);
	}

	@RequestMapping(SUB_MENU_ITEM_AUDIENCE_USER_AGENTS_PATH)
	public String audienceUserAgents(Model model) {
		List<UserAgentCount> userAgentCounts = audienceAnalyticsService
				.getUserAgentCounts();
		model.addAttribute("userAgentCounts", userAgentCounts);

		return SubMenuItem.ADMIN_ANALYTICS_AUDIENCE_USER_AGENTS.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_AUDIENCE_USER_AGENT_SPAM_IPS_PATH)
	public String audienceUserAgentSpamIps(Model model) {
		List<IpCount> userAgentSpamIpCounts = audienceAnalyticsService
				.getUserAgentSpamIPCounts();
		model.addAttribute("userAgentSpamIpCounts", userAgentSpamIpCounts);

		return SubMenuItem.ADMIN_ANALYTICS_AUDIENCE_USER_AGENT_SPAM_IPS
				.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_QR_CODE_GENERATION_LOGS_PATH)
	public String qrCodeGenerationLogs(Model model) {
		List<QrCodeGenerationLog> allQrCodeGenerationLogs = qrCodeService
				.getAllQRCodeGenerationLogs();
		model.addAttribute("allQrCodeGenerationLogs", allQrCodeGenerationLogs);

		return SubMenuItem.ADMIN_ANALYTICS_QR_CODE_GENERATION_LOGS
				.getViewName();
	}

}
