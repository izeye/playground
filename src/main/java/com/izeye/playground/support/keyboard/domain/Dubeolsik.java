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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.izeye.playground.support.lang.ko.phoneme.service.KoreanPhonemeService;
import com.izeye.playground.support.lang.ko.unicode.service.KoreanUnicodeService;

@Service("dubeolsik")
public class Dubeolsik implements KoreanKeyboardLayout {

	private final Map<Character, Character> english2KoreanMap = new HashMap<Character, Character>();
	private final Map<Character, Character> korean2EnglishMap = new HashMap<Character, Character>();

	@Resource
	private KoreanUnicodeService koreanUnicodeService;

	@Resource
	private KoreanPhonemeService koreanPhonemeService;

	public Dubeolsik() {
		loadKeyboardLayout();
	}

	private void loadKeyboardLayout() {
		try {
			File file = ResourceUtils
					.getFile("classpath:data/keyboard_layout/dubeolsik.layout");
			BufferedReader br = new BufferedReader(new FileReader(file));
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
				List<Character> koreanPhonemes = koreanPhonemeService
						.decompose(koreanSylable);
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
