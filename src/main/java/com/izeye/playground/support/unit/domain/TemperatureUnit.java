package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;
import java.math.MathContext;

public enum TemperatureUnit implements Unit<TemperatureUnit> {

	CELSIUS("Celsius") {
		@Override
		public BigDecimal toCelsius(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toFahrenheit(BigDecimal t) {
			return t.multiply(CELSIUS_TO_FAHRENHEIT).add(
					CELSIUS_TO_FAHRENHEIT_BASE);
		}

		@Override
		public BigDecimal toKelvin(BigDecimal t) {
			return t.add(CELSIUS_TO_KELVIN_BASE);
		}

		@Override
		public BigDecimal convert(BigDecimal t, TemperatureUnit u) {
			return u.toCelsius(t);
		}
	},
	FAHRENHEIT("Fahrenheit") {
		@Override
		public BigDecimal toCelsius(BigDecimal t) {
			return t.add(FAHRENHEIT_TO_CELSIUS_BASE).multiply(
					FAHRENHEIT_TO_CELSIUS);
		}

		@Override
		public BigDecimal toFahrenheit(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toKelvin(BigDecimal t) {
			return CELSIUS.toKelvin(toCelsius(t));
		}

		@Override
		public BigDecimal convert(BigDecimal t, TemperatureUnit u) {
			return u.toFahrenheit(t);
		}
	},
	KELVIN("Kelvin") {
		@Override
		public BigDecimal toCelsius(BigDecimal t) {
			return t.add(KELVIN_TO_CELSIUS_BASE);
		}

		@Override
		public BigDecimal toFahrenheit(BigDecimal t) {
			return CELSIUS.toFahrenheit(toCelsius(t));
		}

		@Override
		public BigDecimal toKelvin(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal convert(BigDecimal t, TemperatureUnit u) {
			return u.toKelvin(t);
		}
	};

	private final String name;

	private TemperatureUnit(String name) {
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

	public abstract BigDecimal toCelsius(BigDecimal t);

	public abstract BigDecimal toFahrenheit(BigDecimal t);

	public abstract BigDecimal toKelvin(BigDecimal t);

	public abstract BigDecimal convert(BigDecimal sourceTemperature,
			TemperatureUnit sourceUnit);

	private static final BigDecimal CELSIUS_TO_FAHRENHEIT_BASE = BigDecimal
			.valueOf(32);
	private static final BigDecimal CELSIUS_TO_FAHRENHEIT = BigDecimal
			.valueOf(1.8);
	private static final BigDecimal CELSIUS_TO_KELVIN_BASE = BigDecimal
			.valueOf(273.15);

	private static final BigDecimal FAHRENHEIT_TO_CELSIUS_BASE = CELSIUS_TO_FAHRENHEIT_BASE
			.negate();
	private static final BigDecimal FAHRENHEIT_TO_CELSIUS = BigDecimal.ONE
			.divide(CELSIUS_TO_FAHRENHEIT, MathContext.DECIMAL128);
	private static final BigDecimal KELVIN_TO_CELSIUS_BASE = CELSIUS_TO_KELVIN_BASE
			.negate();

}
