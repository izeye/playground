package com.izeye.playground.support.daum.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.daum.domain.MypeopleBotCallbackAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class MypeopleBotServiceTest {

	@Resource
	private MypeopleBotService mypeopleBotService;

	@Test
	public void handleCallback() {
		MypeopleBotCallbackAction action = MypeopleBotCallbackAction.ADD_BUDDY;
		String groupId = "groupId";
		String buddyId = "buddyId";
		String content = "content";

		mypeopleBotService.handleCallback(action, groupId, buddyId, content);
	}

	@Test
	public void send() {
		String buddyId = "BU__D4DjlwnuN9oUANvChDIOQ00";
		String content = "Hi.";
		mypeopleBotService.send(buddyId, content);
	}

}
