package com.izeye.playground.support.keyboard.service;

import com.izeye.playground.support.keyboard.domain.KoreanKeyboardLayout;
import com.izeye.playground.support.keyboard.domain.KoreanKeyboardLayoutType;

public interface KoreanKeyboardLayoutSelector {

	KoreanKeyboardLayout select(KoreanKeyboardLayoutType type);

}
