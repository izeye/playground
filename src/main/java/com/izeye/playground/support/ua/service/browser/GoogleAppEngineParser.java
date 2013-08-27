package com.izeye.playground.support.ua.service.browser;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;

import static com.izeye.playground.support.ua.domain.UserAgentConstants.*;

@Service("googleAppEngineParser")
public class GoogleAppEngineParser implements BrowserInfoParser {

	@Override
	public BrowserInfo parse(String browserInfoInUserAgent) {
		String[] splitBrowserInfo = browserInfoInUserAgent
				.split(COMMENT_DELIMITER);
		return new BrowserInfo(BrowserType.GOOGLE_APP_ENGINE,
				splitBrowserInfo[1].split(":")[1].trim());
	}

}
