package com.izeye.playground.support.unit.domain;

public enum AreaUnit {

	SQUARE_KM("Square km"), HECTARE("Hectare"), SQUARE_METER("Square meter"), SQUARE_MILE(
			"Square mile"), ACRE("Acre"), SQUARE_YARD("Square yard"), SQUARE_FOOT(
			"Square foot"), SQUARE_INCH("Square inch");

	private final String name;

	private AreaUnit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
