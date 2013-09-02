package com.izeye.playground.support.math.mean.domain;

public enum MeanType {

	ARITHEMETIC_MEAN("Arithmetic mean"), //
	GEOMETRIC_MEAN("Geometric mean"), //
	HARMONIC_MEAN("Harmonic mean");

	private final String name;

	private MeanType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
