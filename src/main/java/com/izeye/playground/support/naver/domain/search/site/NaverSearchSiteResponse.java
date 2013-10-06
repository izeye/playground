package com.izeye.playground.support.naver.domain.search.site;

public class NaverSearchSiteResponse {

	private final String label;
	private final String url;

	public NaverSearchSiteResponse(String label, String url) {
		this.label = label;
		this.url = url;
	}

	public String getLabel() {
		return label;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "NaverSearchSiteResponse [label=" + label + ", url=" + url + "]";
	}

}
