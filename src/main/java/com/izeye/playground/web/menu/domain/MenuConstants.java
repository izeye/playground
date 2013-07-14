package com.izeye.playground.web.menu.domain;

public interface MenuConstants {

	String MENU_NAME_HOME = "Home";
	String MENU_NAME_PLAYGROUND = "Playground";
	String MENU_NAME_ABOUT = "About";
	String MENU_NAME_LINKS = "Links";
	String MENU_NAME_ADMIN = "Admin";

	String SUB_MENU_HEADER_DEMO = "Demo";

	String SUB_MENU_ITEM_NAME_WEBCAM = "Webcam";
	String SUB_MENU_ITEM_URL_WEBCAM = "/playground/demo/webcam/live";

	String SUB_MENU_HEADER_ANALYTICS = "Analytics";

	String SUB_MENU_ITEM_NAME_AUDIENCE_OVERVIEW = "Audience Overview";
	String SUB_MENU_ITEM_URL_AUDIENCE_OVERVIEW = "/admin/analytics/audience/overview";

	String SUB_MENU_ITEM_NAME_AUDIENCE_ACCESS_LOGS = "Audience Access Logs";
	String SUB_MENU_ITEM_URL_AUDIENCE_ACCESS_LOGS = "/admin/analytics/audience/access_logs";

	String SUB_MENU_ITEM_NAME_AUDIENCE_USER_AGENTS = "Audience User Agents";
	String SUB_MENU_ITEM_URL_AUDIENCE_USER_AGENTS = "/admin/analytics/audience/user_agents";

}
