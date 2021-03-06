package com.kadir.dao;

import java.util.List;

import com.kadir.domain.Kitap;
import com.kadir.domain.OgrenciIsleri;

public interface KitapDAO {

	List<Kitap> getKitaplar();

	Kitap getKitap(int kitapId);

	void saveOrUpdate(OgrenciIsleri ogrenci,Kitap kitap);

	List<Kitap> getKitapp(int ogrenciNo);

}
