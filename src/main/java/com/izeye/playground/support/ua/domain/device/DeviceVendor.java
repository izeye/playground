package com.izeye.playground.support.ua.domain.device;

import com.izeye.playground.common.util.StringConstants;

public enum DeviceVendor {

	APPLE("Apple"), SAMSUNG("Samsung"), PANTECH("Pantech"), LG("LG"), HTC("HTC"), NOT_AVAILABLE(
			StringConstants.NOT_AVAILABLE);

	private final String name;

	private DeviceVendor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
