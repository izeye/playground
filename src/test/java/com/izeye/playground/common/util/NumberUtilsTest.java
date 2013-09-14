package com.izeye.playground.common.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NumberUtilsTest {

	@Test
	public void format() {
		String expected = "123,456,789";
		long number = 123456789;
		assertThat(NumberUtils.format(number), is(expected));
	}

}
