package com.kadir.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OGRETMEN_DETAY")
public class OgretmenDetay {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "ogretmen_det_seq",sequenceName = "seq_ogretmen_detay",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ogretmen_det_seq")
	private Integer id;
	@Column(name="expertise")
	private String expertise;
	@Column(name="hobby")
	private String hobby;
	@Column(name="website")
	private String website;
	@Column(name="fb_page")
	private String fbPage;
	
	// All delete
	//@OneToOne(mappedBy = "ogretmenDetay",cascade = {CascadeType.ALL,CascadeType.REMOVE})
	@OneToOne(mappedBy = "ogretmenDetay",cascade = CascadeType.PERSIST)
	private Ogretmen ogretmen;
	
	public OgretmenDetay() {
		super();
	}
	public OgretmenDetay(String expertive, String hobby, String website, String fbPage) {
		super();
		this.expertise = expertive;
		this.hobby = hobby;
		this.website = website;
		this.fbPage = fbPage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getExpertive() {
		return expertise;
	}
	public void setExpertive(String expertise) {
		this.expertise = expertise;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getFbPage() {
		return fbPage;
	}
	public void setFbPage(String fbPage) {
		this.fbPage = fbPage;
	}
	public Ogretmen getOgretmen() {
		return ogretmen;
	}
	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}
	@Override
	public String toString() {
		return "OgretmenDetay [id=" + id + ", expertise=" + expertise + ", hobby=" + hobby + ", website=" + website
				+ ", fbPage=" + fbPage + ", ogretmen=" + ogretmen.getId() + "]";
	}
	
	
	
	
	
}
