package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum TimeUnit implements Unit<TimeUnit> {

	NANOSECOND("Nanosecond"), MICROSECOND("Microsecond"), MILLISECOND(
			"Millisecond"), SECOND("Second"), MINUTE("Minute"), HOUR("Hour"), DAY(
			"Day"), WEEK("Week"), MONTH("Month"), YEAR("Year"), DECADE("Decade"), CENTURY(
			"Century");

	private final String name;

	private TimeUnit(String name) {
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
	public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
		// TODO Auto-generated method stub
		return null;
	}

}
