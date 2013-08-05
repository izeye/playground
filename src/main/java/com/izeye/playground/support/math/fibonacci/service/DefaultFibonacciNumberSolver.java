package com.izeye.playground.support.math.fibonacci.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("fibonacciNumberSolver")
public class DefaultFibonacciNumberSolver implements FibonacciNumberSolver {

	@Override
	public List<Long> solve(long length) {
		if (length < 0) {
			throw new IllegalArgumentException(
					"The length of the fibonacci number can NOT be negative: "
							+ length);
		}

		List<Long> result = new ArrayList<Long>();
		if (length == 0) {
			return result;
		}

		long f0 = 0;
		result.add(f0);
		if (length == 1) {
			return result;
		}

		long f1 = 1;
		result.add(f1);
		for (int i = 2; i < length; i++) {
			result.add(result.get(i - 2) + result.get(i - 1));
		}
		return result;
	}

}
