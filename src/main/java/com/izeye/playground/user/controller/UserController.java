package com.izeye.playground.user.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_USER_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.playground.support.menu.domain.MenuItem;

@Controller
public class UserController extends AbstractUserController {

	@RequestMapping(MENU_ITEM_USER_PATH)
	public String user() {
		return MenuItem.USER.getViewName();
	}

}
