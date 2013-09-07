package com.izeye.playground.support.quota.domain;

public class Quota {

	private final int hardLimit;
	private final int softLimit;
	private final int todayQueryCount;

	public Quota(int hardLimit, int softLimit, int todayQueryCount) {
		this.hardLimit = hardLimit;
		this.softLimit = softLimit;
		this.todayQueryCount = todayQueryCount;
	}

	public int getHardLimit() {
		return hardLimit;
	}

	public int getSoftLimit() {
		return softLimit;
	}

	public int getTodayQueryCount() {
		return todayQueryCount;
	}

	@Override
	public String toString() {
		return "Quota [hardLimit=" + hardLimit + ", softLimit=" + softLimit
				+ ", todayQueryCount=" + todayQueryCount + "]";
	}

}
