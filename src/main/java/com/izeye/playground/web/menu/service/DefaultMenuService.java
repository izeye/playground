package com.izeye.playground.web.menu.service;

import static com.izeye.playground.web.menu.domain.MenuConstants.*;
import static com.izeye.playground.web.menu.domain.MenuConstants.MENU_NAME_PLAYGROUND;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_HEADER_ANALYTICS;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_HEADER_DEMO;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_AUDIENCE_ACCESS_LOGS;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_AUDIENCE_OVERVIEW;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_AUDIENCE_USER_AGENTS;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_WEBCAM;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_AUDIENCE_ACCESS_LOGS;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_AUDIENCE_OVERVIEW;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_AUDIENCE_USER_AGENTS;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_WEBCAM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.izeye.playground.web.menu.domain.SubMenuSection;

@Service("menuService")
public class DefaultMenuService implements MenuService {

	private Map<String, List<SubMenuSection>> menuNameAndSubMenuSectionListMap = new HashMap<String, List<SubMenuSection>>();

	@PostConstruct
	public void init() {
		// Playground
		List<SubMenuSection> subMenuSections = new ArrayList<SubMenuSection>();
		SubMenuSection subMenuSection = new SubMenuSection(SUB_MENU_HEADER_DEMO);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_WEBCAM,
				SUB_MENU_ITEM_URL_WEBCAM);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_UA_ANALYZER,
				SUB_MENU_ITEM_URL_UA_ANALYZER);
		subMenuSections.add(subMenuSection);
		menuNameAndSubMenuSectionListMap.put(MENU_NAME_PLAYGROUND,
				subMenuSections);

		// Admin
		subMenuSections = new ArrayList<SubMenuSection>();
		subMenuSection = new SubMenuSection(SUB_MENU_HEADER_ANALYTICS);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_AUDIENCE_OVERVIEW,
				SUB_MENU_ITEM_URL_AUDIENCE_OVERVIEW);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_AUDIENCE_ACCESS_LOGS,
				SUB_MENU_ITEM_URL_AUDIENCE_ACCESS_LOGS);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_AUDIENCE_USER_AGENTS,
				SUB_MENU_ITEM_URL_AUDIENCE_USER_AGENTS);
		subMenuSections.add(subMenuSection);
		menuNameAndSubMenuSectionListMap.put(MENU_NAME_ADMIN, subMenuSections);
	}

	@Override
	public List<SubMenuSection> getSubMenu(String menuName) {
		return menuNameAndSubMenuSectionListMap.get(menuName);
	}

}