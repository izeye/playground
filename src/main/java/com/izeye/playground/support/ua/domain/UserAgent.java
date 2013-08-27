package com.izeye.playground.support.ua.domain;

import com.izeye.playground.support.ua.domain.browser.BrowserCategory;
import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.device.DeviceType;
import com.izeye.playground.support.ua.domain.os.OSInfo;

public class UserAgent {

	public static final UserAgent NOT_AVAILABLE = new UserAgent(
			UserAgentTypeInfo.NOT_AVAILABLE);

	public static final UserAgent SUSPICIOUS = new UserAgent(
			UserAgentTypeInfo.SUSPICIOUS);

	public static final UserAgent SPAM_BOT = new UserAgent(
			UserAgentTypeInfo.SPAM_BOT);

	private final UserAgentTypeInfo typeInfo;

	private OSInfo osInfo;
	private BrowserInfo browserInfo;
	private DeviceType deviceType;

	public UserAgent(UserAgentTypeInfo typeInfo, OSInfo osInfo,
			BrowserInfo browserInfo, DeviceType deviceType) {
		this.typeInfo = typeInfo;
		this.osInfo = osInfo;
		this.browserInfo = browserInfo;
		this.deviceType = deviceType;
	}

	public UserAgent(UserAgentTypeInfo typeInfo) {
		this(typeInfo, OSInfo.NOT_AVAILABLE, BrowserInfo.NOT_AVAILABLE,
				DeviceType.NOT_AVAILABLE);
	}

	public UserAgentTypeInfo getTypeInfo() {
		return typeInfo;
	}

	public OSInfo getOsInfo() {
		return osInfo;
	}

	public void setOsInfo(OSInfo osInfo) {
		this.osInfo = osInfo;
	}

	public BrowserInfo getBrowserInfo() {
		return browserInfo;
	}

	public void setBrowserInfo(BrowserInfo browserInfo) {
		this.browserInfo = browserInfo;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public String getDisplayName() {
		return "Type: " + typeInfo.getDisplayName() + ", OS: "
				+ osInfo.getDisplayName() + ", browser: "
				+ browserInfo.getDisplayName() + ", device: "
				+ deviceType.getDisplayName();
	}

	public boolean isSpam() {
		return typeInfo.getType() == UserAgentType.SPAM_BOT;
	}

	public boolean isBot() {
		return browserInfo.getType().getCategory() == BrowserCategory.BOT;
	}

	@Override
	public String toString() {
		return "UserAgent [typeInfo=" + typeInfo + ", osInfo=" + osInfo
				+ ", browserInfo=" + browserInfo + ", deviceType=" + deviceType
				+ "]";
	}

}
