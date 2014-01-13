package com.carrefour.entity;


public class  Product {
	
	
	private String barcode;
	private String description;
	private double price;
	private Unit unitType;
	private double discountAmount;
	private double vat;
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Unit getUnitType() {
		return unitType;
	}
	public void setUnitType(Unit unitType) {
		this.unitType = unitType;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}		
}
