package com.kadir.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ogrenci_isleri")
public class OgrenciIsleri {
	
	@Id
	@Column(name = "ogrenci_no")
	private Integer ogrenciNo;
	
	@Column(name = "isim")
	private String isim;
	
	@Column(name = "soyisim")
	private String soyisim;
	
	@Column(name = "aktif")
	private boolean aktif;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "ogrenci",fetch = FetchType.EAGER)
	private List<Kitap> kitap;
	
	
	
	public List<Kitap> getKitap() {
		return kitap;
	}

	public void setKitap(List<Kitap> kitap) {
		this.kitap = kitap;
	}

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

	@Override
	public String toString() {
		return "OgrenciIsleri [ogrenciNo=" + ogrenciNo + ", isim=" + isim + ", soyisim=" + soyisim + ", aktif=" + aktif
				 + "]";
	}
	
	
}

