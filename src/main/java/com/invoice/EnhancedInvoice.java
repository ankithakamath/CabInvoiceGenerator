package com.invoice;

public class EnhancedInvoice {
	public int TotalNumOfRides;
	public Double TotalFare;
	public Double AvgFarePerRide;

	public EnhancedInvoice(Double TotalFare, int TotalNumOfRides ) {
		this.TotalNumOfRides=TotalNumOfRides;
		this.TotalFare= TotalFare;
		this.AvgFarePerRide=TotalFare/TotalNumOfRides;
		
	}
	public EnhancedInvoice(Ride[] rides) {
		// TODO Auto-generated constructor stub
	}
	public int getTotalNumOfRides() {
		return TotalNumOfRides;
	}

	public void setTotalNumOfRides(int totalNumOfRides) {
		TotalNumOfRides = totalNumOfRides;
	}

	public Double getTotalFare() {
		return TotalFare;
	}

	public void setTotalFare(Double totalFare) {
		TotalFare = totalFare;
	}

	public Double getAvgFarePerRide() {
		return AvgFarePerRide;
	}

	public void setAvgFarePerRide(Double avgFarePerRide) {
		AvgFarePerRide = avgFarePerRide;
	}

}
