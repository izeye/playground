package com.izeye.playground.support.http.domain;

public interface HTTPConstants {

	String CRLF = "\r\n";

	String HEADER_DELIMITER = ":";
	String PARAMETER_DELIMITER = "=";
	String PARAMETERS_DELIMITER = "&";

	int DEFAULT_PORT = 80;

	String HEADER_HOST = "Host"; // Mandatory header.
	String HEADER_USER_AGENT = "User-Agent";
	String HEADER_REFERER = "Referer";

	String HEADER_CONNECTION = "Connection";
	String HEADER_CONNECTION_CLOSE = "close";

	String HEADER_CONTENT_LENGTH = "Content-Length";

	String HEADER_CONTENT_TYPE = "Content-Type";
	String HEADER_CONTENT_TYPE_APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

}
