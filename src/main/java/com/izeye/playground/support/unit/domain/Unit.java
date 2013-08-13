package com.izeye.playground.support.unit.domain;

import java.math.BigDecimal;

public interface Unit<T extends Unit<?>> {

	String getName();

	String getKey();

	BigDecimal convert(BigDecimal sourceValue, T sourceUnit);

}
