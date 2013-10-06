package com.izeye.playground.support.naver.domain.search.cafe;

import com.izeye.playground.support.naver.domain.search.BaseNaverSearchItem;

public class NaverSearchCafeArticleItem extends BaseNaverSearchItem {

	private String cafeName;
	private String cafeUrl;

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getCafeUrl() {
		return cafeUrl;
	}

	public void setCafeUrl(String cafeUrl) {
		this.cafeUrl = cafeUrl;
	}

	@Override
	public String toString() {
		return "NaverSearchCafeArticleItem [cafeName=" + cafeName
				+ ", cafeUrl=" + cafeUrl + ", toString()=" + super.toString()
				+ "]";
	}

}
