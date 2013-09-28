package com.izeye.playground.support.menu.domain;

public interface MenuConstants {

	String MENU_ITEM_HOME_NAME = "Home";
	String MENU_ITEM_HOME_PATH = "/";
	String MENU_ITEM_HOME_VIEW_NAME = "home";

	String MENU_ITEM_PLAYGROUND_NAME = "Playground";
	String MENU_ITEM_PLAYGROUND_PATH = "/playground";

	String SUB_MENU_ITEM_GROUP_PLAYGROUND_ENTERTAINMENT_PATH = MENU_ITEM_PLAYGROUND_PATH
			+ "/entertainment";

	String SUB_MENU_ITEM_KOREAN_LOTTO_GENERATION_NAME = "Korean Lotto";
	String SUB_MENU_ITEM_KOREAN_LOTTO_GENERATION_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_ENTERTAINMENT_PATH
			+ "/korean_lotto/generation";

	String API_PATH_KOREAN_LOTTO_GENERATION_GENERATE = SUB_MENU_ITEM_KOREAN_LOTTO_GENERATION_PATH
			+ "/generate/api";
	String API_PATH_KOREAN_LOTTO_GENERATION_HISTORY = SUB_MENU_ITEM_KOREAN_LOTTO_GENERATION_PATH
			+ "/history/api";

	String SUB_MENU_ITEM_KOREAN_LOTTO_WINNING_HISTORY_NAME = "Korean Lotto Winning History";
	String SUB_MENU_ITEM_KOREAN_LOTTO_WINNING_HISTORY_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_ENTERTAINMENT_PATH
			+ "/korean_lotto/winning_history";

	String API_PATH_KOREAN_LOTTO_WINNING_HISTORY = SUB_MENU_ITEM_KOREAN_LOTTO_WINNING_HISTORY_PATH
			+ "/api";

	String SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH = MENU_ITEM_PLAYGROUND_PATH
			+ "/demo";

	String SUB_MENU_ITEM_WEBCAM_LIVE_NAME = "Webcam";
	String SUB_MENU_ITEM_WEBCAM_LIVE_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/webcam/live";

	String SUB_MENU_ITEM_WEBCAM_SNAPSHOTS_NAME = "Webcam Snapshots";
	String SUB_MENU_ITEM_WEBCAM_SNAPSHOTS_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/webcam/snapshots";

	String SUB_MENU_ITEM_KAKAO_LINK_NAME = "KakaoLink";
	String SUB_MENU_ITEM_KAKAO_LINK_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/kakao_link";

	String SUB_MENU_ITEM_NAVER_SEARCH_RANK_NAME = "Naver Search Rank";
	String SUB_MENU_ITEM_NAVER_SEARCH_RANK_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/naver/search/rank";

	String API_PATH_NAVER_SEARCH_RANK = SUB_MENU_ITEM_NAVER_SEARCH_RANK_PATH
			+ "/api";

	String SUB_MENU_ITEM_NAVER_SEARCH_BLOG_NAME = "Naver Search Blog";
	String SUB_MENU_ITEM_NAVER_SEARCH_BLOG_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/naver/search/blog";

	String API_PATH_NAVER_SEARCH_BLOG = SUB_MENU_ITEM_NAVER_SEARCH_BLOG_PATH
			+ "/api";

	String SUB_MENU_ITEM_NAVER_SEARCH_NEWS_NAME = "Naver Search News";
	String SUB_MENU_ITEM_NAVER_SEARCH_NEWS_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/naver/search/news";

	String API_PATH_NAVER_SEARCH_NEWS = SUB_MENU_ITEM_NAVER_SEARCH_NEWS_PATH
			+ "/api";

	String SUB_MENU_ITEM_NAVER_SEARCH_BOOK_NAME = "Naver Search Book";
	String SUB_MENU_ITEM_NAVER_SEARCH_BOOK_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/naver/search/book";

	String API_PATH_NAVER_SEARCH_BOOK = SUB_MENU_ITEM_NAVER_SEARCH_BOOK_PATH
			+ "/api";

	String SUB_MENU_ITEM_NAVER_SEARCH_RECOMMEND_NAME = "Naver Search Recommendations";
	String SUB_MENU_ITEM_NAVER_SEARCH_RECOMMEND_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/naver/search/recommend";

	String API_PATH_NAVER_SEARCH_RECOMMEND = SUB_MENU_ITEM_NAVER_SEARCH_RECOMMEND_PATH
			+ "/api";

	String SUB_MENU_ITEM_NAVER_SEARCH_CAFE_NAME = "Naver Search Cafe";
	String SUB_MENU_ITEM_NAVER_SEARCH_CAFE_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/naver/search/cafe";

	String API_PATH_NAVER_SEARCH_CAFE = SUB_MENU_ITEM_NAVER_SEARCH_CAFE_PATH
			+ "/api";

	String SUB_MENU_ITEM_NAVER_SEARCH_ADULT_NAME = "Naver Search Adult";
	String SUB_MENU_ITEM_NAVER_SEARCH_ADULT_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/naver/search/adult";

	String API_PATH_NAVER_SEARCH_ADULT = SUB_MENU_ITEM_NAVER_SEARCH_ADULT_PATH
			+ "/api";

	String SUB_MENU_ITEM_NAVER_SEARCH_ENCYCLOPEDIA_NAME = "Naver Search Encyclopedia";
	String SUB_MENU_ITEM_NAVER_SEARCH_ENCYCLOPEDIA_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/naver/search/encyclopedia";

	String API_PATH_NAVER_SEARCH_ENCYCLOPEDIA = SUB_MENU_ITEM_NAVER_SEARCH_ENCYCLOPEDIA_PATH
			+ "/api";

	String SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_NAME = "Naver Search Movie";
	String SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_PATH = SUB_MENU_ITEM_GROUP_PLAYGROUND_DEMO_PATH
			+ "/naver/search/movie";

	String API_PATH_NAVER_SEARCH_MOVIE = SUB_MENU_ITEM_NAVER_SEARCH_MOVIE_PATH
			+ "/api";

	String MENU_ITEM_TOOLS_NAME = "Tools";
	String MENU_ITEM_TOOLS_PATH = "/tools";

	String SUB_MENU_ITEM_GROUP_TOOLS_LIFE_PATH = MENU_ITEM_TOOLS_PATH + "/life";

	String SUB_MENU_ITEM_UNIT_CONVERTER_NAME = "Unit Converter";
	String SUB_MENU_ITEM_UNIT_CONVERTER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LIFE_PATH
			+ "/unit_converter";

	String API_PATH_UNIT_CONVERTER = SUB_MENU_ITEM_UNIT_CONVERTER_PATH + "/api";

	String SUB_MENU_ITEM_TEXT_COUNTER_NAME = "Text Counter";
	String SUB_MENU_ITEM_TEXT_COUNTER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LIFE_PATH
			+ "/text_counter";

	String API_PATH_TEXT_COUNTER = SUB_MENU_ITEM_TEXT_COUNTER_PATH + "/api";

	String SUB_MENU_ITEM_TEXT_2_QR_CODE_IN_JAVA_NAME = "Text 2 QR Code";
	String SUB_MENU_ITEM_TEXT_2_QR_CODE_IN_JAVA_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LIFE_PATH
			+ "/text2qrcode_in_java";

	String API_PATH_TEXT_2_QR_CODE_IN_JAVA = SUB_MENU_ITEM_TEXT_2_QR_CODE_IN_JAVA_PATH
			+ "/api";

	String SUB_MENU_ITEM_TEXT_2_QR_CODE_IN_JAVASCRIPT_NAME = "Text 2 QR Code (JavaScript)";
	String SUB_MENU_ITEM_TEXT_2_QR_CODE_IN_JAVASCRIPT_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LIFE_PATH
			+ "/text2qrcode_in_js";

	String SUB_MENU_ITEM_WORLD_CLOCK_NAME = "World Clock";
	String SUB_MENU_ITEM_WORLD_CLOCK_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LIFE_PATH
			+ "/world_clock";

	String SUB_MENU_ITEM_BOOKMARKLETS_NAME = "Bookmarklets";
	String SUB_MENU_ITEM_BOOKMARKLETS_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LIFE_PATH
			+ "/bookmarklets";

	String SUB_MENU_ITEM_CSV_PARSER_NAME = "CSV Parser";
	String SUB_MENU_ITEM_CSV_PARSER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LIFE_PATH
			+ "/csv_parser";

	String API_PATH_CSV_PARSER = SUB_MENU_ITEM_CSV_PARSER_PATH + "/api";

	String SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH = MENU_ITEM_TOOLS_PATH
			+ "/computer";

	String SUB_MENU_ITEM_TIMESTAMP_2_DATE_AND_TIME_NAME = "Timestamp 2 Date&Time";
	String SUB_MENU_ITEM_TIMESTAMP_2_DATE_AND_TIME_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/timestamp2datetime";

	String API_PATH_TIMESTAMP_2_DATE_AND_TIME = SUB_MENU_ITEM_TIMESTAMP_2_DATE_AND_TIME_PATH
			+ "/timestamp2date/api";
	String API_PATH_DATE_AND_TIME_2_TIMESTAMP = SUB_MENU_ITEM_TIMESTAMP_2_DATE_AND_TIME_PATH
			+ "/date2timestamp/api";

	String SUB_MENU_ITEM_URL_ENCODER_AND_DECODER_NAME = "URL Encoder&Decoder";
	String SUB_MENU_ITEM_URL_ENCODER_AND_DECODER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/url_encoder_and_decoder";

	String API_PATH_URL_ENCODER_AND_DECODER_ENCODE = SUB_MENU_ITEM_URL_ENCODER_AND_DECODER_PATH
			+ "/encode/api";
	String API_PATH_URL_ENCODER_AND_DECODER_DECODE = SUB_MENU_ITEM_URL_ENCODER_AND_DECODER_PATH
			+ "/decode/api";

	String SUB_MENU_ITEM_BASE64_ENCODER_AND_DECODER_NAME = "Base64 Encoder&Decoder";
	String SUB_MENU_ITEM_BASE64_ENCODER_AND_DECODER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/base64_encoder_and_decoder";

	String API_PATH_BASE64_ENCODER_AND_DECODER_ENCODE = SUB_MENU_ITEM_BASE64_ENCODER_AND_DECODER_PATH
			+ "/encode/api";
	String API_PATH_BASE64_ENCODER_AND_DECODER_DECODE = SUB_MENU_ITEM_BASE64_ENCODER_AND_DECODER_PATH
			+ "/decode/api";

	String SUB_MENU_ITEM_UNICODE_ENCODER_AND_DECODER_NAME = "Unicode Encoder&Decoder";
	String SUB_MENU_ITEM_UNICODE_ENCODER_AND_DECODER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/unicode_encoder_and_decoder";

	String API_PATH_UNICODE_ENCODER_AND_DECODER_ENCODE = SUB_MENU_ITEM_UNICODE_ENCODER_AND_DECODER_PATH
			+ "/encode/api";
	String API_PATH_UNICODE_ENCODER_AND_DECODER_DECODE = SUB_MENU_ITEM_UNICODE_ENCODER_AND_DECODER_PATH
			+ "/decode/api";

	String SUB_MENU_ITEM_KOREAN_UNICODE_TABLE_NAME = "Korean Unicode Table";
	String SUB_MENU_ITEM_KOREAN_UNICODE_TABLE_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/korean_unicode_table";

	String SUB_MENU_ITEM_HTML_ESCAPE_AND_UNESCAPE_NAME = "HTML Escape&Unescape";
	String SUB_MENU_ITEM_HTML_ESCAPE_AND_UNESCAPE_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/html_escape_and_unescape";

	String API_PATH_HTML_ESCAPE_AND_UNESCAPE_ESCAPE = SUB_MENU_ITEM_HTML_ESCAPE_AND_UNESCAPE_PATH
			+ "/escape/api";
	String API_PATH_HTML_ESCAPE_AND_UNESCAPE_UNESCAPE = SUB_MENU_ITEM_HTML_ESCAPE_AND_UNESCAPE_PATH
			+ "/unescape/api";

	String SUB_MENU_ITEM_HTTP_CLIENT_NAME = "HTTP Client";
	String SUB_MENU_ITEM_HTTP_CLIENT_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/http_client";

	String API_PATH_HTTP_CLIENT = SUB_MENU_ITEM_HTTP_CLIENT_PATH + "/api";

	String SUB_MENU_ITEM_IP_ANALYZER_NAME = "IP Analyzer";
	String SUB_MENU_ITEM_IP_ANALYZER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/ip_analyzer";

	String API_PATH_IP_ANALYZER = SUB_MENU_ITEM_IP_ANALYZER_PATH + "/api";

	String SUB_MENU_ITEM_UA_ANALYZER_NAME = "UA Analyzer";
	String SUB_MENU_ITEM_UA_ANALYZER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/ua_analyzer";

	String API_PATH_UA_ANALYZER = SUB_MENU_ITEM_UA_ANALYZER_PATH + "/api";

	String SUB_MENU_ITEM_MULTI_WORD_NOTATION_CONVERTER_NAME = "Multi-word Notation Converter";
	String SUB_MENU_ITEM_MULTI_WORD_NOTATION_CONVERTER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/multi_word_notation_converter";

	String API_PATH_MULTI_WORD_NOTATION_CONVERTER = SUB_MENU_ITEM_MULTI_WORD_NOTATION_CONVERTER_PATH
			+ "/api";

	String SUB_MENU_ITEM_BASE_CONVERTER_NAME = "Base Converter";
	String SUB_MENU_ITEM_BASE_CONVERTER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_COMPUTER_PATH
			+ "/base_converter";

	String API_PATH_BASE_CONVERTER = SUB_MENU_ITEM_BASE_CONVERTER_PATH + "/api";

	String SUB_MENU_ITEM_GROUP_TOOLS_LINGUISTICS_PATH = MENU_ITEM_TOOLS_PATH
			+ "/linguistics";

	String SUB_MENU_ITEM_KOREAN_ROMANIZATION_NAME = "Korean Romanization";
	String SUB_MENU_ITEM_KOREAN_ROMANIZATION_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LINGUISTICS_PATH
			+ "/korean_romanization";

	String API_PATH_KOREAN_ROMANIZATION_KOREAN_2_ROMAN = SUB_MENU_ITEM_KOREAN_ROMANIZATION_PATH
			+ "/korean2roman/api";
	String API_PATH_KOREAN_ROMANIZATION_ROMAN_2_KOREAN = SUB_MENU_ITEM_KOREAN_ROMANIZATION_PATH
			+ "/roman2korean/api";

	String SUB_MENU_ITEM_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_NAME = "Korean/English Language Switch Typo Fixer";
	String SUB_MENU_ITEM_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LINGUISTICS_PATH
			+ "/korean_english_language_switch_typo_fixer";

	String API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_KOREAN_2_ENGLISH = SUB_MENU_ITEM_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_PATH
			+ "/korean2english/api";
	String API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_ENGLISH_2_KOREAN = SUB_MENU_ITEM_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_PATH
			+ "/english2korean/api";

	String SUB_MENU_ITEM_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_NAME = "Korean Phoneme Composer&Decomposer";
	String SUB_MENU_ITEM_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LINGUISTICS_PATH
			+ "/korean_phoneme_composer_and_decomposer";

	String API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_COMPOSE = SUB_MENU_ITEM_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_PATH
			+ "/compose/api";
	String API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_DECOMPOSE = SUB_MENU_ITEM_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_PATH
			+ "/decompose/api";

	String SUB_MENU_ITEM_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_NAME = "English LowerCase/UpperCase Converter";
	String SUB_MENU_ITEM_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_PATH = SUB_MENU_ITEM_GROUP_TOOLS_LINGUISTICS_PATH
			+ "/english_lowercase_uppercase_converter";

	String API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_LOWERCASE = SUB_MENU_ITEM_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_PATH
			+ "/to_lowercase/api";
	String API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_UPPERCASE = SUB_MENU_ITEM_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_PATH
			+ "/to_uppercase/api";

	String MENU_ITEM_MATH_NAME = "Math";
	String MENU_ITEM_MATH_PATH = "/math";
	String MENU_ITEM_MATH_VIEW_NAME = "math";

	String SUB_MENU_ITEM_GROUP_MATH_ALGEBRA_PATH = MENU_ITEM_MATH_PATH
			+ "/algebra";

	String SUB_MENU_ITEM_PRIME_NAME = "Prime";
	String SUB_MENU_ITEM_PRIME_PATH = SUB_MENU_ITEM_GROUP_MATH_ALGEBRA_PATH
			+ "/prime";

	String API_PATH_PRIME_IS_PRIME = SUB_MENU_ITEM_PRIME_PATH + "/is_prime/api";
	String API_PATH_PRIME_ALL_PRIMES = SUB_MENU_ITEM_PRIME_PATH
			+ "/all_prime/api";

	String SUB_MENU_ITEM_PRIME_FACTORIZATION_NAME = "Prime Factorization";
	String SUB_MENU_ITEM_PRIME_FACTORIZATION_PATH = SUB_MENU_ITEM_GROUP_MATH_ALGEBRA_PATH
			+ "/prime_factorization";

	String API_PATH_PRIME_FACTORIZATION = SUB_MENU_ITEM_PRIME_FACTORIZATION_PATH
			+ "/api";

	String SUB_MENU_ITEM_GCD_AND_LCM_NAME = "GCD&LCM";
	String SUB_MENU_ITEM_GCD_AND_LCM_PATH = SUB_MENU_ITEM_GROUP_MATH_ALGEBRA_PATH
			+ "/gcd_and_lcm";

	String API_PATH_GCD_AND_LCM = SUB_MENU_ITEM_GCD_AND_LCM_PATH + "/api";

	String SUB_MENU_ITEM_FACTORIAL_NAME = "Factorial";
	String SUB_MENU_ITEM_FACTORIAL_PATH = SUB_MENU_ITEM_GROUP_MATH_ALGEBRA_PATH
			+ "/factorial";

	String API_PATH_FACTORIAL = SUB_MENU_ITEM_FACTORIAL_PATH + "/api";

	String SUB_MENU_ITEM_FIBONACCI_NAME = "Fibonacci Number";
	String SUB_MENU_ITEM_FIBONACCI_PATH = SUB_MENU_ITEM_GROUP_MATH_ALGEBRA_PATH
			+ "/fibonacci";

	String API_PATH_FIBONACCI = SUB_MENU_ITEM_FIBONACCI_PATH + "/api";

	String SUB_MENU_ITEM_GOLDBACH_NAME = "Goldbach's Conjecture";
	String SUB_MENU_ITEM_GOLDBACH_PATH = SUB_MENU_ITEM_GROUP_MATH_ALGEBRA_PATH
			+ "/goldbach";

	String API_PATH_GOLDBACH = SUB_MENU_ITEM_GOLDBACH_PATH + "/api";

	String SUB_MENU_ITEM_COLLATZ_NAME = "Collatz Conjecture";
	String SUB_MENU_ITEM_COLLATZ_PATH = SUB_MENU_ITEM_GROUP_MATH_ALGEBRA_PATH
			+ "/collatz";

	String API_PATH_COLLATZ = SUB_MENU_ITEM_COLLATZ_PATH + "/api";

	String SUB_MENU_ITEM_MEAN_NAME = "Mean";
	String SUB_MENU_ITEM_MEAN_PATH = SUB_MENU_ITEM_GROUP_MATH_ALGEBRA_PATH
			+ "/mean";

	String API_PATH_MEAN = SUB_MENU_ITEM_MEAN_PATH + "/api";

	String SUB_MENU_ITEM_GROUP_MATH_GEOMETRY_PATH = MENU_ITEM_MATH_PATH
			+ "/geometry";

	String SUB_MENU_ITEM_FRACTALS_NAME = "Fractals";
	String SUB_MENU_ITEM_FRACTALS_PATH = SUB_MENU_ITEM_GROUP_MATH_GEOMETRY_PATH
			+ "/fractals";

	String MENU_ITEM_LINKS_NAME = "Links";
	String MENU_ITEM_LINKS_PATH = "/links";

	String SUB_MENU_ITEM_GROUP_LINKS_KID_PATH = MENU_ITEM_LINKS_PATH + "/kid";

	String SUB_MENU_ITEM_ROBOCAR_POLI_NAME = "Robocar Poli";
	String SUB_MENU_ITEM_ROBOCAR_POLI_PATH = SUB_MENU_ITEM_GROUP_LINKS_KID_PATH
			+ "/robocar_poli";

	String MENU_ITEM_ABOUT_NAME = "About";
	String MENU_ITEM_ABOUT_PATH = "/about";

	String SUB_MENU_ITEM_GROUP_ABOUT_ABOUT_ME_PATH = MENU_ITEM_ABOUT_PATH
			+ "/about_me";

	String SUB_MENU_ITEM_ABOUT_ME_NAME = "About Me";
	String SUB_MENU_ITEM_ABOUT_ME_PATH = SUB_MENU_ITEM_GROUP_ABOUT_ABOUT_ME_PATH
			+ "/about_me";

	String SUB_MENU_ITEM_GROUP_ABOUT_LINKS_PATH = MENU_ITEM_ABOUT_PATH
			+ "/links";

	String SUB_MENU_ITEM_LINKS_NAME = "Links";
	String SUB_MENU_ITEM_LINKS_PATH = SUB_MENU_ITEM_GROUP_ABOUT_LINKS_PATH
			+ "/links";

	String SUB_MENU_ITEM_GROUP_ABOUT_SEARCH_PATH = MENU_ITEM_ABOUT_PATH
			+ "/search";

	String SUB_MENU_ITEM_PLAYGROUND_SEARCH_NAME = "Search in izeye's Playground";
	String SUB_MENU_ITEM_PLAYGROUND_SEARCH_PATH = SUB_MENU_ITEM_GROUP_ABOUT_SEARCH_PATH
			+ "/playground";

	String SUB_MENU_ITEM_DEVDAY_SEARCH_NAME = "Search in DevDay";
	String SUB_MENU_ITEM_DEVDAY_SEARCH_PATH = SUB_MENU_ITEM_GROUP_ABOUT_SEARCH_PATH
			+ "/devday";

	String SUB_MENU_ITEM_CTBRG_SEARCH_NAME = "Search in CTB Research Group";
	String SUB_MENU_ITEM_CTBRG_SEARCH_PATH = SUB_MENU_ITEM_GROUP_ABOUT_SEARCH_PATH
			+ "/ctbrg";

	String MENU_ITEM_USER_NAME = "User";
	String MENU_ITEM_USER_PATH = "/user";

	String SUB_MENU_ITEM_GROUP_USER_MY_INFORMATION_PATH = MENU_ITEM_USER_PATH
			+ "/my_information";

	String SUB_MENU_ITEM_CHANGE_PROFILE_NAME = "Change Profile";
	String SUB_MENU_ITEM_CHANGE_PROFILE_PATH = SUB_MENU_ITEM_GROUP_USER_MY_INFORMATION_PATH
			+ "/profile/change";

	String API_PATH_CHANGE_PROFILE = SUB_MENU_ITEM_CHANGE_PROFILE_PATH + "/api";

	String MENU_ITEM_ADMIN_NAME = "Admin";
	String MENU_ITEM_ADMIN_PATH = "/admin";

	String SUB_MENU_ITEM_GROUP_ADMIN_ANALYTICS_PATH = MENU_ITEM_ADMIN_PATH
			+ "/analytics";

	String SUB_MENU_ITEM_AUDIENCE_OVERVIEW_NAME = "Audience Overview";
	String SUB_MENU_ITEM_AUDIENCE_OVERVIEW_PATH = SUB_MENU_ITEM_GROUP_ADMIN_ANALYTICS_PATH
			+ "/audience/overview";

	String SUB_MENU_ITEM_AUDIENCE_ACCESS_LOGS_NAME = "Audience Access Logs";
	String SUB_MENU_ITEM_AUDIENCE_ACCESS_LOGS_PATH = SUB_MENU_ITEM_GROUP_ADMIN_ANALYTICS_PATH
			+ "/audience/access_logs";

	String API_PATH_AUDIENCE_ACCESS_LOGS = SUB_MENU_ITEM_AUDIENCE_ACCESS_LOGS_PATH
			+ "/api";

	String SUB_MENU_ITEM_AUDIENCE_USER_AGENTS_NAME = "Audience User Agents";
	String SUB_MENU_ITEM_AUDIENCE_USER_AGENTS_PATH = SUB_MENU_ITEM_GROUP_ADMIN_ANALYTICS_PATH
			+ "/audience/user_agents";

	String SUB_MENU_ITEM_AUDIENCE_USER_AGENT_SPAM_IPS_NAME = "Audience User Agent Spam IPs";
	String SUB_MENU_ITEM_AUDIENCE_USER_AGENT_SPAM_IPS_PATH = SUB_MENU_ITEM_GROUP_ADMIN_ANALYTICS_PATH
			+ "/audience/user_agent_spam_ips";

	String SUB_MENU_ITEM_QR_CODE_GENERATION_LOGS_NAME = "QR Code Generation Logs";
	String SUB_MENU_ITEM_QR_CODE_GENERATION_LOGS_PATH = SUB_MENU_ITEM_GROUP_ADMIN_ANALYTICS_PATH
			+ "/qrcode/qrcode_generation_logs";

	String SUB_MENU_ITEM_GROUP_ADMIN_MONITORING_PATH = MENU_ITEM_ADMIN_PATH
			+ "/monitoring";

	String SUB_MENU_ITEM_QUOTA_NAME = "Quota";
	String SUB_MENU_ITEM_QUOTA_PATH = SUB_MENU_ITEM_GROUP_ADMIN_MONITORING_PATH
			+ "/quota";

	String SUB_MENU_ITEM_GROUP_ADMIN_MANAGEMENT_PATH = MENU_ITEM_ADMIN_PATH
			+ "/management";

	String SUB_MENU_ITEM_EXECUTE_TEMPORARILY_NAME = "Exectue Temporarily";
	String SUB_MENU_ITEM_EXECUTE_TEMPORARILY_PATH = SUB_MENU_ITEM_GROUP_ADMIN_MANAGEMENT_PATH
			+ "/execute_temporarily";

	String API_PATH_EXECUTE_TEMPORARILY = SUB_MENU_ITEM_EXECUTE_TEMPORARILY_PATH
			+ "/api";

}
