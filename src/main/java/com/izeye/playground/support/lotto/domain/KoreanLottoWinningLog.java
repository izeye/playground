package com.izeye.playground.support.lotto.domain;

public class KoreanLottoWinningLog {

	private int id;
	private int sequence;
	private String day;
	private String numbers;

	public KoreanLottoWinningLog(int sequence, String day, String numbers) {
		this.sequence = sequence;
		this.day = day;
		this.numbers = numbers;
	}

	public KoreanLottoWinningLog() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return "KoreanLottoWinningNumbers [id=" + id + ", sequence=" + sequence
				+ ", day=" + day + ", numbers=" + numbers + "]";
	}

}
