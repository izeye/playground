package com.izeye.playground.support.ua.domain;

import java.util.HashMap;
import java.util.Map;

import com.izeye.playground.common.util.StringConstants;
import com.izeye.playground.support.ua.domain.browser.BrowserType;

public enum UserAgentType {

	MOZILLA("Mozilla", "Mozilla"), OPERA("Opera", "Opera"), BOT("Bot",
			StringConstants.NOT_AVAILABLE), SPAM_BOT("Spam bot",
			StringConstants.NOT_AVAILABLE), SUSPICIOUS("Suspicious",
			StringConstants.NOT_AVAILABLE), NOT_AVAILABLE(
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE);

	private final String name;
	private final String prefix;

	private static final Map<String, UserAgentType> prefixAndValueMap = new HashMap<String, UserAgentType>();
	static {
		for (UserAgentType type : values()) {
			prefixAndValueMap.put(type.getPrefix(), type);
		}
	}

	private UserAgentType(String name, String prefix) {
		this.name = name;
		this.prefix = prefix;
	}

	public String getName() {
		return name;
	}

	public String getPrefix() {
		return prefix;
	}

	public static UserAgentType getByPrefix(String prefix) {
		UserAgentType userAgentType = prefixAndValueMap.get(prefix);
		if (userAgentType != null) {
			return userAgentType;
		}

		// NOTE:
		// Handle some bots.
		if (BrowserType.isBot(prefix)) {
			return UserAgentType.BOT;
		}

		return UserAgentType.NOT_AVAILABLE;
	}

}
