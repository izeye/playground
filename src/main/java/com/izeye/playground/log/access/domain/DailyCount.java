package com.izeye.playground.log.access.domain;

public class DailyCount {

	private String day;
	private int pageviews;
	private int uniqueVisitors;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getPageviews() {
		return pageviews;
	}

	public void setPageviews(int pageviews) {
		this.pageviews = pageviews;
	}

	public int getUniqueVistors() {
		return uniqueVisitors;
	}

	public void setUniqueVisitors(int uniqueVisitors) {
		this.uniqueVisitors = uniqueVisitors;
	}

	@Override
	public String toString() {
		return "DailyCount [day=" + day + ", pageviews=" + pageviews
				+ ", uniqueVisitors=" + uniqueVisitors + "]";
	}

}
