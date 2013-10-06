package com.izeye.playground.support.naver.domain.search.car;

import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.NaverSearchType;

public class NaverSearchCarRequest extends NaverSearchRequest {

	private Integer yearFrom;
	private Integer yearTo;

	public NaverSearchCarRequest(String query) {
		super(NaverSearchType.CAR, query);
	}

	public NaverSearchCarRequest(String query, int display, int start) {
		super(NaverSearchType.CAR, query, display, start);
	}

	public Integer getYearFrom() {
		return yearFrom;
	}

	public void setYearFrom(Integer yearFrom) {
		this.yearFrom = yearFrom;
	}

	public Integer getYearTo() {
		return yearTo;
	}

	public void setYearTo(Integer yearTo) {
		this.yearTo = yearTo;
	}

	@Override
	public String toString() {
		return "NaverSearchCarRequest [yearFrom=" + yearFrom + ", yearTo="
				+ yearTo + ", toString()=" + super.toString() + "]";
	}

}
