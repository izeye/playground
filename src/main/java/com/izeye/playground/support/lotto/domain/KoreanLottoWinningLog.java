package com.izeye.playground.support.lotto.domain;

import com.izeye.playground.common.util.NumberUtils;

public class KoreanLottoWinningLog {

	private int id;
	private int sequence;
	private String day;
	private String numbers;
	private long prize1;
	private long prize2;
	private long prize3;
	private long prize4;
	private long prize5;

	public KoreanLottoWinningLog(int sequence, String day, String numbers,
			long prize1, long prize2, long prize3, long prize4, long prize5) {
		this.sequence = sequence;
		this.day = day;
		this.numbers = numbers;
		this.prize1 = prize1;
		this.prize2 = prize2;
		this.prize3 = prize3;
		this.prize4 = prize4;
		this.prize5 = prize5;
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

	public long getPrize1() {
		return prize1;
	}

	public void setPrize1(long prize1) {
		this.prize1 = prize1;
	}

	public String getFormattedPrize1() {
		return "₩" + NumberUtils.format(prize1);
	}

	public long getPrize2() {
		return prize2;
	}

	public void setPrize2(long prize2) {
		this.prize2 = prize2;
	}

	public String getFormattedPrize2() {
		return "₩" + NumberUtils.format(prize2);
	}

	public long getPrize3() {
		return prize3;
	}

	public void setPrize3(long prize3) {
		this.prize3 = prize3;
	}

	public String getFormattedPrize3() {
		return "₩" + NumberUtils.format(prize3);
	}

	public long getPrize4() {
		return prize4;
	}

	public void setPrize4(long prize4) {
		this.prize4 = prize4;
	}

	public String getFormattedPrize4() {
		return "₩" + NumberUtils.format(prize4);
	}

	public long getPrize5() {
		return prize5;
	}

	public void setPrize5(long prize5) {
		this.prize5 = prize5;
	}

	public String getFormattedPrize5() {
		return "₩" + NumberUtils.format(prize5);
	}

	public long getPrize(int rank) {
		switch (rank) {
		case 1:
			return prize1;

		case 2:
			return prize2;

		case 3:
			return prize3;

		case 4:
			return prize4;

		case 5:
			return prize5;

		default:
			return 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((numbers == null) ? 0 : numbers.hashCode());
		result = prime * result + (int) (prize1 ^ (prize1 >>> 32));
		result = prime * result + (int) (prize2 ^ (prize2 >>> 32));
		result = prime * result + (int) (prize3 ^ (prize3 >>> 32));
		result = prime * result + (int) (prize4 ^ (prize4 >>> 32));
		result = prime * result + (int) (prize5 ^ (prize5 >>> 32));
		result = prime * result + sequence;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KoreanLottoWinningLog other = (KoreanLottoWinningLog) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (numbers == null) {
			if (other.numbers != null)
				return false;
		} else if (!numbers.equals(other.numbers))
			return false;
		if (prize1 != other.prize1)
			return false;
		if (prize2 != other.prize2)
			return false;
		if (prize3 != other.prize3)
			return false;
		if (prize4 != other.prize4)
			return false;
		if (prize5 != other.prize5)
			return false;
		if (sequence != other.sequence)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KoreanLottoWinningLog [id=" + id + ", sequence=" + sequence
				+ ", day=" + day + ", numbers=" + numbers + ", prize1="
				+ prize1 + ", prize2=" + prize2 + ", prize3=" + prize3
				+ ", prize4=" + prize4 + ", prize5=" + prize5 + "]";
	}

}
