package com.izeye.playground.support.lang.ko.phoneme.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanConsonant;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanFinalJamo;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhonemeType;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanVowel;
import com.izeye.playground.support.lang.ko.syllable.domain.KoreanSyllableBuilder;
import com.izeye.playground.support.lang.ko.unicode.service.KoreanUnicodeService;

@Service("koreanPhonemeService")
public class DefaultKoreanPhonemeService implements KoreanPhonemeService {

	@Resource
	private KoreanUnicodeService koreanUnicodeService;

	@Override
	public boolean isKoreanPhoneme(char phonemeChar) {
		return getPossibleTypes(phonemeChar).size() != 0;
	}

	@Override
	public Set<KoreanPhonemeType> getPossibleTypes(char phonemeChar) {
		Set<KoreanPhonemeType> types = new HashSet<KoreanPhonemeType>();
		KoreanConsonant consonant = KoreanConsonant.getByValue(phonemeChar);
		if (consonant != null) {
			types.add(KoreanPhonemeType.INITIAL_JAMO);
		}
		KoreanVowel vowel = KoreanVowel.getByValue(phonemeChar);
		if (vowel != null) {
			types.add(KoreanPhonemeType.MEDIAL_JAMO);
		}
		KoreanFinalJamo finalJamo = KoreanFinalJamo.getByValue(phonemeChar);
		if (finalJamo != KoreanFinalJamo.NO_JAMO) {
			types.add(KoreanPhonemeType.FINAL_JAMO);
		}
		return types;
	}

	@Override
	public Map<KoreanPhonemeType, KoreanPhoneme> getPossiblePhonemeMap(
			char phonemeChar) {
		Map<KoreanPhonemeType, KoreanPhoneme> phonemes = new HashMap<KoreanPhonemeType, KoreanPhoneme>();
		KoreanConsonant consonant = KoreanConsonant.getByValue(phonemeChar);
		if (consonant != null) {
			KoreanPhoneme phoneme = new KoreanPhoneme(
					KoreanPhonemeType.INITIAL_JAMO, phonemeChar);
			phonemes.put(phoneme.getType(), phoneme);
		}
		KoreanVowel vowel = KoreanVowel.getByValue(phonemeChar);
		if (vowel != null) {
			KoreanPhoneme phoneme = new KoreanPhoneme(
					KoreanPhonemeType.MEDIAL_JAMO, phonemeChar);
			phonemes.put(phoneme.getType(), phoneme);
		}
		KoreanFinalJamo finalJamo = KoreanFinalJamo.getByValue(phonemeChar);
		if (finalJamo != KoreanFinalJamo.NO_JAMO) {
			KoreanPhoneme phoneme = new KoreanPhoneme(
					KoreanPhonemeType.FINAL_JAMO, phonemeChar);
			phonemes.put(phoneme.getType(), phoneme);
		}
		return phonemes;
	}

	@Override
	public List<KoreanPhoneme> phonemeChars2Phonemes(
			List<Character> phonemeChars) {
		List<KoreanPhoneme> phonemes = new ArrayList<KoreanPhoneme>();

		KoreanPhoneme prevPhoneme = null;

		int charsSize = phonemeChars.size();
		for (int i = 0; i < charsSize; i++) {
			KoreanPhoneme phoneme = null;

			char c = phonemeChars.get(i);
			if (koreanUnicodeService.isKorean(c)) {
				Map<KoreanPhonemeType, KoreanPhoneme> possiblePhonemeMap = getPossiblePhonemeMap(c);
				Iterator<KoreanPhoneme> it = possiblePhonemeMap.values()
						.iterator();
				KoreanPhoneme possiblePhoneme = it.next();

				switch (possiblePhonemeMap.size()) {
				case 1:
					phoneme = possiblePhoneme;
					break;

				case 2:
					if (i + 1 < charsSize) {
						char nextC = phonemeChars.get(i + 1);
						if (koreanUnicodeService.isKorean(nextC)) {
							Set<KoreanPhonemeType> nextPossibleTypes = getPossibleTypes(nextC);
							if (nextPossibleTypes
									.contains(KoreanPhonemeType.MEDIAL_JAMO)) {
								phoneme = possiblePhonemeMap
										.get(KoreanPhonemeType.INITIAL_JAMO);
							}
						}
					}

					if (phoneme == null) {
						if (prevPhoneme != null
								&& prevPhoneme.getType() == KoreanPhonemeType.MEDIAL_JAMO) {
							phoneme = possiblePhonemeMap
									.get(KoreanPhonemeType.FINAL_JAMO);
						} else {
							phoneme = possiblePhonemeMap
									.get(KoreanPhonemeType.INITIAL_JAMO);
						}
					}
					break;

				default:
					throw new IllegalStateException(
							"The size of possible phoneme set should be 1 or 2.");
				}
			} else {
				phoneme = new KoreanPhoneme(KoreanPhonemeType.NO_JAMO, c);
			}

			phonemes.add(phoneme);
			prevPhoneme = phoneme;
		}

		return phonemes;
	}

	@Override
	public String composeCharsStrictly(List<Character> phonemeChars) {
		StringBuilder sb = new StringBuilder();

		int i = 0;
		int phonemeCharsSize = phonemeChars.size();
		while (i < phonemeCharsSize) {
			Character initialJamoValueCandidate = phonemeChars.get(i++);

			char syllable = initialJamoValueCandidate;

			KoreanConsonant initialJamo = KoreanConsonant
					.getByValue(initialJamoValueCandidate);
			if (initialJamo != null && i < phonemeCharsSize) {
				Character medialJamoValueCandidate = phonemeChars.get(i);
				KoreanVowel medialJamo = KoreanVowel
						.getByValue(medialJamoValueCandidate);
				if (medialJamo != null) {
					// NOTE:
					// Consume the valid medial Jamo.
					i++;
					KoreanFinalJamo finalJamo = KoreanFinalJamo.NO_JAMO;
					if (i < phonemeCharsSize) {
						Character finalJamoValueCandidate = phonemeChars.get(i);
						KoreanFinalJamo finalJamoCandidate = KoreanFinalJamo
								.getByValue(finalJamoValueCandidate);
						if (finalJamoCandidate != KoreanFinalJamo.NO_JAMO) {
							if (i == phonemeCharsSize - 1) {
								finalJamo = finalJamoCandidate;
								// NOTE:
								// Consume the valid final Jamo.
								i++;
							} else {
								KoreanConsonant nextInitialJamoCandidate = KoreanConsonant
										.getByValue(finalJamoValueCandidate);
								Character nextMedialJamoValueCandidate = phonemeChars
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
	public String composeCharsLoosely(List<Character> phonemeChars) {
		return composePhonemesLoosely(phonemeChars2Phonemes(phonemeChars));
	}

	@Override
	public String composePhonemesLoosely(List<KoreanPhoneme> phonemes) {
		StringBuilder sb = new StringBuilder();
		int phonemesSize = phonemes.size();
		for (int i = 0; i < phonemesSize; i++) {
			KoreanPhoneme initialJamoCandidate = phonemes.get(i);
			switch (initialJamoCandidate.getType()) {
			case INITIAL_JAMO:
				if (i + 1 < phonemesSize) {
					KoreanPhoneme medialJamoCandidate = phonemes.get(i + 1);
					switch (medialJamoCandidate.getType()) {
					case INITIAL_JAMO:
						sb.append(initialJamoCandidate.getValue());
						break;

					case MEDIAL_JAMO:
						// NOTE:
						// Consume the valid medial Jamo.
						i++;

						KoreanPhoneme finalJamo = null;
						if (i + 1 < phonemesSize) {
							KoreanPhoneme finalJamoCandidate = phonemes
									.get(i + 1);
							if (finalJamoCandidate.getType() == KoreanPhonemeType.FINAL_JAMO) {
								// NOTE:
								// Consume the valid final Jamo.
								i++;

								finalJamo = finalJamoCandidate;
							}
						}

						KoreanSyllableBuilder builder = new KoreanSyllableBuilder();
						builder.setInitialJamo(initialJamoCandidate);
						builder.setMedialJamo(medialJamoCandidate);
						if (finalJamo != null) {
							builder.setFinalJamo(finalJamo);
						}
						sb.append(builder.build());
						break;

					case FINAL_JAMO:
						sb.append(initialJamoCandidate.getValue());
						// NOTE:
						// Consume the inappropriate final Jamo.
						i++;

						sb.append(medialJamoCandidate.getValue());
						break;
					}
				} else {
					sb.append(initialJamoCandidate.getValue());
				}
				break;

			case MEDIAL_JAMO:
				KoreanPhoneme finalJamo = null;
				if (i + 1 < phonemesSize) {
					KoreanPhoneme finalJamoCandidate = phonemes.get(i + 1);
					if (finalJamoCandidate.getType() == KoreanPhonemeType.FINAL_JAMO) {
						// NOTE:
						// Consume the valid final Jamo.
						i++;

						finalJamo = finalJamoCandidate;
					}
				}

				KoreanSyllableBuilder builder = new KoreanSyllableBuilder();
				builder.setMedialJamo(initialJamoCandidate);
				if (finalJamo != null) {
					builder.setFinalJamo(finalJamo);
				}
				sb.append(builder.build());
				break;

			case FINAL_JAMO:
			case NO_JAMO:
				sb.append(initialJamoCandidate.getValue());
				break;
			}
		}
		return sb.toString();
	}

	@Override
	public List<Character> decomposeAsCharacters(String text) {
		List<Character> phonemeChars = new ArrayList<Character>();
		for (char c : text.toCharArray()) {
			phonemeChars.addAll(decomposeAsCharacters(c));
		}
		return phonemeChars;
	}

	@Override
	public List<Character> decomposeAsCharacters(char syllable) {
		List<Character> phonemeChars = new ArrayList<Character>();

		int value = syllable - 44032;
		int initialValue = value / 588;
		value %= 588;
		int medialValue = value / 28;
		int finalValue = value % 28;

		phonemeChars.add(KoreanConsonant.values()[initialValue].getValue());
		phonemeChars.add(KoreanVowel.values()[medialValue].getValue());
		if (finalValue != KoreanFinalJamo.NO_JAMO.ordinal()) {
			phonemeChars.add(KoreanFinalJamo.values()[finalValue].getValue());
		}

		return phonemeChars;
	}

	@Override
	public List<KoreanPhoneme> decompose(String text) {
		List<KoreanPhoneme> phonemes = new ArrayList<KoreanPhoneme>();
		for (char c : text.toCharArray()) {
			if (koreanUnicodeService.isKorean(c)) {
				phonemes.addAll(decompose(c));
			} else {
				phonemes.add(new KoreanPhoneme(KoreanPhonemeType.NO_JAMO, c));
			}
		}
		return phonemes;
	}

	@Override
	public List<KoreanPhoneme> decompose(char syllable) {
		List<KoreanPhoneme> phonemes = new ArrayList<KoreanPhoneme>();

		int value = syllable - 44032;
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
