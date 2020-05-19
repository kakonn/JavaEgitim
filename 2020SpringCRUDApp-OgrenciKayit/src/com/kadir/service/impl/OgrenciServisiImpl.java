package com.kadir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadir.dao.OgrenciDAO;
import com.kadir.entity.Ogrenci;
import com.kadir.service.OgrenciServisi;

@Service
public class OgrenciServisiImpl implements OgrenciServisi {
	
	@Autowired
	OgrenciDAO ogrenciDAO;
	
	@Transactional
	@Override
	public List<Ogrenci> getOgrenciler() {
		
		return ogrenciDAO.getOgrenciler();
	}
	
	@Transactional
	@Override
	public void saveOgrenci(Ogrenci ogr) {
		//on kontroller
		ogrenciDAO.saveOgrenci(ogr);

	}
	
	@Transactional
	@Override
	public Ogrenci getOgrenci(int ogrId) {
		
		
		return ogrenciDAO.getOgrenci(ogrId);
	}
	
	@Transactional
	@Override
	public void deleteOgrenci(int ogrId) {
		ogrenciDAO.deleteOgrenci(ogrId);
		
	}
	
	

}
