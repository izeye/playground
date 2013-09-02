package com.izeye.playground.support.math.mean.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.math.mean.domain.MeanType;

@Service("meanCalculator")
public class DefaultMeanCalculator implements MeanCalculator {

	@Override
	public BigDecimal calculate(MeanType meanType, List<BigDecimal> numbers) {
		switch (meanType) {
		case ARITHEMETIC_MEAN:
			return calculateArithmeticMean(numbers);

		case GEOMETRIC_MEAN:
			return calculateGeometricMean(numbers);

		case HARMONIC_MEAN:
			return calculateHarmonicMean(numbers);

		default:
			throw new IllegalArgumentException("Unsupported mean type: "
					+ meanType);
		}
	}

	@Override
	public BigDecimal calculateArithmeticMean(List<BigDecimal> numbers) {
		if (numbers.size() == 0) {
			return BigDecimal.ZERO;
		}

		BigDecimal sum = BigDecimal.ZERO;
		for (BigDecimal number : numbers) {
			sum = sum.add(number);
		}
		return sum.divide(BigDecimal.valueOf(numbers.size()));
	}

	@Override
	public BigDecimal calculateGeometricMean(List<BigDecimal> numbers) {
		if (numbers.size() == 0) {
			return BigDecimal.ZERO;
		}

		BigDecimal product = BigDecimal.ONE;
		for (BigDecimal number : numbers) {
			product = product.multiply(number);
		}
		return BigDecimal.valueOf(Math.pow(product.doubleValue(),
				1d / numbers.size()));
	}

	@Override
	public BigDecimal calculateHarmonicMean(List<BigDecimal> numbers) {
		BigDecimal inverseSum = BigDecimal.ZERO;
		for (BigDecimal number : numbers) {
			inverseSum = inverseSum.add(BigDecimal.ONE.divide(number,
					MathContext.DECIMAL128));
		}
		return BigDecimal.valueOf(numbers.size()).divide(inverseSum,
				MathContext.DECIMAL128);
	}
}
