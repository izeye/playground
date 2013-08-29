package com.izeye.playground.support.text.service;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.text.domain.TextCount;

@Service("textService")
public class DefaultTextService implements TextService {

	@Override
	public int countBytes(String text) {
		return text.getBytes().length;
	}

	@Override
	public int countChars(String text) {
		return text.length();
	}

	@Override
	public int countWords(String text) {
		return text.split("\\s").length;
	}

	@Override
	public int countLines(String text) {
		return text.split("\n").length;
	}

	@Override
	public TextCount countAll(String text) {
		int byteCount = countBytes(text);
		int charCount = countChars(text);
		int wordCount = countWords(text);
		int lineCount = countLines(text);
		return new TextCount(byteCount, charCount, wordCount, lineCount);
	}

}
