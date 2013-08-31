package com.izeye.playground.tools.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_TOOLS_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.support.menu.domain.MenuItem;

@Controller
public class ToolsController extends AbstractToolsController {

	@RequestMapping(MENU_ITEM_TOOLS_PATH)
	public String tools(Model model) {
		return MenuItem.TOOLS.getViewName();
	}

}
