package com.kadir.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OGRENCI_ISLERI")
public class OgrenciIsleri {
	
	@Id
	@Column(name = "OGRENCI_NO")
	private Integer ogrenciNo;
	
	@Column(name = "ISIM")
	private String isim;
	
	@Column(name = "SOYISIM")
	private String soyisim;
	
	@Column(name = "AKTIF")
	private boolean aktif;
	

	public Integer getOgrenciNo() {
		return ogrenciNo;
	}

	public void setOgrenciNo(Integer ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
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

	public boolean isAktif() {
		return aktif;
	}

	public void setAktif(boolean aktif) {
		this.aktif = aktif;
	}
	
	
}

