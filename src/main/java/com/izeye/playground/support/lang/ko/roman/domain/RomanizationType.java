package com.izeye.playground.support.lang.ko.roman.domain;

public enum RomanizationType {

	TRANSLITERATION("Transliteration"), TRANSCRIPTION("Transcription");

	private final String name;

	private RomanizationType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
