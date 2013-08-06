package com.izeye.playground.support.math.prime.domain;

public class PrimeFactor {

	private final long prime;
	private final long exponent;

	public PrimeFactor(long prime, long exponent) {
		this.prime = prime;
		this.exponent = exponent;
	}

	public long getPrime() {
		return prime;
	}

	public long getExponent() {
		return exponent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (exponent ^ (exponent >>> 32));
		result = prime * result + (int) (this.prime ^ (this.prime >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrimeFactor other = (PrimeFactor) obj;
		if (exponent != other.exponent)
			return false;
		if (prime != other.prime)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrimeFactor [prime=" + prime + ", exponent=" + exponent + "]";
	}

}
