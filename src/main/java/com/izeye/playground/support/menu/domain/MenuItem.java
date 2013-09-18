package com.izeye.playground.support.menu.domain;

import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_ABOUT_NAME;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_ABOUT_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_ADMIN_NAME;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_ADMIN_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_HOME_NAME;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_HOME_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_HOME_VIEW_NAME;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_LINKS_NAME;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_LINKS_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_MATH_NAME;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_MATH_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_PLAYGROUND_NAME;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_PLAYGROUND_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_TOOLS_NAME;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_TOOLS_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_USER_NAME;
import static com.izeye.playground.support.menu.domain.MenuConstants.MENU_ITEM_USER_PATH;

public enum MenuItem {

	HOME(MENU_ITEM_HOME_NAME, MENU_ITEM_HOME_PATH, MENU_ITEM_HOME_VIEW_NAME,
			SubMenu.HOME), //
	PLAYGROUND(MENU_ITEM_PLAYGROUND_NAME, MENU_ITEM_PLAYGROUND_PATH,
			SubMenu.PLAYGROUND), //
	TOOLS(MENU_ITEM_TOOLS_NAME, MENU_ITEM_TOOLS_PATH, SubMenu.TOOLS), //
	MATH(MENU_ITEM_MATH_NAME, MENU_ITEM_MATH_PATH, SubMenu.MATH), //
	LINKS(MENU_ITEM_LINKS_NAME, MENU_ITEM_LINKS_PATH, SubMenu.LINKS), //
	ABOUT(MENU_ITEM_ABOUT_NAME, MENU_ITEM_ABOUT_PATH, SubMenu.ABOUT), //
	USER(MENU_ITEM_USER_NAME, MENU_ITEM_USER_PATH, SubMenu.USER), //
	ADMIN(MENU_ITEM_ADMIN_NAME, MENU_ITEM_ADMIN_PATH, SubMenu.ADMIN);

	private final String name;
	private final String path;
	private final String viewName;
	private final SubMenu subMenu;

	private MenuItem(String name, String path, SubMenu subMenu) {
		this(name, path, path.substring(1), subMenu);
	}

	private MenuItem(String name, String path, String viewName, SubMenu subMenu) {
		this.name = name;
		this.path = path;
		this.viewName = viewName;
		this.subMenu = subMenu;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public String getViewName() {
		return viewName;
	}

	public SubMenu getSubMenu() {
		return subMenu;
	}

}
