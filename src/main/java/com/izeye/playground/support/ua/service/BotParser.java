package com.izeye.playground.support.ua.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.domain.UserAgentToken;
import com.izeye.playground.support.ua.domain.UserAgentTypeInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;
import com.izeye.playground.support.ua.service.browser.GoogleAppEngineParser;

@Service("botParser")
public class BotParser implements UserAgentParser {

	@Resource
	private GoogleAppEngineParser googleAppEngineParser;

	@Override
	public UserAgent parse(String userAgent,
			List<UserAgentToken> userAgentTokens,
			UserAgentTypeInfo userAgentTypeInfo) {
		UserAgent analyzedUserAgent = new UserAgent(userAgentTypeInfo);

		BrowserType browserType = BrowserType
				.getBrowserTypeFromKey(userAgentTypeInfo.getName());
		BrowserInfo browserInfo;
		switch (browserType) {
		case GOOGLE_APP_ENGINE:
			browserInfo = googleAppEngineParser.parse(userAgentTokens.get(1)
					.getValue());
			break;

		default:
			browserInfo = new BrowserInfo(browserType,
					userAgentTypeInfo.getVersion());
			break;
		}
		analyzedUserAgent.setBrowserInfo(browserInfo);

		return analyzedUserAgent;
	}
}
