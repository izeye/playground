package com.izeye.playground.support.naver.domain.search.image;

import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.NaverSearchType;

public class NaverSearchImageRequest extends NaverSearchRequest {

	private String filter;

	public NaverSearchImageRequest(String query) {
		super(NaverSearchType.IMAGE, query);
	}

	public NaverSearchImageRequest(String query, int display, int start) {
		super(NaverSearchType.IMAGE, query, display, start);
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	@Override
	public String toString() {
		return "NaverSearchImageRequest [filter=" + filter + ", toString()="
				+ super.toString() + "]";
	}

}
