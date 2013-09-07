package com.izeye.playground.common.util;

import java.util.Map;

public class UrlUtils {

	public static String createUrl(String urlPrefix, Map<String, Object> params) {
		StringBuilder sbUrl = new StringBuilder(urlPrefix);
		for (Map.Entry<String, Object> param : params.entrySet()) {
			sbUrl.append(param.getKey());
			sbUrl.append('=');
			Object value = param.getValue();
			// sbParams.append(value == null ? "" : value);
			sbUrl.append(value);
			sbUrl.append('&');
		}
		sbUrl.deleteCharAt(sbUrl.length() - 1);
		return sbUrl.toString();
	}

}
