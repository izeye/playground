package com.izeye.playground.support.math.factorial.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

@Service("factorialSolver")
public class DefaultFactorialSolver implements FactorialSolver {

	@Override
	public BigInteger solve(BigInteger number) {
		BigInteger result = BigInteger.ONE;
		BigInteger i = number;
		while (true) {
			if (i.equals(BigInteger.ONE)) {
				return result;
			}
			result = result.multiply(i);
			i = i.subtract(BigInteger.ONE);
		}
	}

}
