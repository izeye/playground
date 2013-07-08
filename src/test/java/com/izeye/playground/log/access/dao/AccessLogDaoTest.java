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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("unittest")
public class AccessLogDaoTest {

	@Resource
	private AccessLogDao accessLogDao;

	@Test
	public void insert() {
		Date accessTime = new Date();
		String ip = "1.2.3.4";
		String url = "http://izeye.cafe24.com";
		String userAgent = "userAgent";
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

}
