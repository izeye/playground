package com.izeye.playground.support.lang.ko.phoneme.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanConsonant;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanFinalJamo;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhonemeType;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanVowel;

@Service("koreanPhonemeService")
public class DefaultKoreanPhonemeService implements KoreanPhonemeService {

	@Override
	public Set<KoreanPhonemeType> getPossibleTypes(char phoneme) {
		Set<KoreanPhonemeType> types = new HashSet<KoreanPhonemeType>();
		KoreanConsonant consonant = KoreanConsonant.getByValue(phoneme);
		if (consonant != null) {
			types.add(KoreanPhonemeType.INITIAL_JAMO);
		}
		KoreanVowel vowel = KoreanVowel.getByValue(phoneme);
		if (vowel != null) {
			types.add(KoreanPhonemeType.MEDIAL_JAMO);
		}
		KoreanFinalJamo finalJamo = KoreanFinalJamo.getByValue(phoneme);
		if (finalJamo != KoreanFinalJamo.NO_JAMO) {
			types.add(KoreanPhonemeType.FINAL_JAMO);
		}
		return types;
	}

	@Override
	public Set<KoreanPhoneme> getPossiblePhonemes(char phoneme) {
		Set<KoreanPhoneme> phonemes = new HashSet<KoreanPhoneme>();
		KoreanConsonant consonant = KoreanConsonant.getByValue(phoneme);
		if (consonant != null) {
			phonemes.add(new KoreanPhoneme(KoreanPhonemeType.INITIAL_JAMO,
					phoneme));
		}
		KoreanVowel vowel = KoreanVowel.getByValue(phoneme);
		if (vowel != null) {
			phonemes.add(new KoreanPhoneme(KoreanPhonemeType.MEDIAL_JAMO,
					phoneme));
		}
		KoreanFinalJamo finalJamo = KoreanFinalJamo.getByValue(phoneme);
		if (finalJamo != KoreanFinalJamo.NO_JAMO) {
			phonemes.add(new KoreanPhoneme(KoreanPhonemeType.FINAL_JAMO,
					phoneme));
		}
		return phonemes;
	}

	@Override
	public String compose(List<Character> phonemes) {
		StringBuilder sb = new StringBuilder();

		int i = 0;
		while (i < phonemes.size()) {
			Character initialJamoValueCandidate = phonemes.get(i++);

			char syllable = initialJamoValueCandidate;

			KoreanConsonant initialJamo = KoreanConsonant
					.getByValue(initialJamoValueCandidate);
			if (initialJamo != null) {
				Character medialJamoValueCandidate = phonemes.get(i);
				KoreanVowel medialJamo = KoreanVowel
						.getByValue(medialJamoValueCandidate);
				if (medialJamo != null) {
					// NOTE:
					// Consume the valid medial Jamo.
					i++;
					KoreanFinalJamo finalJamo = KoreanFinalJamo.NO_JAMO;
					if (i < phonemes.size()) {
						Character finalJamoValueCandidate = phonemes.get(i);
						KoreanFinalJamo finalJamoCandidate = KoreanFinalJamo
								.getByValue(finalJamoValueCandidate);
						if (finalJamoCandidate != null) {
							if (i == phonemes.size() - 1) {
								finalJamo = finalJamoCandidate;
								// NOTE:
								// Consume the valid final Jamo.
								i++;
							} else {
								KoreanConsonant nextInitialJamoCandidate = KoreanConsonant
										.getByValue(finalJamoValueCandidate);
								Character nextMedialJamoValueCandidate = phonemes
										.get(i + 1);
								KoreanVowel nextMedialJamoCandidate = KoreanVowel
										.getByValue(nextMedialJamoValueCandidate);
								if (nextInitialJamoCandidate == null
										|| nextMedialJamoCandidate == null) {
									finalJamo = finalJamoCandidate;
									// NOTE:
									// Consume the valid final Jamo.
									i++;
								}
							}
						}
					}
					syllable = (char) (initialJamo.ordinal() * 588
							+ medialJamo.ordinal() * 28 + finalJamo.ordinal() + 44032);
				}
			}
			sb.append(syllable);
		}

		return sb.toString();
	}

	@Override
	public List<Character> decomposeAsCharacters(String text) {
		List<Character> phonemes = new ArrayList<Character>();
		for (char c : text.toCharArray()) {
			phonemes.addAll(decomposeAsCharacters(c));
		}
		return phonemes;
	}

	@Override
	public List<Character> decomposeAsCharacters(char c) {
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

	@Override
	public List<KoreanPhoneme> decompose(String text) {
		List<KoreanPhoneme> phonemes = new ArrayList<KoreanPhoneme>();
		for (char c : text.toCharArray()) {
			phonemes.addAll(decompose(c));
		}
		return phonemes;
	}

	@Override
	public List<KoreanPhoneme> decompose(char c) {
		List<KoreanPhoneme> phonemes = new ArrayList<KoreanPhoneme>();

		int value = c - 44032;
		int initialValue = value / 588;
		value %= 588;
		int medialValue = value / 28;
		int finalValue = value % 28;

		phonemes.add(KoreanConsonant.values()[initialValue].getPhoneme());
		phonemes.add(KoreanVowel.values()[medialValue].getPhoneme());
		if (finalValue != KoreanFinalJamo.NO_JAMO.ordinal()) {
			phonemes.add(KoreanFinalJamo.values()[finalValue].getPhoneme());
		}

		return phonemes;
	}

}
