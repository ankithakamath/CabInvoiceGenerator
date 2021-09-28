package com.invoice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
	/*
	 * the test passes when the expected fare is equal to the generated fare
	 */
	@Test
	public void MatchofTheFare() {
		CabInvoiceGenerator cabinvoiceGenerator = new CabInvoiceGenerator();
		double distance = 10.0;
		int time = 8;
		double Fare = cabinvoiceGenerator.generateFare(distance, time);
		Assert.assertEquals(108, Fare, 0.0);
	}

	/*
	 * the test passes when the multiple rides fare match with expected and
	 * generated
	 */
	@Test
	public void MatchofFareRide() {
		CabInvoiceGenerator cabinvoiceGenerator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(10.0, 8), new Ride(1, 3) };
		double Fare = cabinvoiceGenerator.calculateFare(rides);
		Assert.assertEquals(121, Fare, 0.0);
	}
}