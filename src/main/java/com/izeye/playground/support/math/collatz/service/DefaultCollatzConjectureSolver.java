package com.izeye.playground.support.math.collatz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("collatzConjectureSolver")
public class DefaultCollatzConjectureSolver implements CollatzConjectureSolver {

	@Override
	public List<Long> solve(long number) {
		return solveInternal(number, new ArrayList<Long>());
	}

	// NOTE:
	// void is better?
	// Return the result for convenience.
	private List<Long> solveInternal(long number, List<Long> result) {
		result.add(number);

		if (number == 1) {
			return result;
		}
		if (number % 2 == 0) {
			return solveInternal(number / 2, result);
		} else {
			return solveInternal(number * 3 + 1, result);
		}
	}

}
