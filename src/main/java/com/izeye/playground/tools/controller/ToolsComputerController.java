package com.izeye.playground.tools.controller;

import static com.izeye.playground.support.http.domain.HTTPConstants.HEADER_DELIMITER;
import static com.izeye.playground.support.http.domain.HTTPConstants.PARAMETER_DELIMITER;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_BASE64_ENCODER_AND_DECODER_DECODE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_BASE64_ENCODER_AND_DECODER_ENCODE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_BASE_CONVERTER;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_DATE_AND_TIME_2_TIMESTAMP;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_HTML_ESCAPE_AND_UNESCAPE_ESCAPE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_HTML_ESCAPE_AND_UNESCAPE_UNESCAPE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_HTTP_CLIENT;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_IP_ANALYZER;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_MULTI_WORD_NOTATION_CONVERTER;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_TIMESTAMP_2_DATE_AND_TIME;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_UA_ANALYZER;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_UNICODE_ENCODER_AND_DECODER_DECODE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_UNICODE_ENCODER_AND_DECODER_ENCODE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_URL_ENCODER_AND_DECODER_DECODE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_URL_ENCODER_AND_DECODER_ENCODE;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_BASE64_ENCODER_AND_DECODER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_BASE_CONVERTER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_HTML_ESCAPE_AND_UNESCAPE_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_HTTP_CLIENT_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_IP_ANALYZER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_KOREAN_UNICODE_TABLE_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_MULTI_WORD_NOTATION_CONVERTER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_TIMESTAMP_2_DATE_AND_TIME_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_UA_ANALYZER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_UNICODE_ENCODER_AND_DECODER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_URL_ENCODER_AND_DECODER_PATH;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.support.code.domain.MultiWordNotationType;
import com.izeye.playground.support.date.service.DateService;
import com.izeye.playground.support.encode.base64.service.Base64EncodingService;
import com.izeye.playground.support.encode.unicode.service.UnicodeEncodingService;
import com.izeye.playground.support.encode.url.service.URLEncodingService;
import com.izeye.playground.support.http.client.domain.HttpMethod;
import com.izeye.playground.support.http.client.domain.HttpRequest;
import com.izeye.playground.support.http.client.domain.HttpRequestAndResponsePair;
import com.izeye.playground.support.http.client.domain.HttpResponse;
import com.izeye.playground.support.http.client.service.HttpClient;
import com.izeye.playground.support.ip.domain.IpInfo;
import com.izeye.playground.support.ip.service.IpAnalyzer;
import com.izeye.playground.support.lang.ko.unicode.domain.Unicode;
import com.izeye.playground.support.lang.ko.unicode.service.KoreanUnicodeService;
import com.izeye.playground.support.math.base.domain.Base;
import com.izeye.playground.support.menu.domain.SubMenuItem;
import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.service.UserAgentAnalyzer;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

@Controller
public class ToolsComputerController extends AbstractToolsController {

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
	private HttpClient httpClient;

	@Resource
	private IpAnalyzer ipAnalyzer;

	@Resource
	private UserAgentAnalyzer userAgentAnalyzer;

	@RequestMapping(SUB_MENU_ITEM_TIMESTAMP_2_DATE_AND_TIME_PATH)
	public String timestamp2DateAndTime(Model model) {
		Date currentDate = new Date();
		long currentTimestampInSeconds = TimeUnit.MILLISECONDS
				.toSeconds(currentDate.getTime());
		String currentFormattedDate = dateService.format(currentDate);
		model.addAttribute("currentTimestampInSeconds",
				currentTimestampInSeconds);
		model.addAttribute("currentFormattedDate", currentFormattedDate);

		model.addAttribute("API_URL_TIMESTAMP_2_DATE_AND_TIME",
				API_PATH_TIMESTAMP_2_DATE_AND_TIME);
		model.addAttribute("API_URL_DATE_AND_TIME_2_TIMESTAMP",
				API_PATH_DATE_AND_TIME_2_TIMESTAMP);

		return SubMenuItem.TOOLS_COMPUTER_TIMESTAMP_2_DATE_AND_TIME
				.getViewName();
	}

	@RequestMapping(API_PATH_TIMESTAMP_2_DATE_AND_TIME)
	@ResponseBody
	public String timestamp2DateAndTimeApi(@RequestParam long timestampInSeconds) {
		return dateService
				.timestampInSecondsToFormattedDate(timestampInSeconds);
	}

	@RequestMapping(API_PATH_DATE_AND_TIME_2_TIMESTAMP)
	@ResponseBody
	public long dateAndTime2TimestampApi(@RequestParam String formattedDate)
			throws ParseException {
		return dateService.formattedDateToTimestampInSeconds(formattedDate);
	}

	@RequestMapping(SUB_MENU_ITEM_URL_ENCODER_AND_DECODER_PATH)
	public String urlEncoderAndDecoder(Model model) {
		model.addAttribute("API_PATH_URL_ENCODER_AND_DECODER_ENCODE",
				API_PATH_URL_ENCODER_AND_DECODER_ENCODE);
		model.addAttribute("API_PATH_URL_ENCODER_AND_DECODER_DECODE",
				API_PATH_URL_ENCODER_AND_DECODER_DECODE);

		return SubMenuItem.TOOLS_COMPUTER_URL_ENCODER_AND_DECODER.getViewName();
	}

	@RequestMapping(API_PATH_URL_ENCODER_AND_DECODER_ENCODE)
	@ResponseBody
	public String urlEncoderAndDecoderEncodeApi(
			@RequestParam String textToEncode)
			throws UnsupportedEncodingException {
		return urlEncodingService.encode(textToEncode);
	}

	@RequestMapping(value = API_PATH_URL_ENCODER_AND_DECODER_DECODE, produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String urlEncoderAndDecoderDecodeApi(
			@RequestParam String textToDecode) throws ParseException,
			UnsupportedEncodingException {
		return urlEncodingService.decode(textToDecode);
	}

	@RequestMapping(SUB_MENU_ITEM_BASE64_ENCODER_AND_DECODER_PATH)
	public String base64EncoderAndDecoder(Model model) {
		model.addAttribute("API_PATH_BASE64_ENCODER_AND_DECODER_ENCODE",
				API_PATH_BASE64_ENCODER_AND_DECODER_ENCODE);
		model.addAttribute("API_PATH_BASE64_ENCODER_AND_DECODER_DECODE",
				API_PATH_BASE64_ENCODER_AND_DECODER_DECODE);

		return SubMenuItem.TOOLS_COMPUTER_BASE64_ENCODER_AND_DECODER
				.getViewName();
	}

	@RequestMapping(API_PATH_BASE64_ENCODER_AND_DECODER_ENCODE)
	@ResponseBody
	public String base64EncoderAndDecoderEncodeApi(
			@RequestParam String textToEncode)
			throws UnsupportedEncodingException {
		return base64EncodingService.encode(textToEncode);
	}

	@RequestMapping(value = API_PATH_BASE64_ENCODER_AND_DECODER_DECODE, produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String base64EncoderAndDecoderDecodeApi(
			@RequestParam String textToDecode) throws Base64DecodingException {
		return base64EncodingService.decode(textToDecode);
	}

	@RequestMapping(SUB_MENU_ITEM_UNICODE_ENCODER_AND_DECODER_PATH)
	public String unicodeEncoderAndDecoder(Model model) {
		model.addAttribute("API_PATH_UNICODE_ENCODER_AND_DECODER_ENCODE",
				API_PATH_UNICODE_ENCODER_AND_DECODER_ENCODE);
		model.addAttribute("API_PATH_UNICODE_ENCODER_AND_DECODER_DECODE",
				API_PATH_UNICODE_ENCODER_AND_DECODER_DECODE);

		return SubMenuItem.TOOLS_COMPUTER_UNICODE_ENCODER_AND_DECODER
				.getViewName();
	}

	@RequestMapping(API_PATH_UNICODE_ENCODER_AND_DECODER_ENCODE)
	@ResponseBody
	public String unicodeEncoderAndDecoderEncodeApi(
			@RequestParam String textToEncode) {
		return unicodeEncodingService.encode(textToEncode);
	}

	@RequestMapping(value = API_PATH_UNICODE_ENCODER_AND_DECODER_DECODE, produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String unicodeEncoderAndDecoderDecodeApi(
			@RequestParam String textToDecode) {
		return unicodeEncodingService.decode(textToDecode);
	}

	@RequestMapping(SUB_MENU_ITEM_KOREAN_UNICODE_TABLE_PATH)
	public String koreanUnicodeTable(Model model) {
		List<Unicode> allUnicodes = koreanUnicodeService.getAllUnicodes();
		model.addAttribute("allUnicodes", allUnicodes);

		return SubMenuItem.TOOLS_COMPUTER_KOREAN_UNICODE_TABLE.getViewName();
	}

	@RequestMapping(SUB_MENU_ITEM_HTML_ESCAPE_AND_UNESCAPE_PATH)
	public String htmlEscapeAndUnescape(Model model) {
		model.addAttribute("API_PATH_HTML_ESCAPE_AND_UNESCAPE_ESCAPE",
				API_PATH_HTML_ESCAPE_AND_UNESCAPE_ESCAPE);
		model.addAttribute("API_PATH_HTML_ESCAPE_AND_UNESCAPE_UNESCAPE",
				API_PATH_HTML_ESCAPE_AND_UNESCAPE_UNESCAPE);

		return SubMenuItem.TOOLS_COMPUTER_HTML_ESCAPE_AND_UNESCAPE
				.getViewName();
	}

	@RequestMapping(API_PATH_HTML_ESCAPE_AND_UNESCAPE_ESCAPE)
	@ResponseBody
	public String htmlEscapeAndUnescapeEscapeApi(
			@RequestParam String textToEscape) {
		return StringEscapeUtils.escapeHtml4(textToEscape);
	}

	@RequestMapping(API_PATH_HTML_ESCAPE_AND_UNESCAPE_UNESCAPE)
	@ResponseBody
	public String htmlEscapeAndUnescapeUnescapeApi(
			@RequestParam String textToUnescape) {
		return StringEscapeUtils.unescapeHtml4(textToUnescape);
	}

	@RequestMapping(SUB_MENU_ITEM_HTTP_CLIENT_PATH)
	public String httpClient(Model model) {
		model.addAttribute("methods", HttpMethod.values());

		model.addAttribute("API_PATH_HTTP_CLIENT", API_PATH_HTTP_CLIENT);

		return SubMenuItem.TOOLS_COMPUTER_HTTP_CLIENT.getViewName();
	}

	@RequestMapping(API_PATH_HTTP_CLIENT)
	@ResponseBody
	public HttpRequestAndResponsePair httpClientApi(
			@RequestParam HttpMethod method, @RequestParam String url,
			@RequestParam String headers, @RequestParam String parameters)
			throws MalformedURLException {
		HttpRequest request = new HttpRequest(method, url);

		headers = headers.trim();
		if (!headers.isEmpty()) {
			Map<String, String> headerMap = new HashMap<String, String>();

			String[] splitHeaders = headers.split("\n");
			for (String header : splitHeaders) {
				String[] splitHeader = header.split(HEADER_DELIMITER);
				String headerName = splitHeader[0].trim();
				String headerValue = splitHeader[1].trim();
				for (int i = 2; i < splitHeader.length; i++) {
					headerValue += HEADER_DELIMITER + splitHeader[i];
				}
				headerMap.put(headerName, headerValue);
			}

			request.setHeaders(headerMap);
		}

		parameters = parameters.trim();
		if (!parameters.isEmpty()) {
			Map<String, String> parameterMap = new HashMap<String, String>();

			String[] splitParameters = parameters.split("\n");
			for (String parameter : splitParameters) {
				String[] splitParameter = parameter.split(PARAMETER_DELIMITER);
				String parameterName = splitParameter[0].trim();
				String parameterValue = splitParameter[1].trim();
				parameterMap.put(parameterName, parameterValue);
			}

			request.setParameters(parameterMap);
		}

		HttpResponse response = httpClient.send(request);
		return new HttpRequestAndResponsePair(request, response);
	}

	@RequestMapping(SUB_MENU_ITEM_IP_ANALYZER_PATH)
	public String ipAnalyzer(HttpServletRequest request, Model model) {
		IpInfo ipInfo = ipAnalyzer.analyze(request.getRemoteAddr());
		model.addAttribute("ipInfo", ipInfo);

		model.addAttribute("API_PATH_IP_ANALYZER", API_PATH_IP_ANALYZER);

		return SubMenuItem.TOOLS_COMPUTER_IP_ANALYZER.getViewName();
	}

	@RequestMapping(API_PATH_IP_ANALYZER)
	@ResponseBody
	public IpInfo ipAnalyzerApi(@RequestParam String ipAddress) {
		return ipAnalyzer.analyze(ipAddress);
	}

	@RequestMapping(SUB_MENU_ITEM_UA_ANALYZER_PATH)
	public String uaAnalyzer(@RequestHeader("User-Agent") String userAgent,
			Model model) {
		UserAgent analyzedUserAgent = userAgentAnalyzer.analyze(userAgent);
		model.addAttribute("userAgent", userAgent);
		model.addAttribute("analyzedUserAgent", analyzedUserAgent);

		model.addAttribute("API_PATH_UA_ANALYZER", API_PATH_UA_ANALYZER);

		return SubMenuItem.TOOLS_COMPUTER_UA_ANALYZER.getViewName();
	}

	@RequestMapping(API_PATH_UA_ANALYZER)
	@ResponseBody
	public UserAgent uaAnalyzerApi(@RequestParam String userAgent) {
		return userAgentAnalyzer.analyze(userAgent);
	}

	@RequestMapping(SUB_MENU_ITEM_MULTI_WORD_NOTATION_CONVERTER_PATH)
	public String multiWordNotationConverter(Model model) {
		model.addAttribute("notations", MultiWordNotationType.values());

		model.addAttribute("API_PATH_MULTI_WORD_NOTATION_CONVERTER",
				API_PATH_MULTI_WORD_NOTATION_CONVERTER);

		return SubMenuItem.TOOLS_COMPUTER_MULTI_WORD_NOTATION_CONVERTER
				.getViewName();
	}

	@RequestMapping(value = API_PATH_MULTI_WORD_NOTATION_CONVERTER, produces = { "text/plain; charset=UTF-8" })
	@ResponseBody
	public String multiWordNotationConverterApi(
			@RequestParam MultiWordNotationType sourceNotation,
			@RequestParam MultiWordNotationType targetNotation,
			@RequestParam String stringToConvert) {
		return targetNotation.convert(stringToConvert, sourceNotation);
	}

	@RequestMapping(SUB_MENU_ITEM_BASE_CONVERTER_PATH)
	public String baseConverter(Model model) {
		model.addAttribute("bases", Base.values());

		model.addAttribute("API_PATH_BASE_CONVERTER", API_PATH_BASE_CONVERTER);

		return SubMenuItem.TOOLS_COMPUTER_BASE_CONVERTER.getViewName();
	}

	@RequestMapping(API_PATH_BASE_CONVERTER)
	@ResponseBody
	public String baseConverterApi(@RequestParam Base sourceBase,
			@RequestParam Base targetBase, @RequestParam String numberToConvert) {
		return targetBase.convert(numberToConvert, sourceBase);
	}

}
