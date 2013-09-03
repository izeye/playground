package com.izeye.playground.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class HttpUtilsTest {

	@Test
	public void urlToInputStream() throws IOException {
		String urlAsString = "http://devday.tistory.com";
		InputStream is = HttpUtils.urlToInputStream(urlAsString);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

}
