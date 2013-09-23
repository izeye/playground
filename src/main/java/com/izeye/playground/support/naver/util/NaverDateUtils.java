package com.izeye.playground.support.naver.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NaverDateUtils {

	private static final ThreadLocal<SimpleDateFormat> NAVER_SEARCH_DATE_TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US);
		}
	};

	private static final ThreadLocal<SimpleDateFormat> NAVER_SEARCH_DATA_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd");
		}
	};

	private static final ThreadLocal<SimpleDateFormat> NAVER_SEARCH_VIEW_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy.MM.dd");
		}
	};

	public static Date parseDateTime(String dateTime) {
		try {
			return NAVER_SEARCH_DATE_TIME_FORMAT.get().parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Date parseDate(String date) {
		try {
			return NAVER_SEARCH_DATA_DATE_FORMAT.get().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String formatDate(Date date) {
		return NAVER_SEARCH_VIEW_DATE_FORMAT.get().format(date);
	}

}
