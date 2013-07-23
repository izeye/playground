package com.izeye.playground.web.menu.domain;

public interface MenuConstants {

	String MENU_NAME_HOME = "Home";
	String MENU_NAME_PLAYGROUND = "Playground";
	String MENU_NAME_ABOUT = "About";
	String MENU_NAME_LINKS = "Links";
	String MENU_NAME_ADMIN = "Admin";

	String SUB_MENU_HEADER_UTILITIES = "Utilities";

	String SUB_MENU_ITEM_NAME_TEXT_2_QR_CODE = "Text 2 QR Code";
	String SUB_MENU_ITEM_URL_TEXT_2_QR_CODE = "/playground/utilities/text2qrcode";

	String SUB_MENU_ITEM_NAME_IP_ANALYZER = "IP Analyzer";
	String SUB_MENU_ITEM_URL_IP_ANALYZER = "/playground/utilities/ip";

	String SUB_MENU_ITEM_NAME_UA_ANALYZER = "UA Analyzer";
	String SUB_MENU_ITEM_URL_UA_ANALYZER = "/playground/utilities/ua";

	String SUB_MENU_ITEM_NAME_WORLD_CLOCK = "World Clock";
	String SUB_MENU_ITEM_URL_WORLD_CLOCK = "/playground/utilities/world_clock";

	String SUB_MENU_HEADER_MATH = "Math";

	String SUB_MENU_ITEM_NAME_FRACTALS = "Fractals";
	String SUB_MENU_ITEM_URL_FRACTALS = "/playground/math/fractals";

	String SUB_MENU_ITEM_NAME_COLLATZ = "Collatz Conjecture";
	String SUB_MENU_ITEM_URL_COLLATZ = "/playground/math/collatz";

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

	String SUB_MENU_ITEM_NAME_AUDIENCE_QR_CODE_GENERATION_LOGS = "QR Code Generation Logs";
	String SUB_MENU_ITEM_URL_AUDIENCE_QR_CODE_GENERATION_LOGS = "/admin/analytics/qrcode/qrcode_generation_logs";

}
