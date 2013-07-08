package com.izeye.playground.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

public class DateUtils {

	private static final ThreadLocal<SimpleDateFormat> DEFAULT_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		};
	};

	public static String formatDate(Date date) {
		return DEFAULT_DATE_FORMAT.get().format(date);
	}

	public static String getToday() {
		return DateUtils.formatDate(new Date());
	}

	public static String getYesterday() {
		return DateUtils.formatDate(new DateTime().minusDays(1).toDate());
	}

}
