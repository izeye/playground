package com.izeye.playground.support.http.client.domain;

import static com.izeye.playground.support.http.domain.HTTPConstants.HEADER_CONNECTION_CLOSE;
import static com.izeye.playground.web.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_HTTP_CLIENT;

import java.math.BigDecimal;

import com.izeye.playground.support.unit.domain.DigitalStorageUnit;

public interface HTTPClientConstants {

	String DEFAULT_HTTP_VERSION = "1.1";

	String DEFAULT_PATH = "/";

	String DEFAULT_USER_AGENT_NAME = "izeye-http-client";
	String DEFAULT_USER_AGENT_VERSION = "1.0";
	String DEFAULT_HEADER_USER_AGENT = DEFAULT_USER_AGENT_NAME + "/"
			+ DEFAULT_USER_AGENT_VERSION;

	String DEFAULT_HEADER_REFERER = "http://izeye.cafe24.com"
			+ SUB_MENU_ITEM_URL_HTTP_CLIENT;

	String DEFAULT_HEADER_CONNECTION = HEADER_CONNECTION_CLOSE;

	int DEFAULT_RESPONSE_CONTENT_LENGTH_LIMIT = DigitalStorageUnit.MEGABYTE
			.toByte(BigDecimal.ONE).intValue();

}
