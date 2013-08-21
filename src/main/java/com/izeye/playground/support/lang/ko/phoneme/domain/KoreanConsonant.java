package com.izeye.playground.support.lang.ko.phoneme.domain;

import java.util.HashMap;
import java.util.Map;

// http://en.wikipedia.org/wiki/Hangul#Consonant_names
public enum KoreanConsonant {

	GIYEOK('ㄱ', "기역"), SSANGGIYEOK('ㄲ', "쌍기역"), NIEUN('ㄴ', "니은"), DIGEUT('ㄷ',
			"디귿"), SSANGDIGEUT('ㄸ', "쌍디귿"), RIEUL('ㄹ', "리을"), MIEUM('ㅁ', "미음"), BIEUP(
			'ㅂ', "비읍"), SSANGBIEUP('ㅃ', "쌍비읍"), SIOT('ㅅ', "시옷"), SSANGSIOT('ㅆ',
			"쌍시옷"), IEUNG('ㅇ', "이응"), JIEUT('ㅈ', "지읒"), SSANGJIEUT('ㅉ', "쌍지읒"), CHIEUT(
			'ㅊ', "치읓"), KIEUK('ㅋ', "키읔"), TIEUT('ㅌ', "티읕"), PIEUP('ㅍ', "피읖"), HIEUT(
			'ㅎ', "히읗");

	private final char value;
	private final String nameInEnglish;
	private final String nameInKorean;

	private KoreanConsonant(char value, String nameInKorean) {
		this.value = value;
		this.nameInEnglish = name().toLowerCase();
		this.nameInKorean = nameInKorean;
	}

	public char getValue() {
		return value;
	}

	public String getNameInEnglish() {
		return nameInEnglish;
	}

	public String getNameInKorean() {
		return nameInKorean;
	}

	private static final Map<Character, KoreanConsonant> valueMap = new HashMap<Character, KoreanConsonant>();
	static {
		for (KoreanConsonant consonant : values()) {
			valueMap.put(consonant.getValue(), consonant);
		}
	}

	public static KoreanConsonant getByValue(Character c) {
		return valueMap.get(c);
	}

	private static final Map<Character, KoreanPhoneme> valueAndPhonemeMap = new HashMap<Character, KoreanPhoneme>();
	static {
		for (KoreanConsonant consonant : values()) {
			char consonantValue = consonant.getValue();
			valueAndPhonemeMap.put(consonantValue, new KoreanPhoneme(
					KoreanPhonemeType.INITIAL_JAMO, consonantValue));
		}
	}

	public KoreanPhoneme getPhoneme() {
		return valueAndPhonemeMap.get(value);
	}

}
