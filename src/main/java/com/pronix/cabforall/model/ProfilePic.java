package com.pronix.cabforall.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.type.BlobType;

@Entity
public class ProfilePic {
	@Id
	public String username;
	public BlobType profilepic;

	public ProfilePic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BlobType getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(BlobType profilepic) {
		this.profilepic = profilepic;
	}

	public ProfilePic(String username, BlobType profilepic) {
		super();
		this.username = username;
		this.profilepic = profilepic;
	}

}
