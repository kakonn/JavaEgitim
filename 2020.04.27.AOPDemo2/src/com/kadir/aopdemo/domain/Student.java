package com.kadir.aopdemo.domain;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private String isim;
	private String soyisim;
	private int id;
	
	public String getIsim() {
		System.out.println("getIsim");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isim;
	}

	
	public int getId() {
	//	if(id==0)
		throw new RuntimeException("Id Hatasi");
	//	return id;
	}

	
	public void setId(int id) {
		this.id = id;
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
		if (this.isim != null)
			throw new RuntimeException("Ad Soyad Hatasi");
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
