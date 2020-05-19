package com.kadir.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadir.dao.OgrenciIsleriDAO;
import com.kadir.domain.OgrenciIsleri;

@Repository
public class OgrenciIsleriDAOImpl implements OgrenciIsleriDAO {
		
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<OgrenciIsleri> getOgrenciler() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<OgrenciIsleri> query = session.createQuery("from OgrenciIsleri o where aktif=1",OgrenciIsleri.class);
		List<OgrenciIsleri> resultList = query.getResultList();
		
		return resultList;
	}

	@Override
	public OgrenciIsleri getOgrenci(int ogrenciNo) {
		Session session = sessionFactory.getCurrentSession();
		
		OgrenciIsleri ogrenci = session.get(OgrenciIsleri.class, ogrenciNo);
		return ogrenci;
	}

	@Override
	public void update(OgrenciIsleri ogrenci) {
		Session session = sessionFactory.getCurrentSession();
		session.update(ogrenci);
		
	}

}
