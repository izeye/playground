package com.izeye.playground.web.menu.service;

import java.util.List;

import com.izeye.playground.web.menu.domain.SubMenuSection;

public interface MenuService {

	List<SubMenuSection> getSubMenu(String menuName);

}
