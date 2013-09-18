package com.izeye.playground.links.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_LINKS_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_ROBOCAR_POLI_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.controller.AbstractController;
import com.izeye.playground.support.menu.domain.MenuItem;
import com.izeye.playground.support.menu.domain.SubMenu;
import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class LinksController extends AbstractController {

	@Override
	public SubMenu subMenu() {
		return SubMenu.LINKS;
	}

	@RequestMapping(MENU_ITEM_LINKS_PATH)
	public String links() {
		return MenuItem.LINKS.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_ROBOCAR_POLI_PATH)
	public String linksKidRobocarPoli() {
		return SubMenuItem.LINKS_KID_ROBOCAR_POLI_PATH.getViewName();
	}

}
