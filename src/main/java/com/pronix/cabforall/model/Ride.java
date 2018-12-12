package com.pronix.cabforall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
 
import javax.persistence.Id;

 
 

@Entity
public class Ride {

	/*
	 * @GeneratedValue(strategy = GenerationType.AUTO) public int id;
	 */
	@Id
	private String emailid;
	@Column(unique =true)
	private String username;
	private String mobno;
	private String pickup;
	@Column(unique = false)
	private String dropoff;
	private String stopovers;
	private String startingdate;
	private String returndate;
	private int rate;
	private int seats;
	 
	private String stats;
	
	

	 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public Ride(String emailid, String mobno, String pickup, String dropoff, String stopovers, String startingdate,
			String returndate, int rate, int seats,String stats) {
		super();
		this.emailid = emailid;
		this.mobno = mobno;
		this.pickup = pickup;
		this.dropoff = dropoff;
		this.stopovers = stopovers;
		this.startingdate = startingdate;
		this.returndate = returndate;
		this.rate = rate;
		this.seats = seats;
		this.stats=stats;
	}

	public Ride() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
 
	public Ride(String emailid, String pickup, String dropoff, String stopovers, String startingdate, String returndate,
			int rate, int seats) {
		super();
		this.emailid = emailid;
		this.pickup = pickup;
		this.dropoff = dropoff;
		this.stopovers = stopovers;
		this.startingdate = startingdate;
		this.returndate = returndate;
		this.rate = rate;
		this.seats = seats;
	}

	public Ride(String pickup, String dropoff, String startingdate) {
		super();
		this.pickup = pickup;
		this.dropoff = dropoff;
		this.startingdate = startingdate;
	}

	public Ride(String emailid, String pickup, String dropoff, String stopovers, String startingdate,
			String returndate) {
		super();
		this.emailid = emailid;
		this.pickup = pickup;
		this.dropoff = dropoff;
		this.stopovers = stopovers;
		this.startingdate = startingdate;
		this.returndate = returndate;
	}
	
	
	 
	public Ride(String username, String mobno, String pickup, String dropoff, String stopovers, String startingdate,
			String returndate, int rate, int seats) {
		super();
		this.username = username;
		this.mobno = mobno;
		this.pickup = pickup;
		this.dropoff = dropoff;
		this.stopovers = stopovers;
		this.startingdate = startingdate;
		this.returndate = returndate;
		this.rate = rate;
		this.seats = seats;
	}

	public Ride(String emailid2, String username2, String mobno2, String pickup2, String dropoff2, String stopovers2,
			String startingdate2, String returndate2, int rate2, int seats2) {
		super();
		this.emailid=emailid2;
		this.username = username2;
		this.mobno = mobno2;
		this.pickup = pickup2;
		this.dropoff = dropoff2;
		this.stopovers = stopovers2;
		this.startingdate = startingdate2;
		this.returndate = returndate2;
		this.rate = rate2;
		this.seats = seats2;
	}

	public Ride(String emailid2, String username2, String mobno2, String pickup2, String dropoff2, String stopovers2,
			String startingdate2, String returndate2, int rate2, int seats2, String stats2) {
		super();
		this.emailid=emailid2;
		this.username = username2;
		this.mobno = mobno2;
		this.pickup = pickup2;
		this.dropoff = dropoff2;
		this.stopovers = stopovers2;
		this.startingdate = startingdate2;
		this.returndate = returndate2;
		this.rate = rate2;
		this.seats = seats2;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getDropoff() {
		return dropoff;
	}

	public void setDropoff(String dropoff) {
		this.dropoff = dropoff;
	}

	public String getStopovers() {
		return stopovers;
	}

	public void setStopovers(String stopovers) {
		this.stopovers = stopovers;
	}

	public String getStartingdate() {
		return startingdate;
	}

	public void setStartingdate(String startingdate) {
		this.startingdate = startingdate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}
