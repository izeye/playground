package com.izeye.playground.support.lang.ko.roman.domain;

import org.springframework.stereotype.Component;

// FIXME:
// The following rule has been ignored:
// As this w isn't phonemically distinctive after labial consonants in modern Korean,
// the Yale system omits it in that context, merging hangul ㅜ (RR u) and ㅡ (RR eu).
// Thus, there is not a one-to-one correspondence in the spelling of back vowels.
@Component("yaleRomanization")
public class YaleRomanization extends AbstractKoreanRomanization {

	public YaleRomanization() {
		super(KoreanRomanizationScheme.YALE);
	}

}
