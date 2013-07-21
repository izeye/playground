package com.izeye.playground.common.util;

import java.util.Map;

public class URLUtils {

	public static String createURL(String urlPrefix, Map<String, Object> params) {
		StringBuilder sbURL = new StringBuilder(urlPrefix);
		for (Map.Entry<String, Object> param : params.entrySet()) {
			sbURL.append(param.getKey());
			sbURL.append('=');
			Object value = param.getValue();
			// sbParams.append(value == null ? "" : value);
			sbURL.append(value);
			sbURL.append('&');
		}
		sbURL.deleteCharAt(sbURL.length() - 1);
		return sbURL.toString();
	}

}
