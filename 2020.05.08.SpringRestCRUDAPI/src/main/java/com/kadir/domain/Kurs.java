package com.kadir.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Entity
//@Table(name = "KURSS")
public class Kurs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ogr-seq")
	@SequenceGenerator(name = "ogr-seq",sequenceName = "KURS_SEQ",allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "KURS_ADI")
	private String kursAdi;
	
	@Column(name = "SAAT")
	private Integer saat;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID")
	private Ogretmen ogretmen;

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

	public Integer getSaat() {
		return saat;
	}

	public void setSaat(Integer saat) {
		this.saat = saat;
	}

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}
	
	
}
