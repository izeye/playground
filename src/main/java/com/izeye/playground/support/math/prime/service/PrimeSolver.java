package com.izeye.playground.support.math.prime.service;

import java.util.List;

public interface PrimeSolver {

	List<Long> getAllPrimesWithin(long n);

	boolean isPrime(long n);

	Long getNextPrime(long n);

}
