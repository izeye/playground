package com.izeye.playground.support.country.domain;

import com.izeye.playground.common.domain.StringConstants;

public class Country {

	public static final Country NOT_AVAILABLE = new Country(
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE,
			StringConstants.NOT_AVAILABLE);

	private String iso;
	private String code;
	private String name;

	public Country(String iso, String code, String name) {
		this.iso = iso;
		this.code = code;
		this.name = name;
	}

	public Country() {
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((iso == null) ? 0 : iso.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Country other = (Country) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (iso == null) {
			if (other.iso != null)
				return false;
		} else if (!iso.equals(other.iso))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [iso=" + iso + ", code=" + code + ", name=" + name
				+ "]";
	}

}
