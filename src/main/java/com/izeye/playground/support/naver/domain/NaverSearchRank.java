package com.izeye.playground.support.naver.domain;

public class NaverSearchRank {

	private final int rank;
	private final String keyword;
	private final NaverSearchRankStatus status;
	private final int variance;

	public NaverSearchRank(int rank, String keyword,
			NaverSearchRankStatus status, int variance) {
		this.rank = rank;
		this.keyword = keyword;
		this.status = status;
		this.variance = variance;
	}

	public int getRank() {
		return rank;
	}

	public String getKeyword() {
		return keyword;
	}

	public NaverSearchRankStatus getStatus() {
		return status;
	}

	public int getVariance() {
		return variance;
	}

	public String getFormattedStatus() {
		return status.getFormattedValue(variance);
	}

	@Override
	public String toString() {
		return "NaverSearchRank [rank=" + rank + ", keyword=" + keyword
				+ ", status=" + status + ", variance=" + variance + "]";
	}

}
