package com.izeye.playground.common.util;

import java.text.NumberFormat;

public class NumberUtils {

	private static final ThreadLocal<NumberFormat> NUMBER_FORMAT = new ThreadLocal<NumberFormat>() {
		protected NumberFormat initialValue() {
			return NumberFormat.getNumberInstance();
		}
	};

	public static String format(long number) {
		return NUMBER_FORMAT.get().format(number);
	}

}
