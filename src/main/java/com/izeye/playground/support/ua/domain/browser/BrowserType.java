package com.izeye.playground.support.ua.domain.browser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.izeye.playground.common.EnumObjectSerializer;
import com.izeye.playground.common.util.StringConstants;
import com.izeye.playground.support.ua.domain.UnidentifiableUserAgentException;

@JsonSerialize(using = EnumObjectSerializer.class)
public enum BrowserType {

	// NOTE:
	// Chrome has Safari information.
	// So the order is critical between Chrome and Safari.
	NAVER_APP("NAVER", "Naver App", false), GOOGLEBOT("Googlebot", "Googlebot",
			true), EOLIN_NET_BOT("Eolin.Net.ExtHTTPRequest", "Eolin Net Bot",
			true), BINGBOT("bingbot", "Bingbot", true), SEMRUSH_BOT(
			"SemrushBot", "Semrush Bot", true), BAIDUSPIDER("Baiduspider",
			"Baiduspider", true), ZUM_BOT("ZumBot", "Zum Bot", true), JAVA(
			"Java", "Java", true), DAUM_BOT("Daumoa-feedfetcher", "Daum Bot",
			true), YANDEX_BOT("YandexBot", "Yandex Bot", true), YETI_BOT(
			"Yeti", "Yeti Bot", true) /* Naver */, NUMZ_HUB_CRAWLER(
			"NumzHUBcrawler", "Numz HUB Crawler", true), DOCOMO("DoCoMo",
			"DoCoMo", true), CHROME("Chrome", "Chrome", false), IE("MSIE",
			"Internet Explorer", false), FIREFOX("Firefox", "Firefox", false), SAFARI(
			"Safari", "Safari", false), NOT_AVAILABLE(
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE, false);

	private final String keyInUserAgent;
	private final String name;
	private final boolean bot;

	private static final Map<String, BrowserType> keyAndValueMap = new HashMap<String, BrowserType>();
	private static final Set<String> botKeySet = new HashSet<String>();
	static {
		for (BrowserType browserType : values()) {
			keyAndValueMap.put(browserType.getKeyInUserAgent(), browserType);
			if (browserType.isBot()) {
				botKeySet.add(browserType.getKeyInUserAgent());
			}
		}
	}

	private BrowserType(String keyInUserAgent, String name, boolean bot) {
		this.keyInUserAgent = keyInUserAgent;
		this.name = name;
		this.bot = bot;
	}

	public String getKeyInUserAgent() {
		return keyInUserAgent;
	}

	public String getName() {
		return name;
	}

	public boolean isBot() {
		return bot;
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

	public static boolean isBot(String key) {
		return botKeySet.contains(key);
	}

}
