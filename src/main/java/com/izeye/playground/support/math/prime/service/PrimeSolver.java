package com.izeye.playground.support.math.prime.service;

import java.util.List;

import com.izeye.playground.support.math.prime.domain.PrimeFactor;

public interface PrimeSolver {

	List<Long> getAllPrimesWithin(long n);

	boolean isPrime(long n);

	Long getNextPrime(long n);

	List<PrimeFactor> getPrimeFactors(long n);

}
