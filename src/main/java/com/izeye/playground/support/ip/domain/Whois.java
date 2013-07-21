package com.izeye.playground.support.ip.domain;

import com.izeye.playground.support.country.domain.Country;

public class Whois {

	private String ipAddress;
	private Country country;

	private WhoisDetail koreanDetail;
	private WhoisDetail englishDetail;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public WhoisDetail getKoreanDetail() {
		return koreanDetail;
	}

	public void setKoreanDetail(WhoisDetail koreanDetail) {
		this.koreanDetail = koreanDetail;
	}

	public WhoisDetail getEnglishDetail() {
		return englishDetail;
	}

	public void setEnglishDetail(WhoisDetail englishDetail) {
		this.englishDetail = englishDetail;
	}

	@Override
	public String toString() {
		return "Whois [ipAddress=" + ipAddress + ", country=" + country
				+ ", koreanDetail=" + koreanDetail + ", englishDetail="
				+ englishDetail + "]";
	}

}
