package com.izeye.playground.support.ua.domain.browser;

import com.izeye.playground.common.util.StringConstants;
import com.izeye.playground.support.ua.domain.carrier.CarrierType;

public class BrowserInfo {

	public static final BrowserInfo NOT_AVAILABLE = new BrowserInfo(
			BrowserType.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE);

	private final BrowserType type;
	private final String version;
	private final CarrierType carrierType;

	public BrowserInfo(BrowserType type, String version, CarrierType carrierType) {
		this.type = type;
		this.version = version;
		this.carrierType = carrierType;
	}

	public BrowserInfo(BrowserType type, String version) {
		this(type, version, CarrierType.NOT_AVAILABLE);
	}

	public BrowserType getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}

	public CarrierType getCarrierType() {
		return carrierType;
	}

	public String getDisplayName() {
		StringBuilder sb = new StringBuilder();
		sb.append(type.getName());
		sb.append(' ');
		sb.append(version);
		if (carrierType != CarrierType.NOT_AVAILABLE) {
			sb.append(" (");
			sb.append(carrierType.getName());
			sb.append(')');
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "BrowserInfo [type=" + type + ", version=" + version
				+ ", carrierType=" + carrierType + "]";
	}

}
