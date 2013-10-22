package com.izeye.playground.support.daum.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.daum.domain.MypeopleBotCallbackLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class MypeopleBotDaoTest {

	@Resource
	private MypeopleBotDao mypeopleBotDao;

	@Test
	public void insert() {
		String action = "action";
		String groupId = "groupId";
		String buddyId = "buddyId";
		String content = "content";
		MypeopleBotCallbackLog callbackLog = new MypeopleBotCallbackLog(action,
				groupId, buddyId, content);

		mypeopleBotDao.insert(callbackLog);
	}

}
