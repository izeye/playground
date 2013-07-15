package com.izeye.playground.support.ua.domain;

import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.device.DeviceType;
import com.izeye.playground.support.ua.domain.os.OSInfo;

public class UserAgent {

	private OSInfo osInfo;
	private BrowserInfo browserInfo;
	private DeviceType deviceType;

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

	@Override
	public String toString() {
		return "UserAgent [osInfo=" + osInfo + ", browserInfo=" + browserInfo
				+ ", deviceType=" + deviceType + "]";
	}

}