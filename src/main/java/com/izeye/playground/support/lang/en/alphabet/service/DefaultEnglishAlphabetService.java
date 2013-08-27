package com.izeye.playground.support.lang.en.alphabet.service;

import org.springframework.stereotype.Service;

@Service("englishAlphabetService")
public class DefaultEnglishAlphabetService implements EnglishAlphabetService {

	@Override
	public String toLowerCase(String original) {
		return original.toLowerCase();
	}

	@Override
	public String toUpperCase(String original) {
		return original.toUpperCase();
	}

}
