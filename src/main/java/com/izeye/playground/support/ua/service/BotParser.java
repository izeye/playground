package com.izeye.playground.support.ua.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.domain.UserAgentToken;
import com.izeye.playground.support.ua.domain.UserAgentTypeInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;

@Service("botParser")
public class BotParser implements UserAgentParser {

	@Override
	public UserAgent parse(String userAgent,
			List<UserAgentToken> userAgentTokens,
			UserAgentTypeInfo userAgentTypeInfo) {
		UserAgent analyzedUserAgent = new UserAgent(userAgentTypeInfo);

		BrowserType browserType = BrowserType
				.getBrowserTypeFromKey(userAgentTypeInfo.getName());
		BrowserInfo browserInfo = new BrowserInfo(browserType,
				userAgentTypeInfo.getVersion());
		analyzedUserAgent.setBrowserInfo(browserInfo);

		return analyzedUserAgent;
	}
}
