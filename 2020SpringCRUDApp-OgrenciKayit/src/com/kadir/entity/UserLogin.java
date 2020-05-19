package com.kadir.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserLogin {
	
	
	@NotEmpty(message = "Boþ gelme")
	@Email(message = "Bak orda email yaziyor, lütfen....")
	private String email;

	@NotEmpty(message = "Hee oldu buyur..")
	private String password;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [email=" + email + ", password=" + password + "]";
	}

}
