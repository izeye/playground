package com.izeye.playground.support.ip.domain;

import com.izeye.playground.support.country.domain.Country;

public class IpInfo {

	public static final IpInfo NOT_AVAILABLE = new IpInfo(Whois.NOT_AVAILABLE);

	private Whois whois;

	public IpInfo(Whois whois) {
		this.whois = whois;
	}

	public Whois getWhois() {
		return whois;
	}

	public String getLocation() {
		Country country = getCountry();
		if (country == Country.NOT_AVAILABLE
				|| !country.getCode().equalsIgnoreCase(
						KisaWhoisConstants.COUNTRY_CODE_KR)) {
			return country.getName();
		} else {
			return whois.getKoreanDetail().getUserAddr();
		}
	}

	public Country getCountry() {
		return whois.getCountry();
	}

	@Override
	public String toString() {
		return "IPInfo [whois=" + whois + "]";
	}

}
