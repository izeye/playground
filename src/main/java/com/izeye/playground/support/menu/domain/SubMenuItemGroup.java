package com.izeye.playground.support.menu.domain;

import java.util.ArrayList;
import java.util.List;

public enum SubMenuItemGroup {

	PLAYGROUND_DEMO("Demo"), //
	TOOLS_LIFE("Life"), //
	TOOLS_COMPUTER("Computer"), //
	TOOLS_LINGUISTICS("Linguistics"), //
	MATH_ALGEBRA("Algebra"), //
	MATH_GEOMETRY("Geometry"), //
	ABOUT_ABOUT_ME("About Me"), //
	ABOUT_LINKS("Links"), //
	ADMIN_ANALYTICS("Analytics");

	private final String name;
	private final List<SubMenuItem> subMenuItem;

	private SubMenuItemGroup(String name) {
		this.name = name;

		this.subMenuItem = SubMenuItem.getSubMenuItems(this);
	}

	public String getName() {
		return name;
	}

	public List<SubMenuItem> getSubMenuItems() {
		return subMenuItem;
	}

	public static List<SubMenuItemGroup> getSubMenuItemGroups(SubMenu subMenu) {
		List<SubMenuItemGroup> groups = new ArrayList<SubMenuItemGroup>();
		for (SubMenuItemGroup group : values()) {
			if (group.name().startsWith(subMenu.name())) {
				groups.add(group);
			}
		}
		return groups;
	}

}
