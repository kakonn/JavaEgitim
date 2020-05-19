package com.kadir.SpringRestClient.domain;

import java.util.Date;

public class Ogrenci {

	private Integer id;

	private String isim;

	private String soyisim;

	private Integer ogrenciNo;

	private Date mezuniyetTarihi;

	public Ogrenci() {
		super();
	}

	public Ogrenci(String isim, String soyisim, Integer ogrenciNo, Date mezuniyetTarihi) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.ogrenciNo = ogrenciNo;
		this.mezuniyetTarihi = mezuniyetTarihi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public Date getMezuniyetTarihi() {
		return mezuniyetTarihi;
	}

	public void setMezuniyetTarihi(Date mezuniyetTarihi) {
		this.mezuniyetTarihi = mezuniyetTarihi;
	}

	public Integer getOgrenciNo() {
		return ogrenciNo;
	}

	public void setOgrenciNo(Integer ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}

	@Override
	public String toString() {
		return "Ogrenci [id=" + id + ", isim=" + isim + ", soyisim=" + soyisim + ", ogrenciNo=" + ogrenciNo
				+ ", mezuniyetTarihi=" + mezuniyetTarihi + "]";
	}
	
	
}
