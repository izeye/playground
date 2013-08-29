package com.izeye.playground.support.text.service;

import com.izeye.playground.support.text.domain.TextCount;

public interface TextService {

	int countBytes(String text);

	int countChars(String text);

	int countWords(String text);

	int countLines(String text);

	TextCount countAll(String text);

}
