package com.izeye.playground.tools.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_LOWERCASE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_UPPERCASE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_ENGLISH_2_KOREAN;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_KOREAN_2_ENGLISH;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_COMPOSE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_DECOMPOSE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_ROMANIZATION_KOREAN_2_ROMAN;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_KOREAN_ROMANIZATION_ROMAN_2_KOREAN;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_KOREAN_ROMANIZATION_PATH;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.support.keyboard.domain.KoreanKeyboardLayoutType;
import com.izeye.playground.support.keyboard.service.KoreanKeyboardLayoutSelector;
import com.izeye.playground.support.lang.en.alphabet.service.EnglishAlphabetService;
import com.izeye.playground.support.lang.ko.phoneme.service.KoreanPhonemeService;
import com.izeye.playground.support.lang.ko.roman.domain.KoreanRomanizationScheme;
import com.izeye.playground.support.lang.ko.roman.domain.RomanizationType;
import com.izeye.playground.support.lang.ko.roman.service.KoreanRomanizationService;
import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class ToolsLinguisticsController extends AbstractToolsController {

	@Resource
	private KoreanRomanizationService koreanRomanizationService;

	@Resource
	private KoreanKeyboardLayoutSelector koreanKeyboardLayoutSelector;

	@Resource
	private KoreanPhonemeService koreanPhonemeService;

	@Resource
	private EnglishAlphabetService englishAlphabetService;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping(SUB_MENU_ITEM_KOREAN_ROMANIZATION_PATH)
	public String koreanRomanization(Model model) {
		model.addAttribute("romanizationSchemes",
				KoreanRomanizationScheme.values());
		model.addAttribute("romanizationTypes", RomanizationType.values());

		model.addAttribute("API_PATH_KOREAN_ROMANIZATION_KOREAN_2_ROMAN",
				API_PATH_KOREAN_ROMANIZATION_KOREAN_2_ROMAN);
		model.addAttribute("API_PATH_KOREAN_ROMANIZATION_ROMAN_2_KOREAN",
				API_PATH_KOREAN_ROMANIZATION_ROMAN_2_KOREAN);

		return SubMenuItem.TOOLS_LINGUISTICS_KOREAN_ROMANIZATION.getViewName();
	}

	@RequestMapping(value = API_PATH_KOREAN_ROMANIZATION_KOREAN_2_ROMAN, produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String koreanRomanizationKorean2RomanApi(
			@RequestParam KoreanRomanizationScheme romanizationScheme,
			@RequestParam RomanizationType romanizationType,
			@RequestParam String korean) {
		return koreanRomanizationService.korean2Roman(romanizationScheme,
				romanizationType, korean);
	}

	@RequestMapping(API_PATH_KOREAN_ROMANIZATION_ROMAN_2_KOREAN)
	@ResponseBody
	public Set<String> koreanRomanizationRoman2KoreanApi(
			@RequestParam KoreanRomanizationScheme romanizationScheme,
			@RequestParam RomanizationType romanizationType,
			@RequestParam String roman) {
		return koreanRomanizationService.roman2PossibleKoreanSet(
				romanizationScheme, romanizationType, roman);
	}

	@RequestMapping(SUB_MENU_ITEM_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_PATH)
	public String koreanEnglishLanguageSwitchTypoFixer(Model model) {
		model.addAttribute("keyboardLayoutTypes",
				KoreanKeyboardLayoutType.values());

		model.addAttribute(
				"API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_KOREAN_2_ENGLISH",
				API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_KOREAN_2_ENGLISH);
		model.addAttribute(
				"API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_ENGLISH_2_KOREAN",
				API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_ENGLISH_2_KOREAN);

		return SubMenuItem.TOOLS_LINGUISTICS_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER
				.getViewName();
	}

	@RequestMapping(API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_KOREAN_2_ENGLISH)
	@ResponseBody
	public String koreanEnglishLanguageSwitchTypoFixerKorean2EnglishApi(
			@RequestParam KoreanKeyboardLayoutType keyboardLayoutType,
			@RequestParam String korean) {
		return koreanKeyboardLayoutSelector.select(keyboardLayoutType)
				.korean2English(korean);
	}

	@RequestMapping(value = API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_ENGLISH_2_KOREAN, produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String koreanEnglishLanguageSwitchTypoFixerEnglish2KoreanApi(
			@RequestParam KoreanKeyboardLayoutType keyboardLayoutType,
			@RequestParam String english) {
		return koreanKeyboardLayoutSelector.select(keyboardLayoutType)
				.english2Korean(english);
	}

	@RequestMapping(SUB_MENU_ITEM_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_PATH)
	public String koreanPhonemeComposerAndDecomposer(Model model) {
		model.addAttribute(
				"API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_COMPOSE",
				API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_COMPOSE);
		model.addAttribute(
				"API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_DECOMPOSE",
				API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_DECOMPOSE);

		return SubMenuItem.TOOLS_LINGUISTICS_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER
				.getViewName();
	}

	@RequestMapping(value = API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_COMPOSE, produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String koreanPhonemeComposerAndDecomposerComposeApi(
			@RequestParam String commaSeparatedPhonemes) {
		List<Character> phonemes = new ArrayList<Character>();
		for (String phoneme : commaSeparatedPhonemes.split(",")) {
			phonemes.add(phoneme.charAt(0));
		}
		return koreanPhonemeService.composeCharsStrictly(phonemes);
	}

	@RequestMapping(API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_DECOMPOSE)
	@ResponseBody
	public List<Character> koreanPhonemeComposerAndDecomposerDecomposeApi(
			@RequestParam String wordToDecompose) {
		return koreanPhonemeService.decomposeAsCharacters(wordToDecompose);
	}

	@RequestMapping(SUB_MENU_ITEM_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_PATH)
	public String englishLowerCaseUpperCaseConverter(Model model) {
		model.addAttribute(
				"API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_LOWERCASE",
				API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_LOWERCASE);
		model.addAttribute(
				"API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_UPPERCASE",
				API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_UPPERCASE);

		return SubMenuItem.TOOLS_LINGUISTICS_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER
				.getViewName();
	}

	@RequestMapping(value = API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_LOWERCASE, produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String englishLowerCaseUpperCaseConverterToLowerCaseApi(
			@RequestParam String textToBeLowerCase) {
		log.debug(textToBeLowerCase);

		return englishAlphabetService.toLowerCase(textToBeLowerCase);
	}

	@RequestMapping(value = API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_UPPERCASE, produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String englishLowerCaseUpperCaseConverterToUpperCaseApi(
			@RequestParam String textToBeUpperCase) {
		log.debug(textToBeUpperCase);

		return englishAlphabetService.toUpperCase(textToBeUpperCase);
	}

}
