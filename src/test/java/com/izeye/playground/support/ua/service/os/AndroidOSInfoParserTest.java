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
public class AndroidOSInfoParserTest {

	@Resource
	private AndroidOSInfoParser androidOSInfoParser;

	@Test
	public void parse() {
		String osInfoInUserAgent = "Android 4.1.2";
		OSInfo osInfo = androidOSInfoParser.parse(osInfoInUserAgent);
		System.out.println(osInfo);
		System.out.println(osInfo.getDisplayName());
	}

}
