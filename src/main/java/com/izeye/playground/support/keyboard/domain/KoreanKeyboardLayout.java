package com.izeye.playground.support.keyboard.domain;

public interface KoreanKeyboardLayout extends KeyboardLayout {

	Character english2Korean(char englishPhoneme);

	Character korean2English(char koreanPhoneme);

	String english2Korean(String english);

	String korean2English(String korean);

}
