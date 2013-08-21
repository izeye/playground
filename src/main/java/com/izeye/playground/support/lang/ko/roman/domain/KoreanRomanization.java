package com.izeye.playground.support.lang.ko.roman.domain;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;

public interface KoreanRomanization {

	Character roman2KoreanPhoneme(String roman); // set of phonemes?

	String koreanPhoneme2Roman(KoreanPhoneme koreanPhoneme);

	String roman2Korean(String roman);

	String korean2Roman(String korean);

}
