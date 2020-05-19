package com.kadir.rest;

public class OgrenciIsleriErrorResponse {

	private int status;
	private String message;

	public OgrenciIsleriErrorResponse() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
