package com.izeye.playground.support.lotto.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.lotto.domain.KoreanLottoNumbers;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningNumbers;

@Service("koreanLottoParser")
public class DefaultKoreanLottoParser implements KoreanLottoParser {

	@Resource
	private KoreanLottoValidator validator;

	@Override
	public KoreanLottoNumbers parseNumbers(String numbers) {
		String[] splitNumbers = numbers.split(",");
		validator.validateCount(splitNumbers.length);
		Set<Integer> numberSet = new HashSet<Integer>();
		for (String number : splitNumbers) {
			numberSet.add(validator.validateNumber(Integer.valueOf(number)));
		}
		return new KoreanLottoNumbers(numberSet);
	}

	@Override
	public KoreanLottoWinningNumbers parseWinningNumbers(String winningNumbers) {
		int lastIndex = winningNumbers.lastIndexOf(',');
		KoreanLottoNumbers koreanLottoNumbers = parseNumbers(winningNumbers
				.substring(0, lastIndex));
		int bonusNumber = validator.validateNumber(Integer
				.parseInt(winningNumbers.substring(lastIndex + 1)));
		return new KoreanLottoWinningNumbers(koreanLottoNumbers, bonusNumber);
	}

}
