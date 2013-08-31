package com.izeye.playground.math.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_FRACTALS_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class MathGeometryController extends AbstractMathController {

	@RequestMapping(SUB_MENU_ITEM_FRACTALS_PATH)
	public String mathFractals(Model model) {
		return SubMenuItem.MATH_GEOMETRY_FRACTALS.getViewName();
	}

}
