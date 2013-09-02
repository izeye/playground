package com.izeye.playground.tools.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_TEXT_2_QR_CODE;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_TEXT_COUNTER;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_UNIT_CONVERTER;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_TEXT_2_QR_CODE_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_TEXT_COUNTER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_UNIT_CONVERTER_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_WORLD_CLOCK_PATH;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.WriterException;
import com.izeye.playground.support.menu.domain.SubMenuItem;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationRequest;
import com.izeye.playground.support.qrcode.service.QRCodeService;
import com.izeye.playground.support.text.domain.TextCount;
import com.izeye.playground.support.text.service.TextService;
import com.izeye.playground.support.unit.domain.UnitType;

@Controller
public class ToolsLifeController extends AbstractToolsController {

	@Resource
	private TextService textService;

	@Resource
	private QRCodeService qrCodeService;

	@RequestMapping(SUB_MENU_ITEM_UNIT_CONVERTER_PATH)
	public String unitConverter(Model model) {
		model.addAttribute("unitTypes", UnitType.values());

		model.addAttribute("API_PATH_UNIT_CONVERTER", API_PATH_UNIT_CONVERTER);

		return SubMenuItem.TOOLS_LIFE_UNIT_CONVERTER.getViewName();
	}

	@RequestMapping(API_PATH_UNIT_CONVERTER)
	@ResponseBody
	public BigDecimal unitConverterApi(@RequestParam UnitType unitType,
			@RequestParam String sourceUnit, @RequestParam String targetUnit,
			@RequestParam BigDecimal valueToConvert) {
		return unitType.convert(sourceUnit, valueToConvert, targetUnit);
	}

	@RequestMapping(SUB_MENU_ITEM_TEXT_COUNTER_PATH)
	public String textCounter(Model model) {
		model.addAttribute("API_PATH_TEXT_COUNTER", API_PATH_TEXT_COUNTER);

		return SubMenuItem.TOOLS_LIFE_TEXT_COUNTER.getViewName();
	}

	@RequestMapping(API_PATH_TEXT_COUNTER)
	@ResponseBody
	public TextCount textCounterApi(@RequestParam String text) {
		return textService.countAll(text);
	}

	@RequestMapping(SUB_MENU_ITEM_TEXT_2_QR_CODE_PATH)
	public String utilitiesText2QRCode(Model model) {
		model.addAttribute("API_PATH_TEXT_2_QR_CODE", API_PATH_TEXT_2_QR_CODE);

		return SubMenuItem.TOOLS_LIFE_TEXT_2_QR_CODE.getViewName();
	}

	@RequestMapping(API_PATH_TEXT_2_QR_CODE)
	public ResponseEntity<byte[]> utilitiesText2QRCodeAPI(
			@ModelAttribute("ipAddress") String ipAddress,
			@RequestParam String text, @RequestParam int size)
			throws WriterException, IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);

		QRCodeGenerationRequest request = new QRCodeGenerationRequest(text,
				size, ipAddress);
		byte[] qrcode = qrCodeService.text2QRCode(request);
		return new ResponseEntity<byte[]>(qrcode, headers, HttpStatus.CREATED);
	}

	@RequestMapping(SUB_MENU_ITEM_WORLD_CLOCK_PATH)
	public String worldClock(Model model) {
		model.addAttribute("now", new Date());
		model.addAttribute("timeZoneIds", TimeZone.getAvailableIDs());

		return SubMenuItem.TOOLS_LIFE_WORLD_CLOCK.getViewName();
	}

}
