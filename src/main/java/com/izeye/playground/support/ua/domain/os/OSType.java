package com.izeye.playground.support.ua.domain.os;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.izeye.playground.common.EnumObjectSerializer;
import com.izeye.playground.common.util.StringConstants;

@JsonSerialize(using = EnumObjectSerializer.class)
public enum OSType {

	MAC_OS_X("Intel Mac OS X", "Mac OS X"), WINDOWS("Windows", "Windows"), IOS(
			"None", "iOS"), ANDROID("Android", "Android"), NOT_AVAILABLE(
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE);

	private final String keyInUserAgent;
	private final String name;

	private OSType(String keyInUserAgent, String name) {
		this.keyInUserAgent = keyInUserAgent;
		this.name = name;
	}

	public String getKeyInUserAgent() {
		return keyInUserAgent;
	}

	public String getName() {
		return name;
	}

	public static OSType extractFromUserAgent(String userAgent) {
		for (OSType osType : values()) {
			if (userAgent.contains(osType.getKeyInUserAgent())) {
				return osType;
			}
		}
		return OSType.NOT_AVAILABLE;
	}

}
