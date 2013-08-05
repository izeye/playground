package com.izeye.playground.support.unit.domain;

public enum DigitalStorageUnit {

	BIT("Bit"), BYTE("Byte"), KILOBIT("Kilobit"), KILOBYTE("Kilobyte"), MEGABIT(
			"Megabit"), MEGABYTE("Megabyte"), GIGABIT("Gigabit"), GIGABYTE(
			"Gigabyte"), TERABIT("Terabit"), TERABYTE("Terabyte"), PETABIT(
			"Petabit"), PETABYTE("Petabyte");

	private final String name;

	private DigitalStorageUnit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
