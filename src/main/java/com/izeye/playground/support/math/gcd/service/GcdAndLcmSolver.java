package com.izeye.playground.support.math.gcd.service;

import com.izeye.playground.support.math.gcd.domain.GcdAndLcm;

public interface GcdAndLcmSolver {

	long getGcd(long m, long n);

	long getLcm(long m, long n);

	long getLcm(long m, long n, long gcd);

	GcdAndLcm getGcdAndLcm(long m, long n);

}
