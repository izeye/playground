package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum AreaUnit implements Unit<AreaUnit> {

	SQUARE_KM("Square km") {
		@Override
		public BigDecimal toSquareKm(BigDecimal a) {
			return a;
		}

		@Override
		public BigDecimal toHectare(BigDecimal a) {
			return a.multiply(SQUARE_KM_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_HECTARE);
		}

		@Override
		public BigDecimal toSquareMeter(BigDecimal a) {
			return a.multiply(SQUARE_KM_TO_SQUARE_METER);
		}

		@Override
		public BigDecimal toSquareMile(BigDecimal a) {
			return a.multiply(SQUARE_KM_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_MILE);
		}

		@Override
		public BigDecimal toAcre(BigDecimal a) {
			return a.multiply(SQUARE_KM_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_ACRE);
		}

		@Override
		public BigDecimal toSquareYard(BigDecimal a) {
			return a.multiply(SQUARE_KM_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_YARD);
		}

		@Override
		public BigDecimal toSquareFoot(BigDecimal a) {
			return a.multiply(SQUARE_KM_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_FOOT);
		}

		@Override
		public BigDecimal toSquareInch(BigDecimal a) {
			return a.multiply(SQUARE_KM_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceArea, AreaUnit sourceUnit) {
			return sourceUnit.toSquareKm(sourceArea);
		}
	},
	HECTARE("Hectare") {
		@Override
		public BigDecimal toSquareKm(BigDecimal a) {
			return a.multiply(HECTARE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_KM);
		}

		@Override
		public BigDecimal toHectare(BigDecimal a) {
			return a;
		}

		@Override
		public BigDecimal toSquareMeter(BigDecimal a) {
			return a.multiply(HECTARE_TO_SQUARE_METER);
		}

		@Override
		public BigDecimal toSquareMile(BigDecimal a) {
			return a.multiply(HECTARE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_MILE);
		}

		@Override
		public BigDecimal toAcre(BigDecimal a) {
			return a.multiply(HECTARE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_ACRE);
		}

		@Override
		public BigDecimal toSquareYard(BigDecimal a) {
			return a.multiply(HECTARE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_YARD);
		}

		@Override
		public BigDecimal toSquareFoot(BigDecimal a) {
			return a.multiply(HECTARE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_FOOT);
		}

		@Override
		public BigDecimal toSquareInch(BigDecimal a) {
			return a.multiply(HECTARE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceArea, AreaUnit sourceUnit) {
			return sourceUnit.toHectare(sourceArea);
		}
	},
	SQUARE_METER("Square meter") {
		@Override
		public BigDecimal toSquareKm(BigDecimal a) {
			return a.multiply(SQUARE_METER_TO_SQUARE_KM);
		}

		@Override
		public BigDecimal toHectare(BigDecimal a) {
			return a.multiply(SQUARE_METER_TO_HECTARE);
		}

		@Override
		public BigDecimal toSquareMeter(BigDecimal a) {
			return a;
		}

		@Override
		public BigDecimal toSquareMile(BigDecimal a) {
			return a.multiply(SQUARE_METER_TO_SQUARE_MILE);
		}

		@Override
		public BigDecimal toAcre(BigDecimal a) {
			return a.multiply(SQUARE_METER_TO_ACRE);
		}

		@Override
		public BigDecimal toSquareYard(BigDecimal a) {
			return a.multiply(SQUARE_METER_TO_SQUARE_YARD);
		}

		@Override
		public BigDecimal toSquareFoot(BigDecimal a) {
			return a.multiply(SQUARE_METER_TO_SQUARE_FOOT);
		}

		@Override
		public BigDecimal toSquareInch(BigDecimal a) {
			return a.multiply(SQUARE_METER_TO_SQUARE_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceArea, AreaUnit sourceUnit) {
			return sourceUnit.toSquareMeter(sourceArea);
		}
	},
	SQUARE_MILE("Square mile") {
		@Override
		public BigDecimal toSquareKm(BigDecimal a) {
			return a.multiply(SQUARE_MILE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_KM);
		}

		@Override
		public BigDecimal toHectare(BigDecimal a) {
			return a.multiply(SQUARE_MILE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_HECTARE);
		}

		@Override
		public BigDecimal toSquareMeter(BigDecimal a) {
			return a.multiply(SQUARE_MILE_TO_SQUARE_METER);
		}

		@Override
		public BigDecimal toSquareMile(BigDecimal a) {
			return a;
		}

		@Override
		public BigDecimal toAcre(BigDecimal a) {
			return a.multiply(SQUARE_MILE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_ACRE);
		}

		@Override
		public BigDecimal toSquareYard(BigDecimal a) {
			return a.multiply(SQUARE_MILE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_YARD);
		}

		@Override
		public BigDecimal toSquareFoot(BigDecimal a) {
			return a.multiply(SQUARE_MILE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_FOOT);
		}

		@Override
		public BigDecimal toSquareInch(BigDecimal a) {
			return a.multiply(SQUARE_MILE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceArea, AreaUnit sourceUnit) {
			return sourceUnit.toSquareMile(sourceArea);
		}
	},
	ACRE("Acre") {
		@Override
		public BigDecimal toSquareKm(BigDecimal a) {
			return a.multiply(ACRE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_KM);
		}

		@Override
		public BigDecimal toHectare(BigDecimal a) {
			return a.multiply(ACRE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_HECTARE);
		}

		@Override
		public BigDecimal toSquareMeter(BigDecimal a) {
			return a.multiply(ACRE_TO_SQUARE_METER);
		}

		@Override
		public BigDecimal toSquareMile(BigDecimal a) {
			return a.multiply(ACRE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_MILE);
		}

		@Override
		public BigDecimal toAcre(BigDecimal a) {
			return a;
		}

		@Override
		public BigDecimal toSquareYard(BigDecimal a) {
			return a.multiply(ACRE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_YARD);
		}

		@Override
		public BigDecimal toSquareFoot(BigDecimal a) {
			return a.multiply(ACRE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_FOOT);
		}

		@Override
		public BigDecimal toSquareInch(BigDecimal a) {
			return a.multiply(ACRE_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceArea, AreaUnit sourceUnit) {
			return sourceUnit.toAcre(sourceArea);
		}
	},
	SQUARE_YARD("Square yard") {
		@Override
		public BigDecimal toSquareKm(BigDecimal a) {
			return a.multiply(SQUARE_YARD_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_KM);
		}

		@Override
		public BigDecimal toHectare(BigDecimal a) {
			return a.multiply(SQUARE_YARD_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_HECTARE);
		}

		@Override
		public BigDecimal toSquareMeter(BigDecimal a) {
			return a.multiply(SQUARE_YARD_TO_SQUARE_METER);
		}

		@Override
		public BigDecimal toSquareMile(BigDecimal a) {
			return a.multiply(SQUARE_YARD_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_MILE);
		}

		@Override
		public BigDecimal toAcre(BigDecimal a) {
			return a.multiply(SQUARE_YARD_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_ACRE);
		}

		@Override
		public BigDecimal toSquareYard(BigDecimal a) {
			return a;
		}

		@Override
		public BigDecimal toSquareFoot(BigDecimal a) {
			return a.multiply(SQUARE_YARD_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_FOOT);
		}

		@Override
		public BigDecimal toSquareInch(BigDecimal a) {
			return a.multiply(SQUARE_YARD_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceArea, AreaUnit sourceUnit) {
			return sourceUnit.toSquareYard(sourceArea);
		}
	},
	SQUARE_FOOT("Square foot") {
		@Override
		public BigDecimal toSquareKm(BigDecimal a) {
			return a.multiply(SQUARE_FOOT_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_KM);
		}

		@Override
		public BigDecimal toHectare(BigDecimal a) {
			return a.multiply(SQUARE_FOOT_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_HECTARE);
		}

		@Override
		public BigDecimal toSquareMeter(BigDecimal a) {
			return a.multiply(SQUARE_FOOT_TO_SQUARE_METER);
		}

		@Override
		public BigDecimal toSquareMile(BigDecimal a) {
			return a.multiply(SQUARE_FOOT_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_MILE);
		}

		@Override
		public BigDecimal toAcre(BigDecimal a) {
			return a.multiply(SQUARE_FOOT_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_ACRE);
		}

		@Override
		public BigDecimal toSquareYard(BigDecimal a) {
			return a.multiply(SQUARE_FOOT_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_YARD);
		}

		@Override
		public BigDecimal toSquareFoot(BigDecimal a) {
			return a;
		}

		@Override
		public BigDecimal toSquareInch(BigDecimal a) {
			return a.multiply(SQUARE_FOOT_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceArea, AreaUnit sourceUnit) {
			return sourceUnit.toSquareFoot(sourceArea);
		}
	},
	SQUARE_INCH("Square inch") {
		@Override
		public BigDecimal toSquareKm(BigDecimal a) {
			return a.multiply(SQUARE_INCH_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_KM);
		}

		@Override
		public BigDecimal toHectare(BigDecimal a) {
			return a.multiply(SQUARE_INCH_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_HECTARE);
		}

		@Override
		public BigDecimal toSquareMeter(BigDecimal a) {
			return a.multiply(SQUARE_INCH_TO_SQUARE_METER);
		}

		@Override
		public BigDecimal toSquareMile(BigDecimal a) {
			return a.multiply(SQUARE_INCH_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_MILE);
		}

		@Override
		public BigDecimal toAcre(BigDecimal a) {
			return a.multiply(SQUARE_INCH_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_ACRE);
		}

		@Override
		public BigDecimal toSquareYard(BigDecimal a) {
			return a.multiply(SQUARE_INCH_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_YARD);
		}

		@Override
		public BigDecimal toSquareFoot(BigDecimal a) {
			return a.multiply(SQUARE_INCH_TO_SQUARE_METER).multiply(
					SQUARE_METER_TO_SQUARE_FOOT);
		}

		@Override
		public BigDecimal toSquareInch(BigDecimal a) {
			return a;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceArea, AreaUnit sourceUnit) {
			return sourceUnit.toSquareInch(sourceArea);
		}
	};

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

	public abstract BigDecimal toSquareKm(BigDecimal a);

	public abstract BigDecimal toHectare(BigDecimal a);

	public abstract BigDecimal toSquareMeter(BigDecimal a);

	public abstract BigDecimal toSquareMile(BigDecimal a);

	public abstract BigDecimal toAcre(BigDecimal a);

	public abstract BigDecimal toSquareYard(BigDecimal a);

	public abstract BigDecimal toSquareFoot(BigDecimal a);

	public abstract BigDecimal toSquareInch(BigDecimal a);

	public abstract BigDecimal convert(BigDecimal sourceArea,
			AreaUnit sourceUnit);

	private static final BigDecimal SQUARE_METER_TO_SQUARE_KM = BigDecimal
			.valueOf(1e-6);
	private static final BigDecimal SQUARE_METER_TO_HECTARE = BigDecimal
			.valueOf(1e-4);
	private static final BigDecimal SQUARE_METER_TO_SQUARE_MILE = BigDecimal
			.valueOf(3.861e-7);
	private static final BigDecimal SQUARE_METER_TO_ACRE = BigDecimal
			.valueOf(0.000247105);
	private static final BigDecimal SQUARE_METER_TO_SQUARE_YARD = BigDecimal
			.valueOf(1.19599);
	private static final BigDecimal SQUARE_METER_TO_SQUARE_FOOT = BigDecimal
			.valueOf(10.7639);
	private static final BigDecimal SQUARE_METER_TO_SQUARE_INCH = BigDecimal
			.valueOf(1550);

	private static final BigDecimal SQUARE_KM_TO_SQUARE_METER = BigDecimal
			.valueOf(1e+6);
	private static final BigDecimal HECTARE_TO_SQUARE_METER = BigDecimal
			.valueOf(10000);
	private static final BigDecimal SQUARE_MILE_TO_SQUARE_METER = BigDecimal
			.valueOf(2.59e+6);
	private static final BigDecimal ACRE_TO_SQUARE_METER = BigDecimal
			.valueOf(4046.86);
	private static final BigDecimal SQUARE_YARD_TO_SQUARE_METER = BigDecimal
			.valueOf(0.836127);
	private static final BigDecimal SQUARE_FOOT_TO_SQUARE_METER = BigDecimal
			.valueOf(0.092903);
	private static final BigDecimal SQUARE_INCH_TO_SQUARE_METER = BigDecimal
			.valueOf(0.00064516);

}
