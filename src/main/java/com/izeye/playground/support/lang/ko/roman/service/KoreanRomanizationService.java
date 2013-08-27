package com.izeye.playground.support.lang.ko.roman.service;

import java.util.Set;

import com.izeye.playground.support.lang.ko.roman.domain.KoreanRomanizationScheme;
import com.izeye.playground.support.lang.ko.roman.domain.RomanizationType;

public interface KoreanRomanizationService {

	String korean2Roman(KoreanRomanizationScheme scheme, RomanizationType type,
			String korean);

	Set<String> roman2PossibleKoreanSet(KoreanRomanizationScheme scheme,
			RomanizationType type, String roman);

}
