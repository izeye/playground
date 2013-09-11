package com.izeye.playground.admin.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_EXECUTE_TEMPORARILY;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_EXECUTE_TEMPORARILY_PATH;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.support.lotto.service.KoreanLottoWinningLogMigrationService;
import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class AdminManagementController extends AbstractAdminController {

	@Resource
	private KoreanLottoWinningLogMigrationService koreanLottoWinningLogMigrationService;

	@RequestMapping(SUB_MENU_ITEM_EXECUTE_TEMPORARILY_PATH)
	public String executeTemporarily(Model model) {
		model.addAttribute("API_PATH_EXECUTE_TEMPORARILY",
				API_PATH_EXECUTE_TEMPORARILY);

		return SubMenuItem.ADMIN_MANAGEMENT_EXECUTE_TEMPORARILY.getViewName();
	}

	@RequestMapping(API_PATH_EXECUTE_TEMPORARILY)
	@ResponseBody
	public String executeTemporarilyApi() {
		koreanLottoWinningLogMigrationService.file2db();
		return "Success";
	}

}
