package com.izeye.playground.support.ua.domain;

public class UserAgentToken {

	private final UserAgentTokenType type;
	private final String value;

	public UserAgentToken(UserAgentTokenType type, String value) {
		this.type = type;
		this.value = value;
	}

	public UserAgentTokenType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		UserAgentToken other = (UserAgentToken) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserAgentToken [type=" + type + ", value=" + value + "]";
	}

}
