package com.kadir.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadir.dao.KitapDAO;
import com.kadir.domain.Kitap;
import com.kadir.domain.OgrenciIsleri;

@Repository
public class KitapDAOImpl implements KitapDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Kitap> getKitaplar() {
		Session session = sessionFactory.getCurrentSession();

		Query<Kitap> query = session.createQuery("from Kitap", Kitap.class);
		List<Kitap> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public Kitap getKitap(int kitapId) {
		Session session = sessionFactory.getCurrentSession();

		Kitap kitap = session.get(Kitap.class, kitapId);
		return kitap;
	}

	@Override
	public void saveOrUpdate(OgrenciIsleri ogrenci, Kitap kitap) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ogrenci);
		session.saveOrUpdate(kitap);
	}

	@Override
	public List<Kitap> getKitapp(int ogrenciNo) {
		Session session = sessionFactory.getCurrentSession();
		Query<Kitap> query = session.createQuery("from Kitap k where ogrenci.ogrenciNo= :ogrenciNo",Kitap.class)
				.setParameter("ogrenciNo", ogrenciNo);
		List<Kitap> resultList = query.getResultList();
		return resultList;
	}

}
