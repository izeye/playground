package com.izeye.playground.support.lotto.domain;

import java.util.List;

import com.izeye.playground.common.util.ListUtils;

public class KoreanLottoResponse {

	private final List<Integer> numbers;

	public KoreanLottoResponse(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public String getNumbersAsString() {
		return ListUtils.list2CommaSeparatedStrings(numbers);
	}

	@Override
	public String toString() {
		return "KoreanLottoResponse [numbers=" + numbers + "]";
	}

}
