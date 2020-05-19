package com.kadir.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kitap")
public class Kitap {
	
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "kitap_adi")
	private String kitapAdi;

	@Column(name = "yazar")
	private String yazar;

	@ManyToOne
	@JoinColumn(name = "ogrenci_no")
	private OgrenciIsleri ogrenci;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

	public OgrenciIsleri getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(OgrenciIsleri ogrenci) {
		this.ogrenci = ogrenci;
	}

	@Override
	public String toString() {
		return "Kitap [id=" + id + ", kitapAdi=" + kitapAdi + ", yazar=" + yazar + ", ogrenci=" + ogrenci.getOgrenciNo() + "]";
	}
	
	
}
