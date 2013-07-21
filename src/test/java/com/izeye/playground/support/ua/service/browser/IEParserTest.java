package com.izeye.playground.support.ua.service.browser;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.ua.domain.browser.BrowserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class IEParserTest {

	@Resource
	private IEParser ieParser;

	@Test
	public void parse() {
		String browserInfoInUserAgent = "MSIE 6.0";
		BrowserInfo browserInfo = ieParser.parse(browserInfoInUserAgent);
		System.out.println(browserInfo);
	}

}
