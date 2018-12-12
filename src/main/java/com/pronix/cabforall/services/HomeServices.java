package com.pronix.cabforall.services;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronix.cabforall.model.CarRegistration;
import com.pronix.cabforall.model.Registration;
import com.pronix.cabforall.model.Ride;
import com.pronix.cabforall.model.Validation;
import com.pronix.cabforall.pojo.LoginStatus;
import com.pronix.cabforall.pojo.ResponseStatus;
import com.pronix.cabforall.pojo.RideStatus;
import com.pronix.cabforall.repository.CarRegRepository;
import com.pronix.cabforall.repository.RegistRepo;
import com.pronix.cabforall.repository.RideRepo;
import com.pronix.cabforall.repository.ValidationRepo;

@Service
public class HomeServices {

	@Autowired
	RegistRepo registRepo;
	@Autowired
	RideRepo rideRepo;
	@Autowired
	ValidationRepo validationRepo;
	@Autowired
	CarRegRepository carRepo;

	List<Ride> ridelist;
	List<Registration> currentregisterdb;

	public ResponseStatus registration(Registration regist) {
		String username = regist.getUsername();
		String result = registRepo.findByUser(username);
		System.out.println(result);
		if (result == null) {
			System.out.println(result);
			registRepo.save(regist);
			return new ResponseStatus("success", 001, "");
		} else {
			return new ResponseStatus("failed", 003, "Username is already registered");
		}

	}

	public ResponseStatus login(Registration regist) {
		String emailid = regist.getEmailid();
		String password = regist.getPassword();
		System.out.println(emailid);
		String pass = registRepo.checkPswd(emailid);
		System.out.println("pswd is" + password);
		if (password.equals(pass)) {

			return new ResponseStatus("success", 001, "");
		} else {
			return new ResponseStatus("failure", 003, "username and password is wrong");
		}

	}

	public List<Ride> findaride(Ride ride) {
		String pickpoint = ride.getPickup();
		String droppoint = ride.getDropoff();
		String dateofjourney = ride.getStartingdate();
		System.out.println(pickpoint);
		System.out.println(droppoint);
		System.out.println(dateofjourney);
		List<Ride> rideStatus1 = new ArrayList<>();
		Ride ride3 = null;
		ridelist = rideRepo.checkride(pickpoint, droppoint, dateofjourney);
		System.out.println(ridelist.size());
		for (Ride ridelists : ridelist) {
			System.out.println(ridelists.getEmailid());

			ride3 = new Ride(ridelists.getEmailid(),ridelists.getUsername(), ridelists.getMobno(), ridelists.getPickup(),
					ridelists.getDropoff(), ridelists.getStopovers(), ridelists.getStartingdate(),
					ridelists.getReturndate(), ridelists.getRate(), ridelists.getSeats(), ridelists.getStats());
			rideStatus1.add(ride3);
		}
		return rideStatus1;
	}

	public LoginStatus findPersonelProfile(Registration regist) {
		LoginStatus loginStatus = null;
		String emailid = regist.getEmailid();
		currentregisterdb = registRepo.findByEmailid(emailid);
		if (currentregisterdb.size() > 0) {
			for (Registration registers : currentregisterdb) {
				loginStatus = new LoginStatus(new ResponseStatus("success", 001, ""),
						new Registration(registers.getGender(), registers.getUsername(), registers.getFirstname(),
								registers.getLastname(), registers.getEmailid(), registers.getBirthdate()));
			}
		} else {

			loginStatus = new LoginStatus(new ResponseStatus("failure", 003, " no profile available"), null);
		}

		return loginStatus;
	}

	public ResponseStatus offerRide(Ride ride) {
		String emailid = ride.getEmailid();
		System.out.println(emailid);
		String rides = rideRepo.findARide(emailid);
		if (rides == null) {
			rideRepo.save(ride);
			return new ResponseStatus("success", 001, "");
		} else {
			return new ResponseStatus("failure", 003, "already registered");
		}

	}

	public ResponseStatus checkEmailId(Validation validation) {
		String EmailId = validation.getEmailid();
		System.out.println(EmailId);
		String detail = registRepo.checkEmailExistance(EmailId);
		System.out.println(detail);
		if (detail.isEmpty()) {
			return new ResponseStatus("failure", 003, "EmailId is not registered ");
		} else {
			return new ResponseStatus("success", 001, "");
		}
	}

	public RideStatus findExistingRides(Ride ride) {
		RideStatus rideStatus = null;
		String emailid = ride.getEmailid();
		System.out.println(emailid);
		ridelist = rideRepo.findExistRides(emailid);
		if (ridelist.size() > 0) {
			for (Ride ridelists : ridelist) {
				rideStatus = new RideStatus(new ResponseStatus("success", 001, ""),
						new Ride(ridelists.getEmailid(),ridelists.getUsername(),ridelists.getMobno(), ridelists.getPickup(), ridelists.getDropoff(),
								ridelists.getStopovers(), ridelists.getStartingdate(), ridelists.getReturndate(),
								ridelists.getRate(), ridelists.getSeats()));
			}
		} else {
			rideStatus = new RideStatus(new ResponseStatus("failure", 003, ""), null);
		}
		return rideStatus;

	}

	public void bookingStatus(Ride ride) {
		String username = ride.getUsername();
		String emailid = ride.getEmailid();
		System.out.println(username);
		System.out.println(emailid);
		rideRepo.bookStats(emailid, username);

	}

	public RideStatus bookedHistory(Ride ride) {
		String stats=ride.getEmailid();
		List<Ride> rideHistory = rideRepo.bookedHistory(stats);
		RideStatus ridestats = null;
		if (rideHistory.size() > 0) {
			for (Ride ridesHistory : rideHistory) {
				ridestats = new RideStatus(new ResponseStatus("success", 001, null),
						new Ride(ridesHistory.getEmailid(),ridesHistory.getUsername(), ridesHistory.getMobno(), ridesHistory.getPickup(),
								ridesHistory.getDropoff(), ridesHistory.getStopovers(), ridesHistory.getStartingdate(),
								ridesHistory.getReturndate(), ridesHistory.getRate(), ridesHistory.getSeats()));
			}
		} else {
			ridestats = new RideStatus(new ResponseStatus("failure", 003, null), new Ride());
		}

		return ridestats;
	}

	public void updateProfile(Registration regist) {
		registRepo.save(regist);

	}

	public void carRegistration(CarRegistration carReg) {
		carRepo.save(carReg);

	}

	public void registeredCars(CarRegistration carReg) {
		String emailid = carReg.getEmailid();
		carRepo.findByEmailid(emailid);

	}

}
