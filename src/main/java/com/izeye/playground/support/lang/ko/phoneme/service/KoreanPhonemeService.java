package com.izeye.playground.support.lang.ko.phoneme.service;

import java.util.List;

public interface KoreanPhonemeService {

	String compose(List<Character> phonemes);

	List<Character> decompose(String text);

	List<Character> decompose(char c);

}
