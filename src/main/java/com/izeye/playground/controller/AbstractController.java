package com.izeye.playground.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.izeye.playground.support.menu.domain.Menu;
import com.izeye.playground.support.menu.domain.SubMenu;

public abstract class AbstractController {

	@Resource
	private Menu menu;

	@ModelAttribute
	public Menu menu() {
		return menu;
	}

	@ModelAttribute
	public abstract SubMenu subMenu();

}
