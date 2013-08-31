package com.izeye.playground.admin.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_ADMIN_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.support.menu.domain.MenuItem;

@Controller
public class AdminController extends AbstractAdminController {

	@RequestMapping(MENU_ITEM_ADMIN_PATH)
	public String admin(Model model) {
		return MenuItem.ADMIN.getViewName();
	}

}
