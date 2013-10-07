package com.izeye.playground.support.naver.domain.search.image;

import com.izeye.playground.support.naver.domain.search.BaseNaverSearchItem;

public class NaverSearchImageItem extends BaseNaverSearchItem {

	private String thumbnail;
	private int sizeHeight;
	private int sizeWidth;

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getSizeHeight() {
		return sizeHeight;
	}

	public void setSizeHeight(int sizeHeight) {
		this.sizeHeight = sizeHeight;
	}

	public int getSizeWidth() {
		return sizeWidth;
	}

	public void setSizeWidth(int sizeWidth) {
		this.sizeWidth = sizeWidth;
	}

	@Override
	public String toString() {
		return "NaverSearchImageItem [thumbnail=" + thumbnail + ", sizeHeight="
				+ sizeHeight + ", sizeWidth=" + sizeWidth + ", toString()="
				+ super.toString() + "]";
	}

}
