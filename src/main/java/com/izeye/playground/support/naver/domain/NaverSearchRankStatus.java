package com.izeye.playground.support.naver.domain;

import java.util.HashMap;
import java.util.Map;

public enum NaverSearchRankStatus {

	PLUS("+", "↑"), MINUS("-", "↓"), IN_PLACE(".", "-"), NEW("new", "New");

	private static final Map<String, NaverSearchRankStatus> valueAndStatusMap = new HashMap<String, NaverSearchRankStatus>();
	static {
		for (NaverSearchRankStatus status : values()) {
			valueAndStatusMap.put(status.getValue(), status);
		}
	}

	private final String value;
	private final String displayValue;

	private NaverSearchRankStatus(String value, String displayValue) {
		this.value = value;
		this.displayValue = displayValue;
	}

	public String getValue() {
		return value;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getFormattedValue(int variance) {
		switch (this) {
		case PLUS:
		case MINUS:
			return getDisplayValue() + variance;

		case IN_PLACE:
		case NEW:
			return getDisplayValue();

		default:
			throw new IllegalStateException("Unexpected type: " + this);
		}
	}

	public static NaverSearchRankStatus getStatusByValue(String value) {
		return valueAndStatusMap.get(value);
	}

}
