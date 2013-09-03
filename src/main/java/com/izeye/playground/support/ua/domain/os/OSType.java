package com.izeye.playground.support.ua.domain.os;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.izeye.playground.common.EnumObjectSerializer;
import com.izeye.playground.common.domain.StringConstants;

@JsonSerialize(using = EnumObjectSerializer.class)
public enum OsType {

	MAC_OS_X("Intel Mac OS X", "Mac OS X"), WINDOWS("Windows", "Windows"), IOS(
			"None", "iOS"), ANDROID("Android", "Android"), NOT_AVAILABLE(
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE);

	private final String keyInUserAgent;
	private final String name;

	private OsType(String keyInUserAgent, String name) {
		this.keyInUserAgent = keyInUserAgent;
		this.name = name;
	}

	public String getKeyInUserAgent() {
		return keyInUserAgent;
	}

	public String getName() {
		return name;
	}

	public static OsType extractFromUserAgent(String userAgent) {
		for (OsType osType : values()) {
			if (userAgent.contains(osType.getKeyInUserAgent())) {
				return osType;
			}
		}
		return OsType.NOT_AVAILABLE;
	}

}
