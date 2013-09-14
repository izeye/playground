package com.izeye.playground.support.lotto.domain;

import java.util.Date;

import com.izeye.playground.common.domain.StringConstants;
import com.izeye.playground.common.util.DateUtils;
import com.izeye.playground.common.util.NumberUtils;

public class KoreanLottoGenerationLog {

	private long id;
	private String numbers;
	private String ip;
	private Date generatedTime;

	private Integer sequence;
	private Integer rank;
	private Long prize;

	public KoreanLottoGenerationLog() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getGeneratedTime() {
		return generatedTime;
	}

	public void setGeneratedTime(Date generatedTime) {
		this.generatedTime = generatedTime;
	}

	public String getFormattedGeneratedTime() {
		return DateUtils.formatDateTime(generatedTime);
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Long getPrize() {
		return prize;
	}

	public void setPrize(Long prize) {
		this.prize = prize;
	}

	public String getFormattedPrize() {
		return prize == null ? StringConstants.NOT_AVAILABLE : "₩"
				+ NumberUtils.format(prize);
	}

	@Override
	public String toString() {
		return "KoreanLottoGenerationLog [id=" + id + ", numbers=" + numbers
				+ ", ip=" + ip + ", generatedTime=" + generatedTime
				+ ", sequence=" + sequence + ", rank=" + rank + ", prize="
				+ prize + "]";
	}

}
