package com.izeye.playground.support.math.gcd.domain;

public class GcdAndLcm {

	private final long gcd;
	private final long lcm;

	public GcdAndLcm(long gcd, long lcm) {
		this.gcd = gcd;
		this.lcm = lcm;
	}

	public long getGcd() {
		return gcd;
	}

	public long getLcm() {
		return lcm;
	}

	@Override
	public String toString() {
		return "GcdAndLcm [gcd=" + gcd + ", lcm=" + lcm + "]";
	}

}
