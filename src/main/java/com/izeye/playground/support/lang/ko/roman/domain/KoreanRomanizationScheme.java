package com.izeye.playground.support.lang.ko.roman.domain;

public enum KoreanRomanizationScheme {

	REVISED_ROMANIZATION_OF_KOREAN("Revised Romanization of Korean"), YALE(
			"Yale"), MC_CUNE_REISCHAUER("McCune-Reischauer");

	private final String name;

	private KoreanRomanizationScheme(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
