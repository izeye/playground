package com.izeye.playground.support.keyboard.domain;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;

public interface KoreanKeyboardLayout {

	Character english2Korean(char englishPhoneme);

	Character korean2English(char koreanPhomeme);

	Character korean2English(KoreanPhoneme koreanPhoneme);

	String english2Korean(String english);

	String korean2English(String korean);

}
