package com.invoice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CanInvoiceGeneratorTest {
/*
 * the test passes when the expected fare is equal to the generated fare
 */
	@Test
	public void MatchofTheFare() {
		CabInvoiceGenerator cabinvoiceGenerator = new CabInvoiceGenerator();
		double distance = 10.0;
		int time = 8;
		double fare = cabinvoiceGenerator.generateFare(distance, time);
		Assert.assertEquals(108, fare, 0);
	}

}