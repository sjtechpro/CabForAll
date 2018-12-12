package com.pronix.cabforall.pojo;

import com.pronix.cabforall.model.Ride;

public class RideStatus {
	public ResponseStatus respstats;
	public Ride ride;

	public RideStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseStatus getRespstats() {
		return respstats;
	}

	public void setRespstats(ResponseStatus respstats) {
		this.respstats = respstats;
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}

	public RideStatus(ResponseStatus respstats, Ride ride) {
		super();
		this.respstats = respstats;
		this.ride = ride;
	} 

}
