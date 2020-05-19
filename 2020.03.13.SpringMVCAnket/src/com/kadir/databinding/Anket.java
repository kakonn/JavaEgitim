package com.kadir.databinding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;





@Component
@Scope("prototype")
public class Anket {
    int i=0;
    @NotEmpty(message = "Bu Alan Zorunludur!")
	private String uyruk;
    @NotEmpty(message = "Bu Alan Zorunludur!")
    private String isim;
    @NotEmpty(message = "Bu Alan Zorunludur!")
	private String soyisim;
    @NotEmpty(message = "Bu Alan Zorunludur!")
	private String cinsiyet;
    @NotEmpty(message = "Bu Alan Zorunludur!")
	private String sehir;
    @NotEmpty(message = "Bu Alan Zorunludur!")
    @Size(min = 1, max = 100)
   // @Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$")
	private String eposta;
    @NotEmpty(message = "Bu Alan Zorunludur!")
	private String adres;
    @NotEmpty(message = "Bu Alan Zorunludur!")
	private static List<String> sehirler;
    @NotEmpty(message = "Bu Alan Zorunludur!")
	private String okul;
	private static List<String> okullar;
	@NotEmpty(message = "Bu Alan Zorunludur!")
	private String bolum;
	private static List<String> bolumler;
	private String ortalama;
	private String egitimDurumu;
	private  String[] yabanciDil;
	static String ydil="";
	String errorMessage;

	

	static {
		sehirler = new ArrayList<String>();
		sehirler.add("Adana");
		sehirler.add("Ankara");
		sehirler.add("Bolu");
		sehirler.add("Isparta");
		sehirler.add("Antalya");
		sehirler.add("Denizli");
		sehirler.add("Amasya");

		okullar = new ArrayList<String>();
		okullar.add("Ankara Universitesi");
		okullar.add("Gazi Universitesi");
		okullar.add("Hacettepe Universitesi");
		okullar.add("Akdeniz Universitesi");
		okullar.add("Pamukkale Universitesi");
		okullar.add("Suleyman Demirel Universitesi");
		okullar.add("Amasya Universitesi");

		bolumler = new ArrayList<String>();
		bolumler.add("Bilgisayar Muhendisligi");
		bolumler.add("Fen-Edebiyat");
		bolumler.add("Hukuk");
		bolumler.add("Elektrik Elektronik Muhendisligi");
		bolumler.add("Hemsirelik");
	}
	public Anket() {
		System.out.println("merhaba");
		yabanciDil = new String[3];
	}
	public String getUyruk() {
		return uyruk;
	}

	public void setUyruk(String uyruk) {
		this.uyruk = uyruk;
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

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public List<String> getSehirler() {
		return sehirler;
	}

	public void setSehirler(List<String> sehirler) {
		this.sehirler = sehirler;
	}

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getOkul() {
		return okul;
	}

	public void setOkul(String okul) {
		this.okul = okul;
	}

	public List<String> getOkullar() {
		return okullar;
	}

	public void setOkullar(List<String> okullar) {
		this.okullar = okullar;
	}

	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public List<String> getBolumler() {
		return bolumler;
	}

	public void setBolumler(List<String> bolumler) {
		this.bolumler = bolumler;
	}

	public String getEgitimDurumu() {
		return egitimDurumu;
	}

	public void setEgitimDurumu(String egitimDurumu) {
		this.egitimDurumu = egitimDurumu;
	}

	public String getOrtalama() {
		return ortalama;
	}

	public void setOrtalama(String ortalama) {
		this.ortalama = ortalama;
	}

	public String[] getYabanciDil() {
		return yabanciDil;
	}

	public void setYabanciDil(String[] yabanciDil) {
		for (int i = 0; i < yabanciDil.length; i++) {
			if(yabanciDil[i]!=null) {
				ydil+=yabanciDil[i]+",";
				ydil=ydil.substring(0,ydil.length()-1);
			}
		}
		System.out.println(ydil);
		System.out.println("abcbcbc");
		this.yabanciDil = yabanciDil;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String veriTabaninaGonder() {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			//Class.forName("oracle.jdbcdriver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "basvuru", "basvuru");

			ps = con.prepareStatement(
					"INSERT INTO basvuru(uyruk, isim, soyisim, cinsiyet, sehir, eposta, adres, okul, bolum, ortalama, egitimDurumu, yabanciDil) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, uyruk);
			ps.setString(2, isim);
			ps.setString(3, soyisim);
			ps.setString(4, cinsiyet);
			ps.setString(5, sehir);
			ps.setString(6, eposta);
			ps.setString(7, adres);
			ps.setString(8, okul);
			ps.setString(9, bolum);
			ps.setString(10, ortalama);
			ps.setString(11, egitimDurumu);
			ps.setString(12, ydil);

			i=ps.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			}
		}
		if (i > 0) {
			return "basarili?faces-redirect=true";
		} else {
			return "basarisiz?faces-redirect=true";
		}
	}

}
