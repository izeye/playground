package com.izeye.playground.support.unit.domain;

public enum FuelConsumptionUnit {

	MPG_US("MPG (US)"), MPG_IMP("MPG (imp.)"), KM_PER_LITER("Km/liter"), LITER_PER_100KM(
			"Liter/100km");

	private final String name;

	private FuelConsumptionUnit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
