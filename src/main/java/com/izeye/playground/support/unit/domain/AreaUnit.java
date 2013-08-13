package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum AreaUnit implements Unit<AreaUnit> {

	SQUARE_KM("Square km"), HECTARE("Hectare"), SQUARE_METER("Square meter"), SQUARE_MILE(
			"Square mile"), ACRE("Acre"), SQUARE_YARD("Square yard"), SQUARE_FOOT(
			"Square foot"), SQUARE_INCH("Square inch");

	private final String name;

	private AreaUnit(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getKey() {
		return name();
	}

	@Override
	public BigDecimal convert(BigDecimal sourceArea, AreaUnit sourceUnit) {
		// TODO Auto-generated method stub
		return null;
	}

}
