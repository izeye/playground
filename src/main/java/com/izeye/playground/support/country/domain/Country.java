package com.izeye.playground.support.country.domain;

import com.izeye.playground.common.util.StringConstants;

public class Country {

	public static final Country NOT_AVAILABLE = new Country(
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE,
			StringConstants.NOT_AVAILABLE);

	private final String iso;
	private final String code;
	private final String name;

	public Country(String iso, String code, String name) {
		this.iso = iso;
		this.code = code;
		this.name = name;
	}

	public String getIso() {
		return iso;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Country [iso=" + iso + ", code=" + code + ", name=" + name
				+ "]";
	}

}
