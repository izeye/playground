package com.izeye.playground.support.ua.service.os;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.ua.domain.os.OSInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("unittest")
public class WindowsParserTest {

	@Resource
	private WindowsParser windowsParser;

	@Test
	public void parse() {
		String osInfoInUserAgent = "Windows NT 5.1";
		OSInfo osInfo = windowsParser.parse(osInfoInUserAgent);
		System.out.println(osInfo);
		System.out.println(osInfo.getDisplayName());
	}

}
