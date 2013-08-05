package com.izeye.playground.support.ua.service.browser;

import org.springframework.stereotype.Service;

import com.izeye.playground.common.util.StringConstants;
import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;
import com.izeye.playground.support.ua.domain.carrier.CarrierType;

@Service("facebookAppParser")
public class FacebookAppParser implements BrowserInfoParser {

	private static final String KEY_FACEBOOK_APP_VERSION = "FBAV";

	@Override
	public BrowserInfo parse(String browserInfoInUserAgent) {
		String version = StringConstants.NOT_AVAILABLE;
		String[] splitBrowserInfo = browserInfoInUserAgent.split(";");
		for (String partOfBrowserInfo : splitBrowserInfo) {
			if (partOfBrowserInfo.startsWith(KEY_FACEBOOK_APP_VERSION)) {
				version = partOfBrowserInfo.split("/")[1];
			}
		}

		// FIXME:
		// The signature of extractFromUserAgent() and the invocation of it
		// don't match strictly here even though it's working.
		// The expected parameter is the whole user agent
		// but the actual one provides the partial of it.
		CarrierType carrierType = CarrierType
				.extractFromUserAgent(browserInfoInUserAgent);
		return new BrowserInfo(BrowserType.FACEBOOK_APP, version, carrierType);
	}

}
