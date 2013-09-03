package com.izeye.playground.support.lotto.domain;

public class KoreanLottoRequest {

	private final String ip;

	public KoreanLottoRequest(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	@Override
	public String toString() {
		return "KoreanLottoRequest [ip=" + ip + "]";
	}

}
