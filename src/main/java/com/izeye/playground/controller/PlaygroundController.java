package com.izeye.playground.controller;

import static com.izeye.playground.web.menu.domain.MenuConstants.MENU_NAME_PLAYGROUND;

import java.io.IOException;
import java.util.List;

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
import com.izeye.playground.support.ip.domain.IPInfo;
import com.izeye.playground.support.ip.service.IPAnalyzer;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationRequest;
import com.izeye.playground.support.qrcode.service.QRCodeService;
import com.izeye.playground.support.ua.domain.UserAgent;
import com.izeye.playground.support.ua.service.UserAgentAnalyzer;
import com.izeye.playground.web.menu.domain.SubMenuSection;
import com.izeye.playground.web.menu.service.MenuService;

@Controller
public class PlaygroundController {

	@Resource
	private MenuService menuService;

	@Resource
	private QRCodeService qrCodeService;

	@Resource
	private IPAnalyzer ipAnalyzer;

	@Resource
	private UserAgentAnalyzer userAgentAnalyzer;

	@RequestMapping("/playground")
	public String home(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PLAYGROUND);
		model.addAttribute("subMenuSections", subMenuSections);
		return "playground/playground";
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

}
