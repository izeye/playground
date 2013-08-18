package com.izeye.playground.support.ua.service;

import static com.izeye.playground.support.ua.domain.UserAgentConstants.COMMENT_DELIMITER;
import static com.izeye.playground.support.ua.domain.UserAgentConstants.PRODUCT_DELIMITER;
import static com.izeye.playground.support.ua.domain.UserAgentConstants.SECURITY_VALUE_STRONG_SECURITY;
import static com.izeye.playground.support.ua.domain.UserAgentConstants.USER_AGENT_EMPTY;
import static com.izeye.playground.support.ua.domain.UserAgentTokenType.COMMENT;
import static com.izeye.playground.support.ua.domain.UserAgentTokenType.PRODUCT;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.common.util.StringConstants;
import com.izeye.playground.support.ua.domain.UnidentifiableUserAgentException;
import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.domain.UserAgentToken;
import com.izeye.playground.support.ua.domain.UserAgentTokenType;
import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;
import com.izeye.playground.support.ua.domain.device.DeviceType;
import com.izeye.playground.support.ua.domain.os.OSInfo;
import com.izeye.playground.support.ua.domain.os.OSType;
import com.izeye.playground.support.ua.service.browser.FacebookAppParser;
import com.izeye.playground.support.ua.service.browser.IEParser;
import com.izeye.playground.support.ua.service.browser.NaverAppParser;
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

	@Resource
	private NaverAppParser naverAppParser;

	@Resource
	private FacebookAppParser facebookAppParser;

	private static final String MOZILLA = "Mozilla";

	private static final Set<String> validMozillaVersionSet;
	static {
		Set<String> mozillaTokens = new HashSet<String>();
		mozillaTokens.add("4.0");
		mozillaTokens.add("5.0");

		validMozillaVersionSet = Collections.unmodifiableSet(mozillaTokens);
	}

	@Override
	public UserAgent analyze(String userAgent) {
		// NOTE:
		// Suspicious user agent!
		if (userAgent.equals(USER_AGENT_EMPTY)) {
			return UserAgent.NOT_AVAILABLE;
		}

		UserAgent analyzedUserAgent = new UserAgent();

		try {
			OSType osType = OSType.extractFromUserAgent(userAgent);
			BrowserType browserType = BrowserType
					.extractFromUserAgent(userAgent);
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
			String mozillaTokenValue = mozillaToken.getValue();

			String[] splitMozillaTokenValue = mozillaTokenValue
					.split(PRODUCT_DELIMITER);
			String mozilla = splitMozillaTokenValue[0];

			// NOTE:
			// Remove the trailing semicolon for Google Producer.
			if (mozilla.endsWith(";")) {
				mozilla = mozilla.substring(0, mozilla.length() - 1);
			}

			String mozillaVersion = StringConstants.NOT_AVAILABLE;

			// NOTE:
			// The Google Producer doesn't have the version part.
			if (splitMozillaTokenValue.length == 2) {
				mozillaVersion = splitMozillaTokenValue[1];
			}

			// Handle some bots.
			if (BrowserType.isBot(mozilla)) {
				analyzedUserAgent.setBrowserInfo(new BrowserInfo(browserType,
						mozillaVersion));
				return analyzedUserAgent;
			}

			if (!mozilla.equals(MOZILLA)
					|| !validMozillaVersionSet.contains(mozillaVersion)) {
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

			String[] splitSystemAndBrowserToken = systemAndBrowserToken
					.getValue().split(COMMENT_DELIMITER);

			OSInfo osInfo = OSInfo.NOT_AVAILABLE;
			switch (osType) {
			case MAC_OS_X:
				String osInfoCandidate = splitSystemAndBrowserToken[1].trim();
				if (osInfoCandidate.equals(SECURITY_VALUE_STRONG_SECURITY)) {
					osInfoCandidate = splitSystemAndBrowserToken[2].trim();
				}
				osInfo = appleOSInfoParser.parse(osInfoCandidate);
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
				osInfoCandidate = splitSystemAndBrowserToken[1].trim();
				if (osInfoCandidate.equals(SECURITY_VALUE_STRONG_SECURITY)) {
					osInfoCandidate = splitSystemAndBrowserToken[2].trim();
				}
				osInfo = appleOSInfoParser.parse(osInfoCandidate);
				break;

			case ANDROID:
				osInfoCandidate = splitSystemAndBrowserToken[1].trim();
				if (osInfoCandidate.equals(SECURITY_VALUE_STRONG_SECURITY)) {
					osInfoCandidate = splitSystemAndBrowserToken[2].trim();
				}
				osInfo = androidOSInfoParser.parse(osInfoCandidate);
				break;
			}
			analyzedUserAgent.setOsInfo(osInfo);

			UserAgentToken platformToken = null;
			if (userAgentTokens.size() != 0) {
				// [platform]
				platformToken = userAgentTokens.remove(0);
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

			BrowserInfo browserInfo = BrowserInfo.NOT_AVAILABLE;
			switch (browserType) {
			case IE:
				browserInfo = ieParser.parse(splitSystemAndBrowserToken[1]
						.trim());
				break;

			case CHROME:
				browserInfo = productBasedBrowserInfoParser
						.parse(extensionsTokens.get(0).getValue());
				break;

			case GOOGLEBOT:
			case EOLIN_NET_BOT:
			case BINGBOT:
			case SEMRUSH_BOT:
			case BAIDUSPIDER:
			case YANDEX_BOT:
			case EZOOMS_BOT:
			case AHREFS_BOT:
			case EXABOT:
				browserInfo = productBasedBrowserInfoParser
						.parse(splitSystemAndBrowserToken[1].trim());
				break;

			case DAUM_BOT:
				browserInfo = productBasedBrowserInfoParser.parse(platformToken
						.getValue().trim());
				break;

			case GOOGLE_BOT_MOBILE:
				browserInfo = productBasedBrowserInfoParser
						.parse(extensionsTokens.get(3).getValue().split(";")[1]
								.trim());
				break;

			case FIREFOX:
				browserInfo = productBasedBrowserInfoParser
						.parse(extensionsTokens.get(0).getValue());
				break;

			case SAFARI:
				browserInfo = productBasedBrowserInfoParser
						.parse(extensionsTokens
								.get(extensionsTokens.size() - 1).getValue());
				break;

			case NAVER_APP:
				boolean succeeded = false;
				for (int i = 0; i < extensionsTokens.size(); i++) {
					String extensionsTokenValue = extensionsTokens.get(i)
							.getValue();
					if (extensionsTokenValue.equals(BrowserType.NAVER_APP
							.getKeyInUserAgent())) {
						browserInfo = naverAppParser.parse(extensionsTokens
								.get(i + 1).getValue());
						succeeded = true;
						break;
					}
				}
				if (!succeeded) {
					throw new UnidentifiableUserAgentException(
							"Unexpected Naver app signature: " + userAgent);
				}
				break;

			case FACEBOOK_APP:
				browserInfo = facebookAppParser.parse(extensionsTokens.get(1)
						.getValue());
				break;

			case DAUM_APP:
				browserInfo = productBasedBrowserInfoParser
						.parse(extensionsTokens
								.get(extensionsTokens.size() - 1).getValue());
				break;

			default:
				break;
			}

			analyzedUserAgent.setBrowserInfo(browserInfo);
		} catch (UnidentifiableUserAgentException e) {
			e.printStackTrace();
		}

		return analyzedUserAgent;
	}

}
