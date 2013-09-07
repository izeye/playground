package com.izeye.playground.common.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

}
