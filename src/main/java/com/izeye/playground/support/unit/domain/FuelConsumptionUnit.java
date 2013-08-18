package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;
import java.math.MathContext;

public enum FuelConsumptionUnit implements Unit<FuelConsumptionUnit> {

	MPG_US("MPG (US)") {
		@Override
		public BigDecimal toMpgUS(BigDecimal fc) {
			return fc;
		}

		@Override
		public BigDecimal toMpgImp(BigDecimal fc) {
			return fc.multiply(MPG_US_TO_KM_PER_LITER).multiply(
					KM_PER_LITER_TO_MPG_IMP);
		}

		@Override
		public BigDecimal toKmPerLiter(BigDecimal fc) {
			return fc.multiply(MPG_US_TO_KM_PER_LITER);
		}

		@Override
		public BigDecimal toLiterPer100Km(BigDecimal fc) {
			return KM_PER_LITER.toLiterPer100Km(fc
					.multiply(MPG_US_TO_KM_PER_LITER));
		}

		@Override
		public BigDecimal convert(BigDecimal sourceFuelConsumption,
				FuelConsumptionUnit sourceUnit) {
			return sourceUnit.toMpgUS(sourceFuelConsumption);
		}
	},
	MPG_IMP("MPG (imp.)") {
		@Override
		public BigDecimal toMpgUS(BigDecimal fc) {
			return fc.multiply(MPG_IMP_TO_KM_PER_LITER).multiply(
					KM_PER_LITER_TO_MPG_US);
		}

		@Override
		public BigDecimal toMpgImp(BigDecimal fc) {
			return fc;
		}

		@Override
		public BigDecimal toKmPerLiter(BigDecimal fc) {
			return fc.multiply(MPG_IMP_TO_KM_PER_LITER);
		}

		@Override
		public BigDecimal toLiterPer100Km(BigDecimal fc) {
			return KM_PER_LITER.toLiterPer100Km(fc
					.multiply(MPG_IMP_TO_KM_PER_LITER));
		}

		@Override
		public BigDecimal convert(BigDecimal sourceFuelConsumption,
				FuelConsumptionUnit sourceUnit) {
			return sourceUnit.toMpgImp(sourceFuelConsumption);
		}
	},
	KM_PER_LITER("Km/liter") {
		@Override
		public BigDecimal toMpgUS(BigDecimal fc) {
			return fc.multiply(KM_PER_LITER_TO_MPG_US);
		}

		@Override
		public BigDecimal toMpgImp(BigDecimal fc) {
			return fc.multiply(KM_PER_LITER_TO_MPG_IMP);
		}

		@Override
		public BigDecimal toKmPerLiter(BigDecimal fc) {
			return fc;
		}

		@Override
		public BigDecimal toLiterPer100Km(BigDecimal fc) {
			return BigDecimal.valueOf(100).divide(fc, MathContext.DECIMAL128);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceFuelConsumption,
				FuelConsumptionUnit sourceUnit) {
			return sourceUnit.toKmPerLiter(sourceFuelConsumption);
		}
	},
	LITER_PER_100KM("Liter/100km") {
		@Override
		public BigDecimal toMpgUS(BigDecimal fc) {
			return toKmPerLiter(fc).multiply(KM_PER_LITER_TO_MPG_US);
		}

		@Override
		public BigDecimal toMpgImp(BigDecimal fc) {
			return toKmPerLiter(fc).multiply(KM_PER_LITER_TO_MPG_IMP);
		}

		@Override
		public BigDecimal toKmPerLiter(BigDecimal fc) {
			return BigDecimal.valueOf(100).divide(fc);
		}

		@Override
		public BigDecimal toLiterPer100Km(BigDecimal fc) {
			return fc;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceFuelConsumption,
				FuelConsumptionUnit sourceUnit) {
			return sourceUnit.toLiterPer100Km(sourceFuelConsumption);
		}
	};

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

	public abstract BigDecimal toMpgUS(BigDecimal fc);

	public abstract BigDecimal toMpgImp(BigDecimal fc);

	public abstract BigDecimal toKmPerLiter(BigDecimal fc);

	public abstract BigDecimal toLiterPer100Km(BigDecimal fc);

	public abstract BigDecimal convert(BigDecimal sourceFuelConsumption,
			FuelConsumptionUnit sourceUnit);

	private static final BigDecimal KM_PER_LITER_TO_MPG_US = BigDecimal
			.valueOf(2.35215);
	private static final BigDecimal KM_PER_LITER_TO_MPG_IMP = BigDecimal
			.valueOf(2.82481);

	private static final BigDecimal MPG_US_TO_KM_PER_LITER = BigDecimal
			.valueOf(0.425144);
	private static final BigDecimal MPG_IMP_TO_KM_PER_LITER = BigDecimal
			.valueOf(0.354006);

}
