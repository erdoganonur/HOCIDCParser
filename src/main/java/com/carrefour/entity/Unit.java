package com.carrefour.entity;

public class Unit {

	public enum UnitType{
		
		WEIGHT, QUANTITY
	}
	
	private double value;
	private UnitType unitType;
	
	public Unit(double value, UnitType unitType) {
		this.value = value;
		this.unitType = unitType;
	}
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}
	
	
}
