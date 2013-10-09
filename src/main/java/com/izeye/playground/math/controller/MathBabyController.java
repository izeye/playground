package com.izeye.playground.math.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_NUMBER_COUNTING_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class MathBabyController extends AbstractMathController {

	@RequestMapping(SUB_MENU_ITEM_NUMBER_COUNTING_PATH)
	public String numberCounting() {
		return SubMenuItem.MATH_BABY_NUMBER_COUNTING.getViewName();
	}

}
