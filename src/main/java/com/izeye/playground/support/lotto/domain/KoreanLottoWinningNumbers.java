package com.izeye.playground.support.lotto.domain;

public class KoreanLottoWinningNumbers {

	private KoreanLottoNumbers numbers;
	private int bonusNumber;

	public KoreanLottoWinningNumbers(KoreanLottoNumbers numbers, int bonusNumber) {
		this.numbers = numbers;
		this.bonusNumber = bonusNumber;
	}

	public KoreanLottoNumbers getNumbers() {
		return numbers;
	}

	public void setNumbers(KoreanLottoNumbers numbers) {
		this.numbers = numbers;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	@Override
	public String toString() {
		return "KoreanLottoWinningNumbers [numbers=" + numbers
				+ ", bonusNumber=" + bonusNumber + "]";
	}

}
