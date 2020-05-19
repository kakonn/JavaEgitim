package com.kadir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadir.dao.KursDAO;
import com.kadir.domain.Kurs;
import com.kadir.service.KursService;

//@Service
public class KursServiceImpl implements KursService {
	
	//@Autowired
	private KursDAO kursDAO;
	
	//@Transactional
	@Override
	public List<Kurs> getKurslar() {
		return kursDAO.getkurslar();
	}
	
	//@Transactional
	@Override
	public Kurs getKurs(int kursId) {
		return kursDAO.getKurs(kursId);
	}

}
