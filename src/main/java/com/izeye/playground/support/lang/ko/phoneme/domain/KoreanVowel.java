package com.izeye.playground.support.lang.ko.phoneme.domain;

import java.util.HashMap;
import java.util.Map;

// http://en.wikipedia.org/wiki/Hangul#Vowel_names
public enum KoreanVowel {

	A('ㅏ', "아"), AE('ㅐ', "애"), YA('ㅑ', "야"), YAE('ㅒ', "얘"), EO('ㅓ', "어"), E(
			'ㅔ', "에"), YEO('ㅕ', "여"), YE('ㅖ', "예"), O('ㅗ', "오"), WA('ㅘ', "와"), WAE(
			'ㅙ', "왜"), OE('ㅚ', "외"), YO('ㅛ', "요"), U('ㅜ', "우"), WO('ㅝ', "워"), WE(
			'ㅞ', "웨"), WI('ㅟ', "위"), YU('ㅠ', "유"), EU('ㅡ', "으"), UI('ㅢ', "의"), I(
			'ㅣ', "이");

	private final char value;
	private final String nameInEnglish;
	private final String nameInKorean;

	private KoreanVowel(char value, String nameInKorean) {
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

	private static final Map<Character, KoreanVowel> valueMap = new HashMap<Character, KoreanVowel>();
	static {
		for (KoreanVowel vowel : values()) {
			valueMap.put(vowel.getValue(), vowel);
		}
	}

	public static KoreanVowel getByValue(Character c) {
		return valueMap.get(c);
	}

	private static final Map<Character, KoreanPhoneme> valueAndPhonemeMap = new HashMap<Character, KoreanPhoneme>();
	static {
		for (KoreanVowel vowel : values()) {
			char vowelValue = vowel.getValue();
			valueAndPhonemeMap.put(vowelValue, new KoreanPhoneme(
					KoreanPhonemeType.MEDIAL_JAMO, vowelValue));
		}
	}

	public KoreanPhoneme getPhoneme() {
		return valueAndPhonemeMap.get(value);
	}

}
