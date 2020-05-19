package com.kadir.service;

import java.util.List;

import com.kadir.domain.OgrenciIsleri;

public interface OgrenciIsleriService {

	List<OgrenciIsleri> getOgrenciler();

	OgrenciIsleri getOgrenci(int ogrenciNo);

	void update(OgrenciIsleri ogrenci);

}
