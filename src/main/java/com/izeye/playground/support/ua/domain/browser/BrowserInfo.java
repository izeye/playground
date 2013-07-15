package com.izeye.playground.support.ua.domain.browser;

public class BrowserInfo {

	private final BrowserType type;
	private final String version;

	public BrowserInfo(BrowserType type, String version) {
		this.type = type;
		this.version = version;
	}

	public BrowserType getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}

	public String getDisplayName() {
		return type.getName() + " " + version + "";
	}

	@Override
	public String toString() {
		return "BrowserInfo [type=" + type + ", version=" + version + "]";
	}

}
