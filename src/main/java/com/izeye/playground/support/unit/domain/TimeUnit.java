package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum TimeUnit implements Unit<TimeUnit> {

	NANOSECOND("Nanosecond") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND).multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND).multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND).multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND).multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND).multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND).multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND).multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND).multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND).multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(NANOSECOND_TO_SECOND).multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toNanosecond(sourceTime);
		}
	},
	MICROSECOND("Microsecond") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND).multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND).multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND).multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND).multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND).multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND).multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND).multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND).multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND).multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(MICROSECOND_TO_SECOND).multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toMicrosecond(sourceTime);
		}
	},
	MILLISECOND("Millisecond") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND).multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND).multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND).multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND).multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND).multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND).multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND).multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND).multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND).multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(MILLISECOND_TO_SECOND).multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toMillisecond(sourceTime);
		}
	},
	SECOND("Second") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toSecond(sourceTime);
		}
	},
	MINUTE("Minute") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND).multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND).multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND).multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND).multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND).multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND).multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND).multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND).multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND).multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(MINUTE_TO_SECOND).multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toMinute(sourceTime);
		}
	},
	HOUR("Hour") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND).multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND).multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND).multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND).multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND).multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND).multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND).multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND).multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND).multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(HOUR_TO_SECOND).multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toHour(sourceTime);
		}
	},
	DAY("Day") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND).multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND).multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND).multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND).multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND).multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND).multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND).multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND).multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND).multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(DAY_TO_SECOND).multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toDay(sourceTime);
		}
	},
	WEEK("Week") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND).multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND).multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND).multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND).multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND).multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND).multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND).multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND).multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND).multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(WEEK_TO_SECOND).multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toWeek(sourceTime);
		}
	},
	MONTH("Month") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND).multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND).multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND).multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND).multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND).multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND).multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND).multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND).multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND).multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(MONTH_TO_SECOND).multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toMonth(sourceTime);
		}
	},
	YEAR("Year") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND).multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND).multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND).multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND).multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND).multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND).multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND).multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND).multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND).multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(YEAR_TO_SECOND).multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toYear(sourceTime);
		}
	},
	DECADE("Decade") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND).multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND).multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND).multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND).multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND).multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND).multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND).multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND).multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND).multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t.multiply(DECADE_TO_SECOND).multiply(SECOND_TO_CENTURY);
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toDecade(sourceTime);
		}
	},
	CENTURY("Century") {
		@Override
		public BigDecimal toNanosecond(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND).multiply(SECOND_TO_NANOSECOND);
		}

		@Override
		public BigDecimal toMicrosecond(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND).multiply(SECOND_TO_MICROSECOND);
		}

		@Override
		public BigDecimal toMillisecond(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND).multiply(SECOND_TO_MILLISECOND);
		}

		@Override
		public BigDecimal toSecond(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND);
		}

		@Override
		public BigDecimal toMinute(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND).multiply(SECOND_TO_MINUTE);
		}

		@Override
		public BigDecimal toHour(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND).multiply(SECOND_TO_HOUR);
		}

		@Override
		public BigDecimal toDay(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND).multiply(SECOND_TO_DAY);
		}

		@Override
		public BigDecimal toWeek(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND).multiply(SECOND_TO_WEEK);
		}

		@Override
		public BigDecimal toMonth(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND).multiply(SECOND_TO_MONTH);
		}

		@Override
		public BigDecimal toYear(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND).multiply(SECOND_TO_YEAR);
		}

		@Override
		public BigDecimal toDecade(BigDecimal t) {
			return t.multiply(CENTURY_TO_SECOND).multiply(SECOND_TO_DECADE);
		}

		@Override
		public BigDecimal toCentury(BigDecimal t) {
			return t;
		}

		@Override
		public BigDecimal convert(BigDecimal sourceTime, TimeUnit sourceUnit) {
			return sourceUnit.toCentury(sourceTime);
		}
	};

	private final String name;

	private TimeUnit(String name) {
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

	public abstract BigDecimal toNanosecond(BigDecimal t);

	public abstract BigDecimal toMicrosecond(BigDecimal t);

	public abstract BigDecimal toMillisecond(BigDecimal t);

	public abstract BigDecimal toSecond(BigDecimal t);

	public abstract BigDecimal toMinute(BigDecimal t);

	public abstract BigDecimal toHour(BigDecimal t);

	public abstract BigDecimal toDay(BigDecimal t);

	public abstract BigDecimal toWeek(BigDecimal t);

	public abstract BigDecimal toMonth(BigDecimal t);

	public abstract BigDecimal toYear(BigDecimal t);

	public abstract BigDecimal toDecade(BigDecimal t);

	public abstract BigDecimal toCentury(BigDecimal t);

	public abstract BigDecimal convert(BigDecimal sourceTime,
			TimeUnit sourceUnit);

	private static final BigDecimal SECOND_TO_NANOSECOND = BigDecimal
			.valueOf(1e+9);
	private static final BigDecimal SECOND_TO_MICROSECOND = BigDecimal
			.valueOf(1e+6);
	private static final BigDecimal SECOND_TO_MILLISECOND = BigDecimal
			.valueOf(1000);
	private static final BigDecimal SECOND_TO_MINUTE = BigDecimal.valueOf(0.0166667);
	private static final BigDecimal SECOND_TO_HOUR = BigDecimal.valueOf(0.000277778);
	private static final BigDecimal SECOND_TO_DAY = BigDecimal.valueOf(1.1574e-5);
	private static final BigDecimal SECOND_TO_WEEK = BigDecimal.valueOf(1.6534e-6);
	private static final BigDecimal SECOND_TO_MONTH = BigDecimal.valueOf(3.8027e-7);
	private static final BigDecimal SECOND_TO_YEAR = BigDecimal.valueOf(3.1689e-8);
	private static final BigDecimal SECOND_TO_DECADE = BigDecimal.valueOf(3.1689e-9);
	private static final BigDecimal SECOND_TO_CENTURY = BigDecimal.valueOf(3.1689e-10);

	private static final BigDecimal NANOSECOND_TO_SECOND = BigDecimal
			.valueOf(1e-9);
	private static final BigDecimal MICROSECOND_TO_SECOND = BigDecimal
			.valueOf(1e-6);
	private static final BigDecimal MILLISECOND_TO_SECOND = BigDecimal
			.valueOf(0.001);
	private static final BigDecimal MINUTE_TO_SECOND = BigDecimal.valueOf(60);
	private static final BigDecimal HOUR_TO_SECOND = BigDecimal.valueOf(3600);
	private static final BigDecimal DAY_TO_SECOND = BigDecimal.valueOf(86400);
	private static final BigDecimal WEEK_TO_SECOND = BigDecimal.valueOf(604800);
	private static final BigDecimal MONTH_TO_SECOND = BigDecimal.valueOf(2.63e+6);
	private static final BigDecimal YEAR_TO_SECOND = BigDecimal.valueOf(3.156e+7);
	private static final BigDecimal DECADE_TO_SECOND = BigDecimal.valueOf(3.156e+8);
	private static final BigDecimal CENTURY_TO_SECOND = BigDecimal.valueOf(3.156e+9);

}
