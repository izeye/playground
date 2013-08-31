package com.izeye.playground.controller;

import com.izeye.playground.support.menu.domain.SubMenu;

public abstract class AbstractPlaygroundController extends AbstractController {

	@Override
	public SubMenu subMenu() {
		return SubMenu.PLAYGROUND;
	}

}
