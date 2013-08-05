package com.izeye.playground.support.unit.domain;

public enum TimeUnit {

	NANOSECOND("Nanosecond"), MICROSECOND("Microsecond"), MILLISECOND(
			"Millisecond"), SECOND("Second"), MINUTE("Minute"), HOUR("Hour"), DAY(
			"Day"), WEEK("Week"), MONTH("Month"), YEAR("Year"), DECADE("Decade"), CENTURY(
			"Century");

	private final String name;

	private TimeUnit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
