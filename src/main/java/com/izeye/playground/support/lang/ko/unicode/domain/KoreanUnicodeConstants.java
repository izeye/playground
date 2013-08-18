package com.izeye.playground.support.lang.ko.unicode.domain;

public interface KoreanUnicodeConstants {

	CharRange UNICODE_KOREAN_SYLLABLE_RANGE = new CharRange((char) 0xAC00,
			(char) 0xD7A3);
	CharRange UNICODE_KOREAN_JAMO_RANGE = new CharRange((char) 0x1100,
			(char) 0x11FF);
	CharRange UNICODE_KOREAN_COMPATIBILITY_JAMO_RANGE = new CharRange(
			(char) 0x3130, (char) 0x318F);
	CharRange UNICODE_KOREAN_JAMO_EXTENDED_A_RANGE = new CharRange(
			(char) 0xA960, (char) 0xA97F);
	CharRange UNICODE_KOREAN_JAMO_EXTENDED_B_START = new CharRange(
			(char) 0xD7B0, (char) 0xD7FF);

}
