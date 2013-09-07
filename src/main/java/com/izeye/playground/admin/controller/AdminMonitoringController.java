package com.izeye.playground.admin.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_QUOTA_PATH;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.support.menu.domain.SubMenuItem;
import com.izeye.playground.support.quota.domain.Quota;
import com.izeye.playground.support.quota.service.QuotaLimitService;

@Controller
public class AdminMonitoringController extends AbstractAdminController {

	@Resource
	private QuotaLimitService quotaLimitService;

	@RequestMapping(SUB_MENU_ITEM_QUOTA_PATH)
	public String monitoringQuota(Model model) {
		Quota quota = quotaLimitService.getQuota();
		model.addAttribute("quota", quota);
		return SubMenuItem.ADMIN_MONITORING_QUOTA.getViewName();
	}

}
