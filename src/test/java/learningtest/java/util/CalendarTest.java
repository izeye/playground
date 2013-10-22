package learningtest.java.util;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.junit.Test;

public class CalendarTest {

	@Test
	public void dayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, 8); // 9
		calendar.set(Calendar.DAY_OF_MONTH, 6);
		assertThat(calendar.get(Calendar.DAY_OF_WEEK), is(Calendar.FRIDAY));
	}

	@Test
	public void getInstance() {
		assertThat(Calendar.getInstance(),
				is(not(sameInstance(Calendar.getInstance()))));
	}

}
