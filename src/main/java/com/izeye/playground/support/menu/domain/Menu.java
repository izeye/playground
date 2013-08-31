package com.izeye.playground.support.menu.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("menu")
public class Menu {

	private final List<MenuItem> menuItems;

	public Menu() {
		menuItems = Arrays.asList(MenuItem.values());
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	@Override
	public String toString() {
		return "Menu [menuItems=" + menuItems + "]";
	}

}
