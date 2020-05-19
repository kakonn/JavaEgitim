package com.kadir.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OGRENCI")
public class Ogrenci {

	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator="ogr-seq")
	@SequenceGenerator(name = "ogr-seq", sequenceName="SEQ_OGRENCI",allocationSize = 1)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "ISIM")
	private String isim;

	@Column(name = "SOYISIM")
	private String soyisim;

	@Column(name = "OGRENCI_NO")
	private Integer ogrenciNo;

	@Column(name = "MEZUNIYET_TARIHI")
	private Date mezuniyetTarihi;

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

}
