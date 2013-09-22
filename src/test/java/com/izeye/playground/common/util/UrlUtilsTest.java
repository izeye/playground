package com.izeye.playground.common.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UrlUtilsTest {

	@Test
	public void createUrl() {
		String expectedUrl = "http://whois.kisa.or.kr/openapi/whois.jsp?query=125.186.211.36&key=1234";

		String urlPrefix = "http://whois.kisa.or.kr/openapi/whois.jsp?";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("query", "125.186.211.36");
		params.put("key", "1234");
		String url = UrlUtils.createUrl(urlPrefix, params);

		assertThat(url, is(expectedUrl));
	}

	@Test
	public void getRedirectedUrl() {
		String redirectedUrl = "http://devday.tistory.com/2705";
		String url = "http://openapi.naver.com/l?AAAA3ISw6DIBAA0NPI0ijIb8Gim94DmKGaarB02mQ8vSRv9T4/bBy2CxkF8Ykh7fUl3shBF0jewaydLBKUzT4t86JzVN5M1hmxNixhJToH9RjkswP8Q+SRti/VxmOuR09pJ30D4Fh7smYAAAA=";
		assertThat(UrlUtils.getRedirectedUrl(url), is(redirectedUrl));
	}

}
