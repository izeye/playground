package com.izeye.playground.common.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void joinWithArrays() {
		String expected = "1,2,3,4";

		Object[] objects = new Integer[] { 1, 2, 3, 4 };
		String joint = ",";

		assertThat(StringUtils.join(objects, joint), is(expected));
	}

	@Test
	public void joinWithList() {
		String expected = "1,2,3,4";

		List<Integer> objects = Arrays.asList(new Integer[] { 1, 2, 3, 4 });
		String joint = ",";

		assertThat(StringUtils.join(objects, joint), is(expected));
	}

}
