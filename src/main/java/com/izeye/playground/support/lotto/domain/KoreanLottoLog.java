package com.izeye.playground.support.lotto.domain;

import java.util.Date;

import com.izeye.playground.common.util.DateUtils;

public class KoreanLottoLog {

	private long id;
	private String numbers;
	private String ip;
	private Date generatedTime;

	public KoreanLottoLog() {
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

	@Override
	public String toString() {
		return "KoreanLottoLog [id=" + id + ", numbers=" + numbers + ", ip="
				+ ip + ", generatedTime=" + generatedTime + "]";
	}

}
