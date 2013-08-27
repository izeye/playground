package com.izeye.playground.support.lang.ko.roman.domain;

import java.util.Set;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;

public interface KoreanRomanization {

	// NOTE:
	// Only transliteration is meaningful for an individual phoeneme.
	String koreanPhoneme2Roman(KoreanPhoneme koreanPhoneme);

	// NOTE:
	// Only transliteration is meaningful for an individual phoeneme.
	Set<KoreanPhoneme> roman2PossibleKoreanPhonemeSet(String roman);

	String korean2Roman(RomanizationType type, String korean);

	Set<String> roman2PossibleKoreanSet(RomanizationType type, String roman);

	Set<String> roman2PossibleKoreanSet(RomanizationType type, String roman,
			boolean filtered);

}
