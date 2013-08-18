package com.izeye.playground.support.lang.ko.unicode.service;

import static com.izeye.playground.support.lang.ko.unicode.domain.KoreanUnicodeConstants.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.lang.ko.unicode.domain.Unicode;

@Service("koreanUnicodeService")
public class DefaultKoreanUnicodeService implements KoreanUnicodeService {

	@Override
	public List<Unicode> getAllUnicodes() {
		List<Unicode> unicodes = new ArrayList<Unicode>();
		for (char c = UNICODE_KOREAN_SYLABLE_START; c <= UNICODE_KOREAN_SYLABLE_END; c++) {
			unicodes.add(new Unicode(c, (int) c));
		}
		return unicodes;
	}

}
