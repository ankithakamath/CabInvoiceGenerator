package com.invoice;

import java.util.ArrayList;
import java.util.List;

public class RideRepo {

	List<Ride> rides;

	public RideRepo() {
		this.rides = new ArrayList<Ride>();
	}

	public List<Ride> getRides() {
		return rides;
	}

	public void addRide(Ride ride) {
		rides.add(ride);
	}

}