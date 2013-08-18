package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum DigitalStorageUnit implements Unit<DigitalStorageUnit> {

	BIT("Bit") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(TO_KILO);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(TO_KILO).multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(TO_MEGA);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(TO_MEGA).multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(TO_GIGA);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(TO_GIGA).multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(TO_TERA);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(TO_TERA).multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(TO_PETA);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(TO_PETA).multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toBit(sourceDigitalStorage);
		}
	},
	BYTE("Byte") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(TO_KILO).multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(TO_KILO);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(TO_MEGA).multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(TO_MEGA);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(TO_GIGA).multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(TO_GIGA);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(TO_TERA).multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(TO_TERA);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(TO_PETA).multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(TO_PETA);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toByte(sourceDigitalStorage);
		}
	},
	KILOBIT("Kilobit") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(FROM_KILO);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_MEGA);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_MEGA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_GIGA);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_GIGA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_TERA);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_TERA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_PETA);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_PETA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toKilobit(sourceDigitalStorage);
		}
	},
	KILOBYTE("Kilobyte") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(FROM_KILO);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_MEGA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_MEGA);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_GIGA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_GIGA);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_TERA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_TERA);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_PETA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(FROM_KILO).multiply(TO_PETA);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toKilobyte(sourceDigitalStorage);
		}
	},
	MEGABIT("Megabit") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(FROM_MEGA);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_KILO);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_KILO)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_GIGA);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_GIGA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_TERA);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_TERA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_PETA);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_PETA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toMegabit(sourceDigitalStorage);
		}
	},
	MEGABYTE("Megabyte") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(FROM_MEGA);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_KILO)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_KILO);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_GIGA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_GIGA);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_TERA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_TERA);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_PETA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(FROM_MEGA).multiply(TO_PETA);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toMegabyte(sourceDigitalStorage);
		}
	},
	GIGABIT("Gigabit") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(FROM_GIGA);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_KILO);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_KILO)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_MEGA);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_MEGA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_TERA);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_TERA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_PETA);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_PETA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toGigabit(sourceDigitalStorage);
		}
	},
	GIGABYTE("Gigabyte") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(FROM_GIGA);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_KILO)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_KILO);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_MEGA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_MEGA);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_TERA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_TERA);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_PETA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(FROM_GIGA).multiply(TO_PETA);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toGigabyte(sourceDigitalStorage);
		}
	},
	TERABIT("Terabit") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(FROM_TERA);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_KILO);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_KILO)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_MEGA);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_MEGA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_GIGA);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_GIGA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_PETA);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_PETA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toTerabit(sourceDigitalStorage);
		}
	},
	TERABYTE("Terabyte") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(FROM_TERA);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_KILO)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_KILO);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_MEGA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_MEGA);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_GIGA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_GIGA);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_PETA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(FROM_TERA).multiply(TO_PETA);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toTerabyte(sourceDigitalStorage);
		}
	},
	PETABIT("Petabit") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(FROM_PETA);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_KILO);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_KILO)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_MEGA);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_MEGA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_GIGA);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_GIGA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_TERA);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_TERA)
					.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds.multiply(BIT_TO_BYTE);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toPetabit(sourceDigitalStorage);
		}
	},
	PETABYTE("Petabyte") {
		@Override
		public BigDecimal toBit(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toByte(BigDecimal ds) {
			return ds.multiply(FROM_PETA);
		}

		@Override
		public BigDecimal toKilobit(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_KILO)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toKilobyte(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_KILO);
		}

		@Override
		public BigDecimal toMegabit(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_MEGA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toMegabyte(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_MEGA);
		}

		@Override
		public BigDecimal toGigabit(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_GIGA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toGigabyte(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_GIGA);
		}

		@Override
		public BigDecimal toTerabit(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_TERA)
					.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toTerabyte(BigDecimal ds) {
			return ds.multiply(FROM_PETA).multiply(TO_TERA);
		}

		@Override
		public BigDecimal toPetabit(BigDecimal ds) {
			return ds.multiply(BYTE_TO_BIT);
		}

		@Override
		public BigDecimal toPetabyte(BigDecimal ds) {
			return ds;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceDigitalStorage,
				DigitalStorageUnit sourceUnit) {
			return sourceUnit.toPetabyte(sourceDigitalStorage);
		}
	};

	private final String name;

	private DigitalStorageUnit(String name) {
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

	public abstract BigDecimal toBit(BigDecimal ds);

	public abstract BigDecimal toByte(BigDecimal ds);

	public abstract BigDecimal toKilobit(BigDecimal ds);

	public abstract BigDecimal toKilobyte(BigDecimal ds);

	public abstract BigDecimal toMegabit(BigDecimal ds);

	public abstract BigDecimal toMegabyte(BigDecimal ds);

	public abstract BigDecimal toGigabit(BigDecimal ds);

	public abstract BigDecimal toGigabyte(BigDecimal ds);

	public abstract BigDecimal toTerabit(BigDecimal ds);

	public abstract BigDecimal toTerabyte(BigDecimal ds);

	public abstract BigDecimal toPetabit(BigDecimal ds);

	public abstract BigDecimal toPetabyte(BigDecimal ds);

	public abstract BigDecimal convert(BigDecimal sourceDigitalStorage,
			DigitalStorageUnit sourceUnit);

	private static final BigDecimal BYTE_TO_BIT = BigDecimal.valueOf(8);
	private static final BigDecimal BIT_TO_BYTE = BigDecimal.ONE
			.divide(BYTE_TO_BIT);

	private static final BigDecimal FROM_KILO = BigDecimal.valueOf(Math.pow(2,
			10));
	private static final BigDecimal FROM_MEGA = BigDecimal.valueOf(Math.pow(2,
			20));
	private static final BigDecimal FROM_GIGA = BigDecimal.valueOf(Math.pow(2,
			30));
	private static final BigDecimal FROM_TERA = BigDecimal.valueOf(Math.pow(2,
			40));
	private static final BigDecimal FROM_PETA = BigDecimal.valueOf(Math.pow(2,
			50));

	private static final BigDecimal TO_KILO = BigDecimal.ONE.divide(FROM_KILO);
	private static final BigDecimal TO_MEGA = BigDecimal.ONE.divide(FROM_MEGA);
	private static final BigDecimal TO_GIGA = BigDecimal.ONE.divide(FROM_GIGA);
	private static final BigDecimal TO_TERA = BigDecimal.ONE.divide(FROM_TERA);
	private static final BigDecimal TO_PETA = BigDecimal.ONE.divide(FROM_PETA);

}
