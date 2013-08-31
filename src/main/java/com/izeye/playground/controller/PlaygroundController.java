package com.izeye.playground.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_PLAYGROUND_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.support.menu.domain.MenuItem;

@Controller
public class PlaygroundController extends AbstractPlaygroundController {

	@RequestMapping(MENU_ITEM_PLAYGROUND_PATH)
	public String playground(Model model) {
		return MenuItem.PLAYGROUND.getViewName();
	}

}
