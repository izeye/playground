package com.izeye.playground.user.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_CHANGE_PROFILE;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_CHANGE_PROFILE_PATH;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.support.menu.domain.SubMenuItem;
import com.izeye.playground.support.user.domain.User;
import com.izeye.playground.support.user.service.UserService;

@Controller
public class UserMyInformationController extends AbstractUserController {

	@Resource
	private UserService userService;

	@RequestMapping(SUB_MENU_ITEM_CHANGE_PROFILE_PATH)
	public String changeProfile(Model model) {
		model.addAttribute("API_PATH_CHANGE_PROFILE", API_PATH_CHANGE_PROFILE);

		return SubMenuItem.USER_MY_INFORMATION_CHANGE_PROFILE.getViewName();
	}

	@RequestMapping(API_PATH_CHANGE_PROFILE)
	@ResponseBody
	public String changeProfileApi() {
		User user = new User();
		user.setName("test");
		userService.changeProfile(user);

		return "Success";
	}

}
