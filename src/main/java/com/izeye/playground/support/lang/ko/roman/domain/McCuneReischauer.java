package com.izeye.playground.support.lang.ko.roman.domain;

import org.springframework.stereotype.Component;

// FIXME:
// The following rules have been ignored:
// 1. e – written as ë after ㅏ and ㅗ
// 2. The consonants digraphs (ㄳ, ㄵ, ㄶ, ㄺ, ㄻ, ㄼ, ㄽ, ㄾ, ㄿ, ㅀ, ㅄ) only exist in finals.
// These digraphs are transcribed by their actual pronunciation.
@Component("mcCuneReischauer")
public class McCuneReischauer extends AbstractKoreanRomanization {

	public McCuneReischauer() {
		super(KoreanRomanizationScheme.MC_CUNE_REISCHAUER);
	}

}
