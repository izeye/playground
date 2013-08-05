package com.izeye.playground.support.unit.domain;

public enum UnitType {

	TEMPERATURE("Temperature"), LENGTH("Length"), MASS("Mass"), SPEED("Speed"), VOLUME(
			"Volume"), AREA("Area"), FUEL_CONSUMPTION("Fuel Consumption"), TIME(
			"Time"), DIGITAL_STORAGE("Digital Storage");

	private final String name;

	private UnitType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
