package com.izeye.playground.support.ua.domain.browser;

import com.izeye.playground.common.domain.StringConstants;

public enum BrowserCategory {

	NORMAL("Normal"), BOT("Bot"), APP("App"), NOT_AVAILABLE(
			StringConstants.NOT_AVAILABLE);

	private String name;

	private BrowserCategory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
