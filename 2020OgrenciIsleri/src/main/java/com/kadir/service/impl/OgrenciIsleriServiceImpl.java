package com.kadir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadir.dao.OgrenciIsleriDAO;
import com.kadir.domain.OgrenciIsleri;
import com.kadir.service.OgrenciIsleriService;

@Service
public class OgrenciIsleriServiceImpl implements OgrenciIsleriService {
	
	@Autowired
	OgrenciIsleriDAO ogrenciIsleriDAO;
	
	@Transactional
	@Override
	public List<OgrenciIsleri> getOgrenciler() {
		
		return ogrenciIsleriDAO.getOgrenciler();
	}
	
	@Transactional
	@Override
	public OgrenciIsleri getOgrenci(int ogrenciNo) {
		
		return ogrenciIsleriDAO.getOgrenci(ogrenciNo);
	}
	
	@Transactional
	@Override
	public void update(OgrenciIsleri ogrenci) {
		ogrenciIsleriDAO.update(ogrenci);
		
	}

}
