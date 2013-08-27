package com.izeye.playground.support.lang.ko.syllable.domain;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanConsonant;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanFinalJamo;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhonemeType;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanVowel;

public class KoreanSyllableBuilder {

	private KoreanConsonant initialJamo = KoreanConsonant.IEUNG;
	private KoreanVowel medialJamo;
	private KoreanFinalJamo finalJamo = KoreanFinalJamo.NO_JAMO;

	public KoreanConsonant getInitialJamo() {
		return initialJamo;
	}

	public void setInitialJamo(KoreanConsonant initialJamo) {
		this.initialJamo = initialJamo;
	}

	public void setInitialJamo(char c) {
		setInitialJamo(KoreanConsonant.getByValue(c));
	}

	public void setInitialJamo(KoreanPhoneme koreanPhoneme) {
		if (koreanPhoneme.getType() != KoreanPhonemeType.INITIAL_JAMO) {
			throw new IllegalArgumentException(
					"The type of korean phoneme should be initial Jamo.");
		}
		setInitialJamo(koreanPhoneme.getValue());
	}

	public KoreanVowel getMedialJamo() {
		return medialJamo;
	}

	public void setMedialJamo(KoreanVowel medialJamo) {
		this.medialJamo = medialJamo;
	}

	public void setMedialJamo(char c) {
		setMedialJamo(KoreanVowel.getByValue(c));
	}

	public void setMedialJamo(KoreanPhoneme koreanPhoneme) {
		if (koreanPhoneme.getType() != KoreanPhonemeType.MEDIAL_JAMO) {
			throw new IllegalArgumentException(
					"The type of korean phoneme should be medial Jamo.");
		}
		setMedialJamo(koreanPhoneme.getValue());
	}

	public KoreanFinalJamo getFinalJamo() {
		return finalJamo;
	}

	public void setFinalJamo(KoreanFinalJamo finalJamo) {
		this.finalJamo = finalJamo;
	}

	public void setFinalJamo(char c) {
		setFinalJamo(KoreanFinalJamo.getByValue(c));
	}

	public void setFinalJamo(KoreanPhoneme koreanPhoneme) {
		if (koreanPhoneme.getType() != KoreanPhonemeType.FINAL_JAMO) {
			throw new IllegalArgumentException(
					"The type of korean phoneme should be final Jamo.");
		}
		setFinalJamo(koreanPhoneme.getValue());
	}

	public char build() {
		return (char) (initialJamo.ordinal() * 588 + medialJamo.ordinal() * 28
				+ finalJamo.ordinal() + 44032);
	}

	@Override
	public String toString() {
		return "KoreanSyllable [initialJamo=" + initialJamo + ", medialJamo="
				+ medialJamo + ", finalJamo=" + finalJamo + "]";
	}

}
