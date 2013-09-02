package com.izeye.playground.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import static com.izeye.playground.common.domain.HttpConstants.*;

public class HttpUtils {

	public static String getUserAgent(HttpServletRequest request) {
		return request.getHeader(HEADER_USER_AGENT);
	}

	public static String getReferer(HttpServletRequest request) {
		String referer = request.getHeader(HEADER_REFERER);
		return referer != null ? referer : request.getHeader(HEADER_REFERRER);
	}

	public static InputStream urlToInputStream(String urlAsString)
			throws IOException {
		URL url = new URL(urlAsString);
		return url.openStream();
	}

}
