package com.izeye.playground.tools.controller;

import com.izeye.playground.controller.AbstractController;
import com.izeye.playground.support.menu.domain.SubMenu;

public abstract class AbstractToolsController extends AbstractController {

	@Override
	public SubMenu subMenu() {
		return SubMenu.TOOLS;
	}

}
