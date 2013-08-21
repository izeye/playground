package com.izeye.playground.support.ua.service;

import static com.izeye.playground.support.ua.domain.UserAgentConstants.PRODUCT_DELIMITER;
import static com.izeye.playground.support.ua.domain.UserAgentConstants.USER_AGENT_EMPTY;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.common.util.StringConstants;
import com.izeye.playground.support.spam.ua.service.UserAgentSpamFilter;
import com.izeye.playground.support.ua.domain.UnidentifiableUserAgentException;
import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.domain.UserAgentToken;
import com.izeye.playground.support.ua.domain.UserAgentType;
import com.izeye.playground.support.ua.domain.UserAgentTypeInfo;

@Service("userAgentAnalyzer")
public class DefaultUserAgentAnalyzer implements UserAgentAnalyzer {

	@Resource
	private UserAgentTokenizer userAgentTokenizer;

	@Resource
	private UserAgentSpamFilter userAgentSpamFilter;

	@Resource
	private MozillaParser mozillaParser;

	@Resource
	private OperaParser operaParser;

	@Resource
	private BotParser botParser;

	private static final Set<String> validMozillaVersionSet;
	static {
		Set<String> versionSet = new HashSet<String>();
		versionSet.add("4.0");
		versionSet.add("5.0");

		validMozillaVersionSet = Collections.unmodifiableSet(versionSet);
	}

	private static final Set<String> validOperaVersionSet;
	static {
		Set<String> versionSet = new HashSet<String>();
		versionSet.add("9.80");

		validOperaVersionSet = Collections.unmodifiableSet(versionSet);
	}

	@Override
	public UserAgent analyze(String userAgent)
			throws UnidentifiableUserAgentException {
		List<UserAgentToken> userAgentTokens = userAgentTokenizer
				.tokenize(userAgent);

		UserAgentTypeInfo userAgentTypeAndNameAndVersion = getUserAgentTypeAndNameAndVersion(
				userAgent, userAgentTokens);
		UserAgentType userAgentType = userAgentTypeAndNameAndVersion.getType();
		switch (userAgentType) {
		case MOZILLA:
			return mozillaParser.parse(userAgent, userAgentTokens,
					userAgentTypeAndNameAndVersion);

		case OPERA:
			return operaParser.parse(userAgent, userAgentTokens,
					userAgentTypeAndNameAndVersion);

		case BOT:
			return botParser.parse(userAgent, userAgentTokens,
					userAgentTypeAndNameAndVersion);

		case SPAM_BOT:
			return UserAgent.SPAM_BOT;

		case SUSPICIOUS:
			return UserAgent.SUSPICIOUS;

		case NOT_AVAILABLE:
			return UserAgent.NOT_AVAILABLE;

		default:
			throw new IllegalStateException("Unexpected user agent type: "
					+ userAgentType);
		}
	}

	private UserAgentTypeInfo getUserAgentTypeAndNameAndVersion(
			String userAgent, List<UserAgentToken> userAgentTokens) {
		// NOTE:
		// Suspicious user agent!
		if (userAgent.equals(USER_AGENT_EMPTY)) {
			return UserAgentTypeInfo.SUSPICIOUS;
		}

		if (userAgentSpamFilter.filter(userAgent)) {
			return UserAgentTypeInfo.SPAM_BOT;
		}

		UserAgentToken firstUserAgentToken = userAgentTokens.get(0);
		String firstUserAgentTokenValue = firstUserAgentToken.getValue();
		String[] split = firstUserAgentTokenValue.split(PRODUCT_DELIMITER);
		String name = split[0];

		// NOTE:
		// Remove the trailing semicolon for Google Producer.
		if (name.endsWith(";")) {
			name = name.substring(0, name.length() - 1);
		}

		UserAgentType userAgentType = UserAgentType.getByPrefix(name);
		String version = split.length == 2 ? split[1]
				: StringConstants.NOT_AVAILABLE;

		// NOTE:
		// Validate user agent's type and version pair.
		switch (userAgentType) {
		case MOZILLA:
			if (!validMozillaVersionSet.contains(version)) {
				throw new UnidentifiableUserAgentException(
						"Unexpected mozilla token: " + firstUserAgentToken
								+ ", user agent: " + userAgent);
			}
			break;

		case OPERA:
			if (!validOperaVersionSet.contains(version)) {
				throw new UnidentifiableUserAgentException(
						"Unexpected opera token: " + firstUserAgentToken
								+ ", user agent: " + userAgent);
			}
			break;

		default:
			break;
		}

		return new UserAgentTypeInfo(userAgentType, name, version);
	}

}
