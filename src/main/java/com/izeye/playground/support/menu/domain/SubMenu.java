package com.izeye.playground.support.menu.domain;

import java.util.List;

public enum SubMenu {

	HOME, PLAYGROUND, TOOLS, MATH, ABOUT, ADMIN;

	private final List<SubMenuItemGroup> subMenuItemGroup;

	private SubMenu() {
		this.subMenuItemGroup = SubMenuItemGroup.getSubMenuItemGroups(this);
	}

	public List<SubMenuItemGroup> getSubMenuItemGroups() {
		return subMenuItemGroup;
	}

}
