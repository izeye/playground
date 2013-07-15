package com.izeye.playground.support.ua.domain.device;

import org.codehaus.jackson.annotate.JsonValue;

public enum DeviceType {

	MACINTOSH("Macintosh", "Macintosh"), IPHONE("iPhone", "iPhone"), IPAD(
			"iPad", "iPad"), PC("PC", "PC"), GALAXY_NOTE("SC-05D",
			"Samsung Galaxy Note"), GALAXY_NOTE_II("SHV-E250K",
			"Samsung Galaxy Note II"), UNKNOWN("Unknown", "Unknown");

	private final String modelName;
	private final String productName;

	private DeviceType(String modelName, String productName) {
		this.modelName = modelName;
		this.productName = productName;
	}

	public String getModelName() {
		return modelName;
	}

	public String getProductName() {
		return productName;
	}

	@JsonValue
	public String getDisplayName() {
		return productName + " (" + modelName + ")";
	}

	public static DeviceType extractFromUserAgent(String userAgent) {
		for (DeviceType deviceType : values()) {
			if (userAgent.contains(deviceType.getModelName())) {
				return deviceType;
			}
		}
		return DeviceType.UNKNOWN;
	}

	@Override
	public String toString() {
		return "DeviceType [modelName=" + modelName + ", productName="
				+ productName + "]";
	}

}
