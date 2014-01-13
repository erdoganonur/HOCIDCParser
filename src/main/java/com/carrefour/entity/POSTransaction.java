package com.carrefour.entity;

import java.util.ArrayList;

public class POSTransaction {
	
	String storeId;
	String cashNumber;
	int transactionType;
	String startDate;
	String finishDate;
	String transactionNo;
	int transactionStep;
	ArrayList<Double> payments;
	double total;
	
}
