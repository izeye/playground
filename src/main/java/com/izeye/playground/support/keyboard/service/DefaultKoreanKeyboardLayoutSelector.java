package com.izeye.playground.support.keyboard.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.keyboard.domain.Dubeolsik;
import com.izeye.playground.support.keyboard.domain.KoreanKeyboardLayout;
import com.izeye.playground.support.keyboard.domain.KoreanKeyboardLayoutType;
import com.izeye.playground.support.keyboard.domain.Sebeolsik390;
import com.izeye.playground.support.keyboard.domain.SebeolsikFinal;
import com.izeye.playground.support.keyboard.domain.SebeolsikNoshift;

@Service("koreanKeyboardLayoutSelector")
public class DefaultKoreanKeyboardLayoutSelector implements
		KoreanKeyboardLayoutSelector {

	@Resource
	private Dubeolsik dubeolsik;

	@Resource
	private Sebeolsik390 sebeolsik390;

	@Resource
	private SebeolsikFinal sebeolsikFinal;

	@Resource
	private SebeolsikNoshift sebeolsikNoshift;

	@Override
	public KoreanKeyboardLayout select(KoreanKeyboardLayoutType type) {
		switch (type) {
		case DUBEOLSIK:
			return dubeolsik;

		case SEBEOLSIK_390:
			return sebeolsik390;

		case SEBEOLSIK_FINAL:
			return sebeolsikFinal;

		case SEBEOLSIK_NOSHIFT:
			return sebeolsikNoshift;

		default:
			throw new IllegalArgumentException(
					"Unsupported Korean keyboard layout type: " + type);
		}
	}

}
