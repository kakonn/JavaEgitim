package com.kadir.rest;

public class KitapNotFoundException extends RuntimeException{
	
	public KitapNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public KitapNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public KitapNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
