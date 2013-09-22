package com.izeye.playground.support.naver.domain.search.rank;

public class NaverSearchRankItem {

	private final int rank;
	private final String keyword;
	private final NaverSearchRankStatus status;
	private final int variance;

	public NaverSearchRankItem(int rank, String keyword,
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
		return "NaverSearchRankItem [rank=" + rank + ", keyword=" + keyword
				+ ", status=" + status + ", variance=" + variance + "]";
	}

}
