package com.invoice;

public class CabInvoiceGenerator {
	private int Minimum = 5;

	public double generateFare(double distance, int time) {
		double cost = distance * 10;
		cost = cost + (time * 1);
		if (cost > Minimum)
			return cost;
		else
			return Minimum;
	}
}
