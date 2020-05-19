package com.kadir.dao;

import java.util.List;

import com.kadir.domain.OgrenciIsleri;

public interface OgrenciIsleriDAO {

	List<OgrenciIsleri> getOgrenciler();

	OgrenciIsleri getOgrenci(int ogrenciNo);

	void update(OgrenciIsleri ogrenci);

}
