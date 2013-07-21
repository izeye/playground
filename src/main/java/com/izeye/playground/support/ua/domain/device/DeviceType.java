package com.izeye.playground.support.ua.domain.device;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.izeye.playground.common.EnumObjectSerializer;
import com.izeye.playground.common.util.StringConstants;

@JsonSerialize(using = EnumObjectSerializer.class)
public enum DeviceType {

	MACINTOSH("Macintosh", "Macintosh", false), IPHONE("iPhone", "iPhone", true), IPAD(
			"iPad", "iPad", false), PC("PC", "PC", false), GALAXY_NOTE_DOCOMO(
			"SC-05D", "Samsung Galaxy Note (Docomo)", true), GALAXY_NOTE_II_KT(
			"SHV-E250K", "Samsung Galaxy Note II (KT)", true), NOT_AVAILABLE(
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE, false);

	private final String modelName;
	private final String productName;
	private final boolean callable;

	private final String displayName;

	private DeviceType(String modelName, String productName, boolean callable) {
		this.modelName = modelName;
		this.productName = productName;
		this.callable = callable;

		this.displayName = productName + " (" + modelName + "), "
				+ (callable ? "callable" : "non-callable");
	}

	public String getModelName() {
		return modelName;
	}

	public String getProductName() {
		return productName;
	}

	public boolean isCallable() {
		return callable;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static DeviceType extractFromUserAgent(String userAgent) {
		for (DeviceType deviceType : values()) {
			if (userAgent.contains(deviceType.getModelName())) {
				return deviceType;
			}
		}
		return DeviceType.NOT_AVAILABLE;
	}

	@Override
	public String toString() {
		return "DeviceType [modelName=" + modelName + ", productName="
				+ productName + "]";
	}

}
