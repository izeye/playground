package com.izeye.playground.support.naver.domain.search;

import java.util.Date;
import java.util.List;

public abstract class AbstractNaverSearchResponse<T extends NaverSearchItem>
		implements NaverSearchResponse<T> {

	private Date lastBuildDate;
	private int total;

	// NOTE:
	// Redundant with request.
	private int start;
	private int display;

	private List<T> items;

	@Override
	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	@Override
	public void setLastBuildDate(Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	@Override
	public int getTotal() {
		return total;
	}

	@Override
	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public int getStart() {
		return start;
	}

	@Override
	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public int getDisplay() {
		return display;
	}

	@Override
	public void setDisplay(int display) {
		this.display = display;
	}

	@Override
	public List<T> getItems() {
		return items;
	}

	@Override
	public void setItems(List<T> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "AbstractNaverSearchResponse [lastBuildDate=" + lastBuildDate
				+ ", total=" + total + ", start=" + start + ", display="
				+ display + ", items=" + items + "]";
	}

}
