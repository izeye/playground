package com.izeye.playground.analytics.audience.domain;

public class VisitStat {

	private int pageviews;
	private int uniqueVisitors;

	public VisitStat(int pageviews, int uniqueVisitors) {
		this.pageviews = pageviews;
		this.uniqueVisitors = uniqueVisitors;
	}

	public int getPageviews() {
		return pageviews;
	}

	public void setPageviews(int pageviews) {
		this.pageviews = pageviews;
	}

	public int getUniqueVisitors() {
		return uniqueVisitors;
	}

	public void setUniqueVisitors(int uniqueVisitors) {
		this.uniqueVisitors = uniqueVisitors;
	}

	@Override
	public String toString() {
		return "VisitStat [pageviews=" + pageviews + ", uniqueVisitors="
				+ uniqueVisitors + "]";
	}

}
