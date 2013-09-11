package com.izeye.playground.support.lotto.domain;

import java.util.Set;

public class KoreanLottoNumbers {

	private Set<Integer> numbers;

	public KoreanLottoNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	@Override
	public String toString() {
		return "KoreanLottoNumbers [numbers=" + numbers + "]";
	}

}
