package com.izeye.playground.support.ua.domain.device;

import static com.izeye.playground.support.ua.domain.device.DeviceVendor.APPLE;
import static com.izeye.playground.support.ua.domain.device.DeviceVendor.*;
import static com.izeye.playground.support.ua.domain.carrier.CarrierType.*;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.izeye.playground.common.EnumObjectSerializer;
import com.izeye.playground.common.domain.StringConstants;
import com.izeye.playground.support.ua.domain.carrier.CarrierType;

@JsonSerialize(using = EnumObjectSerializer.class)
public enum DeviceType {

	MACINTOSH("Macintosh", "Macintosh", APPLE, CarrierType.NOT_AVAILABLE, false), //
	IPHONE("iPhone", "iPhone", APPLE, CarrierType.NOT_AVAILABLE, true), //
	IPAD("iPad", "iPad", APPLE, CarrierType.NOT_AVAILABLE, false), //
	PC("PC", "PC", DeviceVendor.NOT_AVAILABLE, CarrierType.NOT_AVAILABLE, false), //
	GALAXY_ACE("SHW-M240S", "Galaxy Ace", SAMSUNG, SKT, true), //
	GALAXY_S_II_SKT("SHW-M250S", "Galaxy S II", SAMSUNG, SKT, true), //
	GALAXY_S_II_KT("SHW-M250K", "Galaxy S II", SAMSUNG, KT, true), //
	GALAXY_S_II_DOCOMO("SC-02C", "Galaxy S II", SAMSUNG, DOCOMO, true), //
	GALAXY_S_II_HD_LG_U_PLUS("SHV-E120L", "Galaxy S II HD", SAMSUNG, LG_U_PLUS,
			true), //
	GALAXY_S_II_LTE_SKT("SHV-E110S", "Galaxy S II LTE", SAMSUNG, SKT, true), //
	GALAXY_S_III_SKT("SHV-E210S", "Galaxy S III", SAMSUNG, SKT, true), //
	GALAXY_S_III_KT("SHV-E210K", "Galaxy S III", SAMSUNG, KT, true), //
	GALAXY_S_III_LG_U_PLUS("SHV-E210L", "Galaxy S III", SAMSUNG, LG_U_PLUS,
			true), //
	GALAXY_NOTE_SKT("SHV-E160S", "Galaxy Note", SAMSUNG, SKT, true), //
	GALAXY_NOTE_DOCOMO("SC-05D", "Galaxy Note", SAMSUNG, DOCOMO, true), //
	GALAXY_NOTE_N7000("GT-N7000", "Galaxy Note N7000", SAMSUNG,
			CarrierType.NOT_AVAILABLE, true), //
	GALAXY_NOTE_II_SKT("SHV-E250S", "Galaxy Note II", SAMSUNG, SKT, true), //
	GALAXY_NOTE_II_KT("SHV-E250K", "Galaxy Note II", SAMSUNG, KT, true), //
	GALAXY_M_STYLE("SHW-M340S", "Galaxy M Style", SAMSUNG, SKT, true), //
	OPTIMUS_G_PRO_KT("LG-F240K", "Optimus G Pro", LG, KT, true), //
	OPTIMUS_G_PRO_LG_U_PLUS("LG-F240L", "Optimus G Pro", LG, KT, true), //
	OPTIMUS_VU("LG-F100L", "Optimus Vu", LG, LG_U_PLUS, true), //
	OPTIMUS_3D("LG-SU760", "Optimus 3D", LG, CarrierType.NOT_AVAILABLE, true), //
	VEGA_RACER_KT("IM-A770K", "Vega Racer", PANTECH, KT, true), //
	VEGA_R3_SKT("IM-A850S", "Vega R3", PANTECH, SKT, true), //
	HTC_DESIRE_A8181("Desire_A8181", "HTC Desire A8181 (Bravo)", //
			HTC, CarrierType.NOT_AVAILABLE, true), //
	NOT_AVAILABLE(StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE,
			DeviceVendor.NOT_AVAILABLE, CarrierType.NOT_AVAILABLE, false);

	private final String modelName;
	private final String productName;
	private final DeviceVendor vendor;
	private final CarrierType carrierType;
	private final boolean callable;

	private final String displayName;

	private DeviceType(String modelName, String productName,
			DeviceVendor vendor, CarrierType carrierType, boolean callable) {
		this.modelName = modelName;
		this.productName = productName;
		this.vendor = vendor;
		this.carrierType = carrierType;
		this.callable = callable;

		this.displayName = buildDisplayName();
	}

	private String buildDisplayName() {
		StringBuilder sbDisplayName = new StringBuilder();
		sbDisplayName.append(vendor.getName());
		sbDisplayName.append(", ");
		sbDisplayName.append(productName);
		sbDisplayName.append(" (");
		sbDisplayName.append(modelName);
		sbDisplayName.append("), ");
		if (carrierType != CarrierType.NOT_AVAILABLE) {
			sbDisplayName.append(carrierType.getName());
			sbDisplayName.append(", ");
		}
		sbDisplayName.append(callable ? "callable" : "non-callable");
		return sbDisplayName.toString();
	}

	public String getModelName() {
		return modelName;
	}

	public String getProductName() {
		return productName;
	}

	public DeviceVendor getVendor() {
		return vendor;
	}

	public CarrierType getCarrierType() {
		return carrierType;
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

}
