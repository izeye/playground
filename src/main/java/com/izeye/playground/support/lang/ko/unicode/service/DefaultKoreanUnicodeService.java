package com.izeye.playground.support.lang.ko.unicode.service;

import static com.izeye.playground.support.lang.ko.unicode.domain.KoreanUnicodeConstants.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.lang.ko.unicode.domain.Unicode;

@Service("koreanUnicodeService")
public class DefaultKoreanUnicodeService implements KoreanUnicodeService {

	@Override
	public boolean isKorean(char c) {
		return isKoreanSyllable(c) || isKoreanJamo(c);
	}

	@Override
	public boolean isKoreanSyllable(char c) {
		return UNICODE_KOREAN_SYLLABLE_RANGE.isInRange(c);
	}

	@Override
	public boolean isKoreanJamo(char c) {
		return UNICODE_KOREAN_JAMO_RANGE.isInRange(c)
				|| UNICODE_KOREAN_COMPATIBILITY_JAMO_RANGE.isInRange(c)
				|| UNICODE_KOREAN_JAMO_EXTENDED_A_RANGE.isInRange(c)
				|| UNICODE_KOREAN_JAMO_EXTENDED_B_START.isInRange(c);
	}

	@Override
	public List<Unicode> getAllUnicodes() {
		List<Unicode> unicodes = new ArrayList<Unicode>();
		for (char c = UNICODE_KOREAN_SYLLABLE_RANGE.getStartChar(); c <= UNICODE_KOREAN_SYLLABLE_RANGE
				.getEndChar(); c++) {
			unicodes.add(new Unicode(c, (int) c));
		}
		return unicodes;
	}

}
