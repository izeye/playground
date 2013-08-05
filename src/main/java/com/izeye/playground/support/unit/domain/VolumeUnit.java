package com.izeye.playground.support.unit.domain;

public enum VolumeUnit {

	US_GAL("US gal"), US_QUART("US quart"), US_PINT("US pint"), US_CUP("US cup"), US_OZ(
			"US oz"), US_TBSP("US tbsp."), US_TSP("US tsp."), CUBIC_METER(
			"Cubic meter"), LITER("Liter"), MILLILITER("Milliliter"), IMPERIAL_GAL(
			"Imperial gal"), IMPERIAL_QUART("Imperial quart"), IMPERIAL_PINT(
			"Imperial pint"), IMPERIAL_OZ("Imperial oz"), IMPERIAL_TBSP(
			"Imperial tbsp."), IMPERIAL_TSP("Imperial tsp."), CUBIC_FOOT(
			"Cubic foot"), CUBIC_INCH("Cubic inch");

	private final String name;

	private VolumeUnit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
