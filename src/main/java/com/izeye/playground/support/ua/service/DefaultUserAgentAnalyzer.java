package com.izeye.playground.support.ua.service;

import static com.izeye.playground.support.ua.domain.UserAgentConstants.*;
import static com.izeye.playground.support.ua.domain.UserAgentTokenType.COMMENT;
import static com.izeye.playground.support.ua.domain.UserAgentTokenType.PRODUCT;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.UnidentifiableUserAgentException;
import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.domain.UserAgentToken;
import com.izeye.playground.support.ua.domain.UserAgentTokenType;
import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;
import com.izeye.playground.support.ua.domain.device.DeviceType;
import com.izeye.playground.support.ua.domain.os.OSInfo;
import com.izeye.playground.support.ua.domain.os.OSType;
import com.izeye.playground.support.ua.service.browser.IEParser;
import com.izeye.playground.support.ua.service.browser.ProductBasedBrowserInfoParser;
import com.izeye.playground.support.ua.service.os.AndroidOSInfoParser;
import com.izeye.playground.support.ua.service.os.AppleOSInfoParser;
import com.izeye.playground.support.ua.service.os.WindowsParser;

// Reference:
// http://en.wikipedia.org/wiki/User_agent
// Mozilla/[version] ([system and browser information]) [platform] ([platform details]) [extensions]
@Service("userAgentAnalyzer")
public class DefaultUserAgentAnalyzer implements UserAgentAnalyzer {

	@Resource
	private UserAgentTokenizer userAgentTokenizer;

	@Resource
	private AppleOSInfoParser appleOSInfoParser;

	@Resource
	private AndroidOSInfoParser androidOSInfoParser;

	@Resource
	private WindowsParser windowsParser;

	@Resource
	private ProductBasedBrowserInfoParser productBasedBrowserInfoParser;

	@Resource
	private IEParser ieParser;

	private static final String MOZILLA_4_0 = "Mozilla/4.0";
	private static final String MOZILLA_5_0 = "Mozilla/5.0";

	private static final Set<String> validMozillaTokenSet;
	static {
		Set<String> mozillaTokens = new HashSet<String>();
		mozillaTokens.add(MOZILLA_4_0);
		mozillaTokens.add(MOZILLA_5_0);

		validMozillaTokenSet = Collections.unmodifiableSet(mozillaTokens);
	}

	@Override
	public UserAgent analyze(String userAgent) {
		UserAgent analyzedUserAgent = new UserAgent();

		OSType osType = OSType.extractFromUserAgent(userAgent);
		BrowserType browserType = BrowserType.extractFromUserAgent(userAgent);
		DeviceType deviceType = DeviceType.extractFromUserAgent(userAgent);
		analyzedUserAgent.setDeviceType(deviceType);
		switch (deviceType) {
		case IPHONE:
		case IPAD:
			osType = OSType.IOS;
			break;
		}

		List<UserAgentToken> userAgentTokens = userAgentTokenizer
				.tokenize(userAgent);

		// Mozilla/[version]
		UserAgentToken mozillaToken = userAgentTokens.remove(0);
		if (mozillaToken.getType() != PRODUCT
				|| !validMozillaTokenSet.contains(mozillaToken.getToken())) {
			throw new UnidentifiableUserAgentException(
					"Unexpected mozilla token: " + mozillaToken
							+ ", user agent: " + userAgent);
		}

		// ([system and browser information])
		UserAgentToken systemAndBrowserToken = userAgentTokens.remove(0);
		if (systemAndBrowserToken.getType() != COMMENT) {
			throw new UnidentifiableUserAgentException(
					"Unexpected system and browser token: "
							+ systemAndBrowserToken + ", user agent: "
							+ userAgent);
		}

		String[] splitSystemAndBrowserToken = systemAndBrowserToken.getToken()
				.split(COMMENT_DELIMITER);

		OSInfo osInfo = OSInfo.UNKNOWN;
		switch (osType) {
		case MAC_OS_X:
			osInfo = appleOSInfoParser.parse(splitSystemAndBrowserToken[1]
					.trim());
			analyzedUserAgent.setDeviceType(DeviceType.MACINTOSH);
			break;

		case WINDOWS:
			switch (browserType) {
			case IE:
				osInfo = windowsParser.parse(splitSystemAndBrowserToken[2]
						.trim());
				break;

			case CHROME:
				osInfo = windowsParser.parse(splitSystemAndBrowserToken[0]
						.trim());
				break;
			}
			analyzedUserAgent.setDeviceType(DeviceType.PC);
			break;

		case IOS:
			osInfo = appleOSInfoParser.parse(splitSystemAndBrowserToken[1]
					.trim());
			break;

		case ANDROID:
			String osInfoCandidate = splitSystemAndBrowserToken[1].trim();
			if (osInfoCandidate.equals(SECURITY_VALUE_STRONG_SECURITY)) {
				osInfoCandidate = splitSystemAndBrowserToken[2].trim();
			}
			osInfo = androidOSInfoParser.parse(osInfoCandidate);
			break;
		}
		analyzedUserAgent.setOsInfo(osInfo);

		if (userAgentTokens.size() != 0) {
			// [platform]
			UserAgentToken platformToken = userAgentTokens.remove(0);
			if (platformToken.getType() != PRODUCT) {
				throw new UnidentifiableUserAgentException(
						"Unexpected platform token: " + platformToken
								+ ", user agent: " + userAgent);
			}

			// UserAgentToken platformDetailsToken = null;
			if (userAgentTokens.size() != 0) {
				// ([platform details])
				UserAgentToken platformDetailsTokenCandidate = userAgentTokens
						.get(0);
				if (platformDetailsTokenCandidate.getType() == UserAgentTokenType.COMMENT) {
					// platformDetailsToken = platformDetailsTokenCandidate;
					userAgentTokens.remove(0);
				}
			}
		}

		// [extensions]
		List<UserAgentToken> extensionsTokens = userAgentTokens;

		BrowserInfo browserInfo;
		switch (browserType) {
		case IE:
			browserInfo = ieParser.parse(splitSystemAndBrowserToken[1].trim());
			break;

		case CHROME:
			browserInfo = productBasedBrowserInfoParser.parse(extensionsTokens
					.get(0).getToken());
			break;

		case GOOGLEBOT:
		case EOLIN_NET_BOT:
		case BINGBOT:
		case SEMRUSH_BOT:
		case BAIDUSPIDER:
			browserInfo = productBasedBrowserInfoParser
					.parse(splitSystemAndBrowserToken[1].trim());
			analyzedUserAgent.setDeviceType(DeviceType.UNKNOWN);
			break;

		case FIREFOX:
			browserInfo = productBasedBrowserInfoParser.parse(extensionsTokens
					.get(0).getToken());
			break;

		case SAFARI:
			browserInfo = productBasedBrowserInfoParser.parse(extensionsTokens
					.get(extensionsTokens.size() - 1).getToken());
			break;

		default:
			throw new IllegalStateException("Unreachable code.");
		}
		analyzedUserAgent.setBrowserInfo(browserInfo);

		return analyzedUserAgent;
	}
}
