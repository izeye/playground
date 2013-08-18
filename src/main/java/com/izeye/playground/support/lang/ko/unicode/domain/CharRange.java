package com.izeye.playground.support.lang.ko.unicode.domain;

public class CharRange {

	private final char startChar;
	private final char endChar;

	public CharRange(char startChar, char endChar) {
		this.startChar = startChar;
		this.endChar = endChar;
	}

	public char getStartChar() {
		return startChar;
	}

	public char getEndChar() {
		return endChar;
	}

	public boolean isInRange(char c) {
		return c >= startChar && c <= endChar;
	}

	@Override
	public String toString() {
		return "CharRange [startChar=" + startChar + ", endChar=" + endChar
				+ "]";
	}

}
