package com.kadir.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Kurs {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "kurs_seq",sequenceName = "seq_kurs",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kurs_seq")
	private Integer id;
	@Column(name="kurs_adi")
	private String kursAdi;
	@Column(name="saat")
	private String saat;
	@Column(name="ogretmen_id")
	private String ogretmenId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKursAdi() {
		return kursAdi;
	}
	public void setKursAdi(String kursAdi) {
		this.kursAdi = kursAdi;
	}
	public String getSaat() {
		return saat;
	}
	public void setSaat(String saat) {
		this.saat = saat;
	}
	public String getOgretmenId() {
		return ogretmenId;
	}
	public void setOgretmenId(String ogretmenId) {
		this.ogretmenId = ogretmenId;
	}
	
	

}
