package com.izeye.playground.support.lang.ko.phoneme.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhonemeType;

public interface KoreanPhonemeService {

	boolean isKoreanPhoneme(char phonemeChar);

	Set<KoreanPhonemeType> getPossibleTypes(char phonemeChar);

	Map<KoreanPhonemeType, KoreanPhoneme> getPossiblePhonemeMap(char phonemeChar);

	List<KoreanPhoneme> phonemeChars2Phonemes(List<Character> phonemeChars);

	String composeCharsStrictly(List<Character> phonemeChars);

	String composeCharsLoosely(List<Character> phonemeChars);

	String composePhonemesLoosely(List<KoreanPhoneme> phonemes);

	List<Character> decomposeAsCharacters(String text);

	List<Character> decomposeAsCharacters(char syllable);

	List<KoreanPhoneme> decompose(String text);

	List<KoreanPhoneme> decompose(char syllable);

}
