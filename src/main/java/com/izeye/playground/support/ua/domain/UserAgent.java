package com.izeye.playground.support.ua.domain;

public class UserAgent {

	private String browserName;
	private String browserVersion;

	private String osName;
	private String osVersion;

	private String deviceModelName;
	private String deviceProductName;

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getDeviceModelName() {
		return deviceModelName;
	}

	public void setDeviceModelName(String deviceModelName) {
		this.deviceModelName = deviceModelName;
	}

	public String getDeviceProductName() {
		return deviceProductName;
	}

	public void setDeviceProductName(String deviceProductName) {
		this.deviceProductName = deviceProductName;
	}

	@Override
	public String toString() {
		return "UserAgent [browserName=" + browserName + ", browserVersion="
				+ browserVersion + ", osName=" + osName + ", osVersion="
				+ osVersion + ", deviceModelName=" + deviceModelName
				+ ", deviceProductName=" + deviceProductName + "]";
	}

}
