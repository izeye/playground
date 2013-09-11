package com.izeye.playground.support.lotto.domain;

import java.util.List;

import com.izeye.playground.common.util.StringUtils;

public class KoreanLottoGenerationResponse {

	private final List<Integer> numbers;

	public KoreanLottoGenerationResponse(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public String getNumbersAsString() {
		return StringUtils.join(numbers, ",");
	}

	@Override
	public String toString() {
		return "KoreanLottoResponse [numbers=" + numbers + "]";
	}

}
