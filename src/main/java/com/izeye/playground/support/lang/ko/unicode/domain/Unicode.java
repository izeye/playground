package com.izeye.playground.support.lang.ko.unicode.domain;

public class Unicode {

	private final char value;
	private final int code;

	public Unicode(char value, int code) {
		this.value = value;
		this.code = code;
	}

	public char getValue() {
		return value;
	}

	public int getCode() {
		return code;
	}

	public String getHexCode() {
		return Integer.toHexString(code);
	}

	@Override
	public String toString() {
		return "Unicode [value=" + value + ", code=" + code + "]";
	}

}
