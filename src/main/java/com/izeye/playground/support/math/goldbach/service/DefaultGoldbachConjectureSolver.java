package com.izeye.playground.support.math.goldbach.service;

import static com.izeye.playground.support.math.goldbach.domain.GoldbachConstants.FIRST_GOLDBACH_NUMBER;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.math.goldbach.domain.GoldbachPartition;
import com.izeye.playground.support.math.prime.service.PrimeSolver;

@Service("goldbachConjectureSolver")
public class DefaultGoldbachConjectureSolver implements
		GoldbachConjectureSolver {

	@Resource
	private PrimeSolver primeSolver;

	@Override
	public List<GoldbachPartition> solve(long n) {
		if (n < FIRST_GOLDBACH_NUMBER) {
			throw new IllegalArgumentException(
					"n must be greater than or equal to "
							+ FIRST_GOLDBACH_NUMBER + ", but was: " + n);
		}
		if (n % 2 != 0) {
			throw new IllegalArgumentException("n must be even, but was: " + n);
		}

		List<GoldbachPartition> goldbachPartitions = new ArrayList<GoldbachPartition>();
		List<Long> primes = primeSolver.getAllPrimesWithin(n);
		for (Long prime : primes) {
			Long secondPrime = n - prime;
			if (prime > secondPrime) {
				break;
			}
			if (primes.contains(secondPrime)) {
				goldbachPartitions
						.add(new GoldbachPartition(prime, secondPrime));
			}
		}
		return goldbachPartitions;
	}
}
