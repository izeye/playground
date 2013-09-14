package com.izeye.playground.common.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void formatDate() {
		Date date = new Date();
		String formattedDate = DateUtils.formatDate(date);
		System.out.println(formattedDate);
	}

	@Test
	public void parseDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, 8); // 9
		calendar.set(Calendar.DAY_OF_MONTH, 7);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date expected = calendar.getTime();

		String date = "2013-09-07";
		assertThat(DateUtils.parseDate(date), is(expected));
	}

	@Test
	public void getToday() {
		String today = DateUtils.getToday();
		System.out.println(today);
	}

	@Test
	public void getYesterday() {
		String yesterday = DateUtils.getYesterday();
		System.out.println(yesterday);
	}

	@Test
	public void isToday() {
		assertThat(DateUtils.isToday(new Date()), is(true));
		assertThat(
				DateUtils.isToday(new Date(new Date().getTime()
						- TimeUnit.DAYS.toMillis(1))), is(false));
		assertThat(
				DateUtils.isToday(new Date(new Date().getTime()
						+ TimeUnit.DAYS.toMillis(1))), is(false));
	}

	@Test
	public void getThisYear() {
		int thisYear = DateUtils.getThisYear();
		System.out.println(thisYear);
	}

}
