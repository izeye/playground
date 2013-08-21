package com.izeye.playground.support.ua.domain;

import com.izeye.playground.common.util.StringConstants;

public class UserAgentTypeInfo {

	public static final UserAgentTypeInfo NOT_AVAILABLE = new UserAgentTypeInfo(
			UserAgentType.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE);
	public static final UserAgentTypeInfo SUSPICIOUS = new UserAgentTypeInfo(
			UserAgentType.SUSPICIOUS, StringConstants.NOT_AVAILABLE);
	public static final UserAgentTypeInfo SPAM_BOT = new UserAgentTypeInfo(
			UserAgentType.SPAM_BOT, StringConstants.NOT_AVAILABLE);

	private final UserAgentType type;
	private final String name;
	private final String version;

	public UserAgentTypeInfo(UserAgentType type, String name,
			String version) {
		this.type = type;
		this.name = name;
		this.version = version;
	}

	public UserAgentTypeInfo(UserAgentType type, String version) {
		this(type, type.getName(), version);
	}

	public UserAgentType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public String getDisplayName() {
		return getName() + " " + version;
	}

	@Override
	public String toString() {
		return "UserAgentTypeAndNameAndVersion [type=" + type + ", name="
				+ name + ", version=" + version + "]";
	}

}
