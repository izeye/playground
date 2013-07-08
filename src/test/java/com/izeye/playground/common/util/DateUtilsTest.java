package com.izeye.playground.common.util;

import java.util.Date;

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

}
