package com.izeye.playground.support.math.goldbach.domain;

public class GoldbachPartition {

	private final long firstPrime;
	private final long secondPrime;

	public GoldbachPartition(long firstPrime, long secondPrime) {
		this.firstPrime = firstPrime;
		this.secondPrime = secondPrime;
	}

	public long getFirstPrime() {
		return firstPrime;
	}

	public long getSecondPrime() {
		return secondPrime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (firstPrime ^ (firstPrime >>> 32));
		result = prime * result + (int) (secondPrime ^ (secondPrime >>> 32));
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
		GoldbachPartition other = (GoldbachPartition) obj;
		if (firstPrime != other.firstPrime)
			return false;
		if (secondPrime != other.secondPrime)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoldbachPartition [firstPrime=" + firstPrime + ", secondPrime="
				+ secondPrime + "]";
	}

}
