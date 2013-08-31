package com.izeye.playground.admin.controller;

import com.izeye.playground.controller.AbstractController;
import com.izeye.playground.support.menu.domain.SubMenu;

public abstract class AbstractAdminController extends AbstractController {

	@Override
	public SubMenu subMenu() {
		return SubMenu.ADMIN;
	}

}
