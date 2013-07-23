package com.izeye.playground.support.ua.service;

import static com.izeye.playground.support.ua.domain.UserAgentTokenType.COMMENT;
import static com.izeye.playground.support.ua.domain.UserAgentTokenType.PRODUCT;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.UserAgentToken;

// Reference:
// http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html
@Service("userAgentTokenizer")
public class DefaultUserAgentTokenizer implements UserAgentTokenizer {

	private enum State {
		NOT_IN_TOKEN, IN_PRODUCT_TOKEN, IN_COMMENT_TOKEN
	}

	@Override
	public List<UserAgentToken> tokenize(String userAgent) {
		List<UserAgentToken> userAgentTokens = new ArrayList<UserAgentToken>();
		StringBuilder sbToken = new StringBuilder();
		State state = State.NOT_IN_TOKEN;
		boolean inParentheses = false;
		for (int i = 0; i < userAgent.length(); i++) {
			char c = userAgent.charAt(i);
			switch (state) {
			case NOT_IN_TOKEN:
				switch (c) {
				case ' ':
					break;

				case '(':
					state = State.IN_COMMENT_TOKEN;
					break;

				default:
					state = State.IN_PRODUCT_TOKEN;
					sbToken.append(c);
					break;
				}
				break;

			case IN_PRODUCT_TOKEN:
				switch (c) {
				case '(':
					inParentheses = true;
					break;

				case ')':
					inParentheses = false;
					break;

				case ' ':
					if (inParentheses) {
						break;
					}

					String token = sbToken.toString();
					userAgentTokens.add(new UserAgentToken(PRODUCT, token));

					sbToken = new StringBuilder();
					state = State.NOT_IN_TOKEN;
					break;

				default:
					sbToken.append(c);
					break;
				}
				break;

			case IN_COMMENT_TOKEN:
				if (c == ')') {
					String token = sbToken.toString();
					userAgentTokens.add(new UserAgentToken(COMMENT, token));

					sbToken = new StringBuilder();
					state = State.NOT_IN_TOKEN;
				} else {
					sbToken.append(c);
				}
				break;
			}
		}

		switch (state) {
		case IN_PRODUCT_TOKEN:
			userAgentTokens
					.add(new UserAgentToken(PRODUCT, sbToken.toString()));
			break;

		case IN_COMMENT_TOKEN:
			userAgentTokens
					.add(new UserAgentToken(COMMENT, sbToken.toString()));
			break;
		}

		return userAgentTokens;
	}
}
