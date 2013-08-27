package com.izeye.playground.support.ua.domain.browser;

import static com.izeye.playground.support.ua.domain.browser.BrowserCategory.APP;
import static com.izeye.playground.support.ua.domain.browser.BrowserCategory.BOT;
import static com.izeye.playground.support.ua.domain.browser.BrowserCategory.NORMAL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.izeye.playground.common.EnumObjectSerializer;
import com.izeye.playground.common.domain.StringConstants;

@JsonSerialize(using = EnumObjectSerializer.class)
public enum BrowserType {

	// NOTE:
	// Chrome has Safari information.
	// So the order is critical between Chrome and Safari.
	NAVER_APP("NAVER", "Naver App", APP), //
	FACEBOOK_APP("FBAN", "Facebook App", APP), //
	DAUM_APP("DaumApps", " Daum App", APP), //
	GOOGLEBOT_IMAGE("Googlebot-Image", "Googlebot Image", BOT), //
	GOOGLE_PRODUCER("GoogleProducer", "Google Producer", BOT), //
	GOOGLE_BOT_MOBILE("Googlebot-Mobile", "Googlebot Mobile", BOT), //
	GOOGLEBOT("Googlebot", "Googlebot", BOT), //
	GOOGLE_APP_ENGINE("AppEngine-Google", "Google AppEngine", BOT), //
	EOLIN_NET_BOT("Eolin.Net.ExtHTTPRequest", "Eolin Net Bot", BOT), //
	BINGBOT("bingbot", "Bingbot", BOT), //
	SEMRUSH_BOT("SemrushBot", "Semrush Bot", BOT), //
	BAIDUSPIDER("Baiduspider", "Baiduspider", BOT), //
	ZUM_BOT("ZumBot", "Zum Bot", BOT), //
	DAUM_BOT("Daumoa-feedfetcher", "Daum Bot", BOT), //
	YANDEX_BOT("YandexBot", "Yandex Bot", BOT), //
	YETI_BOT("Yeti", "Yeti Bot", BOT) /* Naver */, //
	NUMZ_HUB_CRAWLER("NumzHUBcrawler", "Numz HUB Crawler", BOT), //
	DOCOMO("DoCoMo", "DoCoMo", BOT), //
	FACEBOOK_EXTERNAL_HIT("facebookexternalhit", "Facebook External Hit", BOT), //
	SHOWYOU_BOT("ShowyouBot", "Showyou Bot", BOT), //
	MSN_BOT("msnbot", "MSN Bot", BOT), //
	ALEXA_CRAWLER("ia_archiver", "Alexa Crawler", BOT), //
	EZOOMS_BOT("Ezooms", "Ezooms Bot", BOT), //
	AHREFS_BOT("AhrefsBot", "Ahrefs Bot", BOT), //
	EXABOT("Exabot", "Exabot", BOT), //
	ABONTI("Abonti", "Abonti", BOT), //
	JAVA("Java", "Java", BOT), //
	PYTHON("python-requests", "Python", BOT), //
	CHROME("Chrome", "Chrome", NORMAL), //
	IE("MSIE", "Internet Explorer", NORMAL), //
	FIREFOX("Firefox", "Firefox", NORMAL), //
	SAFARI("Safari", "Safari", NORMAL), //
	OPERA("Opera", "Opera", NORMAL), //
	NOT_AVAILABLE(StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE,
			BrowserCategory.NOT_AVAILABLE);

	private final String keyInUserAgent;
	private final String name;
	private final BrowserCategory category;

	private static final Map<String, BrowserType> keyAndValueMap = new HashMap<String, BrowserType>();
	private static final Set<String> botKeySet = new HashSet<String>();
	static {
		for (BrowserType browserType : values()) {
			keyAndValueMap.put(browserType.getKeyInUserAgent(), browserType);
			if (browserType.getCategory() == BrowserCategory.BOT) {
				botKeySet.add(browserType.getKeyInUserAgent());
			}
		}
	}

	private BrowserType(String keyInUserAgent, String name,
			BrowserCategory category) {
		this.keyInUserAgent = keyInUserAgent;
		this.name = name;
		this.category = category;
	}

	public String getKeyInUserAgent() {
		return keyInUserAgent;
	}

	public String getName() {
		return name;
	}

	public BrowserCategory getCategory() {
		return category;
	}

	public static BrowserType extractFromUserAgent(String userAgent) {
		for (BrowserType browserType : values()) {
			if (userAgent.contains(browserType.getKeyInUserAgent())) {
				return browserType;
			}
		}
		return BrowserType.NOT_AVAILABLE;
	}

	public static BrowserType getBrowserTypeFromKey(String key) {
		return keyAndValueMap.get(key);
	}

	public static boolean isBot(String key) {
		return botKeySet.contains(key);
	}

}
