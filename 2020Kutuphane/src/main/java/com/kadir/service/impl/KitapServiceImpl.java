package com.kadir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadir.dao.KitapDAO;
import com.kadir.domain.Kitap;
import com.kadir.domain.OgrenciIsleri;
import com.kadir.service.KitapService;

@Service
public class KitapServiceImpl implements KitapService {
	
	@Autowired
	KitapDAO kitapDAO;
	
	@Transactional
	@Override
	public List<Kitap> getKitaplar() {
		
		return kitapDAO.getKitaplar();
	}
	
	@Transactional
	@Override
	public Kitap getKitap(int kitapId) {

		return kitapDAO.getKitap(kitapId);
	}
	
	@Transactional
	@Override
	public void saveOrUpdate(OgrenciIsleri ogrenci,Kitap kitap) {
		kitapDAO.saveOrUpdate(ogrenci,kitap);
		
	}
	
	@Transactional
	@Override
	public List<Kitap> getKitapp(int ogrenciNo) {
		
		return kitapDAO.getKitapp(ogrenciNo);
	}

}
