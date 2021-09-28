package com.invoice;

public class CabInvoiceGenerator {
	private int Minimum = 5;
/*
 * Method to generate fare 
 */
	public double generateFare(double distance, int time) {
		double cost = distance * 10;
		cost = cost + (time * 1);
		if (cost > Minimum)
			return cost;
		else
			return Minimum;
	}
/*
 * method to generate fare for multiple rides is added
 */
	public double calculateFare(Ride[] rides) {
		double Fare = 0;
		for (Ride ride : rides) {
			Fare += this.generateFare(ride.distance, ride.time);
		}
		return Fare;
	}

}
