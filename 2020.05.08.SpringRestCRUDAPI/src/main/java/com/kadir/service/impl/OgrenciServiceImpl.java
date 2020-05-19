package com.kadir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadir.dao.OgrenciDAO;
import com.kadir.domain.Ogrenci;
import com.kadir.service.OgrenciService;

@Service
public class OgrenciServiceImpl implements OgrenciService{
	
	@Autowired
	private OgrenciDAO ogrenciDAO;
	
	
	@Transactional
	@Override
	public List<Ogrenci> getOgrenciler() {
		
		return ogrenciDAO.getOgrenciler();
	}
	
	
	@Transactional
	@Override
	public Ogrenci getOgrenci(int ogrenciId) {
		return ogrenciDAO.getOgrenci(ogrenciId);
	}
	
	
	public OgrenciDAO getOgrenciDAO() {
		return ogrenciDAO;
	}

	public void setOgrenciDAO(OgrenciDAO ogrenciDAO) {
		this.ogrenciDAO = ogrenciDAO;
	}

	@Transactional
	@Override
	public void addOgrenci(Ogrenci ogrenci) {
		ogrenciDAO.saveOgrenci(ogrenci);
		
	}

	@Transactional
	@Override
	public void updateOgrenci(Ogrenci ogrenci) {
		ogrenciDAO.saveOgrenci(ogrenci);
		
	}

	@Transactional
	@Override
	public int deleteOgrenci(int ogrenciId) {
		return ogrenciDAO.deleteOgrenci(ogrenciId);
		
	}

}
