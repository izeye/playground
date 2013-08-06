package com.izeye.playground.support.math.prime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("primeSolver")
public class DefaultPrimeSolver implements PrimeSolver {

	private static final long SMALLEST_PRIME = 2L;

	private final List<Long> primes;

	public DefaultPrimeSolver() {
		this.primes = new ArrayList<Long>();
		this.primes.add(SMALLEST_PRIME);
	}

	@Override
	public List<Long> getAllPrimesWithin(long n) {
		List<Long> result = new ArrayList<Long>();
		return result;
	}
}
