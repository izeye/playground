package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;
import java.math.MathContext;

public enum TemperatureUnit {

	CELSIUS("Celsius") {
		@Override
		public BigDecimal toCelsius(BigDecimal t) {
			return t;
		}

		// NOTE:
		// F = C * 1.8 + 32
		@Override
		public BigDecimal toFahrenheit(BigDecimal t) {
			return t.multiply(BigDecimal.valueOf(1.8))
					.add(BigDecimal.valueOf(32)).stripTrailingZeros();
		}

		// NOTE:
		// K = C + 273.15
		@Override
		public BigDecimal toKelvin(BigDecimal t) {
			return t.add(BigDecimal.valueOf(273.15));
		}

		@Override
		public BigDecimal convert(BigDecimal t, TemperatureUnit u) {
			return u.toCelsius(t);
		}
	},
	FAHRENHEIT("Fahrenheit") {
		// NOTE:
		// C = (F - 32) / 1.8
		@Override
		public BigDecimal toCelsius(BigDecimal t) {
			return t.subtract(BigDecimal.valueOf(32))
					.divide(BigDecimal.valueOf(1.8), MathContext.DECIMAL128)
					.stripTrailingZeros();
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
		// NOTE:
		// C = K - 273.15
		@Override
		public BigDecimal toCelsius(BigDecimal t) {
			return t.subtract(BigDecimal.valueOf(273.15));
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

	public String getName() {
		return name;
	}

	public abstract BigDecimal toCelsius(BigDecimal t);

	public abstract BigDecimal toFahrenheit(BigDecimal t);

	public abstract BigDecimal toKelvin(BigDecimal t);

	public abstract BigDecimal convert(BigDecimal sourceTemperature,
			TemperatureUnit sourceUnit);

}
