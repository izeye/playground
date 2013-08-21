package com.izeye.playground.support.keyboard.domain;

public enum KoreanKeyboardLayoutType {

	DUBEOLSIK("Dubeolsik"), SEBEOLSIK_390("Sebeolsik 390"), SEBEOLSIK_FINAL(
			"Sebeolsik Final"), SEBEOLSIK_NOSHIFT("Sebeolsik Noshift");

	private final String name;

	private KoreanKeyboardLayoutType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
