package org.joda.time;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateTimeTest {

	@Test
	public void minusDays() {
		Date date = new DateTime().minusDays(1).toDate();
		System.out.println(date);
	}

}
