package com.izeye.playground.support.daum.service;

import com.izeye.playground.support.daum.domain.MypeopleBotCallbackAction;

public interface MypeopleBotService {

	void handleCallback(MypeopleBotCallbackAction action, String groupId,
			String buddyId, String content);

	void send(String buddyId, String content);

}
