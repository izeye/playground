package com.izeye.playground.support.daum.domain;

import java.util.HashMap;
import java.util.Map;

public enum MypeopleBotCallbackAction {

	ADD_BUDDY("addBuddy"), //
	SEND_FROM_MESSAGE("sendFromMessage"), //
	SEND_FROM_GROUP("sendFromGroup"), //
	CREATE_GROUP("createGroup"), //
	INVITE_TO_GROUP("inviteToGroup"), //
	EXIT_FROM_GROUP("exitFromGroup"), //
	HELP_FROM_MESSAGE("helpFromMessage"), //
	HELP_FROM_GROUP("helpFromGroup"), //
	EXIT_BOT("exitBot");

	private static final Map<String, MypeopleBotCallbackAction> valueAndCallbackActionMap = new HashMap<String, MypeopleBotCallbackAction>();
	static {
		for (MypeopleBotCallbackAction callbackAction : values()) {
			valueAndCallbackActionMap.put(callbackAction.getValue(),
					callbackAction);
		}
	}

	private final String value;

	private MypeopleBotCallbackAction(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static MypeopleBotCallbackAction getByValue(String value) {
		MypeopleBotCallbackAction callbackAction = valueAndCallbackActionMap
				.get(value);
		if (callbackAction == null) {
			throw new MypeopleBotException("Unexpected action: " + value);
		}
		return callbackAction;
	}

}
