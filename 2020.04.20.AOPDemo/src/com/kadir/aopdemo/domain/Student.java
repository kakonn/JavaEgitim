package com.kadir.aopdemo.domain;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private String isim;
	private String soyisim;

	public String getIsim() {
		System.out.println("getIsim");
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		System.out.println("getSoyisim");
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public String getAdSoyad() {

		return this.getIsim() + " " + this.getSoyisim();
	}

	public Student afterSetStudent() {
		// Student x = new Student();
		return this;
	}

	public Student() {

		this.isim = "default isim";
		this.soyisim = "default soyisim";
	}

}
