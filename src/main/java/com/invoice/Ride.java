package com.invoice;

public class Ride {
	double distance;
	int time;
	int UserId;
	public String ridetype;

	public Ride(double distance, int time, int UserId, String rideType) {
		this.time = time;
		this.distance = distance;
		this.UserId = UserId;
		this.ridetype = rideType;
	}



	public String getRidetype() {
		return ridetype;
	}



	public void setRidetype(String ridetype) {
		this.ridetype = ridetype;
	}



	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
