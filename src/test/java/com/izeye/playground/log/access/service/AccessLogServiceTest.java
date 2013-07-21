package com.izeye.playground.log.access.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.log.access.domain.AccessLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
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

	@Test
	public void getAllAccessLogs() {
		List<AccessLog> allAccessLogs = accessLogService.getAllAccessLogs();
		System.out.println(allAccessLogs);
	}

}
