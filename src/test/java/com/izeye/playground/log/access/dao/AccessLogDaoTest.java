package com.izeye.playground.log.access.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.UserAgentCount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class AccessLogDaoTest {

	@Resource
	private AccessLogDao accessLogDao;

	@Test
	public void insert() {
		Date accessTime = new Date();
		String ip = "1.2.3.4";
		String url = "http://izeye.cafe24.com";
		// String userAgent = "userAgent";
		String userAgent = null;
		String referer = "http://devday.tistory.com";

		AccessLog log = new AccessLog();
		log.setAccessTime(accessTime);
		log.setIp(ip);
		log.setUrl(url);
		log.setUserAgent(userAgent);
		log.setReferer(referer);

		accessLogDao.insert(log);
	}

	@Test
	public void getAllAccessLogs() {
		List<AccessLog> allAccessLogs = accessLogDao.getAllAccessLogs();
		System.out.println(allAccessLogs);
	}

	@Test
	public void getAccessLogsInSpecificDate() {
		String date = "2013-07-02";
		List<AccessLog> accessLogs = accessLogDao
				.getAccessLogsInSpecificDate(date);
		System.out.println(accessLogs);

		// NOTE:
		// To check the cache.
		accessLogs = accessLogDao.getAccessLogsInSpecificDate(date);
		System.out.println(accessLogs);
	}

	@Test
	public void getDailyCounts() {
		List<DailyCount> dailyCounts = accessLogDao.getDailyCounts();
		System.out.println(dailyCounts);
	}

	@Test
	public void getUserAgentCounts() {
		List<UserAgentCount> userAgentCounts = accessLogDao
				.getUserAgentCounts();
		System.out.println(userAgentCounts);
	}

	@Test
	public void getLatestAccessLogs() {
		int count = 10;
		List<AccessLog> latestAccessLogs = accessLogDao
				.getLatestAccessLogs(count);
		System.out.println(latestAccessLogs);
	}

	@Test
	public void getLatestAccessLogsWithExclusiveBaseId() {
		long exclusiveBaseId = 100;
		int count = 10;
		List<AccessLog> latestAccessLogs = accessLogDao.getLatestAccessLogs(
				exclusiveBaseId, count);
		System.out.println(latestAccessLogs);
	}

}
