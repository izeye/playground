package com.izeye.playground.support.ua.service;

import static com.izeye.playground.support.ua.domain.UserAgentConstants.*;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.domain.UserAgentToken;
import com.izeye.playground.support.ua.domain.UserAgentTypeInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;
import com.izeye.playground.support.ua.domain.device.DeviceType;
import com.izeye.playground.support.ua.domain.os.OsInfo;
import com.izeye.playground.support.ua.service.os.WindowsParser;

// NOTE:
// http://my.opera.com/community/openweb/idopera/
// Opera/9.80 ($OS) Presto/$PRESTO_VERSION Version/$VERSION
@Service("operaParser")
public class OperaParser implements UserAgentParser {

	@Resource
	private WindowsParser windowsParser;

	@Override
	public UserAgent parse(String userAgent,
			List<UserAgentToken> userAgentTokens,
			UserAgentTypeInfo userAgentTypeAndVersion) {
		UserAgent analyzedUserAgent = new UserAgent(userAgentTypeAndVersion);

		// Opera/9.80
		userAgentTokens.remove(0);

		// ($OS)
		UserAgentToken osToken = userAgentTokens.remove(0);
		String osTokenValue = osToken.getValue();
		String[] splitOSTokenValue = osTokenValue.split(COMMENT_DELIMITER);

		// FIXME:
		// Assume that OS is Windows.
		OsInfo osInfo = windowsParser.parse(splitOSTokenValue[0]);
		analyzedUserAgent.setOsInfo(osInfo);

		// FIXME:
		// Assume that device is PC.
		analyzedUserAgent.setDeviceType(DeviceType.PC);

		// Presto/$PRESTO_VERSION
		userAgentTokens.remove(0);

		// Version/$VERSION
		UserAgentToken versionToken = userAgentTokens.remove(0);
		String versionTokenValue = versionToken.getValue();
		String[] splitVersionTokenValue = versionTokenValue
				.split(PRODUCT_DELIMITER);
		String browserVersion = splitVersionTokenValue[1];
		BrowserInfo browserInfo = new BrowserInfo(BrowserType.OPERA,
				browserVersion);
		analyzedUserAgent.setBrowserInfo(browserInfo);

		return analyzedUserAgent;
	}

}
