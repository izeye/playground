package com.izeye.playground.support.math.goldbach.service;

import java.util.List;

import com.izeye.playground.support.math.goldbach.domain.GoldbachPartition;

public interface GoldbachConjectureSolver {

	List<GoldbachPartition> solve(long n);

}
