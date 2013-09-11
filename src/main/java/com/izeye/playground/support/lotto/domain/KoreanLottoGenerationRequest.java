package com.izeye.playground.support.lotto.domain;

public class KoreanLottoGenerationRequest {

	private final String ip;

	public KoreanLottoGenerationRequest(String ip) {
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
