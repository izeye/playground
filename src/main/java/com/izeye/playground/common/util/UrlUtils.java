package com.izeye.playground.common.util;

import static com.izeye.playground.common.domain.HttpConstants.HEADER_LOCATION;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class UrlUtils {

	public static String createUrl(String urlPrefix, Map<String, Object> params) {
		try {
			StringBuilder sbUrl = new StringBuilder(urlPrefix);
			for (Map.Entry<String, Object> param : params.entrySet()) {
				sbUrl.append(param.getKey());
				sbUrl.append('=');
				Object value = param.getValue();
				sbUrl.append(URLEncoder.encode(value.toString(), "UTF-8"));
				sbUrl.append('&');
			}
			sbUrl.deleteCharAt(sbUrl.length() - 1);
			return sbUrl.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String getRedirectedUrl(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url)
					.openConnection();
			connection.setInstanceFollowRedirects(false);
			connection.connect();
			return connection.getHeaderField(HEADER_LOCATION);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
