package com.invoice;

public class Ride {
	double distance;
	int time;
	int UserId;

	public Ride(double distance, int time, int UserId) {
		this.time = time;
		this.distance = distance;
		this.UserId = UserId;
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
