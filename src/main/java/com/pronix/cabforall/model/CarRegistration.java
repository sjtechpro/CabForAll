package com.pronix.cabforall.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarRegistration {
	@Id
	public String emailid;
	public String noplate;
	public String company;
	public String model;
	public String cartype;
	public String color;
	public String modelyear;

	public CarRegistration() {
		super();
	}

	public String getNoplate() {
		return noplate;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public void setNoplate(String noplate) {
		this.noplate = noplate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelyear() {
		return modelyear;
	}

	public void setModelyear(String modelyear) {
		this.modelyear = modelyear;
	}

	public CarRegistration(String emailid, String noplate, String company, String model, String cartype, String color,
			String modelyear) {
		super();
		this.emailid = emailid;
		this.noplate = noplate;
		this.company = company;
		this.model = model;
		this.cartype = cartype;
		this.color = color;
		this.modelyear = modelyear;
	}

}
