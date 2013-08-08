package com.izeye.playground.support.math.base.domain;

public enum Base {

	BINARY("Binary", 2) {
		@Override
		public String toBinary(String value) {
			return value;
		}

		@Override
		public String toOctal(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.OCTAL.getBase());
		}

		@Override
		public String toDecimal(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.DECIMAL.getBase());
		}

		@Override
		public String toHexadecimal(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.HEXADECIMAL.getBase());
		}

		@Override
		public String convert(String sourceValue, Base sourceBase) {
			return sourceBase.toBinary(sourceValue);
		}
	},
	OCTAL("Octal", 8) {
		@Override
		public String toBinary(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.BINARY.getBase());
		}

		@Override
		public String toOctal(String value) {
			return value;
		}

		@Override
		public String toDecimal(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.DECIMAL.getBase());
		}

		@Override
		public String toHexadecimal(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.HEXADECIMAL.getBase());
		}

		@Override
		public String convert(String sourceValue, Base sourceBase) {
			return sourceBase.toOctal(sourceValue);
		}
	},
	DECIMAL("Decimal", 10) {
		@Override
		public String toBinary(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.BINARY.getBase());
		}

		@Override
		public String toOctal(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.OCTAL.getBase());
		}

		@Override
		public String toDecimal(String value) {
			return value;
		}

		@Override
		public String toHexadecimal(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.HEXADECIMAL.getBase());
		}

		@Override
		public String convert(String sourceValue, Base sourceBase) {
			return sourceBase.toDecimal(sourceValue);
		}
	},
	HEXADECIMAL("Hexadecimal", 16) {
		@Override
		public String toBinary(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.BINARY.getBase());
		}

		@Override
		public String toOctal(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.OCTAL.getBase());
		}

		@Override
		public String toDecimal(String value) {
			return Long.toString(Long.valueOf(value, getBase()),
					Base.DECIMAL.getBase());
		}

		@Override
		public String toHexadecimal(String value) {
			return value;
		}

		@Override
		public String convert(String sourceValue, Base sourceBase) {
			return sourceBase.toHexadecimal(sourceValue);
		}
	};

	private final String name;
	private final int base;
	private final String displayName;

	private Base(String name, int base) {
		this.name = name;
		this.base = base;
		this.displayName = name + " (" + base + ")";
	}

	public String getName() {
		return name;
	}

	public int getBase() {
		return base;
	}

	public String getDisplayName() {
		return displayName;
	}

	public abstract String toBinary(String value);

	public abstract String toOctal(String value);

	public abstract String toDecimal(String value);

	public abstract String toHexadecimal(String value);

	public abstract String convert(String sourceValue, Base sourceBase);

}
