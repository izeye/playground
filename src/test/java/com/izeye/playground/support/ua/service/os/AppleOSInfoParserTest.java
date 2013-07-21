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
@ActiveProfiles("dev")
public class AppleOSInfoParserTest {

	@Resource
	private AppleOSInfoParser macOSXParser;

	@Test
	public void parse() {
		String osInfoInUserAgent = "Intel Mac OS X 10_8_4";
		OSInfo osInfo = macOSXParser.parse(osInfoInUserAgent);
		System.out.println(osInfo);
		System.out.println(osInfo.getDisplayName());

		osInfoInUserAgent = "CPU iPhone OS 6_1_3 like Mac OS X";
		osInfo = macOSXParser.parse(osInfoInUserAgent);
		System.out.println(osInfo);
		System.out.println(osInfo.getDisplayName());
	}

}
