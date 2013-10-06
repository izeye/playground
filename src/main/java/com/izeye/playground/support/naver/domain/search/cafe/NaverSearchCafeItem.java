package com.izeye.playground.support.naver.domain.search.cafe;

import com.izeye.playground.support.naver.domain.search.BaseNaverSearchItem;

public class NaverSearchCafeItem extends BaseNaverSearchItem {

	private String ranking;
	private int member;
	private int totalArticles;
	private int newArticles;

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public int getTotalArticles() {
		return totalArticles;
	}

	public void setTotalArticles(int totalArticles) {
		this.totalArticles = totalArticles;
	}

	public int getNewArticles() {
		return newArticles;
	}

	public void setNewArticles(int newArticles) {
		this.newArticles = newArticles;
	}

	@Override
	public String toString() {
		return "NaverSearchCafeItem [ranking=" + ranking + ", member=" + member
				+ ", totalArticles=" + totalArticles + ", newArticles="
				+ newArticles + "]";
	}

}
