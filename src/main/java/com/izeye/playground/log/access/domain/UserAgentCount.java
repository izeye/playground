package com.izeye.playground.log.access.domain;

public class UserAgentCount {

	private String userAgent;
	private int count;

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "UserAgentCount [userAgent=" + userAgent + ", count=" + count
				+ "]";
	}

}
