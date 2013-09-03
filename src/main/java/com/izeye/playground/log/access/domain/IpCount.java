package com.izeye.playground.log.access.domain;

import com.izeye.playground.support.ip.domain.IpInfo;

public class IpCount {

	private String ip;
	private int count;

	private IpInfo analyzedIp;

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

	public IpInfo getAnalyzedIp() {
		return analyzedIp;
	}

	public void setAnalyzedIp(IpInfo analyzedIp) {
		this.analyzedIp = analyzedIp;
	}

	@Override
	public String toString() {
		return "IpCount [ip=" + ip + ", count=" + count + ", analyzedIp="
				+ analyzedIp + "]";
	}

}
