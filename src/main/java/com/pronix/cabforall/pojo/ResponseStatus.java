package com.pronix.cabforall.pojo;

public class ResponseStatus {
	public String status;
	public int errorCode;
	public String description;
	
	
	public ResponseStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseStatus(String status, int errorCode, String description) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
