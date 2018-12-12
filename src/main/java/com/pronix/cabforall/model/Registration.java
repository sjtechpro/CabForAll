package com.pronix.cabforall.model;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

 

@Entity
public class Registration {

	public String gender;
	@Id
	@Column(unique = true)
	public String username;
	public String firstname;
	public String lastname;
	public String emailid;
	@Size(min = 6, max = 32, message = "password must be more then 6 characters or symbols")
	public String password;
	public String confirmpassword;
	/*@JsonFormat(pattern = "dd-mm-yyyy")*/
	public String birthdate;

	public Registration() {
		super();
	 
	}

	public Registration(String gender, @NotNull String username, String firstname, String lastname, String emailid,
			@Size(min = 6, max = 32, message = "password must be more then 6 characters or symbols") String password,
			String confirmpassword, String birthdate) {
		super();
		this.gender = gender;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.birthdate = birthdate;
	}

	public Registration(String gender, @NotNull String username, String firstname, String lastname, String emailid,
			String birthdate) {
		super();
		this.gender = gender;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

}