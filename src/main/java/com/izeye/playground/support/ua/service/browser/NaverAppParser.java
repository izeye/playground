package com.izeye.playground.support.ua.service.browser;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;

@Service("naverAppParser")
public class NaverAppParser implements BrowserInfoParser {

	@Override
	public BrowserInfo parse(String browserInfoInUserAgent) {
		String[] splitBrowserInfo = browserInfoInUserAgent.split(";");
		return new BrowserInfo(BrowserType.NAVER_APP, splitBrowserInfo[3]);
	}

}
