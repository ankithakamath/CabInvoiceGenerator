package com.invoice;

import java.util.List;

public class CabInvoiceGenerator {
	private final int NormalMinimum = 5;
	private final int PremiumMinimum = 20;
	private final int NormalFarePerMinute= 1;
	private final int PremiumFarePerMinute = 2;
	private final int NormalFarePerKm= 10;
	private final int  PremiumFarePerKm= 15;

	/*
	 * Method to generate fare
	 */
	public double generateFare(String type, double distance, double time) {
		double cost;
		if (type.equalsIgnoreCase("premium")) {
			cost = (distance * PremiumFarePerKm) + (PremiumFarePerMinute * time);
			return cost > PremiumMinimum ? cost : PremiumMinimum;
		} else {
			cost = (distance *NormalFarePerKm ) + (NormalFarePerMinute * time);
			return cost >NormalMinimum ? cost : NormalMinimum;
		}
	}
	/*
	 * method to generate fare for multiple rides is added
	 */
	public double calculateFare(List<Ride> rides) {
		
			double totalFare = 0;
			for (Ride ride : rides) {
				totalFare += generateFare(ride.getRidetype(), ride.getDistance(), ride.getTime());
			}
			return totalFare;
		}

	public EnhancedInvoice getEnhancedInvoice(List<Ride> rides) {

		double totalFare = calculateFare(rides);
		EnhancedInvoice invoice = new EnhancedInvoice(totalFare, rides.size());

		return invoice;
	}
}