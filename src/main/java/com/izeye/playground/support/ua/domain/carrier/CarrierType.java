package com.izeye.playground.support.ua.domain.carrier;

import com.izeye.playground.common.domain.StringConstants;

// FIXME:
// Carrier type can be provided by some apps or some device model names.
// So now both BrowserInfo and DeviceType have carrier type.
// Neither BrowserInfo or DeviceType is not suitable for it.
// It is necessary to move it to more common place like UserAgent.
public enum CarrierType {

	// NOTE:
	// The order between SKT and KT is crucial
	// because of the weakness of implementation of extractFromUserAgent().
	SKT("SKTelecom", "SKT"), KT("KT", "KT"), LG_U_PLUS(
			StringConstants.NOT_AVAILABLE, "LG U+"), DOCOMO(
			StringConstants.NOT_AVAILABLE, "Docomo"), NOT_AVAILABLE(
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE);

	private final String key;
	private final String name;

	private CarrierType(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public static CarrierType extractFromUserAgent(String userAgent) {
		for (CarrierType carrierType : values()) {
			if (userAgent.contains(carrierType.getKey())) {
				return carrierType;
			}
		}
		return CarrierType.NOT_AVAILABLE;
	}

}
