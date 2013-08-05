package com.izeye.playground.support.unit.domain;

public enum SpeedUnit {

	MILES_PER_HOUR("Miles/hour"), FEET_PER_SEC("Feet/sec"), METERS_PER_SEC(
			"Meters/sec"), KM_PER_HOUR("Km/hour"), KNOT("Knot");

	private final String name;

	private SpeedUnit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
