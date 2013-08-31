package com.izeye.playground.math.controller;

import com.izeye.playground.controller.AbstractController;
import com.izeye.playground.support.menu.domain.SubMenu;

public abstract class AbstractMathController extends AbstractController {

	@Override
	public SubMenu subMenu() {
		return SubMenu.MATH;
	}

}
