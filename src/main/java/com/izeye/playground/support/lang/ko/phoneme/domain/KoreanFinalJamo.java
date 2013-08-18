package com.izeye.playground.support.lang.ko.phoneme.domain;

import java.util.HashMap;
import java.util.Map;

// http://en.wikipedia.org/wiki/Korean_language_and_computers#Hangul_Syllables_Area
public enum KoreanFinalJamo {

	NO_JAMO(' '), GIYEOK('ㄱ'), SSANGGIYEOK('ㄲ'), GIYEOK_SIOT('ㄳ'), NIEUN('ㄴ'), NIEUN_JIEUT(
			'ㄵ'), NIEUN_HIEUT('ㄶ'), DIGEUT('ㄷ'), RIEUL('ㄹ'), RIEUL_GIYEOK('ㄺ'), RIEUL_MIEUM(
			'ㄻ'), RIEUL_BIEUP('ㄼ'), RIEUL_SIOT('ㄽ'), RIEUL_TIEUT('ㄾ'), RIEUL_PIEUP(
			'ㄿ'), RIEUL_HIEUT('ㅀ'), MIEUM('ㅁ'), BIEUP('ㅂ'), BIEUP_SIOT('ㅄ'), SIOT(
			'ㅅ'), SSANGSIOT('ㅆ'), IEUNG('ㅇ'), JIEUT('ㅈ'), CHIEUT('ㅊ'), KIEUK(
			'ㅋ'), TIEUT('ㅌ'), PIEUP('ㅍ'), HIEUT('ㅎ');

	private final char value;

	private KoreanFinalJamo(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}

	private static final Map<Character, KoreanFinalJamo> valueMap = new HashMap<Character, KoreanFinalJamo>();
	static {
		for (KoreanFinalJamo finalJamo : values()) {
			valueMap.put(finalJamo.getValue(), finalJamo);
		}
	}

	public static KoreanFinalJamo getByValue(Character c) {
		KoreanFinalJamo finalJamo = valueMap.get(c);
		return finalJamo == null ? NO_JAMO : finalJamo;
	}

}
