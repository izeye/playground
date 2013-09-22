package learningtest.java.text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class SimpleDateFormatTest {

	// Sat, 21 Sep 2013 21:05:13 +0900
	@Test
	public void format() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"EEE, d MMM yyyy HH:mm:ss Z", Locale.US);
		System.out.println(dateFormat.format(new Date()));
	}

}
