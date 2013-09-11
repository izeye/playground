package com.izeye.playground.support.lotto.service;

import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.NUMBER_MAX;
import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.NUMBER_MIN;
import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.SELECTION_COUNT;

import org.springframework.stereotype.Component;

@Component("koreanLottoValidator")
public class DefaultKoreanLottoValidator implements KoreanLottoValidator {

	@Override
	public int validateCount(int count) {
		if (count != SELECTION_COUNT) {
			throw new IllegalArgumentException("The number of numbers must be "
					+ SELECTION_COUNT + ", but was " + count + ".");
		}
		return count;
	}

	@Override
	public int validateNumber(int number) {
		if (number < NUMBER_MIN || number > NUMBER_MAX) {
			throw new IllegalArgumentException("Numbers must be between "
					+ NUMBER_MIN + " and " + NUMBER_MAX + ", but was " + number
					+ ".");
		}
		return number;
	}

}
