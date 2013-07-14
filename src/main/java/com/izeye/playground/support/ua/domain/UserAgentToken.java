package com.izeye.playground.support.ua.domain;

public class UserAgentToken {

	private final UserAgentTokenType type;
	private final String token;

	public UserAgentToken(UserAgentTokenType type, String token) {
		this.type = type;
		this.token = token;
	}

	public UserAgentTokenType getType() {
		return type;
	}

	public String getToken() {
		return token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserAgentToken [type=" + type + ", token=" + token + "]";
	}

}
