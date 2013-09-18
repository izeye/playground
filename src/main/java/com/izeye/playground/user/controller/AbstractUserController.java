package com.izeye.playground.user.controller;

import com.izeye.playground.controller.AbstractController;
import com.izeye.playground.support.menu.domain.SubMenu;

public class AbstractUserController extends AbstractController {

	@Override
	public SubMenu subMenu() {
		return SubMenu.USER;
	}

}
