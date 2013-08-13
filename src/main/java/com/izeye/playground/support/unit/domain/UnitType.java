package com.izeye.playground.support.unit.domain;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public enum UnitType {

	TEMPERATURE("Temperature", TemperatureUnit.class), LENGTH("Length",
			LengthUnit.class), MASS("Mass", MassUnit.class), SPEED("Speed",
			SpeedUnit.class), VOLUME("Volume", VolumeUnit.class), AREA("Area",
			AreaUnit.class), FUEL_CONSUMPTION("Fuel Consumption",
			FuelConsumptionUnit.class), TIME("Time", TimeUnit.class), DIGITAL_STORAGE(
			"Digital Storage", DigitalStorageUnit.class);

	private final String name;
	private final Class<? extends Unit<?>> unitTypeClass;

	private UnitType(String name, Class<? extends Unit<?>> clazz) {
		this.name = name;
		this.unitTypeClass = clazz;
	}

	public String getName() {
		return name;
	}

	public Class<? extends Unit<?>> getUnitTypeClass() {
		return unitTypeClass;
	}

	public Unit<?>[] getUnits() {
		try {
			return (Unit[]) unitTypeClass.getDeclaredMethod("values").invoke(
					null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// FIXME:
		// Which value is better than null?
		// Empty Unit array or exception?
		return null;
	}

	public Unit<?> getUnit(String unit) {
		try {
			return (Unit<?>) unitTypeClass.getDeclaredMethod("valueOf",
					String.class).invoke(null, unit);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		// FIXME:
		// Which value is better than null?
		// Dummy Unit or exception?
		return null;
	}

	public <T extends Unit<?>> BigDecimal convert(String sourceUnit,
			BigDecimal sourceValue, String targetUnit) {
		try {
			return (BigDecimal) unitTypeClass.getDeclaredMethod("convert",
					BigDecimal.class, unitTypeClass).invoke(
					getUnit(targetUnit), sourceValue, getUnit(sourceUnit));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		// FIXME:
		// Which value is better than null?
		// Dummy Unit or exception?
		return null;
	}

}
