package com.izeye.playground.support.naver.domain.search.web;

import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.NaverSearchType;

public class NaverSearchWebRequest extends NaverSearchRequest {

	private String domain;

	public NaverSearchWebRequest(String query) {
		super(NaverSearchType.WEB, query);
	}

	public NaverSearchWebRequest(String query, int display, int start) {
		super(NaverSearchType.WEB, query, display, start);
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "NaverSearchWebRequest [domain=" + domain + ", toString()="
				+ super.toString() + "]";
	}

}
