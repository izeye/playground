package com.izeye.playground.support.ua.domain;

import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.device.DeviceType;
import com.izeye.playground.support.ua.domain.os.OSInfo;

public class UserAgent {

	public static final UserAgent NOT_AVAILABLE = new UserAgent(
			OSInfo.NOT_AVAILABLE, BrowserInfo.NOT_AVAILABLE,
			DeviceType.NOT_AVAILABLE);

	private OSInfo osInfo = OSInfo.NOT_AVAILABLE;
	private BrowserInfo browserInfo = BrowserInfo.NOT_AVAILABLE;
	private DeviceType deviceType = DeviceType.NOT_AVAILABLE;

	public UserAgent() {
	}

	public UserAgent(OSInfo osInfo, BrowserInfo browserInfo,
			DeviceType deviceType) {
		this.osInfo = osInfo;
		this.browserInfo = browserInfo;
		this.deviceType = deviceType;
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
		return "OS: " + osInfo.getDisplayName() + ", browser: "
				+ browserInfo.getDisplayName() + ", device: "
				+ deviceType.getDisplayName();
	}

	@Override
	public String toString() {
		return "UserAgent [osInfo=" + osInfo + ", browserInfo=" + browserInfo
				+ ", deviceType=" + deviceType + "]";
	}

}
