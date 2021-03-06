package com.izeye.playground.support.ua.service.browser;

import static com.izeye.playground.support.ua.domain.UserAgentConstants.PRODUCT_DELIMITER;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;

@Service("productBasedBrowserInfoParser")
public class ProductBasedBrowserInfoParser implements BrowserInfoParser {

	@Override
	public BrowserInfo parse(String browserInfoInUserAgent) {
		String[] splitBrowserInfo = browserInfoInUserAgent
				.split(PRODUCT_DELIMITER);
		return new BrowserInfo(
				BrowserType.getBrowserTypeFromKey(splitBrowserInfo[0]),
				splitBrowserInfo[1]);
	}

}
