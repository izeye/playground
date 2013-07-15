package com.izeye.playground.support.ua.service.browser;

import com.izeye.playground.support.ua.domain.browser.BrowserInfo;

public interface BrowserInfoParser {

	BrowserInfo parse(String browserInfoInUserAgent);

}
