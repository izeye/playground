package com.izeye.playground.support.ua.service;

import static com.izeye.playground.support.ua.domain.UserAgentConstants.COMMENT_DELIMITER;
import static com.izeye.playground.support.ua.domain.UserAgentConstants.SECURITY_VALUE_STRONG_SECURITY;
import static com.izeye.playground.support.ua.domain.UserAgentTokenType.COMMENT;
import static com.izeye.playground.support.ua.domain.UserAgentTokenType.PRODUCT;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.UnidentifiableUserAgentException;
import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.domain.UserAgentToken;
import com.izeye.playground.support.ua.domain.UserAgentTokenType;
import com.izeye.playground.support.ua.domain.UserAgentTypeInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.browser.BrowserType;
import com.izeye.playground.support.ua.domain.device.DeviceType;
import com.izeye.playground.support.ua.domain.os.OSInfo;
import com.izeye.playground.support.ua.domain.os.OSType;
import com.izeye.playground.support.ua.service.browser.FacebookAppParser;
import com.izeye.playground.support.ua.service.browser.GoogleAppEngineParser;
import com.izeye.playground.support.ua.service.browser.IEParser;
import com.izeye.playground.support.ua.service.browser.NaverAppParser;
import com.izeye.playground.support.ua.service.browser.ProductBasedBrowserInfoParser;
import com.izeye.playground.support.ua.service.os.AndroidOSInfoParser;
import com.izeye.playground.support.ua.service.os.AppleOSInfoParser;
import com.izeye.playground.support.ua.service.os.WindowsParser;

// NOTE:
// http://en.wikipedia.org/wiki/User_agent
// Mozilla/[version] ([system and browser information]) [platform] ([platform details]) [extensions]
@Service("mozillaParser")
public class MozillaParser implements UserAgentParser {

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

	@Resource
	private GoogleAppEngineParser googleAppEngineParser;

	@Override
	public UserAgent parse(String userAgent,
			List<UserAgentToken> userAgentTokens,
			UserAgentTypeInfo userAgentTypeAndVersion)
			throws UnidentifiableUserAgentException {
		UserAgent analyzedUserAgent = new UserAgent(userAgentTypeAndVersion);

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

			// Mozilla/[version]
			userAgentTokens.remove(0);

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
					osInfoCandidate = splitSystemAndBrowserToken[2].trim();
					if (osInfoCandidate.startsWith(osType.getKeyInUserAgent())) {
						osInfo = windowsParser.parse(osInfoCandidate);
					} else {
						osInfo = windowsParser
								.parse(splitSystemAndBrowserToken[3].trim());
					}
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
				for (UserAgentToken extensionsToken : extensionsTokens) {
					String extensionsTokenValue = extensionsToken.getValue();
					if (extensionsTokenValue.startsWith(browserType
							.getKeyInUserAgent())) {
						browserInfo = productBasedBrowserInfoParser
								.parse(extensionsTokenValue);
						break;
					}
				}
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
			case ABONTI:
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
				String platformTokenValue = platformToken.getValue();
				if (platformTokenValue.startsWith(browserType
						.getKeyInUserAgent())) {
					browserInfo = productBasedBrowserInfoParser
							.parse(platformTokenValue);
				} else {
					browserInfo = productBasedBrowserInfoParser
							.parse(extensionsTokens.get(0).getValue());
				}
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

			case GOOGLE_APP_ENGINE:
				browserInfo = googleAppEngineParser.parse(extensionsTokens.get(
						extensionsTokens.size() - 1).getValue());
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
