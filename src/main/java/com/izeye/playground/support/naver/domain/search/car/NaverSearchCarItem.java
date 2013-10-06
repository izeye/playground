package com.izeye.playground.support.naver.domain.search.car;

import com.izeye.playground.support.naver.domain.search.AbstractNaverSearchItem;

public class NaverSearchCarItem extends AbstractNaverSearchItem {

	private String publishedDate;
	private String maker;
	private String image;
	private String type;

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "NaverSearchCarItem [publishedDate=" + publishedDate
				+ ", maker=" + maker + ", image=" + image + ", type=" + type
				+ ", toString()=" + super.toString() + "]";
	}

}
