package com.izeye.playground.support.lang.ko.roman.service;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.lang.ko.roman.domain.KoreanRomanizationScheme;
import com.izeye.playground.support.lang.ko.roman.domain.McCuneReischauer;
import com.izeye.playground.support.lang.ko.roman.domain.RevisedRomanizationOfKorean;
import com.izeye.playground.support.lang.ko.roman.domain.RomanizationType;
import com.izeye.playground.support.lang.ko.roman.domain.YaleRomanization;

@Service("koreanRomanizationService")
public class DefaultKoreanRomanizationService implements
		KoreanRomanizationService {

	@Resource
	private RevisedRomanizationOfKorean revisedRomanizationOfKorean;

	@Resource
	private YaleRomanization yaleRomanization;

	@Resource
	private McCuneReischauer mcCuneReischauer;

	@Override
	public String korean2Roman(KoreanRomanizationScheme scheme,
			RomanizationType type, String korean) {
		switch (scheme) {
		case REVISED_ROMANIZATION_OF_KOREAN:
			return revisedRomanizationOfKorean.korean2Roman(type, korean);

		case YALE:
			return yaleRomanization.korean2Roman(type, korean);

		case MC_CUNE_REISCHAUER:
			return mcCuneReischauer.korean2Roman(type, korean);

		default:
			throw new IllegalArgumentException(
					"Unsupported Korean romanization scheme.");
		}
	}

	@Override
	public Set<String> roman2PossibleKoreanSet(KoreanRomanizationScheme scheme,
			RomanizationType type, String roman) {
		switch (scheme) {
		case REVISED_ROMANIZATION_OF_KOREAN:
			return revisedRomanizationOfKorean.roman2PossibleKoreanSet(type,
					roman);

		case YALE:
			return yaleRomanization.roman2PossibleKoreanSet(type, roman);

		case MC_CUNE_REISCHAUER:
			return mcCuneReischauer.roman2PossibleKoreanSet(type, roman);

		default:
			throw new IllegalArgumentException(
					"Unsupported Korean romanization scheme.");
		}
	}

}
