package com.izeye.playground.support.spam.ua.service;

import org.springframework.stereotype.Service;

@Service("userAgetSpamFilter")
public class DefaultUserAgentSpamFilter implements UserAgentSpamFilter {

	@Override
	public boolean filter(String userAgent) {
		if (userAgent == null) {
			return true;
		}

		return userAgent.contains("<a");
	}

}
