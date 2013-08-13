package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public enum DigitalStorageUnit implements Unit<DigitalStorageUnit> {

	BIT("Bit"), BYTE("Byte"), KILOBIT("Kilobit"), KILOBYTE("Kilobyte"), MEGABIT(
			"Megabit"), MEGABYTE("Megabyte"), GIGABIT("Gigabit"), GIGABYTE(
			"Gigabyte"), TERABIT("Terabit"), TERABYTE("Terabyte"), PETABIT(
			"Petabit"), PETABYTE("Petabyte");

	private final String name;

	private DigitalStorageUnit(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getKey() {
		return name();
	}

	@Override
	public BigDecimal convert(BigDecimal sourceDigitalStorage,
			DigitalStorageUnit sourceUnit) {
		// TODO Auto-generated method stub
		return null;
	}

}
