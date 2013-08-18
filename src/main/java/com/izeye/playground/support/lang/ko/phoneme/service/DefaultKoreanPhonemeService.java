package com.izeye.playground.support.lang.ko.phoneme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanConsonant;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanFinalJamo;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanVowel;

@Service("koreanPhonemeService")
public class DefaultKoreanPhonemeService implements KoreanPhonemeService {

	@Override
	public String compose(List<Character> phonemes) {
		StringBuilder sb = new StringBuilder();

		int i = 0;
		while (i < phonemes.size()) {
			KoreanConsonant initialJamo = KoreanConsonant.getByValue(phonemes
					.get(i++));
			KoreanVowel medialJamo = KoreanVowel.getByValue(phonemes.get(i++));
			KoreanFinalJamo finalJamo = KoreanFinalJamo.NO_JAMO;
			if (i == phonemes.size() - 1) {
				finalJamo = KoreanFinalJamo.getByValue(phonemes.get(i++));
			} else if (i + 1 < phonemes.size()) {
				Character lookahead = phonemes.get(i + 1);
				KoreanVowel nextMedialJamoCandidate = KoreanVowel
						.getByValue(lookahead);
				if (nextMedialJamoCandidate == null) {
					finalJamo = KoreanFinalJamo.getByValue(phonemes.get(i++));
				}
			}
			char c = (char) (initialJamo.ordinal() * 588 + medialJamo.ordinal()
					* 28 + finalJamo.ordinal() + 44032);
			sb.append(c);
		}

		return sb.toString();
	}

	@Override
	public List<Character> decompose(String text) {
		List<Character> phonemes = new ArrayList<Character>();
		for (char c : text.toCharArray()) {
			phonemes.addAll(decompose(c));
		}
		return phonemes;
	}

	@Override
	public List<Character> decompose(char c) {
		List<Character> phonemes = new ArrayList<Character>();

		int value = c - 44032;
		int initialValue = value / 588;
		value %= 588;
		int medialValue = value / 28;
		int finalValue = value % 28;

		phonemes.add(KoreanConsonant.values()[initialValue].getValue());
		phonemes.add(KoreanVowel.values()[medialValue].getValue());
		if (finalValue != KoreanFinalJamo.NO_JAMO.ordinal()) {
			phonemes.add(KoreanFinalJamo.values()[finalValue].getValue());
		}

		return phonemes;
	}

}
