package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum MassUnit implements Unit<MassUnit> {

	METRIC_TON("Metric ton") {
		@Override
		public BigDecimal toMetricTon(BigDecimal m) {
			return m;
		}

		@Override
		public BigDecimal toKilogram(BigDecimal m) {
			return m.multiply(METRIC_TON_TO_GRAM).multiply(GRAM_TO_KILOGRAM);
		}

		@Override
		public BigDecimal toGram(BigDecimal m) {
			return m.multiply(METRIC_TON_TO_GRAM);
		}

		@Override
		public BigDecimal toMilligram(BigDecimal m) {
			return m.multiply(METRIC_TON_TO_GRAM).multiply(GRAM_TO_MILLIGRAM);
		}

		@Override
		public BigDecimal toMcg(BigDecimal m) {
			return m.multiply(METRIC_TON_TO_GRAM).multiply(GRAM_TO_MCG);
		}

		@Override
		public BigDecimal toLongTon(BigDecimal m) {
			return m.multiply(METRIC_TON_TO_GRAM).multiply(GRAM_TO_LONG_TON);
		}

		@Override
		public BigDecimal toShortTon(BigDecimal m) {
			return m.multiply(METRIC_TON_TO_GRAM).multiply(GRAM_TO_SHORT_TON);
		}

		@Override
		public BigDecimal toStone(BigDecimal m) {
			return m.multiply(METRIC_TON_TO_GRAM).multiply(GRAM_TO_STONE);
		}

		@Override
		public BigDecimal toPound(BigDecimal m) {
			return m.multiply(METRIC_TON_TO_GRAM).multiply(GRAM_TO_POUND);
		}

		@Override
		public BigDecimal toOunce(BigDecimal m) {
			return m.multiply(METRIC_TON_TO_GRAM).multiply(GRAM_TO_OUNCE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
			return sourceUnit.toMetricTon(sourceMass);
		}
	},
	KILOGRAM("Kilogram") {
		@Override
		public BigDecimal toMetricTon(BigDecimal m) {
			return m.multiply(KILOGRAM_TO_GRAM).multiply(GRAM_TO_METRIC_TON);
		}

		@Override
		public BigDecimal toKilogram(BigDecimal m) {
			return m;
		}

		@Override
		public BigDecimal toGram(BigDecimal m) {
			return m.multiply(KILOGRAM_TO_GRAM);
		}

		@Override
		public BigDecimal toMilligram(BigDecimal m) {
			return m.multiply(KILOGRAM_TO_GRAM).multiply(GRAM_TO_MILLIGRAM);
		}

		@Override
		public BigDecimal toMcg(BigDecimal m) {
			return m.multiply(KILOGRAM_TO_GRAM).multiply(GRAM_TO_MCG);
		}

		@Override
		public BigDecimal toLongTon(BigDecimal m) {
			return m.multiply(KILOGRAM_TO_GRAM).multiply(GRAM_TO_LONG_TON);
		}

		@Override
		public BigDecimal toShortTon(BigDecimal m) {
			return m.multiply(KILOGRAM_TO_GRAM).multiply(GRAM_TO_SHORT_TON);
		}

		@Override
		public BigDecimal toStone(BigDecimal m) {
			return m.multiply(KILOGRAM_TO_GRAM).multiply(GRAM_TO_STONE);
		}

		@Override
		public BigDecimal toPound(BigDecimal m) {
			return m.multiply(KILOGRAM_TO_GRAM).multiply(GRAM_TO_POUND);
		}

		@Override
		public BigDecimal toOunce(BigDecimal m) {
			return m.multiply(KILOGRAM_TO_GRAM).multiply(GRAM_TO_OUNCE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
			return sourceUnit.toKilogram(sourceMass);
		}
	},
	GRAM("Gram") {
		@Override
		public BigDecimal toMetricTon(BigDecimal m) {
			return m.multiply(GRAM_TO_METRIC_TON);
		}

		@Override
		public BigDecimal toKilogram(BigDecimal m) {
			return m.multiply(GRAM_TO_KILOGRAM);
		}

		@Override
		public BigDecimal toGram(BigDecimal m) {
			return m;
		}

		@Override
		public BigDecimal toMilligram(BigDecimal m) {
			return m.multiply(GRAM_TO_MILLIGRAM);
		}

		@Override
		public BigDecimal toMcg(BigDecimal m) {
			return m.multiply(GRAM_TO_MCG);
		}

		@Override
		public BigDecimal toLongTon(BigDecimal m) {
			return m.multiply(GRAM_TO_LONG_TON);
		}

		@Override
		public BigDecimal toShortTon(BigDecimal m) {
			return m.multiply(GRAM_TO_SHORT_TON);
		}

		@Override
		public BigDecimal toStone(BigDecimal m) {
			return m.multiply(GRAM_TO_STONE);
		}

		@Override
		public BigDecimal toPound(BigDecimal m) {
			return m.multiply(GRAM_TO_POUND);
		}

		@Override
		public BigDecimal toOunce(BigDecimal m) {
			return m.multiply(GRAM_TO_OUNCE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
			return sourceUnit.toGram(sourceMass);
		}
	},
	MILLIGRAM("Milligram") {
		@Override
		public BigDecimal toMetricTon(BigDecimal m) {
			return m.multiply(MILLIGRAM_TO_GRAM).multiply(GRAM_TO_METRIC_TON);
		}

		@Override
		public BigDecimal toKilogram(BigDecimal m) {
			return m.multiply(MILLIGRAM_TO_GRAM).multiply(GRAM_TO_KILOGRAM);
		}

		@Override
		public BigDecimal toGram(BigDecimal m) {
			return m.multiply(MILLIGRAM_TO_GRAM);
		}

		@Override
		public BigDecimal toMilligram(BigDecimal m) {
			return m;
		}

		@Override
		public BigDecimal toMcg(BigDecimal m) {
			return m.multiply(MILLIGRAM_TO_GRAM).multiply(GRAM_TO_MCG);
		}

		@Override
		public BigDecimal toLongTon(BigDecimal m) {
			return m.multiply(MILLIGRAM_TO_GRAM).multiply(GRAM_TO_LONG_TON);
		}

		@Override
		public BigDecimal toShortTon(BigDecimal m) {
			return m.multiply(MILLIGRAM_TO_GRAM).multiply(GRAM_TO_SHORT_TON);
		}

		@Override
		public BigDecimal toStone(BigDecimal m) {
			return m.multiply(MILLIGRAM_TO_GRAM).multiply(GRAM_TO_STONE);
		}

		@Override
		public BigDecimal toPound(BigDecimal m) {
			return m.multiply(MILLIGRAM_TO_GRAM).multiply(GRAM_TO_POUND);
		}

		@Override
		public BigDecimal toOunce(BigDecimal m) {
			return m.multiply(MILLIGRAM_TO_GRAM).multiply(GRAM_TO_OUNCE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
			return sourceUnit.toMilligram(sourceMass);
		}
	},
	MCG("Mcg") {
		@Override
		public BigDecimal toMetricTon(BigDecimal m) {
			return m.multiply(MCG_TO_GRAM).multiply(GRAM_TO_METRIC_TON);
		}

		@Override
		public BigDecimal toKilogram(BigDecimal m) {
			return m.multiply(MCG_TO_GRAM).multiply(GRAM_TO_KILOGRAM);
		}

		@Override
		public BigDecimal toGram(BigDecimal m) {
			return m.multiply(MCG_TO_GRAM);
		}

		@Override
		public BigDecimal toMilligram(BigDecimal m) {
			return m.multiply(MCG_TO_GRAM).multiply(GRAM_TO_MILLIGRAM);
		}

		@Override
		public BigDecimal toMcg(BigDecimal m) {
			return m;
		}

		@Override
		public BigDecimal toLongTon(BigDecimal m) {
			return m.multiply(MCG_TO_GRAM).multiply(GRAM_TO_LONG_TON);
		}

		@Override
		public BigDecimal toShortTon(BigDecimal m) {
			return m.multiply(MCG_TO_GRAM).multiply(GRAM_TO_SHORT_TON);
		}

		@Override
		public BigDecimal toStone(BigDecimal m) {
			return m.multiply(MCG_TO_GRAM).multiply(GRAM_TO_STONE);
		}

		@Override
		public BigDecimal toPound(BigDecimal m) {
			return m.multiply(MCG_TO_GRAM).multiply(GRAM_TO_POUND);
		}

		@Override
		public BigDecimal toOunce(BigDecimal m) {
			return m.multiply(MCG_TO_GRAM).multiply(GRAM_TO_OUNCE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
			return sourceUnit.toMcg(sourceMass);
		}
	},
	LONG_TON("Long ton") {
		@Override
		public BigDecimal toMetricTon(BigDecimal m) {
			return m.multiply(LONG_TON_TO_GRAM).multiply(GRAM_TO_METRIC_TON);
		}

		@Override
		public BigDecimal toKilogram(BigDecimal m) {
			return m.multiply(LONG_TON_TO_GRAM).multiply(GRAM_TO_KILOGRAM);
		}

		@Override
		public BigDecimal toGram(BigDecimal m) {
			return m.multiply(LONG_TON_TO_GRAM);
		}

		@Override
		public BigDecimal toMilligram(BigDecimal m) {
			return m.multiply(LONG_TON_TO_GRAM).multiply(GRAM_TO_MILLIGRAM);
		}

		@Override
		public BigDecimal toMcg(BigDecimal m) {
			return m.multiply(LONG_TON_TO_GRAM).multiply(GRAM_TO_MCG);
		}

		@Override
		public BigDecimal toLongTon(BigDecimal m) {
			return m;
		}

		@Override
		public BigDecimal toShortTon(BigDecimal m) {
			return m.multiply(LONG_TON_TO_GRAM).multiply(GRAM_TO_SHORT_TON);
		}

		@Override
		public BigDecimal toStone(BigDecimal m) {
			return m.multiply(LONG_TON_TO_GRAM).multiply(GRAM_TO_STONE);
		}

		@Override
		public BigDecimal toPound(BigDecimal m) {
			return m.multiply(LONG_TON_TO_GRAM).multiply(GRAM_TO_POUND);
		}

		@Override
		public BigDecimal toOunce(BigDecimal m) {
			return m.multiply(LONG_TON_TO_GRAM).multiply(GRAM_TO_OUNCE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
			return sourceUnit.toLongTon(sourceMass);
		}
	},
	SHORT_TON("Short ton") {
		@Override
		public BigDecimal toMetricTon(BigDecimal m) {
			return m.multiply(SHORT_TON_TO_GRAM).multiply(GRAM_TO_METRIC_TON);
		}

		@Override
		public BigDecimal toKilogram(BigDecimal m) {
			return m.multiply(SHORT_TON_TO_GRAM).multiply(GRAM_TO_KILOGRAM);
		}

		@Override
		public BigDecimal toGram(BigDecimal m) {
			return m.multiply(SHORT_TON_TO_GRAM);
		}

		@Override
		public BigDecimal toMilligram(BigDecimal m) {
			return m.multiply(SHORT_TON_TO_GRAM).multiply(GRAM_TO_MILLIGRAM);
		}

		@Override
		public BigDecimal toMcg(BigDecimal m) {
			return m.multiply(SHORT_TON_TO_GRAM).multiply(GRAM_TO_MCG);
		}

		@Override
		public BigDecimal toLongTon(BigDecimal m) {
			return m.multiply(SHORT_TON_TO_GRAM).multiply(GRAM_TO_LONG_TON);
		}

		@Override
		public BigDecimal toShortTon(BigDecimal m) {
			return m;
		}

		@Override
		public BigDecimal toStone(BigDecimal m) {
			return m.multiply(SHORT_TON_TO_GRAM).multiply(GRAM_TO_STONE);
		}

		@Override
		public BigDecimal toPound(BigDecimal m) {
			return m.multiply(SHORT_TON_TO_GRAM).multiply(GRAM_TO_POUND);
		}

		@Override
		public BigDecimal toOunce(BigDecimal m) {
			return m.multiply(SHORT_TON_TO_GRAM).multiply(GRAM_TO_OUNCE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
			return sourceUnit.toShortTon(sourceMass);
		}
	},
	STONE("Stone") {
		@Override
		public BigDecimal toMetricTon(BigDecimal m) {
			return m.multiply(STONE_TO_GRAM).multiply(GRAM_TO_METRIC_TON);
		}

		@Override
		public BigDecimal toKilogram(BigDecimal m) {
			return m.multiply(STONE_TO_GRAM).multiply(GRAM_TO_KILOGRAM);
		}

		@Override
		public BigDecimal toGram(BigDecimal m) {
			return m.multiply(STONE_TO_GRAM);
		}

		@Override
		public BigDecimal toMilligram(BigDecimal m) {
			return m.multiply(STONE_TO_GRAM).multiply(GRAM_TO_MILLIGRAM);
		}

		@Override
		public BigDecimal toMcg(BigDecimal m) {
			return m.multiply(STONE_TO_GRAM).multiply(GRAM_TO_MCG);
		}

		@Override
		public BigDecimal toLongTon(BigDecimal m) {
			return m.multiply(STONE_TO_GRAM).multiply(GRAM_TO_LONG_TON);
		}

		@Override
		public BigDecimal toShortTon(BigDecimal m) {
			return m.multiply(STONE_TO_GRAM).multiply(GRAM_TO_SHORT_TON);
		}

		@Override
		public BigDecimal toStone(BigDecimal m) {
			return m;
		}

		@Override
		public BigDecimal toPound(BigDecimal m) {
			return m.multiply(STONE_TO_GRAM).multiply(GRAM_TO_POUND);
		}

		@Override
		public BigDecimal toOunce(BigDecimal m) {
			return m.multiply(STONE_TO_GRAM).multiply(GRAM_TO_OUNCE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
			return sourceUnit.toStone(sourceMass);
		}
	},
	POUND("Pound") {
		@Override
		public BigDecimal toMetricTon(BigDecimal m) {
			return m.multiply(POUND_TO_GRAM).multiply(GRAM_TO_METRIC_TON);
		}

		@Override
		public BigDecimal toKilogram(BigDecimal m) {
			return m.multiply(POUND_TO_GRAM).multiply(GRAM_TO_KILOGRAM);
		}

		@Override
		public BigDecimal toGram(BigDecimal m) {
			return m.multiply(POUND_TO_GRAM);
		}

		@Override
		public BigDecimal toMilligram(BigDecimal m) {
			return m.multiply(POUND_TO_GRAM).multiply(GRAM_TO_MILLIGRAM);
		}

		@Override
		public BigDecimal toMcg(BigDecimal m) {
			return m.multiply(POUND_TO_GRAM).multiply(GRAM_TO_MCG);
		}

		@Override
		public BigDecimal toLongTon(BigDecimal m) {
			return m.multiply(POUND_TO_GRAM).multiply(GRAM_TO_LONG_TON);
		}

		@Override
		public BigDecimal toShortTon(BigDecimal m) {
			return m.multiply(POUND_TO_GRAM).multiply(GRAM_TO_SHORT_TON);
		}

		@Override
		public BigDecimal toStone(BigDecimal m) {
			return m.multiply(POUND_TO_GRAM).multiply(GRAM_TO_STONE);
		}

		@Override
		public BigDecimal toPound(BigDecimal m) {
			return m;
		}

		@Override
		public BigDecimal toOunce(BigDecimal m) {
			return m.multiply(POUND_TO_GRAM).multiply(GRAM_TO_OUNCE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
			return sourceUnit.toPound(sourceMass);
		}
	},
	OUNCE("Ounce") {
		@Override
		public BigDecimal toMetricTon(BigDecimal m) {
			return m.multiply(OUNCE_TO_GRAM).multiply(GRAM_TO_METRIC_TON);
		}

		@Override
		public BigDecimal toKilogram(BigDecimal m) {
			return m.multiply(OUNCE_TO_GRAM).multiply(GRAM_TO_KILOGRAM);
		}

		@Override
		public BigDecimal toGram(BigDecimal m) {
			return m.multiply(OUNCE_TO_GRAM);
		}

		@Override
		public BigDecimal toMilligram(BigDecimal m) {
			return m.multiply(OUNCE_TO_GRAM).multiply(GRAM_TO_MILLIGRAM);
		}

		@Override
		public BigDecimal toMcg(BigDecimal m) {
			return m.multiply(OUNCE_TO_GRAM).multiply(GRAM_TO_MCG);
		}

		@Override
		public BigDecimal toLongTon(BigDecimal m) {
			return m.multiply(OUNCE_TO_GRAM).multiply(GRAM_TO_LONG_TON);
		}

		@Override
		public BigDecimal toShortTon(BigDecimal m) {
			return m.multiply(OUNCE_TO_GRAM).multiply(GRAM_TO_SHORT_TON);
		}

		@Override
		public BigDecimal toStone(BigDecimal m) {
			return m.multiply(OUNCE_TO_GRAM).multiply(GRAM_TO_STONE);
		}

		@Override
		public BigDecimal toPound(BigDecimal m) {
			return m.multiply(OUNCE_TO_GRAM).multiply(GRAM_TO_POUND);
		}

		@Override
		public BigDecimal toOunce(BigDecimal m) {
			return m;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
			return sourceUnit.toOunce(sourceMass);
		}
	};

	private final String name;

	private MassUnit(String name) {
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

	public abstract BigDecimal toMetricTon(BigDecimal m);

	public abstract BigDecimal toKilogram(BigDecimal m);

	public abstract BigDecimal toGram(BigDecimal m);

	public abstract BigDecimal toMilligram(BigDecimal m);

	public abstract BigDecimal toMcg(BigDecimal m);

	public abstract BigDecimal toLongTon(BigDecimal m);

	public abstract BigDecimal toShortTon(BigDecimal m);

	public abstract BigDecimal toStone(BigDecimal m);

	public abstract BigDecimal toPound(BigDecimal m);

	public abstract BigDecimal toOunce(BigDecimal m);

	public abstract BigDecimal convert(BigDecimal sourceMass,
			MassUnit sourceUnit);

	private static final BigDecimal GRAM_TO_METRIC_TON = BigDecimal
			.valueOf(0.000001);
	private static final BigDecimal GRAM_TO_KILOGRAM = BigDecimal
			.valueOf(0.001);
	private static final BigDecimal GRAM_TO_MILLIGRAM = BigDecimal
			.valueOf(1000);
	private static final BigDecimal GRAM_TO_MCG = BigDecimal.valueOf(1000000);
	private static final BigDecimal GRAM_TO_LONG_TON = BigDecimal
			.valueOf(0.00000098421);
	private static final BigDecimal GRAM_TO_SHORT_TON = BigDecimal
			.valueOf(0.0000011023);
	private static final BigDecimal GRAM_TO_STONE = BigDecimal
			.valueOf(0.000157473);
	private static final BigDecimal GRAM_TO_POUND = BigDecimal
			.valueOf(0.00220462);
	private static final BigDecimal GRAM_TO_OUNCE = BigDecimal
			.valueOf(0.035274);

	private static final BigDecimal METRIC_TON_TO_GRAM = BigDecimal
			.valueOf(1000000);
	private static final BigDecimal KILOGRAM_TO_GRAM = BigDecimal.valueOf(1000);
	private static final BigDecimal MILLIGRAM_TO_GRAM = BigDecimal
			.valueOf(0.001);
	private static final BigDecimal MCG_TO_GRAM = BigDecimal.valueOf(0.000001);
	private static final BigDecimal LONG_TON_TO_GRAM = BigDecimal
			.valueOf(1016000);
	private static final BigDecimal SHORT_TON_TO_GRAM = BigDecimal
			.valueOf(907185);
	private static final BigDecimal STONE_TO_GRAM = BigDecimal.valueOf(6350.29);
	private static final BigDecimal POUND_TO_GRAM = BigDecimal.valueOf(453.592);
	private static final BigDecimal OUNCE_TO_GRAM = BigDecimal.valueOf(28.3495);

}
