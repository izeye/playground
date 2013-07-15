package com.izeye.playground.support.ua.domain.browser;

import java.util.HashMap;
import java.util.Map;

import com.izeye.playground.support.ua.domain.UnidentifiableUserAgentException;

public enum BrowserType {

	// NOTE:
	// Chrome has Safari information.
	// So the order is critical between Chrome and Safari.
	CHROME("Chrome", "Chrome"), IE("MSIE", "Internet Explorer"), GOOGLEBOT(
			"Googlebot", "Googlebot"), FIREFOX("Firefox", "Firefox"), SAFARI(
			"Safari", "Safari"), EOLIN_NET_BOT("Eolin.Net.ExtHTTPRequest",
			"Eolin Net Bot"), BINGBOT("bingbot", "Bingbot"), SEMRUSH_BOT(
			"SemrushBot", "Semrush Bot"), BAIDUSPIDER("Baiduspider",
			"Baiduspider");

	private final String keyInUserAgent;
	private final String name;

	private static final Map<String, BrowserType> keyAndValueMap = new HashMap<String, BrowserType>();
	static {
		for (BrowserType browserType : values()) {
			keyAndValueMap.put(browserType.getKeyInUserAgent(), browserType);
		}
	}

	private BrowserType(String keyInUserAgent, String name) {
		this.keyInUserAgent = keyInUserAgent;
		this.name = name;
	}

	public String getKeyInUserAgent() {
		return keyInUserAgent;
	}

	public String getName() {
		return name;
	}

	public static BrowserType extractFromUserAgent(String userAgent) {
		for (BrowserType browserType : values()) {
			if (userAgent.contains(browserType.getKeyInUserAgent())) {
				return browserType;
			}
		}

		throw new UnidentifiableUserAgentException(
				"Unidentifiable browser type: " + userAgent);
	}

	public static BrowserType getBrowserTypeFromKey(String key) {
		return keyAndValueMap.get(key);
	}

}
