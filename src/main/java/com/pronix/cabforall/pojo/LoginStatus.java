package com.pronix.cabforall.pojo;

import com.pronix.cabforall.model.Registration;

public class LoginStatus {

	public ResponseStatus responseStatus;
	public Registration registration;

	public LoginStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginStatus(ResponseStatus responseStatus, Registration registration) {
		super();
		this.registration = registration;
		this.responseStatus = responseStatus;
	}

	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

}
