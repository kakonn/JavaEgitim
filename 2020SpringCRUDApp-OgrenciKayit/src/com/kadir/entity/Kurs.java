package com.kadir.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KURSS")
public class Kurs {


	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "kurs_seq", sequenceName = "kurs_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kurs_seq")
	private Integer id;
	
	@Column(name = "kurs_adi")
	private String kursAdi;
	
	@Column(name = "saat")
	private int saat;
	
	@ManyToOne
	@JoinColumn(name = "ogretmen_id")
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

	public int getSaat() {
		return saat;
	}

	public void setSaat(int saat) {
		this.saat = saat;
	}

	/**
	 * @return the ogretmen
	 */
	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	/**
	 * @param ogretmen the ogretmen to set
	 */
	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	
}
