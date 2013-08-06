package com.izeye.playground.controller;

import static com.izeye.playground.web.menu.domain.MenuConstants.MENU_NAME_PLAYGROUND;

import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.izeye.playground.support.date.service.DateService;
import com.izeye.playground.support.ip.domain.IPInfo;
import com.izeye.playground.support.ip.service.IPAnalyzer;
import com.izeye.playground.support.math.collatz.service.CollatzConjectureSolver;
import com.izeye.playground.support.math.factorial.service.FactorialSolver;
import com.izeye.playground.support.math.fibonacci.service.FibonacciNumberSolver;
import com.izeye.playground.support.math.gcd.domain.GcdAndLcm;
import com.izeye.playground.support.math.gcd.service.GcdAndLcmSolver;
import com.izeye.playground.support.math.prime.service.PrimeSolver;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationRequest;
import com.izeye.playground.support.qrcode.service.QRCodeService;
import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.service.UserAgentAnalyzer;
import com.izeye.playground.support.unit.domain.AreaUnit;
import com.izeye.playground.support.unit.domain.DigitalStorageUnit;
import com.izeye.playground.support.unit.domain.FuelConsumptionUnit;
import com.izeye.playground.support.unit.domain.LengthUnit;
import com.izeye.playground.support.unit.domain.MassUnit;
import com.izeye.playground.support.unit.domain.SpeedUnit;
import com.izeye.playground.support.unit.domain.TemperatureUnit;
import com.izeye.playground.support.unit.domain.UnitType;
import com.izeye.playground.support.unit.domain.VolumeUnit;
import com.izeye.playground.web.menu.domain.SubMenuSection;
import com.izeye.playground.web.menu.service.MenuService;

@Controller
public class PlaygroundController {

	@Resource
	private MenuService menuService;

	@Resource
	private DateService dateService;

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

	@RequestMapping("/playground/utilities/unit_conversion")
	public String utilitiesUnitConversion(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		model.addAttribute("unitTypes", UnitType.values());
		model.addAttribute("temperatureUnits", TemperatureUnit.values());
		model.addAttribute("lengthUnits", LengthUnit.values());
		model.addAttribute("massUnits", MassUnit.values());
		model.addAttribute("speedUnits", SpeedUnit.values());
		model.addAttribute("volumeUnits", VolumeUnit.values());
		model.addAttribute("areaUnits", AreaUnit.values());
		model.addAttribute("fuelConsumptionUnits", FuelConsumptionUnit.values());

		// FIXME: Use mine.
		model.addAttribute("timeUnits", TimeUnit.values());
		model.addAttribute("digitalStorageUnits", DigitalStorageUnit.values());

		return "playground/utilities/unit_conversion";
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

	@RequestMapping("/playground/math/fractals")
	public String mathFractals(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);

		return "playground/math/fractals";
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
