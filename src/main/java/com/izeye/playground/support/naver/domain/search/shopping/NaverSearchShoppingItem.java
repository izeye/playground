package com.izeye.playground.support.naver.domain.search.shopping;

import com.izeye.playground.support.naver.domain.search.BaseNaverSearchItem;

public class NaverSearchShoppingItem extends BaseNaverSearchItem {

	private String image;
	private int lowPrice;
	private int highPrice;
	private String mallName;
	private long productId;
	private int productType;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}

	public int getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(int highPrice) {
		this.highPrice = highPrice;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "NaverSearchShoppingItem [image=" + image + ", lowPrice="
				+ lowPrice + ", highPrice=" + highPrice + ", mallName="
				+ mallName + ", productId=" + productId + ", productType="
				+ productType + ", toString()=" + super.toString() + "]";
	}

}
