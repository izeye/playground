package com.izeye.playground.support.date.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service("dateService")
public class DefaultDateService implements DateService {

	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		}
	};

	@Override
	public Date timestampToDate(long timestamp) {
		return new Date(timestamp);
	}

	@Override
	public Date timestampInSecondsToDate(long timestampInSeconds) {
		return timestampToDate(TimeUnit.SECONDS.toMillis(timestampInSeconds));
	}

	@Override
	public String timestampToFormattedDate(long timestamp) {
		return format(timestampToDate(timestamp));
	}

	@Override
	public String timestampInSecondsToFormattedDate(long timestampInSeconds) {
		return timestampToFormattedDate(TimeUnit.SECONDS
				.toMillis(timestampInSeconds));
	}

	@Override
	public String format(Date date) {
		return dateFormat.get().format(date);
	}

	@Override
	public long formattedDateToTimestamp(String formattedDate)
			throws ParseException {
		return dateFormat.get().parse(formattedDate).getTime();
	}

	@Override
	public long formattedDateToTimestampInSeconds(String formattedDate)
			throws ParseException {
		return TimeUnit.MILLISECONDS
				.toSeconds(formattedDateToTimestamp(formattedDate));
	}

}
