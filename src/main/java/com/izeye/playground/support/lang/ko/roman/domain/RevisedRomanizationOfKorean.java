package com.izeye.playground.support.lang.ko.roman.domain;

import org.springframework.stereotype.Component;

@Component("revisedRomanizationOfKorean")
public class RevisedRomanizationOfKorean extends AbstractKoreanRomanization {

	public RevisedRomanizationOfKorean() {
		super(KoreanRomanizationScheme.REVISED_ROMANIZATION_OF_KOREAN);
	}

}
