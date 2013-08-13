package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum SpeedUnit implements Unit<SpeedUnit> {

	MILES_PER_HOUR("Miles/hour") {
		@Override
		public BigDecimal toMilesPerHour(BigDecimal s) {
			return s;
		}

		@Override
		public BigDecimal toFeetPerSec(BigDecimal s) {
			return s.multiply(MILES_PER_HOUR_TO_METERS_PER_SEC).multiply(
					METERS_PER_SEC_TO_FEET_PER_SEC);
		}

		@Override
		public BigDecimal toMetersPerSec(BigDecimal s) {
			return s.multiply(MILES_PER_HOUR_TO_METERS_PER_SEC);
		}

		@Override
		public BigDecimal toKmPerHour(BigDecimal s) {
			return s.multiply(MILES_PER_HOUR_TO_METERS_PER_SEC).multiply(
					METERS_PER_SEC_TO_KM_PER_HOUR);
		}

		@Override
		public BigDecimal toKnot(BigDecimal s) {
			return s.multiply(MILES_PER_HOUR_TO_METERS_PER_SEC).multiply(
					METERS_PER_SEC_TO_KNOT);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceSpeed, SpeedUnit sourceUnit) {
			return sourceUnit.toMilesPerHour(sourceSpeed);
		}
	},
	FEET_PER_SEC("Feet/sec") {
		@Override
		public BigDecimal toMilesPerHour(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toFeetPerSec(BigDecimal s) {
			return s;
		}

		@Override
		public BigDecimal toMetersPerSec(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toKmPerHour(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toKnot(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceSpeed, SpeedUnit sourceUnit) {
			return sourceUnit.toFeetPerSec(sourceSpeed);
		}
	},
	METERS_PER_SEC("Meters/sec") {
		@Override
		public BigDecimal toMilesPerHour(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toFeetPerSec(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toMetersPerSec(BigDecimal s) {
			return s;
		}

		@Override
		public BigDecimal toKmPerHour(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toKnot(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceSpeed, SpeedUnit sourceUnit) {
			return sourceUnit.toMetersPerSec(sourceSpeed);
		}
	},
	KM_PER_HOUR("Km/hour") {
		@Override
		public BigDecimal toMilesPerHour(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toFeetPerSec(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toMetersPerSec(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toKmPerHour(BigDecimal s) {
			return s;
		}

		@Override
		public BigDecimal toKnot(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceSpeed, SpeedUnit sourceUnit) {
			return sourceUnit.toKmPerHour(sourceSpeed);
		}
	},
	KNOT("Knot") {
		@Override
		public BigDecimal toMilesPerHour(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toFeetPerSec(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toMetersPerSec(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toKmPerHour(BigDecimal s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toKnot(BigDecimal s) {
			return s;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceSpeed, SpeedUnit sourceUnit) {
			return sourceUnit.toKnot(sourceSpeed);
		}
	};

	private final String name;

	private SpeedUnit(String name) {
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

	public abstract BigDecimal toMilesPerHour(BigDecimal s);

	public abstract BigDecimal toFeetPerSec(BigDecimal s);

	public abstract BigDecimal toMetersPerSec(BigDecimal s);

	public abstract BigDecimal toKmPerHour(BigDecimal s);

	public abstract BigDecimal toKnot(BigDecimal s);

	public abstract BigDecimal convert(BigDecimal sourceSpeed,
			SpeedUnit sourceUnit);

	private static final BigDecimal METERS_PER_SEC_TO_MILES_PER_HOUR = BigDecimal
			.valueOf(2.23694);
	private static final BigDecimal METERS_PER_SEC_TO_FEET_PER_SEC = BigDecimal
			.valueOf(3.28084);
	private static final BigDecimal METERS_PER_SEC_TO_KM_PER_HOUR = BigDecimal
			.valueOf(3.6);
	private static final BigDecimal METERS_PER_SEC_TO_KNOT = BigDecimal
			.valueOf(1.94384);

	private static final BigDecimal MILES_PER_HOUR_TO_METERS_PER_SEC = BigDecimal
			.valueOf(0.44704);
	private static final BigDecimal FEET_PER_SEC_TO_METERS_PER_SEC = BigDecimal
			.valueOf(0.3048);
	private static final BigDecimal KM_PER_HOUR_TO_METERS_PER_SEC = BigDecimal
			.valueOf(0.277778);
	private static final BigDecimal KNOT_TO_METERS_PER_SEC = BigDecimal
			.valueOf(0.514444);

}
