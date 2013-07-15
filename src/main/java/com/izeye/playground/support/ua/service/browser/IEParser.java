package com.izeye.playground.support.ua.service.browser;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;

@Service("ieParser")
public class IEParser implements BrowserInfoParser {

	@Override
	public BrowserInfo parse(String browserInfoInUserAgent) {
		String[] splitBrowserInfo = browserInfoInUserAgent.split(" ");
		return new BrowserInfo(BrowserType.IE, splitBrowserInfo[1]);
	}

}
