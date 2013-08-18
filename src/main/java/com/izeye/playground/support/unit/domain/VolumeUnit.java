package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum VolumeUnit implements Unit<VolumeUnit> {

	US_GAL("US gal") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER)
					.multiply(LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(US_GAL_TO_LITER).multiply(LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toUSGal(sourceVolume);
		}
	},
	US_QUART("US quart") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER)
					.multiply(LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(
					LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER)
					.multiply(LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(US_QUART_TO_LITER).multiply(LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toUSQuart(sourceVolume);
		}
	},
	US_PINT("US pint") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER)
					.multiply(LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER)
					.multiply(LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(US_PINT_TO_LITER).multiply(LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toUSPint(sourceVolume);
		}
	},
	US_CUP("US cup") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER)
					.multiply(LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(US_CUP_TO_LITER).multiply(LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toUSCup(sourceVolume);
		}
	},
	US_OZ("US oz") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(US_OZ_TO_LITER).multiply(LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toUSOz(sourceVolume);
		}
	},
	US_TBSP("US tbsp.") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER)
					.multiply(LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER)
					.multiply(LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(US_TBSP_TO_LITER).multiply(LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toUSTbsp(sourceVolume);
		}
	},
	US_TSP("US tsp.") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER)
					.multiply(LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(US_TSP_TO_LITER).multiply(LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toUSTsp(sourceVolume);
		}
	},
	CUBIC_METER("Cubic meter") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(
					LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(
					LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(CUBIC_METER_TO_LITER).multiply(
					LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toCubicMeter(sourceVolume);
		}
	},
	LITER("Liter") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toLiter(sourceVolume);
		}
	},
	MILLILITER("Milliliter") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(
					LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER)
					.multiply(LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(MILLILITER_TO_LITER)
					.multiply(LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toMilliliter(sourceVolume);
		}
	},
	IMPERIAL_GAL("Imperial gal") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER)
					.multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(
					LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(
					LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(
					LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(
					LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(
					LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(IMPERIAL_GAL_TO_LITER).multiply(
					LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toImperialGal(sourceVolume);
		}
	},
	IMPERIAL_QUART("Imperial quart") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER)
					.multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER)
					.multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER)
					.multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(IMPERIAL_QUART_TO_LITER).multiply(
					LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toImperialQuart(sourceVolume);
		}
	},
	IMPERIAL_PINT("Imperial pint") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(
					LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER)
					.multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER)
					.multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(
					LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(
					LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(
					LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(IMPERIAL_PINT_TO_LITER).multiply(
					LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toImperialPint(sourceVolume);
		}
	},
	IMPERIAL_OZ("Imperial oz") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(
					LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(
					LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(
					LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(
					LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(
					LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(IMPERIAL_OZ_TO_LITER).multiply(
					LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toImperialOz(sourceVolume);
		}
	},
	IMPERIAL_TBSP("Imperial tbsp.") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(
					LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER)
					.multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER)
					.multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(
					LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(
					LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(
					LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(IMPERIAL_TBSP_TO_LITER).multiply(
					LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toImperialTbsp(sourceVolume);
		}
	},
	IMPERIAL_TSP("Imperial tsp.") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER)
					.multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(
					LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(
					LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(
					LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(IMPERIAL_TSP_TO_LITER).multiply(
					LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toImperialTsp(sourceVolume);
		}
	},
	CUBIC_FOOT("Cubic foot") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(
					LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER)
					.multiply(LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v.multiply(CUBIC_FOOT_TO_LITER)
					.multiply(LITER_TO_CUBIC_INCH);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toCubicFoot(sourceVolume);
		}
	},
	CUBIC_INCH("Cubic inch") {
		@Override
		public BigDecimal toUSGal(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(LITER_TO_US_GAL);
		}

		@Override
		public BigDecimal toUSQuart(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(LITER_TO_US_QUART);
		}

		@Override
		public BigDecimal toUSPint(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(LITER_TO_US_PINT);
		}

		@Override
		public BigDecimal toUSCup(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(LITER_TO_US_CUP);
		}

		@Override
		public BigDecimal toUSOz(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(LITER_TO_US_OZ);
		}

		@Override
		public BigDecimal toUSTbsp(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(LITER_TO_US_TBSP);
		}

		@Override
		public BigDecimal toUSTsp(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(LITER_TO_US_TSP);
		}

		@Override
		public BigDecimal toCubicMeter(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(
					LITER_TO_CUBIC_METER);
		}

		@Override
		public BigDecimal toLiter(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER);
		}

		@Override
		public BigDecimal toMilliliter(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER)
					.multiply(LITER_TO_MILLILITER);
		}

		@Override
		public BigDecimal toImperialGal(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(
					LITER_TO_IMPERIAL_GAL);
		}

		@Override
		public BigDecimal toImperialQuart(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(
					LITER_TO_IMPERIAL_QUART);
		}

		@Override
		public BigDecimal toImperialPint(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(
					LITER_TO_IMPERIAL_PINT);
		}

		@Override
		public BigDecimal toImperialOz(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(
					LITER_TO_IMPERIAL_OZ);
		}

		@Override
		public BigDecimal toImperialTbsp(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TBSP);
		}

		@Override
		public BigDecimal toImperialTsp(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER).multiply(
					LITER_TO_IMPERIAL_TSP);
		}

		@Override
		public BigDecimal toCubicFoot(BigDecimal v) {
			return v.multiply(CUBIC_INCH_TO_LITER)
					.multiply(LITER_TO_CUBIC_FOOT);
		}

		@Override
		public BigDecimal toCubicInch(BigDecimal v) {
			return v;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
			return sourceUnit.toCubicInch(sourceVolume);
		}
	};

	private final String name;

	private VolumeUnit(String name) {
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

	public abstract BigDecimal toUSGal(BigDecimal v);

	public abstract BigDecimal toUSQuart(BigDecimal v);

	public abstract BigDecimal toUSPint(BigDecimal v);

	public abstract BigDecimal toUSCup(BigDecimal v);

	public abstract BigDecimal toUSOz(BigDecimal v);

	public abstract BigDecimal toUSTbsp(BigDecimal v);

	public abstract BigDecimal toUSTsp(BigDecimal v);

	public abstract BigDecimal toCubicMeter(BigDecimal v);

	public abstract BigDecimal toLiter(BigDecimal v);

	public abstract BigDecimal toMilliliter(BigDecimal v);

	public abstract BigDecimal toImperialGal(BigDecimal v);

	public abstract BigDecimal toImperialQuart(BigDecimal v);

	public abstract BigDecimal toImperialPint(BigDecimal v);

	public abstract BigDecimal toImperialOz(BigDecimal v);

	public abstract BigDecimal toImperialTbsp(BigDecimal v);

	public abstract BigDecimal toImperialTsp(BigDecimal v);

	public abstract BigDecimal toCubicFoot(BigDecimal v);

	public abstract BigDecimal toCubicInch(BigDecimal v);

	public abstract BigDecimal convert(BigDecimal sourceVolume,
			VolumeUnit sourceUnit);

	private static final BigDecimal LITER_TO_US_GAL = BigDecimal
			.valueOf(0.264172);
	private static final BigDecimal LITER_TO_US_QUART = BigDecimal
			.valueOf(1.05669);
	private static final BigDecimal LITER_TO_US_PINT = BigDecimal
			.valueOf(2.11338);
	private static final BigDecimal LITER_TO_US_CUP = BigDecimal
			.valueOf(4.22675);
	private static final BigDecimal LITER_TO_US_OZ = BigDecimal.valueOf(33.814);
	private static final BigDecimal LITER_TO_US_TBSP = BigDecimal
			.valueOf(67.628);
	private static final BigDecimal LITER_TO_US_TSP = BigDecimal
			.valueOf(202.884);
	private static final BigDecimal LITER_TO_CUBIC_METER = BigDecimal
			.valueOf(0.001);
	private static final BigDecimal LITER_TO_MILLILITER = BigDecimal
			.valueOf(1000);
	private static final BigDecimal LITER_TO_IMPERIAL_GAL = BigDecimal
			.valueOf(0.219969);
	private static final BigDecimal LITER_TO_IMPERIAL_QUART = BigDecimal
			.valueOf(0.879877);
	private static final BigDecimal LITER_TO_IMPERIAL_PINT = BigDecimal
			.valueOf(1.75975);
	private static final BigDecimal LITER_TO_IMPERIAL_OZ = BigDecimal
			.valueOf(35.1951);
	private static final BigDecimal LITER_TO_IMPERIAL_TBSP = BigDecimal
			.valueOf(56.3121);
	private static final BigDecimal LITER_TO_IMPERIAL_TSP = BigDecimal
			.valueOf(168.936);
	private static final BigDecimal LITER_TO_CUBIC_FOOT = BigDecimal
			.valueOf(0.0353147);
	private static final BigDecimal LITER_TO_CUBIC_INCH = BigDecimal
			.valueOf(61.0237);

	private static final BigDecimal US_GAL_TO_LITER = BigDecimal
			.valueOf(3.78541);
	private static final BigDecimal US_QUART_TO_LITER = BigDecimal
			.valueOf(0.946353);
	private static final BigDecimal US_PINT_TO_LITER = BigDecimal
			.valueOf(0.473176);
	private static final BigDecimal US_CUP_TO_LITER = BigDecimal
			.valueOf(0.236588);
	private static final BigDecimal US_OZ_TO_LITER = BigDecimal
			.valueOf(0.0295735);
	private static final BigDecimal US_TBSP_TO_LITER = BigDecimal
			.valueOf(0.0147868);
	private static final BigDecimal US_TSP_TO_LITER = BigDecimal
			.valueOf(0.00492892);
	private static final BigDecimal CUBIC_METER_TO_LITER = BigDecimal
			.valueOf(1000);
	private static final BigDecimal MILLILITER_TO_LITER = BigDecimal
			.valueOf(0.001);
	private static final BigDecimal IMPERIAL_GAL_TO_LITER = BigDecimal
			.valueOf(4.54609);
	private static final BigDecimal IMPERIAL_QUART_TO_LITER = BigDecimal
			.valueOf(1.13652);
	private static final BigDecimal IMPERIAL_PINT_TO_LITER = BigDecimal
			.valueOf(0.568261);
	private static final BigDecimal IMPERIAL_OZ_TO_LITER = BigDecimal
			.valueOf(0.0284131);
	private static final BigDecimal IMPERIAL_TBSP_TO_LITER = BigDecimal
			.valueOf(0.0177582);
	private static final BigDecimal IMPERIAL_TSP_TO_LITER = BigDecimal
			.valueOf(0.00591939);
	private static final BigDecimal CUBIC_FOOT_TO_LITER = BigDecimal
			.valueOf(28.3168);
	private static final BigDecimal CUBIC_INCH_TO_LITER = BigDecimal
			.valueOf(0.0163871);

}
