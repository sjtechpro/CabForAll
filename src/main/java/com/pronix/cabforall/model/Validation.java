package com.pronix.cabforall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Validation {
	@Id
	@Column(unique = true)
	public String username;
	public String govtid;
	public String emailid;
	public long phnno;

	public Validation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Validation(String username, String govtid, String emailid, long phnno) {
		super();
		this.username = username;
		this.govtid = govtid;
		this.emailid = emailid;
		this.phnno = phnno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGovtid() {
		return govtid;
	}

	public void setGovtid(String govtid) {
		this.govtid = govtid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public long getPhnno() {
		return phnno;
	}

	public void setPhnno(long phnno) {
		this.phnno = phnno;
	}

}
