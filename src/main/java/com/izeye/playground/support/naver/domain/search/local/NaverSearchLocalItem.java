package com.izeye.playground.support.naver.domain.search.local;

import com.izeye.playground.support.naver.domain.search.BaseNaverSearchItem;

public class NaverSearchLocalItem extends BaseNaverSearchItem {

	private String telephone;
	private String address;
	private int mapX;
	private int mapY;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMapX() {
		return mapX;
	}

	public void setMapX(int mapX) {
		this.mapX = mapX;
	}

	public int getMapY() {
		return mapY;
	}

	public void setMapY(int mapY) {
		this.mapY = mapY;
	}

	@Override
	public String toString() {
		return "NaverSearchLocalItem [telephone=" + telephone + ", address="
				+ address + ", mapX=" + mapX + ", mapY=" + mapY
				+ ", toString()=" + super.toString() + "]";
	}

}
