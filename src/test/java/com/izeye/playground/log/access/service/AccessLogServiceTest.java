package com.izeye.playground.log.access.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccessLogServiceTest {

	@Resource
	private AccessLogService accessLogService;

	@Test
	public void log() {
		String ip = "1.2.3.4";
		String url = "http://izeye.cafe24.com";
		String userAgent = "userAgent";
		String referer = "http://devday.tistory.com";

		accessLogService.log(ip, url, userAgent, referer);
	}

}
