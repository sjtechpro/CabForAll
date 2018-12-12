package com.pronix.cabforall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pronix.cabforall.model.CarRegistration;
import com.pronix.cabforall.model.Registration;
import com.pronix.cabforall.model.Ride;
import com.pronix.cabforall.pojo.ResponseStatus;
import com.pronix.cabforall.repository.CarRegRepository;
import com.pronix.cabforall.repository.RideRepo;
import com.pronix.cabforall.services.HomeServices;

@Controller
public class ReportController {
	@Autowired
	HomeServices homeServices;
	@Autowired
	CarRegRepository carRepo;
	@Autowired
	RideRepo riderepo;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage() {

		return "blabla";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {

		return "contact";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "index";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard() {

		return "dashboard";
	}

	@RequestMapping(value = "/findride", method = RequestMethod.GET)
	public String findaride() {

		return "findaride";
	}
	
	@RequestMapping(value = "/rideresult", method = RequestMethod.GET)
	public String rideresult() {

		return "rideresult";
	}
	
	@RequestMapping(value = "/carregistration", method = RequestMethod.GET)
	public String carregistration() {

		return "carreg";
	}

	@RequestMapping(value = "/offeraride", method = RequestMethod.GET)
	public String offeraride() {

		return "offeraride";
	}

	@RequestMapping(value ="/loginprocess", method = RequestMethod.POST)
	public ModelAndView loginProcess(Registration regist) {
		String emailid = regist.getEmailid();
		String pswd = regist.getPassword();
		System.out.println(pswd);
		System.out.println(emailid);
		ModelAndView mav = new ModelAndView();
		ResponseStatus respStats = homeServices.login(regist); 
		if (respStats.status.equals("success")) {
			mav.setViewName("blabla");
		} else {
			mav.setViewName("index");
		}	
		return mav;
	}

	@RequestMapping(value ="/signupprocess", method = RequestMethod.POST)
	public ModelAndView SignupProcess(Registration regist) {
		String gender = regist.getGender();
		String emailid = regist.getEmailid();
		System.out.println(gender);
		System.out.println(emailid);
		ModelAndView mav = new ModelAndView();
		ResponseStatus respStatus = homeServices.registration(regist); 
		if (respStatus.getStatus().equals("success")) {
			mav.setViewName("index");
		} else {
			/*
			 * String response="already registered"; mav.addObject("data", response);
			 */
			mav.setViewName("index");
		}
		return mav;
	}

	@RequestMapping(value = "/carregisteration")
	public ModelAndView carRegisteration(CarRegistration carReg) {
		ModelAndView mav = new ModelAndView();
		carRepo.save(carReg);
		mav.setViewName("blabla");
		return mav;

	}

	@RequestMapping(value ="/findRide", method = RequestMethod.POST)
	public String findride(Ride ride, Model model) {

		model.addAttribute("rides", homeServices.findaride(ride));
		// String str="success";
		// for(Ride ridelist:rides ) {
		return "rideresult";
	}

	@RequestMapping(value = "/offerride", method = RequestMethod.POST)
	public ModelAndView offerride(Ride ride) {
		ResponseStatus result=homeServices.offerRide(ride);
		System.out.println("status"+result.getStatus());
		ModelAndView mav=new ModelAndView();
		if(result.getStatus().equals("success")) {
			mav.setViewName("blabla");
		}else {
			mav.setViewName("offeraride");
		}
		return mav;
	}
}
/*
 * if(rideStatus.respstats.getStatus()==str) { mav.addObject("ridelist",
 * rideStatus.getRide()); mav.addObject("usrname",
 * rideStatus.ride.getUsername()); mav.addObject("pickup",
 * rideStatus.ride.getPickup()); mav.addObject("dropoff",
 * rideStatus.ride.getDropoff()); mav.addObject("startingdate",
 * rideStatus.ride.getStartingdate()); mav.addObject("returndate",
 * rideStatus.ride.getReturndate()); mav.addObject("stopovers",
 * rideStatus.ride.getStopovers()); mav.addObject("seats",
 * rideStatus.ride.getSeats()); mav.addObject("rate",
 * rideStatus.ride.getRate());
 */
