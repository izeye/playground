package com.izeye.playground.common.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class URLUtilsTest {

	@Test
	public void createURL() {
		String expectedURL = "http://whois.kisa.or.kr/openapi/whois.jsp?query=125.186.211.36&key=1234";

		String urlPrefix = "http://whois.kisa.or.kr/openapi/whois.jsp?";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("query", "125.186.211.36");
		params.put("key", "1234");
		String url = URLUtils.createURL(urlPrefix, params);

		assertThat(url, is(expectedURL));
	}

}
