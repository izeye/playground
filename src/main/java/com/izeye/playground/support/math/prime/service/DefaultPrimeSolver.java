package com.izeye.playground.support.math.prime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.math.prime.domain.PrimeFactor;

@Service("primeSolver")
public class DefaultPrimeSolver implements PrimeSolver {

	private static final long SMALLEST_PRIME = 2L;

	@Override
	public List<Long> getAllPrimesWithin(long n) {
		List<Long> primes = new ArrayList<Long>();
		long prime = SMALLEST_PRIME;
		while (prime <= n) {
			primes.add(prime);
			prime = getNextPrime(prime, primes);
		}
		return primes;
	}

	@Override
	public boolean isPrime(long n) {
		if (n < SMALLEST_PRIME) {
			return false;
		}

		List<Long> primes = getAllPrimesWithin((long) Math.sqrt(n));
		for (Long value : primes) {
			if (n % value == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Long getNextPrime(long n) {
		if (!isPrime(n)) {
			throw new IllegalArgumentException("n must be a prime: " + n);
		}

		List<Long> primes = getAllPrimesWithin(n);
		return getNextPrime(n, primes);
	}

	private Long getNextPrime(long n, List<Long> primes) {
		long primeCandidate = n + 1;
		while (true) {
			boolean isPrime = true;
			for (Long prime : primes) {
				if (primeCandidate % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				return primeCandidate;
			}
			primeCandidate++;
		}
	}

	@Override
	public List<PrimeFactor> getPrimeFactors(long n) {
		List<PrimeFactor> primeFactors = new ArrayList<PrimeFactor>();

		long value = n;
		List<Long> primes = getAllPrimesWithin(n);
		for (Long prime : primes) {
			int exponent = 0;
			while (value % prime == 0) {
				exponent++;
				value /= prime;
			}
			if (exponent != 0) {
				primeFactors.add(new PrimeFactor(prime, exponent));
			}
		}
		return primeFactors;
	}

}
