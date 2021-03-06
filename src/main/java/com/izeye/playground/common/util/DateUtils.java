package com.izeye.playground.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;

public class DateUtils {

	private static final ThreadLocal<SimpleDateFormat> DEFAULT_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

	private static final ThreadLocal<SimpleDateFormat> DEFAULT_DATE_TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	public static String formatDate(Date date) {
		return DEFAULT_DATE_FORMAT.get().format(date);
	}

	public static String formatDate(long timestamp) {
		return DEFAULT_DATE_FORMAT.get().format(new Date(timestamp));
	}

	public static String formatDateTime(Date date) {
		return DEFAULT_DATE_TIME_FORMAT.get().format(date);
	}

	public static String formatDateTime(long timestamp) {
		return DEFAULT_DATE_TIME_FORMAT.get().format(new Date(timestamp));
	}

	public static Date parseDate(String date) {
		try {
			return DEFAULT_DATE_FORMAT.get().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String getToday() {
		return DateUtils.formatDate(new Date());
	}

	public static String getYesterday() {
		return DateUtils.formatDate(new DateTime().minusDays(1).toDate());
	}

	public static boolean isToday(Date date) {
		return formatDate(date).equals(formatDate(new Date()));
	}

	public static int getThisYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

}
