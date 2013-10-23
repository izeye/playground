package com.izeye.playground.support.regex.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service("regularExpressionService")
public class DefaultRegularExpressionService implements
		RegularExpressionService {

	@Override
	public boolean matches(String regex, String input) {
		return Pattern.matches(regex, input);
	}

}
