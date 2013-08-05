package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum LengthUnit {

	KILOMETER("Kilometer") {
		@Override
		public BigDecimal toKilometer(BigDecimal l) {
			return l;
		}

		@Override
		public BigDecimal toMeter(BigDecimal l) {
			return l.multiply(KILOMETER_TO_METER);
		}

		@Override
		public BigDecimal toCentimeter(BigDecimal l) {
			return l.multiply(KILOMETER_TO_METER).multiply(METER_TO_CENTIMETER);
		}

		@Override
		public BigDecimal toMillimeter(BigDecimal l) {
			return l.multiply(KILOMETER_TO_METER).multiply(METER_TO_MILLIMETER);
		}

		@Override
		public BigDecimal toMile(BigDecimal l) {
			return l.multiply(KILOMETER_TO_METER).multiply(METER_TO_MILE);
		}

		@Override
		public BigDecimal toYard(BigDecimal l) {
			return l.multiply(KILOMETER_TO_METER).multiply(METER_TO_YARD);
		}

		@Override
		public BigDecimal toFoot(BigDecimal l) {
			return l.multiply(KILOMETER_TO_METER).multiply(METER_TO_FOOT);
		}

		@Override
		public BigDecimal toInch(BigDecimal l) {
			return l.multiply(KILOMETER_TO_METER).multiply(METER_TO_INCH);
		}

		@Override
		public BigDecimal toNauticalMile(BigDecimal l) {
			return l.multiply(KILOMETER_TO_METER).multiply(
					METER_TO_NAUTICAL_MILE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
			return sourceUnit.toKilometer(sourceLength);
		}
	},
	METER("Meter") {
		@Override
		public BigDecimal toKilometer(BigDecimal l) {
			return l.multiply(METER_TO_KILOMETER);
		}

		@Override
		public BigDecimal toMeter(BigDecimal l) {
			return l;
		}

		@Override
		public BigDecimal toCentimeter(BigDecimal l) {
			return l.multiply(METER_TO_CENTIMETER);
		}

		@Override
		public BigDecimal toMillimeter(BigDecimal l) {
			return l.multiply(METER_TO_MILLIMETER);
		}

		@Override
		public BigDecimal toMile(BigDecimal l) {
			return l.multiply(METER_TO_MILE);
		}

		@Override
		public BigDecimal toYard(BigDecimal l) {
			return l.multiply(METER_TO_YARD);
		}

		@Override
		public BigDecimal toFoot(BigDecimal l) {
			return l.multiply(METER_TO_FOOT);
		}

		@Override
		public BigDecimal toInch(BigDecimal l) {
			return l.multiply(METER_TO_INCH);
		}

		@Override
		public BigDecimal toNauticalMile(BigDecimal l) {
			return l.multiply(METER_TO_NAUTICAL_MILE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
			return sourceUnit.toMeter(sourceLength);
		}
	},
	CENTIMETER("Centimeter") {
		@Override
		public BigDecimal toKilometer(BigDecimal l) {
			return l.multiply(CENTIMETER_TO_METER).multiply(METER_TO_KILOMETER);
		}

		@Override
		public BigDecimal toMeter(BigDecimal l) {
			return l.multiply(CENTIMETER_TO_METER);
		}

		@Override
		public BigDecimal toCentimeter(BigDecimal l) {
			return l;
		}

		@Override
		public BigDecimal toMillimeter(BigDecimal l) {
			return l.multiply(CENTIMETER_TO_METER)
					.multiply(METER_TO_MILLIMETER);
		}

		@Override
		public BigDecimal toMile(BigDecimal l) {
			return l.multiply(CENTIMETER_TO_METER).multiply(METER_TO_MILE);
		}

		@Override
		public BigDecimal toYard(BigDecimal l) {
			return l.multiply(CENTIMETER_TO_METER).multiply(METER_TO_YARD);
		}

		@Override
		public BigDecimal toFoot(BigDecimal l) {
			return l.multiply(CENTIMETER_TO_METER).multiply(METER_TO_FOOT);
		}

		@Override
		public BigDecimal toInch(BigDecimal l) {
			return l.multiply(CENTIMETER_TO_METER).multiply(METER_TO_INCH);
		}

		@Override
		public BigDecimal toNauticalMile(BigDecimal l) {
			return l.multiply(CENTIMETER_TO_METER).multiply(
					METER_TO_NAUTICAL_MILE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
			return sourceUnit.toCentimeter(sourceLength);
		}
	},
	MILLIMETER("Millimeter") {
		@Override
		public BigDecimal toKilometer(BigDecimal l) {
			return l.multiply(MILLIMETER_TO_METER).multiply(METER_TO_KILOMETER);
		}

		@Override
		public BigDecimal toMeter(BigDecimal l) {
			return l.multiply(MILLIMETER_TO_METER);
		}

		@Override
		public BigDecimal toCentimeter(BigDecimal l) {
			return l.multiply(MILLIMETER_TO_METER)
					.multiply(METER_TO_CENTIMETER);
		}

		@Override
		public BigDecimal toMillimeter(BigDecimal l) {
			return l;
		}

		@Override
		public BigDecimal toMile(BigDecimal l) {
			return l.multiply(MILLIMETER_TO_METER).multiply(METER_TO_MILE);
		}

		@Override
		public BigDecimal toYard(BigDecimal l) {
			return l.multiply(MILLIMETER_TO_METER).multiply(METER_TO_YARD);
		}

		@Override
		public BigDecimal toFoot(BigDecimal l) {
			return l.multiply(MILLIMETER_TO_METER).multiply(METER_TO_FOOT);
		}

		@Override
		public BigDecimal toInch(BigDecimal l) {
			return l.multiply(MILLIMETER_TO_METER).multiply(METER_TO_INCH);
		}

		@Override
		public BigDecimal toNauticalMile(BigDecimal l) {
			return l.multiply(MILLIMETER_TO_METER).multiply(
					METER_TO_NAUTICAL_MILE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
			return sourceUnit.toMillimeter(sourceLength);
		}
	},
	MILE("Mile") {
		@Override
		public BigDecimal toKilometer(BigDecimal l) {
			return l.multiply(MILE_TO_METER).multiply(METER_TO_KILOMETER);
		}

		@Override
		public BigDecimal toMeter(BigDecimal l) {
			return l.multiply(MILE_TO_METER);
		}

		@Override
		public BigDecimal toCentimeter(BigDecimal l) {
			return l.multiply(MILE_TO_METER).multiply(METER_TO_CENTIMETER);
		}

		@Override
		public BigDecimal toMillimeter(BigDecimal l) {
			return l.multiply(MILE_TO_METER).multiply(METER_TO_MILLIMETER);
		}

		@Override
		public BigDecimal toMile(BigDecimal l) {
			return l;
		}

		@Override
		public BigDecimal toYard(BigDecimal l) {
			return l.multiply(MILE_TO_METER).multiply(METER_TO_YARD);
		}

		@Override
		public BigDecimal toFoot(BigDecimal l) {
			return l.multiply(MILE_TO_METER).multiply(METER_TO_FOOT);
		}

		@Override
		public BigDecimal toInch(BigDecimal l) {
			return l.multiply(MILE_TO_METER).multiply(METER_TO_INCH);
		}

		@Override
		public BigDecimal toNauticalMile(BigDecimal l) {
			return l.multiply(MILE_TO_METER).multiply(METER_TO_NAUTICAL_MILE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
			return sourceUnit.toMile(sourceLength);
		}
	},
	YARD("Yard") {
		@Override
		public BigDecimal toKilometer(BigDecimal l) {
			return l.multiply(YARD_TO_METER).multiply(METER_TO_KILOMETER);
		}

		@Override
		public BigDecimal toMeter(BigDecimal l) {
			return l.multiply(YARD_TO_METER);
		}

		@Override
		public BigDecimal toCentimeter(BigDecimal l) {
			return l.multiply(YARD_TO_METER).multiply(METER_TO_CENTIMETER);
		}

		@Override
		public BigDecimal toMillimeter(BigDecimal l) {
			return l.multiply(YARD_TO_METER).multiply(METER_TO_MILLIMETER);
		}

		@Override
		public BigDecimal toMile(BigDecimal l) {
			return l.multiply(YARD_TO_METER).multiply(METER_TO_MILE);
		}

		@Override
		public BigDecimal toYard(BigDecimal l) {
			return l;
		}

		@Override
		public BigDecimal toFoot(BigDecimal l) {
			return l.multiply(YARD_TO_METER).multiply(METER_TO_FOOT);
		}

		@Override
		public BigDecimal toInch(BigDecimal l) {
			return l.multiply(YARD_TO_METER).multiply(METER_TO_INCH);
		}

		@Override
		public BigDecimal toNauticalMile(BigDecimal l) {
			return l.multiply(YARD_TO_METER).multiply(METER_TO_NAUTICAL_MILE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
			return sourceUnit.toYard(sourceLength);
		}
	},
	FOOT("Foot") {
		@Override
		public BigDecimal toKilometer(BigDecimal l) {
			return l.multiply(FOOT_TO_METER).multiply(METER_TO_KILOMETER);
		}

		@Override
		public BigDecimal toMeter(BigDecimal l) {
			return l.multiply(FOOT_TO_METER);
		}

		@Override
		public BigDecimal toCentimeter(BigDecimal l) {
			return l.multiply(FOOT_TO_METER).multiply(METER_TO_CENTIMETER);
		}

		@Override
		public BigDecimal toMillimeter(BigDecimal l) {
			return l.multiply(FOOT_TO_METER).multiply(METER_TO_MILLIMETER);
		}

		@Override
		public BigDecimal toMile(BigDecimal l) {
			return l.multiply(FOOT_TO_METER).multiply(METER_TO_MILE);
		}

		@Override
		public BigDecimal toYard(BigDecimal l) {
			return l.multiply(FOOT_TO_METER).multiply(METER_TO_YARD);
		}

		@Override
		public BigDecimal toFoot(BigDecimal l) {
			return l;
		}

		@Override
		public BigDecimal toInch(BigDecimal l) {
			return l.multiply(FOOT_TO_METER).multiply(METER_TO_INCH);
		}

		@Override
		public BigDecimal toNauticalMile(BigDecimal l) {
			return l.multiply(FOOT_TO_METER).multiply(METER_TO_NAUTICAL_MILE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
			return sourceUnit.toFoot(sourceLength);
		}
	},
	INCH("Inch") {
		@Override
		public BigDecimal toKilometer(BigDecimal l) {
			return l.multiply(INCH_TO_METER).multiply(METER_TO_KILOMETER);
		}

		@Override
		public BigDecimal toMeter(BigDecimal l) {
			return l.multiply(INCH_TO_METER);
		}

		@Override
		public BigDecimal toCentimeter(BigDecimal l) {
			return l.multiply(INCH_TO_METER).multiply(METER_TO_CENTIMETER);
		}

		@Override
		public BigDecimal toMillimeter(BigDecimal l) {
			return l.multiply(INCH_TO_METER).multiply(METER_TO_MILLIMETER);
		}

		@Override
		public BigDecimal toMile(BigDecimal l) {
			return l.multiply(INCH_TO_METER).multiply(METER_TO_MILE);
		}

		@Override
		public BigDecimal toYard(BigDecimal l) {
			return l.multiply(INCH_TO_METER).multiply(METER_TO_YARD);
		}

		@Override
		public BigDecimal toFoot(BigDecimal l) {
			return l.multiply(INCH_TO_METER).multiply(METER_TO_FOOT);
		}

		@Override
		public BigDecimal toInch(BigDecimal l) {
			return l;
		}

		@Override
		public BigDecimal toNauticalMile(BigDecimal l) {
			return l.multiply(INCH_TO_METER).multiply(METER_TO_NAUTICAL_MILE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
			return sourceUnit.toInch(sourceLength);
		}
	},
	NAUTICAL_MILE("Nautical mile") {
		@Override
		public BigDecimal toKilometer(BigDecimal l) {
			return l.multiply(NAUTICAL_MILE_TO_METER).multiply(
					METER_TO_KILOMETER);
		}

		@Override
		public BigDecimal toMeter(BigDecimal l) {
			return l.multiply(NAUTICAL_MILE_TO_METER);
		}

		@Override
		public BigDecimal toCentimeter(BigDecimal l) {
			return l.multiply(NAUTICAL_MILE_TO_METER).multiply(
					METER_TO_CENTIMETER);
		}

		@Override
		public BigDecimal toMillimeter(BigDecimal l) {
			return l.multiply(NAUTICAL_MILE_TO_METER).multiply(
					METER_TO_MILLIMETER);
		}

		@Override
		public BigDecimal toMile(BigDecimal l) {
			return l.multiply(NAUTICAL_MILE_TO_METER).multiply(METER_TO_MILE);
		}

		@Override
		public BigDecimal toYard(BigDecimal l) {
			return l.multiply(NAUTICAL_MILE_TO_METER).multiply(METER_TO_YARD);
		}

		@Override
		public BigDecimal toFoot(BigDecimal l) {
			return l.multiply(NAUTICAL_MILE_TO_METER).multiply(METER_TO_FOOT);
		}

		@Override
		public BigDecimal toInch(BigDecimal l) {
			return l.multiply(NAUTICAL_MILE_TO_METER).multiply(METER_TO_INCH);
		}

		@Override
		public BigDecimal toNauticalMile(BigDecimal l) {
			return l;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
			return sourceUnit.toNauticalMile(sourceLength);
		}
	};

	private final String name;

	private LengthUnit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract BigDecimal toKilometer(BigDecimal l);

	public abstract BigDecimal toMeter(BigDecimal l);

	public abstract BigDecimal toCentimeter(BigDecimal l);

	public abstract BigDecimal toMillimeter(BigDecimal l);

	public abstract BigDecimal toMile(BigDecimal l);

	public abstract BigDecimal toYard(BigDecimal l);

	public abstract BigDecimal toFoot(BigDecimal l);

	public abstract BigDecimal toInch(BigDecimal l);

	public abstract BigDecimal toNauticalMile(BigDecimal l);

	public abstract BigDecimal convert(BigDecimal sourceLength,
			LengthUnit sourceUnit);

	private static final BigDecimal METER_TO_KILOMETER = BigDecimal
			.valueOf(0.001);
	private static final BigDecimal METER_TO_CENTIMETER = BigDecimal
			.valueOf(100);
	private static final BigDecimal METER_TO_MILLIMETER = BigDecimal
			.valueOf(1000);
	private static final BigDecimal METER_TO_MILE = BigDecimal
			.valueOf(0.000621371);
	private static final BigDecimal METER_TO_YARD = BigDecimal.valueOf(1.09361);
	private static final BigDecimal METER_TO_FOOT = BigDecimal.valueOf(3.28084);
	private static final BigDecimal METER_TO_INCH = BigDecimal.valueOf(39.3701);
	private static final BigDecimal METER_TO_NAUTICAL_MILE = BigDecimal
			.valueOf(0.0005399577);

	private static final BigDecimal KILOMETER_TO_METER = BigDecimal
			.valueOf(1000);
	private static final BigDecimal CENTIMETER_TO_METER = BigDecimal
			.valueOf(0.01);
	private static final BigDecimal MILLIMETER_TO_METER = BigDecimal
			.valueOf(0.001);
	private static final BigDecimal MILE_TO_METER = BigDecimal
			.valueOf(1609.344);
	private static final BigDecimal YARD_TO_METER = BigDecimal.valueOf(0.9144);
	private static final BigDecimal FOOT_TO_METER = BigDecimal.valueOf(0.3048);
	private static final BigDecimal INCH_TO_METER = BigDecimal.valueOf(0.0254);
	private static final BigDecimal NAUTICAL_MILE_TO_METER = BigDecimal
			.valueOf(1852);

}
