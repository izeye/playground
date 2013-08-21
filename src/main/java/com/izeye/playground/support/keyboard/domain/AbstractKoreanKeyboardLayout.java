package com.izeye.playground.support.keyboard.domain;

import java.io.File;
import java.io.FileNotFoundException;

import javax.annotation.Resource;

import org.springframework.util.ResourceUtils;

import com.izeye.playground.support.lang.ko.phoneme.service.KoreanPhonemeService;
import com.izeye.playground.support.lang.ko.unicode.service.KoreanUnicodeService;

public abstract class AbstractKoreanKeyboardLayout implements
		KoreanKeyboardLayout {

	@Resource
	protected KoreanUnicodeService koreanUnicodeService;

	@Resource
	protected KoreanPhonemeService koreanPhonemeService;

	public AbstractKoreanKeyboardLayout(KoreanKeyboardLayoutType type) {
		loadKeyboardLayout(getKeyboardLayoutFile(type));
	}

	protected abstract void loadKeyboardLayout(File keyboardLayoutFile);

	protected File getKeyboardLayoutFile(KoreanKeyboardLayoutType type) {
		try {
			return ResourceUtils.getFile("classpath:data/keyboard_layout/"
					+ type.name().toLowerCase() + ".layout");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
