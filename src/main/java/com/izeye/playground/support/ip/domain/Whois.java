package com.izeye.playground.support.ip.domain;

import com.izeye.playground.common.domain.StringConstants;
import com.izeye.playground.support.country.domain.Country;

public class Whois {

	public static final Whois NOT_AVAILABLE = new Whois(
			StringConstants.NOT_AVAILABLE, Country.NOT_AVAILABLE,
			WhoisDetail.NOT_AVAILABLE, WhoisDetail.NOT_AVAILABLE);

	private String ipAddress;
	private Country country;

	private WhoisDetail koreanDetail;
	private WhoisDetail englishDetail;

	public Whois(String ipAddress, Country country, WhoisDetail koreanDetail,
			WhoisDetail englishDetail) {
		this.ipAddress = ipAddress;
		this.country = country;
		this.koreanDetail = koreanDetail;
		this.englishDetail = englishDetail;
	}

	public Whois() {
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((englishDetail == null) ? 0 : englishDetail.hashCode());
		result = prime * result
				+ ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result
				+ ((koreanDetail == null) ? 0 : koreanDetail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Whois other = (Whois) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (englishDetail == null) {
			if (other.englishDetail != null)
				return false;
		} else if (!englishDetail.equals(other.englishDetail))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (koreanDetail == null) {
			if (other.koreanDetail != null)
				return false;
		} else if (!koreanDetail.equals(other.koreanDetail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Whois [ipAddress=" + ipAddress + ", country=" + country
				+ ", koreanDetail=" + koreanDetail + ", englishDetail="
				+ englishDetail + "]";
	}

}
