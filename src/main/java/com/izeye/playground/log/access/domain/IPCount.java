package com.izeye.playground.log.access.domain;

public class IPCount {

	private String ip;
	private int count;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "IPCount [ip=" + ip + ", count=" + count + "]";
	}

}
