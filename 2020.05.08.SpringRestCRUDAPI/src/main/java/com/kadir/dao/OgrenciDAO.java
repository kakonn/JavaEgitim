package com.kadir.dao;

import java.util.List;

import com.kadir.domain.Ogrenci;

public interface OgrenciDAO {

	public List<Ogrenci> getOgrenciler();

	public Ogrenci getOgrenci(int ogrenciId);

	public void saveOgrenci(Ogrenci ogrenci);

	public int deleteOgrenci(int ogrenciId);

	

}
