package com.izeye.playground.support.ua.service;

import static com.izeye.playground.support.ua.domain.UserAgentTokenType.COMMENT;
import static com.izeye.playground.support.ua.domain.UserAgentTokenType.PRODUCT;
import static com.izeye.playground.support.ua.domain.UserAgentConstants.*;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.UnidentifiableUserAgentException;
import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.domain.UserAgentToken;

// Reference:
// http://en.wikipedia.org/wiki/User_agent
// Mozilla/[version] ([system and browser information]) [platform] ([platform details]) [extensions]
@Service("userAgentAnalyzer")
public class DefaultUserAgentAnalyzer implements UserAgentAnalyzer {

	@Resource
	private UserAgentTokenizer userAgentTokenizer;

	@Override
	public UserAgent analyze(String userAgent) {
		List<UserAgentToken> userAgentTokens = userAgentTokenizer
				.tokenize(userAgent);

		// Mozilla/[version]
		UserAgentToken mozillaToken = userAgentTokens.remove(0);
		if (mozillaToken.getType() != PRODUCT
				|| mozillaToken.getToken().equals("Mozilla/5.0")) {
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
		// TODO: Continue to implement!

		// [platform]
		// ([platform details])
		// [extensions]
		return null;
	}
}
