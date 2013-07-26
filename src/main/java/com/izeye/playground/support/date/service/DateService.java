package com.izeye.playground.support.date.service;

import java.text.ParseException;
import java.util.Date;

public interface DateService {

	Date timestampToDate(long timestamp);

	Date timestampInSecondsToDate(long timestampInSeconds);

	String timestampToFormattedDate(long timestamp);

	String timestampInSecondsToFormattedDate(long timestampInSeconds);

	String format(Date date);

	long formattedDateToTimestamp(String formattedDate) throws ParseException;

	long formattedDateToTimestampInSeconds(String formattedDate)
			throws ParseException;

}
