package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum FuelConsumptionUnit implements Unit<FuelConsumptionUnit> {

	MPG_US("MPG (US)"), MPG_IMP("MPG (imp.)"), KM_PER_LITER("Km/liter"), LITER_PER_100KM(
			"Liter/100km");

	private final String name;

	private FuelConsumptionUnit(String name) {
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
	public BigDecimal convert(BigDecimal sourceFuelConsumption,
			FuelConsumptionUnit sourceUnit) {
		// TODO Auto-generated method stub
		return null;
	}

}
