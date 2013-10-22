package com.izeye.playground.support.menu.domain;

import static com.izeye.playground.support.menu.domain.MenuConstants.*;

import java.util.ArrayList;
import java.util.List;

// NOTE:
// The menu starting with underscore (_) is a hidden menu.
public enum SubMenuItem {

	PLAYGROUND_ENTERTAINMENT_KOREAN_LOTTO_GENERATION(
			SUB_MENU_ITEM_KOREAN_LOTTO_GENERATION_NAME,
			SUB_MENU_ITEM_KOREAN_LOTTO_GENERATION_PATH), //
	_PLAYGROUND_ENTERTAINMENT_KOREAN_LOTTO_WINNING_HISTORY(
			SUB_MENU_ITEM_KOREAN_LOTTO_WINNING_HISTORY_NAME,
			SUB_MENU_ITEM_KOREAN_LOTTO_WINNING_HISTORY_PATH), //
	PLAYGROUND_DEMO_WEBCAM_LIVE(SUB_MENU_ITEM_WEBCAM_LIVE_NAME,
			SUB_MENU_ITEM_WEBCAM_LIVE_PATH), //
	_PLAYGROUND_DEMO_WEBCAM_SNAPSHOTS(SUB_MENU_ITEM_WEBCAM_SNAPSHOTS_NAME,
			SUB_MENU_ITEM_WEBCAM_SNAPSHOTS_PATH), //
	PLAYGROUND_DEMO_KAKAO_LINK(SUB_MENU_ITEM_KAKAO_LINK_NAME,
			SUB_MENU_ITEM_KAKAO_LINK_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_RANK(SUB_MENU_ITEM_NAVER_SEARCH_RANK_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_RANK_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_BLOG(SUB_MENU_ITEM_NAVER_SEARCH_BLOG_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_BLOG_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_NEWS(SUB_MENU_ITEM_NAVER_SEARCH_NEWS_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_NEWS_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_BOOK(SUB_MENU_ITEM_NAVER_SEARCH_BOOK_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_BOOK_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_RECOMMEND(
			SUB_MENU_ITEM_NAVER_SEARCH_RECOMMEND_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_RECOMMEND_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_CAFE(SUB_MENU_ITEM_NAVER_SEARCH_CAFE_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_CAFE_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_ADULT(SUB_MENU_ITEM_NAVER_SEARCH_ADULT_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_ADULT_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_ENCYCLOPEDIA(
			SUB_MENU_ITEM_NAVER_SEARCH_ENCYCLOPEDIA_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_ENCYCLOPEDIA_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_MOVIE(SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_CAFE_ARTICLE(
			SUB_MENU_ITEM_NAVER_SEARCH_CAFE_ARTICLE_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_CAFE_ARTICLE_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_MOVIE_ACTOR(
			SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_ACTOR_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_ACTOR_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_CAR(SUB_MENU_ITEM_NAVER_SEARCH_CAR_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_CAR_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_SHORTCUT(
			SUB_MENU_ITEM_NAVER_SEARCH_SHORTCUT_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_SHORTCUT_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_KIN(SUB_MENU_ITEM_NAVER_SEARCH_KIN_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_KIN_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_LOCAL(SUB_MENU_ITEM_NAVER_SEARCH_LOCAL_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_LOCAL_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_WEB(SUB_MENU_ITEM_NAVER_SEARCH_WEB_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_WEB_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_TYPO(SUB_MENU_ITEM_NAVER_SEARCH_TYPO_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_TYPO_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_IMAGE(SUB_MENU_ITEM_NAVER_SEARCH_IMAGE_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_IMAGE_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_SHOPPING(
			SUB_MENU_ITEM_NAVER_SEARCH_SHOPPING_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_SHOPPING_PATH), //
	PLAYGROUND_DEMO_NAVER_SEARCH_DOCUMENT(
			SUB_MENU_ITEM_NAVER_SEARCH_DOCUMENT_NAME,
			SUB_MENU_ITEM_NAVER_SEARCH_DOCUMENT_PATH), //
	PLAYGROUND_DEMO_DAUM_MYPEOPLE_BOT(SUB_MENU_ITEM_DAUM_MYPEOPLE_BOT_NAME,
			SUB_MENU_ITEM_DAUM_MYPEOPLE_BOT_PATH), //
	TOOLS_LIFE_UNIT_CONVERTER(SUB_MENU_ITEM_UNIT_CONVERTER_NAME,
			SUB_MENU_ITEM_UNIT_CONVERTER_PATH), //
	TOOLS_LIFE_TEXT_COUNTER(SUB_MENU_ITEM_TEXT_COUNTER_NAME,
			SUB_MENU_ITEM_TEXT_COUNTER_PATH), //
	TOOLS_LIFE_TEXT_2_QR_CODE_IN_JAVA(
			SUB_MENU_ITEM_TEXT_2_QR_CODE_IN_JAVA_NAME,
			SUB_MENU_ITEM_TEXT_2_QR_CODE_IN_JAVA_PATH), //
	_TOOLS_LIFE_TEXT_2_QR_CODE_IN_JAVASCRIPT(
			SUB_MENU_ITEM_TEXT_2_QR_CODE_IN_JAVASCRIPT_NAME,
			SUB_MENU_ITEM_TEXT_2_QR_CODE_IN_JAVASCRIPT_PATH), //
	TOOLS_LIFE_WORLD_CLOCK(SUB_MENU_ITEM_WORLD_CLOCK_NAME,
			SUB_MENU_ITEM_WORLD_CLOCK_PATH), //
	TOOLS_LIFE_BOOKMARKLETS(SUB_MENU_ITEM_BOOKMARKLETS_NAME,
			SUB_MENU_ITEM_BOOKMARKLETS_PATH), //
	TOOLS_LIFE_CSV_PARSER(SUB_MENU_ITEM_CSV_PARSER_NAME,
			SUB_MENU_ITEM_CSV_PARSER_PATH), //
	TOOLS_LIFE_TEXT_2_IMAGE(SUB_MENU_ITEM_TEXT_2_IMAGE_NAME,
			SUB_MENU_ITEM_TEXT_2_IMAGE_PATH), //
	TOOLS_LIFE_DRAW_IMAGE(SUB_MENU_ITEM_DRAW_IMAGE_NAME,
			SUB_MENU_ITEM_DRAW_IMAGE_PATH), //
	TOOLS_COMPUTER_TIMESTAMP_2_DATE_AND_TIME(
			SUB_MENU_ITEM_TIMESTAMP_2_DATE_AND_TIME_NAME,
			SUB_MENU_ITEM_TIMESTAMP_2_DATE_AND_TIME_PATH), //
	TOOLS_COMPUTER_URL_ENCODER_AND_DECODER(
			SUB_MENU_ITEM_URL_ENCODER_AND_DECODER_NAME,
			SUB_MENU_ITEM_URL_ENCODER_AND_DECODER_PATH), //
	TOOLS_COMPUTER_BASE64_ENCODER_AND_DECODER(
			SUB_MENU_ITEM_BASE64_ENCODER_AND_DECODER_NAME,
			SUB_MENU_ITEM_BASE64_ENCODER_AND_DECODER_PATH), //
	TOOLS_COMPUTER_UNICODE_ENCODER_AND_DECODER(
			SUB_MENU_ITEM_UNICODE_ENCODER_AND_DECODER_NAME,
			SUB_MENU_ITEM_UNICODE_ENCODER_AND_DECODER_PATH), //
	TOOLS_COMPUTER_KOREAN_UNICODE_TABLE(
			SUB_MENU_ITEM_KOREAN_UNICODE_TABLE_NAME,
			SUB_MENU_ITEM_KOREAN_UNICODE_TABLE_PATH), //
	TOOLS_COMPUTER_HTML_ESCAPE_AND_UNESCAPE(
			SUB_MENU_ITEM_HTML_ESCAPE_AND_UNESCAPE_NAME,
			SUB_MENU_ITEM_HTML_ESCAPE_AND_UNESCAPE_PATH), //
	TOOLS_COMPUTER_HTTP_CLIENT(SUB_MENU_ITEM_HTTP_CLIENT_NAME,
			SUB_MENU_ITEM_HTTP_CLIENT_PATH), //
	TOOLS_COMPUTER_IP_ANALYZER(SUB_MENU_ITEM_IP_ANALYZER_NAME,
			SUB_MENU_ITEM_IP_ANALYZER_PATH), //
	TOOLS_COMPUTER_UA_ANALYZER(SUB_MENU_ITEM_UA_ANALYZER_NAME,
			SUB_MENU_ITEM_UA_ANALYZER_PATH), //
	TOOLS_COMPUTER_MULTI_WORD_NOTATION_CONVERTER(
			SUB_MENU_ITEM_MULTI_WORD_NOTATION_CONVERTER_NAME,
			SUB_MENU_ITEM_MULTI_WORD_NOTATION_CONVERTER_PATH), //
	TOOLS_COMPUTER_BASE_CONVERTER(SUB_MENU_ITEM_BASE_CONVERTER_NAME,
			SUB_MENU_ITEM_BASE_CONVERTER_PATH), //
	TOOLS_LINGUISTICS_KOREAN_ROMANIZATION(
			SUB_MENU_ITEM_KOREAN_ROMANIZATION_NAME,
			SUB_MENU_ITEM_KOREAN_ROMANIZATION_PATH), //
	TOOLS_LINGUISTICS_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER(
			SUB_MENU_ITEM_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_NAME,
			SUB_MENU_ITEM_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_PATH), //
	TOOLS_LINGUISTICS_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER(
			SUB_MENU_ITEM_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_NAME,
			SUB_MENU_ITEM_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_PATH), //
	TOOLS_LINGUISTICS_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER(
			SUB_MENU_ITEM_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_NAME,
			SUB_MENU_ITEM_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_PATH), //
	MATH_BABY_NUMBER_COUNTING(SUB_MENU_ITEM_NUMBER_COUNTING_NAME,
			SUB_MENU_ITEM_NUMBER_COUNTING_PATH), //
	MATH_ALGEBRA_PRIME(SUB_MENU_ITEM_PRIME_NAME, SUB_MENU_ITEM_PRIME_PATH), //
	MATH_ALGEBRA_PRIME_FACTORIZATION(SUB_MENU_ITEM_PRIME_FACTORIZATION_NAME,
			SUB_MENU_ITEM_PRIME_FACTORIZATION_PATH), //
	MATH_ALGEBRA_GCD_AND_LCM(SUB_MENU_ITEM_GCD_AND_LCM_NAME,
			SUB_MENU_ITEM_GCD_AND_LCM_PATH), //
	MATH_ALGEBRA_FACTORIAL(SUB_MENU_ITEM_FACTORIAL_NAME,
			SUB_MENU_ITEM_FACTORIAL_PATH), //
	MATH_ALGEBRA_FIBONACCI(SUB_MENU_ITEM_FIBONACCI_NAME,
			SUB_MENU_ITEM_FIBONACCI_PATH), //
	MATH_ALGEBRA_GOLDBACH(SUB_MENU_ITEM_GOLDBACH_NAME,
			SUB_MENU_ITEM_GOLDBACH_PATH), //
	MATH_ALGEBRA_COLLATZ(SUB_MENU_ITEM_COLLATZ_NAME, SUB_MENU_ITEM_COLLATZ_PATH), //
	MATH_ALGEBRA_MEAN(SUB_MENU_ITEM_MEAN_NAME, SUB_MENU_ITEM_MEAN_PATH), //
	MATH_GEOMETRY_FRACTALS(SUB_MENU_ITEM_FRACTALS_NAME,
			SUB_MENU_ITEM_FRACTALS_PATH), //
	LINKS_KID_ROBOCAR_POLI_PATH(SUB_MENU_ITEM_ROBOCAR_POLI_NAME,
			SUB_MENU_ITEM_ROBOCAR_POLI_PATH), //
	ABOUT_ABOUT_ME_ABOUT_ME_PATH(SUB_MENU_ITEM_ABOUT_ME_NAME,
			SUB_MENU_ITEM_ABOUT_ME_PATH), //
	ABOUT_LINKS_LINKS_PATH(SUB_MENU_ITEM_LINKS_NAME, SUB_MENU_ITEM_LINKS_PATH), //
	ABOUT_SEARCH_PLAYGROUND_PATH(SUB_MENU_ITEM_PLAYGROUND_SEARCH_NAME,
			SUB_MENU_ITEM_PLAYGROUND_SEARCH_PATH), //
	ABOUT_SEARCH_DEVDAY_PATH(SUB_MENU_ITEM_DEVDAY_SEARCH_NAME,
			SUB_MENU_ITEM_DEVDAY_SEARCH_PATH), //
	ABOUT_SEARCH_CTBRG_PATH(SUB_MENU_ITEM_CTBRG_SEARCH_NAME,
			SUB_MENU_ITEM_CTBRG_SEARCH_PATH), //
	USER_MY_INFORMATION_CHANGE_PROFILE(SUB_MENU_ITEM_CHANGE_PROFILE_NAME,
			SUB_MENU_ITEM_CHANGE_PROFILE_PATH), //
	ADMIN_ANALYTICS_AUDIENCE_OVERVIEW(SUB_MENU_ITEM_AUDIENCE_OVERVIEW_NAME,
			SUB_MENU_ITEM_AUDIENCE_OVERVIEW_PATH), //
	ADMIN_ANALYTICS_AUDIENCE_ACCESS_LOGS(
			SUB_MENU_ITEM_AUDIENCE_ACCESS_LOGS_NAME,
			SUB_MENU_ITEM_AUDIENCE_ACCESS_LOGS_PATH), //
	ADMIN_ANALYTICS_AUDIENCE_USER_AGENTS(
			SUB_MENU_ITEM_AUDIENCE_USER_AGENTS_NAME,
			SUB_MENU_ITEM_AUDIENCE_USER_AGENTS_PATH), //
	ADMIN_ANALYTICS_AUDIENCE_USER_AGENT_SPAM_IPS(
			SUB_MENU_ITEM_AUDIENCE_USER_AGENT_SPAM_IPS_NAME,
			SUB_MENU_ITEM_AUDIENCE_USER_AGENT_SPAM_IPS_PATH), //
	ADMIN_ANALYTICS_QR_CODE_GENERATION_LOGS(
			SUB_MENU_ITEM_QR_CODE_GENERATION_LOGS_NAME,
			SUB_MENU_ITEM_QR_CODE_GENERATION_LOGS_PATH), //
	ADMIN_MONITORING_QUOTA(SUB_MENU_ITEM_QUOTA_NAME, SUB_MENU_ITEM_QUOTA_PATH), //
	ADMIN_MANAGEMENT_EXECUTE_TEMPORARILY(
			SUB_MENU_ITEM_EXECUTE_TEMPORARILY_NAME,
			SUB_MENU_ITEM_EXECUTE_TEMPORARILY_PATH);

	private final String name;
	private final String path;
	private final String viewName;

	private SubMenuItem(String name, String path) {
		this.name = name;
		this.path = path;
		this.viewName = path.substring(1);
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

	public static List<SubMenuItem> getSubMenuItems(SubMenuItemGroup group) {
		List<SubMenuItem> items = new ArrayList<SubMenuItem>();
		for (SubMenuItem item : values()) {
			if (item.name().startsWith(group.name())) {
				items.add(item);
			}
		}
		return items;
	}

}
