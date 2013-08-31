package com.izeye.playground.math.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_MATH_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.support.menu.domain.MenuItem;

@Controller
public class MathController extends AbstractMathController {

	@RequestMapping(MENU_ITEM_MATH_PATH)
	public String math(Model model) {
		return MenuItem.MATH.getViewName();
	}

}
