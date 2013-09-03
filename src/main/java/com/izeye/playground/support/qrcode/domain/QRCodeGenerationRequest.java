package com.izeye.playground.support.qrcode.domain;

public class QrCodeGenerationRequest {

	private final String text;
	private final int size;
	private final String ip;

	public QrCodeGenerationRequest(String text, int size, String ip) {
		this.text = text;
		this.size = size;
		this.ip = ip;
	}

	public String getText() {
		return text;
	}

	public int getSize() {
		return size;
	}

	public String getIp() {
		return ip;
	}

	@Override
	public String toString() {
		return "QRCodeGenerationRequest [text=" + text + ", size=" + size
				+ ", ip=" + ip + "]";
	}

}
