package com.izeye.playground.support.ua.service.browser;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.service.browser.ProductBasedBrowserInfoParser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("unittest")
public class ProductBasedBrowserInfoParserTest {

	@Resource
	private ProductBasedBrowserInfoParser productBasedBrowserInfoParser;

	@Test
	public void parse() {
		String browserInfoInUserAgent = "Chrome/28.0.1500.71";
		BrowserInfo browserInfo = productBasedBrowserInfoParser
				.parse(browserInfoInUserAgent);
		System.out.println(browserInfo);
	}

}
