package com.izeye.playground.support.math.mean.service;

import java.math.BigDecimal;
import java.util.List;

import com.izeye.playground.support.math.mean.domain.MeanType;

public interface MeanCalculator {

	BigDecimal calculate(MeanType meanType, List<BigDecimal> numbers);

	BigDecimal calculateArithmeticMean(List<BigDecimal> numbers);

	BigDecimal calculateGeometricMean(List<BigDecimal> numbers);

	BigDecimal calculateHarmonicMean(List<BigDecimal> numbers);

}
