package com.izeye.playground.support.keyboard.domain;

import org.springframework.stereotype.Component;

@Component("sebeolsikNoshift")
public class SebeolsikNoshift extends AbstractSebeolsik {

	public SebeolsikNoshift() {
		super(KoreanKeyboardLayoutType.SEBEOLSIK_NOSHIFT);
	}

}
