package com.izeye.playground.support.math.gcd.service;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.math.gcd.domain.GcdAndLcm;

@Service("euclidGcdAndLcmSolver")
public class EuclidGcdAndLcmSolver implements GcdAndLcmSolver {

	@Override
	public long getGcd(long m, long n) {
		long max;
		long min;
		if (m > n) {
			max = m;
			min = n;
		} else {
			max = n;
			min = m;
		}
		long newMin = max % min;
		if (newMin == 0) {
			return min;
		} else {
			return getGcd(min, newMin);
		}
	}

	@Override
	public long getLcm(long m, long n) {
		long gcd = getGcd(m, n);
		return getLcm(m, n, gcd);
	}

	@Override
	public long getLcm(long m, long n, long gcd) {
		return m * n / gcd;
	}

	@Override
	public GcdAndLcm getGcdAndLcm(long m, long n) {
		long gcd = getGcd(m, n);
		long lcm = getLcm(m, n, gcd);
		return new GcdAndLcm(gcd, lcm);
	}

}
