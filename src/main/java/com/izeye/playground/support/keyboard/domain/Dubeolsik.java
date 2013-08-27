package com.izeye.playground.support.keyboard.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;

@Component("dubeolsik")
public class Dubeolsik extends AbstractKoreanKeyboardLayout {

	private Map<Character, Character> english2KoreanMap;
	private Map<Character, Character> korean2EnglishMap;

	public Dubeolsik() {
		super(KoreanKeyboardLayoutType.DUBEOLSIK);
	}

	@Override
	protected void loadKeyboardLayout(File keyboardLayoutFile) {
		english2KoreanMap = new HashMap<Character, Character>();
		korean2EnglishMap = new HashMap<Character, Character>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(keyboardLayoutFile));
			String line;
			while ((line = br.readLine()) != null) {
				String[] splitLine = line.split(" ");
				char englishPhoneme = splitLine[0].charAt(0);
				char koreanPhoneme = splitLine[1].charAt(0);
				english2KoreanMap.put(englishPhoneme, koreanPhoneme);
				korean2EnglishMap.put(koreanPhoneme, englishPhoneme);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Character english2Korean(char englishPhoneme) {
		return english2KoreanMap.get(englishPhoneme);
	}

	@Override
	public Character korean2English(char koreanPhoneme) {
		return korean2EnglishMap.get(koreanPhoneme);
	}

	@Override
	public Character korean2English(KoreanPhoneme koreanPhoneme) {
		return korean2EnglishMap.get(koreanPhoneme.getValue());
	}

	@Override
	public String english2Korean(String english) {
		StringBuilder sb = new StringBuilder();

		List<Character> phonemes = new ArrayList<Character>();
		for (char englishPhoneme : english.toCharArray()) {
			Character koreanPhoneme = english2Korean(englishPhoneme);
			if (koreanPhoneme == null) {
				sb.append(koreanPhonemeService.composeCharsStrictly(phonemes));
				phonemes.clear();
				sb.append(englishPhoneme);
			} else {
				phonemes.add(koreanPhoneme);
			}
		}
		if (!phonemes.isEmpty()) {
			sb.append(koreanPhonemeService.composeCharsStrictly(phonemes));
		}

		return sb.toString();
	}

	@Override
	public String korean2English(String korean) {
		StringBuilder sb = new StringBuilder();

		for (char koreanSylable : korean.toCharArray()) {
			if (koreanUnicodeService.isKoreanSyllable(koreanSylable)) {
				List<Character> koreanPhonemes = koreanPhonemeService
						.decomposeAsCharacters(koreanSylable);
				for (Character koreanPhoneme : koreanPhonemes) {
					sb.append(korean2English(koreanPhoneme));
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
