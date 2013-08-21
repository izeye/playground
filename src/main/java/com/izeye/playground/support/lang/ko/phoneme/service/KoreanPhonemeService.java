package com.izeye.playground.support.lang.ko.phoneme.service;

import java.util.List;
import java.util.Set;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhonemeType;

public interface KoreanPhonemeService {

	Set<KoreanPhonemeType> getPossibleTypes(char phoneme);

	Set<KoreanPhoneme> getPossiblePhonemes(char phoneme);

	String compose(List<Character> phonemes);

	List<Character> decomposeAsCharacters(String text);

	List<Character> decomposeAsCharacters(char c);

	List<KoreanPhoneme> decompose(String text);

	List<KoreanPhoneme> decompose(char c);

}
