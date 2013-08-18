package com.izeye.playground.support.lang.ko.unicode.service;

import java.util.List;

import com.izeye.playground.support.lang.ko.unicode.domain.Unicode;

public interface KoreanUnicodeService {

	boolean isKorean(char c);

	boolean isKoreanSyllable(char c);

	boolean isKoreanJamo(char c);

	List<Unicode> getAllUnicodes();

}
