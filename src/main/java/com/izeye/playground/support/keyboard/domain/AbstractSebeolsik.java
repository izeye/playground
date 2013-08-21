package com.izeye.playground.support.keyboard.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhonemeType;

public abstract class AbstractSebeolsik extends AbstractKoreanKeyboardLayout {

	private Map<Character, KoreanPhoneme> english2KoreanMap;
	private Map<KoreanPhoneme, Character> korean2EnglishMap;

	public AbstractSebeolsik(KoreanKeyboardLayoutType type) {
		super(type);
	}

	@Override
	protected void loadKeyboardLayout(File keyboardLayoutFile) {
		english2KoreanMap = new HashMap<Character, KoreanPhoneme>();
		korean2EnglishMap = new HashMap<KoreanPhoneme, Character>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					keyboardLayoutFile));
			String line;
			while ((line = br.readLine()) != null) {
				String[] splitLine = line.split(" ");
				char englishPhonemeValue = splitLine[0].charAt(0);
				char koreanPhonemeValue = splitLine[1].charAt(0);
				KoreanPhonemeType koreanPhonemeType = KoreanPhonemeType
						.valueOf(splitLine[2]);
				KoreanPhoneme koreanPhoneme = new KoreanPhoneme(
						koreanPhonemeType, koreanPhonemeValue);
				english2KoreanMap.put(englishPhonemeValue, koreanPhoneme);
				korean2EnglishMap.put(koreanPhoneme, englishPhonemeValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Character english2Korean(char englishPhoneme) {
		KoreanPhoneme koreanPhoneme = english2KoreanMap.get(englishPhoneme);
		return koreanPhoneme == null ? null : koreanPhoneme.getValue();
	}

	@Override
	public Character korean2English(char koreanPhoneme) {
		Set<KoreanPhoneme> possiblePhonemes = koreanPhonemeService
				.getPossiblePhonemes(koreanPhoneme);
		Iterator<KoreanPhoneme> it = possiblePhonemes.iterator();
		switch (possiblePhonemes.size()) {
		case 1:
			return korean2EnglishMap.get(it.next());

		case 2:
			// NOTE:
			// When it is ambiguous,
			// handle it as initial Jamo.
			KoreanPhoneme phoneme = it.next();
			if (phoneme.getType() == KoreanPhonemeType.INITIAL_JAMO) {
				return korean2EnglishMap.get(phoneme);
			} else {
				return korean2EnglishMap.get(it.next());
			}

		default:
			throw new IllegalArgumentException("Illegal Korean phoneme: "
					+ koreanPhoneme);
		}
	}

	@Override
	public Character korean2English(KoreanPhoneme koreanPhoneme) {
		return korean2EnglishMap.get(koreanPhoneme);
	}

	@Override
	public String english2Korean(String english) {
		StringBuilder sb = new StringBuilder();

		List<Character> phonemes = new ArrayList<Character>();
		for (char englishPhoneme : english.toCharArray()) {
			Character koreanPhoneme = english2Korean(englishPhoneme);
			if (koreanPhoneme == null) {
				sb.append(koreanPhonemeService.compose(phonemes));
				phonemes.clear();
				sb.append(englishPhoneme);
			} else {
				phonemes.add(koreanPhoneme);
			}
		}
		if (!phonemes.isEmpty()) {
			sb.append(koreanPhonemeService.compose(phonemes));
		}

		return sb.toString();
	}

	@Override
	public String korean2English(String korean) {
		StringBuilder sb = new StringBuilder();

		for (char koreanSylable : korean.toCharArray()) {
			if (koreanUnicodeService.isKoreanSyllable(koreanSylable)) {
				List<KoreanPhoneme> koreanPhonemes = koreanPhonemeService
						.decompose(koreanSylable);
				for (KoreanPhoneme koreanPhoneme : koreanPhonemes) {
					sb.append(korean2EnglishMap.get(koreanPhoneme));
				}
			} else if (koreanUnicodeService.isKoreanJamo(koreanSylable)) {
				sb.append(korean2English(koreanSylable));
			} else {
				sb.append(koreanSylable);
			}
		}

		return sb.toString();
	}

}
