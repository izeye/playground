package com.izeye.playground.support.ua.service;

import java.util.List;

import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.domain.UserAgentToken;
import com.izeye.playground.support.ua.domain.UserAgentTypeInfo;

public interface UserAgentParser {

	UserAgent parse(String userAgent, List<UserAgentToken> userAgentTokens,
			UserAgentTypeInfo userAgentTypeAndVersion);

}
