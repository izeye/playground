package com.izeye.playground.support.keyboard.domain;

import org.springframework.stereotype.Component;

@Component("sebeolsikFinal")
public class SebeolsikFinal extends AbstractSebeolsik {

	public SebeolsikFinal() {
		super(KoreanKeyboardLayoutType.SEBEOLSIK_FINAL);
	}

}
