package com.izeye.playground.support.naver.domain.search.encyclopedia;

import com.izeye.playground.support.naver.domain.search.AbstractNaverSearchItem;

public class NaverSearchEncyclopediaItem extends AbstractNaverSearchItem {

	// NOTE:
	// Doesn't work!
	// I guess this is due to the referrer policy of the CDN.
	private String thumbnail;

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "NaverSearchEncyclopediaItem [thumbnail=" + thumbnail
				+ ", toString()=" + super.toString() + "]";
	}

}
