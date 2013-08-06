package com.izeye.playground.web.menu.service;

import static com.izeye.playground.web.menu.domain.MenuConstants.*;
import static com.izeye.playground.web.menu.domain.MenuConstants.MENU_NAME_PLAYGROUND;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_HEADER_ANALYTICS;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_HEADER_DEMO;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_HEADER_UTILITIES;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_AUDIENCE_ACCESS_LOGS;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_AUDIENCE_OVERVIEW;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_AUDIENCE_USER_AGENTS;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_IP_ANALYZER;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_TEXT_2_QR_CODE;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_UA_ANALYZER;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_NAME_WEBCAM;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_AUDIENCE_ACCESS_LOGS;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_AUDIENCE_OVERVIEW;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_AUDIENCE_USER_AGENTS;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_IP_ANALYZER;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_TEXT_2_QR_CODE;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_UA_ANALYZER;
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

		// Playground -> Utilities
		SubMenuSection subMenuSection = new SubMenuSection(
				SUB_MENU_HEADER_UTILITIES);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_TIMESTAMP_2_DATE,
				SUB_MENU_ITEM_URL_TIMESTAMP_2_DATE);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_UNIT_CONVERSION,
				SUB_MENU_ITEM_URL_UNIT_CONVERSION);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_TEXT_2_QR_CODE,
				SUB_MENU_ITEM_URL_TEXT_2_QR_CODE);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_IP_ANALYZER,
				SUB_MENU_ITEM_URL_IP_ANALYZER);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_UA_ANALYZER,
				SUB_MENU_ITEM_URL_UA_ANALYZER);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_WORLD_CLOCK,
				SUB_MENU_ITEM_URL_WORLD_CLOCK);
		subMenuSections.add(subMenuSection);

		// Playground -> Math
		subMenuSection = new SubMenuSection(SUB_MENU_HEADER_MATH);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_FRACTALS,
				SUB_MENU_ITEM_URL_FRACTALS);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_GCD_AND_LCM,
				SUB_MENU_ITEM_URL_GCD_AND_LCM);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_PRIME,
				SUB_MENU_ITEM_URL_PRIME);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_PRIME_FACTORIZATION,
				SUB_MENU_ITEM_URL_PRIME_FACTORIZATION);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_FACTORIAL,
				SUB_MENU_ITEM_URL_FACTORIAL);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_FIBONACCI,
				SUB_MENU_ITEM_URL_FIBONACCI);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_COLLATZ,
				SUB_MENU_ITEM_URL_COLLATZ);
		subMenuSections.add(subMenuSection);

		// Playground -> Demo
		subMenuSection = new SubMenuSection(SUB_MENU_HEADER_DEMO);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_WEBCAM,
				SUB_MENU_ITEM_URL_WEBCAM);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_KAKAO_LINK,
				SUB_MENU_ITEM_URL_KAKAO_LINK);
		subMenuSections.add(subMenuSection);

		menuNameAndSubMenuSectionListMap.put(MENU_NAME_PLAYGROUND,
				subMenuSections);

		// Admin
		subMenuSections = new ArrayList<SubMenuSection>();

		// Admin -> Analytics
		subMenuSection = new SubMenuSection(SUB_MENU_HEADER_ANALYTICS);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_AUDIENCE_OVERVIEW,
				SUB_MENU_ITEM_URL_AUDIENCE_OVERVIEW);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_AUDIENCE_ACCESS_LOGS,
				SUB_MENU_ITEM_URL_AUDIENCE_ACCESS_LOGS);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_AUDIENCE_USER_AGENTS,
				SUB_MENU_ITEM_URL_AUDIENCE_USER_AGENTS);
		subMenuSection.addMenuItem(
				SUB_MENU_ITEM_NAME_AUDIENCE_QR_CODE_GENERATION_LOGS,
				SUB_MENU_ITEM_URL_AUDIENCE_QR_CODE_GENERATION_LOGS);
		subMenuSections.add(subMenuSection);

		menuNameAndSubMenuSectionListMap.put(MENU_NAME_ADMIN, subMenuSections);
	}

	@Override
	public List<SubMenuSection> getSubMenu(String menuName) {
		return menuNameAndSubMenuSectionListMap.get(menuName);
	}

}
