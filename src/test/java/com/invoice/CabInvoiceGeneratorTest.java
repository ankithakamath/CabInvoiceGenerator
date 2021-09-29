package com.invoice;

import java.util.stream.Collectors;
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
		double Fare = cabinvoiceGenerator.generateFare("Normal",distance, time);
		Assert.assertEquals(108, Fare, 0.0);
	}

	/*
	 * the test passes when the multiple rides fare match with expected and
	 * generated
	 */
	@Test
	public void MatchofFareRide() {

		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepo rideRepository = new RideRepo();
		rideRepository.addRide(new Ride(10, 8, 1,"Normal"));
		rideRepository.addRide(new Ride(1, 3, 2,"Normal"));
		rideRepository.addRide(new Ride(10, 3, 1,"Normal"));

		double expectedTotalFare = 224;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFare, cabInvoiceGenerator.calculateFare(rideRepository.getRides()), epsilon);

	}

	/*
	 * the test passes when number of rides matches The test Matches when the Total
	 * 
	 * 
	 */
	@Test
	public void givenMultipleRide_matchingWithTotalNumberOfRide_returnsTrue() {

		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepo rideRepository = new RideRepo();
		rideRepository.addRide(new Ride(10, 8, 1,"Normal"));
		rideRepository.addRide(new Ride(1, 3, 2,"Normal"));
		rideRepository.addRide(new Ride(10, 3, 1,"Normal"));
		EnhancedInvoice invoice = cabInvoiceGenerator.getEnhancedInvoice(rideRepository.getRides());
		int expectedTotalRides = 3;

		Assert.assertEquals(expectedTotalRides, invoice.getTotalNumOfRides());
	}

	/*
	 * The test passes when the expected Total fare matches the calculated fare
	 */
	@Test
	public void givenMultipleRide_matchingWithTotalFare_returnsTrue() {

		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepo rideRepository = new RideRepo();
		rideRepository.addRide(new Ride(10, 8, 1,"Normal"));
		rideRepository.addRide(new Ride(1, 3, 2,"Normal"));
		rideRepository.addRide(new Ride(10, 3, 1,"Normal"));
		EnhancedInvoice invoice = cabInvoiceGenerator.getEnhancedInvoice(rideRepository.getRides());

		double expectedTotalFare = 224;

		double epsilon = 1e-15;

		Assert.assertEquals(expectedTotalFare, invoice.getTotalFare(), epsilon);
	}

	/*
	 * The test passes when expected Average fare matches the calculated fare
	 */
	@Test
	public void givenMultipleRide_matchingWithAvgFareperRide_returnsTrue() {

		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepo rideRepository = new RideRepo();
		rideRepository.addRide(new Ride(10, 8, 1,"Normal"));
		rideRepository.addRide(new Ride(1, 3, 2,"Normal"));
		rideRepository.addRide(new Ride(10, 4, 1,"Normal"));
		EnhancedInvoice invoice = cabInvoiceGenerator.getEnhancedInvoice(rideRepository.getRides());

		double expectedAvgFare = 75;
		double epsilon = 1e-15;

		Assert.assertEquals(expectedAvgFare, invoice.getAvgFarePerRide(), epsilon);
	}

	/*
	 * This test passes when user id matches and on Correct matching of Total Fare
	 */
	@Test
	public void givenMultipleRideOfDifferentCustomer_matchingWithNUmberOfRidesOfCustomer1_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepo rideRepository = new RideRepo();
		rideRepository.addRide(new Ride(10, 8, 1,"Normal"));
		rideRepository.addRide(new Ride(1, 3, 2,"Normal"));
		rideRepository.addRide(new Ride(10, 4, 1,"Normal"));
		EnhancedInvoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserId() == 1).collect(Collectors.toList()));

		int expectedTotalRideofUser1 = 2;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalRideofUser1, invoice.getTotalNumOfRides(), epsilon);

	}

	/*
	 * This test passes when user id matches and on Correct matching of TotalFare
	 */
	@Test
	public void givenMultipleRideOfDifferentCustomer_matchingWithTotalFareOfCustomer1_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepo rideRepository = new RideRepo();
		rideRepository.addRide(new Ride(10, 8, 1,"Normal"));
		rideRepository.addRide(new Ride(1, 3, 2,"Normal"));
		rideRepository.addRide(new Ride(10, 4, 1,"Normal"));

		EnhancedInvoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserId() == 1).collect(Collectors.toList()));

		double expectedTotalFareofUser1 = 212;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFareofUser1, invoice.getTotalFare(), epsilon);

	}

	/*
	 * This test passes when user id matches and on Correct matching of average fare
	 */
	@Test
	public void givenMultipleRideOfDifferentCustomer_matchingWithAverageFareOfCustomer1_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepo rideRepository = new RideRepo();
		rideRepository.addRide(new Ride(10, 8, 1,"Normal"));
		rideRepository.addRide(new Ride(1, 3, 2,"Normal"));
		rideRepository.addRide(new Ride(10, 4, 1,"Normal"));
		EnhancedInvoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserId() == 1).collect(Collectors.toList()));

		double expectedAvgFareofUser1 = 106;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedAvgFareofUser1, invoice.getAvgFarePerRide(), epsilon);

	}
	/**
	 * Test for the total fare of customer over different ride type
	 */
	@Test
	public void givenMultipleRideOfSingleCustomerOfDiffereentType_matchingWithTotalFareOfCustomer_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepo rideRepository = new RideRepo();
		rideRepository.addRide(new Ride(10, 8, 1,"Premium"));
		rideRepository.addRide(new Ride(1, 3, 2,"Normal"));
		rideRepository.addRide(new Ride(10, 4, 1,"Normal"));

		EnhancedInvoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserId() == 1).collect(Collectors.toList()));

		double expectedTotalFareofUser1 = 270;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFareofUser1, invoice.getTotalFare(), epsilon);

	}

	/**
	 * Test for the average fare of customer over different ride type
	 */
	@Test
	public void givenMultipleRideOfSingleCustomerOfDiffereentType_matchingWithAverageFareOfCustomer_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepo rideRepository = new RideRepo();

		rideRepository.addRide(new Ride(10, 8, 1,"Premium"));
		rideRepository.addRide(new Ride(1, 3, 2,"Normal"));
		rideRepository.addRide(new Ride(10, 4, 1,"Normal"));
		EnhancedInvoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserId() == 1).collect(Collectors.toList()));

		double expectedTotalFareofUser1 = 135;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFareofUser1, invoice.getAvgFarePerRide(), epsilon);

	}

}

