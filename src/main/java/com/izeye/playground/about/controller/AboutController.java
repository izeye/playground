package com.izeye.playground.about.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_ABOUT_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_ABOUT_ME_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_LINKS_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.controller.AbstractController;
import com.izeye.playground.support.menu.domain.MenuItem;
import com.izeye.playground.support.menu.domain.SubMenu;
import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class AboutController extends AbstractController {

	@Override
	public SubMenu subMenu() {
		return SubMenu.ABOUT;
	}

	@RequestMapping(MENU_ITEM_ABOUT_PATH)
	public String about() {
		return MenuItem.ABOUT.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_ABOUT_ME_PATH)
	public String aboutAboutMe() {
		return SubMenuItem.ABOUT_ABOUT_ME_ABOUT_ME_PATH.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_LINKS_PATH)
	public String linksLinks() {
		return SubMenuItem.ABOUT_LINKS_LINKS_PATH.getViewName();
	}

}
