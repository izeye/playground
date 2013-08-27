package com.izeye.playground.controller;

import static com.izeye.playground.web.menu.domain.MenuConstants.MENU_NAME_PLAYGROUND;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.WriterException;
import com.izeye.playground.support.code.domain.MultiWordNotationType;
import com.izeye.playground.support.date.service.DateService;
import com.izeye.playground.support.encode.base64.service.Base64EncodingService;
import com.izeye.playground.support.encode.unicode.service.UnicodeEncodingService;
import com.izeye.playground.support.encode.url.service.URLEncodingService;
import com.izeye.playground.support.ip.domain.IPInfo;
import com.izeye.playground.support.ip.service.IPAnalyzer;
import com.izeye.playground.support.keyboard.domain.KoreanKeyboardLayoutType;
import com.izeye.playground.support.keyboard.service.KoreanKeyboardLayoutSelector;
import com.izeye.playground.support.lang.en.alphabet.service.EnglishAlphabetService;
import com.izeye.playground.support.lang.ko.phoneme.service.KoreanPhonemeService;
import com.izeye.playground.support.lang.ko.roman.domain.KoreanRomanizationScheme;
import com.izeye.playground.support.lang.ko.roman.domain.RomanizationType;
import com.izeye.playground.support.lang.ko.roman.service.KoreanRomanizationService;
import com.izeye.playground.support.lang.ko.unicode.domain.Unicode;
import com.izeye.playground.support.lang.ko.unicode.service.KoreanUnicodeService;
import com.izeye.playground.support.math.base.domain.Base;
import com.izeye.playground.support.math.collatz.service.CollatzConjectureSolver;
import com.izeye.playground.support.math.factorial.service.FactorialSolver;
import com.izeye.playground.support.math.fibonacci.service.FibonacciNumberSolver;
import com.izeye.playground.support.math.gcd.domain.GcdAndLcm;
import com.izeye.playground.support.math.gcd.service.GcdAndLcmSolver;
import com.izeye.playground.support.math.goldbach.domain.GoldbachPartition;
import com.izeye.playground.support.math.goldbach.service.GoldbachConjectureSolver;
import com.izeye.playground.support.math.prime.domain.PrimeFactor;
import com.izeye.playground.support.math.prime.service.PrimeSolver;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationRequest;
import com.izeye.playground.support.qrcode.service.QRCodeService;
import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.service.UserAgentAnalyzer;
import com.izeye.playground.support.unit.domain.UnitType;
import com.izeye.playground.web.menu.domain.SubMenuSection;
import com.izeye.playground.web.menu.service.MenuService;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

@Controller
public class PlaygroundController {

	@Resource
	private MenuService menuService;

	@Resource
	private DateService dateService;

	@Resource
	private URLEncodingService urlEncodingService;

	@Resource
	private Base64EncodingService base64EncodingService;

	@Resource
	private UnicodeEncodingService unicodeEncodingService;

	@Resource
	private KoreanUnicodeService koreanUnicodeService;

	@Resource
	private KoreanPhonemeService koreanPhonemeService;

	@Resource
	private KoreanRomanizationService koreanRomanizationService;

	@Resource
	private KoreanKeyboardLayoutSelector koreanKeyboardLayoutSelector;

	@Resource
	private EnglishAlphabetService englishAlphabetService;

	@Resource
	private QRCodeService qrCodeService;

	@Resource
	private IPAnalyzer ipAnalyzer;

	@Resource
	private UserAgentAnalyzer userAgentAnalyzer;

	@Resource
	private GcdAndLcmSolver gcdAndLcmSolver;

	@Resource
	private PrimeSolver primeSolver;

	@Resource
	private FactorialSolver factorialSolver;

	@Resource
	private FibonacciNumberSolver fibonacciNumberSolver;

	@Resource
	private GoldbachConjectureSolver goldbachConjectureSolver;

	@Resource
	private CollatzConjectureSolver collatzConjectureSolver;

	@RequestMapping("/playground")
	public String playground(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/playground";
	}

	@RequestMapping("/playground/utilities/timestamp2date")
	public String utilitiesTimestamp2Date(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		Date currentDate = new Date();
		long currentTimestampInSeconds = TimeUnit.MILLISECONDS
				.toSeconds(currentDate.getTime());
		String currentFormattedDate = dateService.format(currentDate);
		model.addAttribute("currentTimestampInSeconds",
				currentTimestampInSeconds);
		model.addAttribute("currentFormattedDate", currentFormattedDate);

		return "playground/utilities/timestamp2date";
	}

	@RequestMapping("/playground/utilities/timestamp2date/api")
	@ResponseBody
	public String utilitiesTimestamp2DateAPI(
			@RequestParam long timestampInSeconds, Model model) {
		return dateService
				.timestampInSecondsToFormattedDate(timestampInSeconds);
	}

	@RequestMapping("/playground/utilities/date2timestamp/api")
	@ResponseBody
	public long utilitiesDate2TimestampAPI(@RequestParam String formattedDate,
			Model model) throws ParseException {
		return dateService.formattedDateToTimestampInSeconds(formattedDate);
	}

	@RequestMapping("/playground/utilities/url_encoder_and_decoder")
	public String utilitiesURLEncoderAndDecoder(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/utilities/url_encoder_and_decoder";
	}

	@RequestMapping("/playground/utilities/url_encoder_and_decoder/encode/api")
	@ResponseBody
	public String utilitiesURLEncoderAndDecoderEncodeAPI(
			@RequestParam String textToEncode, Model model)
			throws UnsupportedEncodingException {
		return urlEncodingService.encode(textToEncode);
	}

	@RequestMapping(value = "/playground/utilities/url_encoder_and_decoder/decode/api", produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String utilitiesURLEncoderAndDecoderDecodeAPI(
			@RequestParam String textToDecode, Model model)
			throws ParseException, UnsupportedEncodingException {
		return urlEncodingService.decode(textToDecode);
	}

	@RequestMapping("/playground/utilities/base64_encoder_and_decoder")
	public String utilitiesBase64EncoderAndDecoder(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/utilities/base64_encoder_and_decoder";
	}

	@RequestMapping("/playground/utilities/base64_encoder_and_decoder/encode/api")
	@ResponseBody
	public String utilitiesBase64EncoderAndDecoderEncodeAPI(
			@RequestParam String textToEncode, Model model)
			throws UnsupportedEncodingException {
		return base64EncodingService.encode(textToEncode);
	}

	@RequestMapping(value = "/playground/utilities/base64_encoder_and_decoder/decode/api", produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String utilitiesBase64EncoderAndDecoderDecodeAPI(
			@RequestParam String textToDecode, Model model)
			throws Base64DecodingException {
		return base64EncodingService.decode(textToDecode);
	}

	@RequestMapping("/playground/utilities/unicode_encoder_and_decoder")
	public String utilitiesUnicodeEncoderAndDecoder(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/utilities/unicode_encoder_and_decoder";
	}

	@RequestMapping("/playground/utilities/unicode_encoder_and_decoder/encode/api")
	@ResponseBody
	public String utilitiesUnicodeEncoderAndDecoderEncodeAPI(
			@RequestParam String textToEncode, Model model) {
		return unicodeEncodingService.encode(textToEncode);
	}

	@RequestMapping(value = "/playground/utilities/unicode_encoder_and_decoder/decode/api", produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String utilitiesUnicodeEncoderAndDecoderDecodeAPI(
			@RequestParam String textToDecode, Model model) {
		return unicodeEncodingService.decode(textToDecode);
	}

	@RequestMapping("/playground/utilities/korean_unicode_table")
	public String utilitiesKoreanUnicodeTable(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		List<Unicode> allUnicodes = koreanUnicodeService.getAllUnicodes();
		model.addAttribute("allUnicodes", allUnicodes);

		return "playground/utilities/korean_unicode_table";
	}

	@RequestMapping("/playground/utilities/korean_romanization")
	public String utilitiesKoreanRomanization(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		model.addAttribute("romanizationSchemes",
				KoreanRomanizationScheme.values());
		model.addAttribute("romanizationTypes", RomanizationType.values());

		return "playground/utilities/korean_romanization";
	}

	@RequestMapping(value = "/playground/utilities/korean_romanization/korean2roman/api", produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String utilitiesKoreanRomanizationKorean2RomanAPI(
			@RequestParam KoreanRomanizationScheme romanizationScheme,
			@RequestParam RomanizationType romanizationType,
			@RequestParam String korean, Model model) {
		return koreanRomanizationService.korean2Roman(romanizationScheme,
				romanizationType, korean);
	}

	@RequestMapping("/playground/utilities/korean_romanization/roman2korean/api")
	@ResponseBody
	public Set<String> utilitiesKoreanRomanizationRoman2KoreanAPI(
			@RequestParam KoreanRomanizationScheme romanizationScheme,
			@RequestParam RomanizationType romanizationType,
			@RequestParam String roman, Model model) {
		return koreanRomanizationService.roman2PossibleKoreanSet(
				romanizationScheme, romanizationType, roman);
	}

	@RequestMapping("/playground/utilities/korean_english_language_switch_typo_fixer")
	public String utilitiesKoreanEnglishLanguageSwitchTypoFixer(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		model.addAttribute("keyboardLayoutTypes",
				KoreanKeyboardLayoutType.values());

		return "playground/utilities/korean_english_language_switch_typo_fixer";
	}

	@RequestMapping("/playground/utilities/korean_english_language_switch_typo_fixer/korean2english/api")
	@ResponseBody
	public String utilitiesKoreanEnglishLanguageSwitchTypoFixerKorean2EnglishAPI(
			@RequestParam KoreanKeyboardLayoutType keyboardLayoutType,
			@RequestParam String korean, Model model) {
		return koreanKeyboardLayoutSelector.select(keyboardLayoutType)
				.korean2English(korean);
	}

	@RequestMapping(value = "/playground/utilities/korean_english_language_switch_typo_fixer/english2korean/api", produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String utilitiesKoreanEnglishLanguageSwitchTypoFixerEnglish2KoreanAPI(
			@RequestParam KoreanKeyboardLayoutType keyboardLayoutType,
			@RequestParam String english, Model model) {
		return koreanKeyboardLayoutSelector.select(keyboardLayoutType)
				.english2Korean(english);
	}

	@RequestMapping("/playground/utilities/korean_phoneme_composer_and_decomposer")
	public String utilitiesKoreanPhonemeComposerAndDecomposer(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/utilities/korean_phoneme_composer_and_decomposer";
	}

	@RequestMapping(value = "/playground/utilities/korean_phoneme_composer_and_decomposer/compose/api", produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String utilitiesKoreanPhonemeComposerAndDecomposerComposeAPI(
			@RequestParam String commaSeparatedPhonemes, Model model) {
		List<Character> phonemes = new ArrayList<Character>();
		for (String phoneme : commaSeparatedPhonemes.split(",")) {
			phonemes.add(phoneme.charAt(0));
		}
		return koreanPhonemeService.composeCharsStrictly(phonemes);
	}

	@RequestMapping("/playground/utilities/korean_phoneme_composer_and_decomposer/decompose/api")
	@ResponseBody
	public List<Character> utilitiesKoreanPhonemeComposerAndDecomposerDecomposeAPI(
			@RequestParam String wordToDecompose, Model model) {
		return koreanPhonemeService.decomposeAsCharacters(wordToDecompose);
	}

	@RequestMapping("/playground/utilities/english_lowercase_uppercase_converter")
	public String utilitiesEnglishLowerCaseUpperCaseConverter(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/utilities/english_lowercase_uppercase_converter";
	}

	@RequestMapping("/playground/utilities/english_lowercase_uppercase_converter/to_lowercase/api")
	@ResponseBody
	public String utilitiesEnglishLowerCaseUpperCaseConverterToLowerCaseAPI(
			@RequestParam String textToBeLowerCase, Model model) {
		return englishAlphabetService.toLowerCase(textToBeLowerCase);
	}

	@RequestMapping("/playground/utilities/english_lowercase_uppercase_converter/to_uppercase/api")
	@ResponseBody
	public String utilitiesEnglishLowerCaseUpperCaseConverterToUpperCaseAPI(
			@RequestParam String textToBeUpperCase, Model model) {
		return englishAlphabetService.toUpperCase(textToBeUpperCase);
	}

	@RequestMapping("/playground/utilities/html_escape_and_unescape")
	public String utilitiesHTMLEscapeAndUnescape(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/utilities/html_escape_and_unescape";
	}

	@RequestMapping("/playground/utilities/html_escape_and_unescape/escape/api")
	@ResponseBody
	public String utilitiesHTMLEscapeAndUnescapeEscapeAPI(
			@RequestParam String textToEscape, Model model) {
		return StringEscapeUtils.escapeHtml4(textToEscape);
	}

	@RequestMapping("/playground/utilities/html_escape_and_unescape/unescape/api")
	@ResponseBody
	public String utilitiesHTMLEscapeAndUnescapeUnescapeAPI(
			@RequestParam String textToUnescape, Model model) {
		return StringEscapeUtils.unescapeHtml4(textToUnescape);
	}

	@RequestMapping("/playground/utilities/unit_conversion")
	public String utilitiesUnitConversion(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		model.addAttribute("unitTypes", UnitType.values());

		return "playground/utilities/unit_conversion";
	}

	@RequestMapping("/playground/utilities/unit_conversion/json")
	@ResponseBody
	public BigDecimal utilitiesUnitConversionJSON(
			@RequestParam UnitType unitType, @RequestParam String sourceUnit,
			@RequestParam String targetUnit,
			@RequestParam BigDecimal valueToConvert, Model model) {
		return unitType.convert(sourceUnit, valueToConvert, targetUnit);
	}

	@RequestMapping("/playground/utilities/text2qrcode")
	public String utilitiesText2QRCode(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/utilities/text2qrcode";
	}

	@RequestMapping("/playground/utilities/text2qrcode/api")
	public ResponseEntity<byte[]> utilitiesText2QRCodeAPI(
			@ModelAttribute("ipAddress") String ipAddress,
			@RequestParam String text, @RequestParam int size, Model model)
			throws WriterException, IOException {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);

		QRCodeGenerationRequest request = new QRCodeGenerationRequest(text,
				size, ipAddress);
		byte[] qrcode = qrCodeService.text2QRCode(request);
		return new ResponseEntity<byte[]>(qrcode, headers, HttpStatus.CREATED);
	}

	@ModelAttribute("ipAddress")
	public String populateIpAddress(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

	@RequestMapping("/playground/utilities/ip")
	public String utilitiesIP(@ModelAttribute("ipAddress") String ipAddress,
			Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		IPInfo ipInfo = ipAnalyzer.analyze(ipAddress);
		model.addAttribute("ipInfo", ipInfo);

		return "playground/utilities/ip";
	}

	@RequestMapping("/playground/utilities/ip/json")
	@ResponseBody
	public IPInfo utilitiesIPJSON(@RequestParam String ipAddress, Model model) {
		return ipAnalyzer.analyze(ipAddress);
	}

	@RequestMapping("/playground/utilities/ua")
	public String utilitiesUA(@RequestHeader("User-Agent") String userAgent,
			Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		UserAgent analyzedUserAgent = userAgentAnalyzer.analyze(userAgent);
		model.addAttribute("userAgent", userAgent);
		model.addAttribute("analyzedUserAgent", analyzedUserAgent);

		return "playground/utilities/ua";
	}

	@RequestMapping("/playground/utilities/ua/json")
	@ResponseBody
	public UserAgent utilitiesUAJSON(@RequestParam String userAgent, Model model) {
		return userAgentAnalyzer.analyze(userAgent);
	}

	@RequestMapping("/playground/utilities/world_clock")
	public String utilitiesWorldClock(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		model.addAttribute("now", new Date());
		model.addAttribute("timeZoneIds", TimeZone.getAvailableIDs());

		return "playground/utilities/world_clock";
	}

	@RequestMapping("/playground/utilities/multi_word_notation_converter")
	public String utilitiesMultiWordNotationConverter(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		model.addAttribute("notations", MultiWordNotationType.values());

		return "playground/utilities/multi_word_notation_converter";
	}

	@RequestMapping("/playground/utilities/multi_word_notation_converter/api")
	@ResponseBody
	public String utilitiesMultiWordNotationConverterApi(
			@RequestParam MultiWordNotationType sourceNotation,
			@RequestParam MultiWordNotationType targetNotation,
			@RequestParam String stringToConvert, Model model) {
		return targetNotation.convert(stringToConvert, sourceNotation);
	}

	@RequestMapping("/playground/math/fractals")
	public String mathFractals(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/math/fractals";
	}

	@RequestMapping("/playground/math/base_converter")
	public String mathBaseConverter(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		model.addAttribute("bases", Base.values());

		return "playground/math/base_converter";
	}

	@RequestMapping("/playground/math/base_converter/api")
	@ResponseBody
	public String mathBaseConverterApi(@RequestParam Base sourceBase,
			@RequestParam Base targetBase,
			@RequestParam String numberToConvert, Model model) {
		return targetBase.convert(numberToConvert, sourceBase);
	}

	@RequestMapping("/playground/math/prime")
	public String mathPrime(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/math/prime";
	}

	@RequestMapping("/playground/math/prime/all_primes")
	@ResponseBody
	public List<Long> mathPrimeAllPrimeJSON(@RequestParam Long number,
			Model model) {
		return primeSolver.getAllPrimesWithin(number);
	}

	@RequestMapping("/playground/math/prime/is_prime")
	@ResponseBody
	public boolean mathPrimeIsPrimeJSON(@RequestParam Long number, Model model) {
		return primeSolver.isPrime(number);
	}

	@RequestMapping("/playground/math/prime_factorization")
	public String mathPrimeFactorization(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/math/prime_factorization";
	}

	@RequestMapping("/playground/math/prime_factorization/json")
	@ResponseBody
	public List<PrimeFactor> mathPrimeFactorizationJSON(
			@RequestParam Long number, Model model) {
		return primeSolver.getPrimeFactors(number);
	}

	@RequestMapping("/playground/math/gcd_and_lcm")
	public String mathGcdAndLcm(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/math/gcd_and_lcm";
	}

	@RequestMapping("/playground/math/gcd_and_lcm/json")
	@ResponseBody
	public GcdAndLcm mathGcdAndLcmJSON(@RequestParam Long number1,
			@RequestParam Long number2, Model model) {
		return gcdAndLcmSolver.getGcdAndLcm(number1, number2);
	}

	@RequestMapping("/playground/math/factorial")
	public String mathFactorial(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/math/factorial";
	}

	@RequestMapping("/playground/math/factorial/json")
	@ResponseBody
	public String mathFactorialJSON(@RequestParam BigInteger number, Model model) {
		String result = factorialSolver.solve(number).toString();
		return result;
	}

	@RequestMapping("/playground/math/fibonacci")
	public String mathFibonacci(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/math/fibonacci";
	}

	@RequestMapping("/playground/math/fibonacci/json")
	@ResponseBody
	public List<Long> mathFibonacciJSON(@RequestParam Long number, Model model) {
		return fibonacciNumberSolver.solve(number);
	}

	@RequestMapping("/playground/math/goldbach")
	public String mathGoldbach(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/math/goldbach";
	}

	@RequestMapping("/playground/math/goldbach/json")
	@ResponseBody
	public List<GoldbachPartition> mathGoldbachJSON(@RequestParam Long number,
			Model model) {
		return goldbachConjectureSolver.solve(number);
	}

	@RequestMapping("/playground/math/collatz")
	public String mathCollatz(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/math/collatz";
	}

	@RequestMapping("/playground/math/collatz/json")
	@ResponseBody
	public List<Long> mathCollatzJSON(@RequestParam Long number, Model model) {
		return collatzConjectureSolver.solve(number);
	}

	@RequestMapping("/playground/demo/webcam/live")
	public String demoWebcamLive(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/demo/webcam/live";
	}

	@RequestMapping("/playground/demo/webcam/snapshots")
	public String demoWebcamSnapshots(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/demo/webcam/snapshots";
	}

	@RequestMapping("/playground/demo/kakao_link")
	public String demoKakaoLink(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/demo/kakao_link";
	}

}
