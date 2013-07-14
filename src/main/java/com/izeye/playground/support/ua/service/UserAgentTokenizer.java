package com.izeye.playground.support.ua.service;

import java.util.List;

import com.izeye.playground.support.ua.domain.UserAgentToken;

public interface UserAgentTokenizer {

	List<UserAgentToken> tokenize(String userAgent);

}
