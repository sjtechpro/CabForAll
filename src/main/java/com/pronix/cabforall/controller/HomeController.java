package com.pronix.cabforall.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pronix.cabforall.model.CarRegistration;
import com.pronix.cabforall.model.Registration;
import com.pronix.cabforall.model.Ride;
import com.pronix.cabforall.model.Validation;
import com.pronix.cabforall.pojo.LoginStatus;
import com.pronix.cabforall.pojo.ResponseStatus;
import com.pronix.cabforall.pojo.RideStatus; 
import com.pronix.cabforall.services.HomeServices;
@Component
@RestController
public class HomeController {

	@Autowired
	HomeServices homeServices;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseStatus Login(@RequestBody Registration regist) {
		return homeServices.login(regist);

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseStatus register(@RequestBody Registration regist) {
		return homeServices.registration(regist);

	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public ResponseStatus forgotPassword(@RequestBody Validation validation) {
		return homeServices.checkEmailId(validation);
	}

	@RequestMapping(value = "/offeraride", method = RequestMethod.POST)
	public ResponseStatus offerRide(@RequestBody Ride ride) {
		return homeServices.offerRide(ride);

	}

	@RequestMapping(value = "/findaride", method = RequestMethod.POST)
	public List<Ride> findRide(@RequestBody Ride ride) {
		return homeServices.findaride(ride);

	}

	@RequestMapping(value = "/personelprofile", method = RequestMethod.POST)
	public LoginStatus personelInfo(@RequestBody Registration regist) {
		return homeServices.findPersonelProfile(regist);

	}

	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public void updateProfile(@RequestBody Registration regist) {
		homeServices.updateProfile(regist);

	}

	@RequestMapping(value = "/history", method = RequestMethod.POST)
	public RideStatus ridesOffered(@RequestBody Ride ride) {
		return homeServices.findExistingRides(ride);

	}

	@RequestMapping(value = "/carregistration", method = RequestMethod.POST)
	public void carRegistration(@RequestBody CarRegistration carReg) {
		homeServices.carRegistration(carReg);

	}
	@RequestMapping(value="registeredcars",method=RequestMethod.GET)
	public void showCarList(@RequestBody CarRegistration carReg) {
		homeServices.registeredCars(carReg);
	}

	@RequestMapping(value = "/bookingstatus", method = RequestMethod.POST)
	public void bookingStatus(@RequestBody Ride ride) {
		homeServices.bookingStatus(ride);

	}

	@RequestMapping(value = "/bookedhistory", method = RequestMethod.POST)
	public RideStatus bookedHistory(@RequestBody Ride ride) {
		return homeServices.bookedHistory(ride);

	}

}

/*
 * @RequestMapping(value = "/uploadimg", method = RequestMethod.POST) public
 * void uploadPic(@RequestBody ProfilePic profpic) {
 * profilePicRepo.save(profpic);
 * 
 * }
 * 
 * @RequestMapping(value = "/updatePhoto", method = RequestMethod.POST) public
 * String fileUpload(@RequestPart("file") MultipartFile file) { try { // Get the
 * file and save it somewhere byte[] bytes = file.getBytes();
 * 
 * //save file in server - you may need an another scenario Path path =
 * Paths.get("/" + file.getOriginalFilename()); Files.write(path, bytes);
 * 
 * } catch (IOException e) { e.printStackTrace(); }
 * 
 * //redirect to an another url end point return "success"; }
 */
