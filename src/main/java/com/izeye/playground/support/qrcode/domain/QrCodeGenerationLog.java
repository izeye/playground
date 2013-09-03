package com.izeye.playground.support.qrcode.domain;

import java.util.Date;

public class QrCodeGenerationLog {

	private long id;
	private String text;
	private int size;
	private String ip;
	private Date generatedTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	@Override
	public String toString() {
		return "QrCodeGenerationLog [id=" + id + ", text=" + text + ", size="
				+ size + ", ip=" + ip + ", generatedTime=" + generatedTime
				+ "]";
	}

}
