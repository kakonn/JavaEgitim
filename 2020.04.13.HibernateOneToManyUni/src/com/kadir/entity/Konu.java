package com.kadir.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="KONU")
public class Konu {
	
	@Id
	@Column(name="Id")
	@SequenceGenerator(name = "seq_konu", sequenceName = "seq_konu", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_konu")
	private Integer id;
	
	@Column(name="konu_basligi")
	private String konuBasligi;
	
	@Column(name="konu_detay")
	private String konuDetay;

	
	
	
	
	
	public Konu() {
		super();
	}

	
	public Konu(String konuBasligi, String konuDetay) {
		super();
		this.konuBasligi = konuBasligi;
		this.konuDetay = konuDetay;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKonuBasligi() {
		return konuBasligi;
	}

	public void setKonuBasligi(String konuBasligi) {
		this.konuBasligi = konuBasligi;
	}

	public String getKonuDetay() {
		return konuDetay;
	}

	public void setKonuDetay(String konuDetay) {
		this.konuDetay = konuDetay;
	}


	@Override
	public String toString() {
		return "Konu [id=" + id + ", konuBasligi=" + konuBasligi + ", konuDetay=" + konuDetay + "]";
	}

	
	
}
