package com.izeye.playground.log.access.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.log.access.domain.AccessLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
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

}
