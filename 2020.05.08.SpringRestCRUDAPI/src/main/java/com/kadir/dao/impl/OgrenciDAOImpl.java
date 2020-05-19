package com.kadir.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadir.dao.OgrenciDAO;
import com.kadir.domain.Ogrenci;

@Repository
public class OgrenciDAOImpl implements OgrenciDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Ogrenci> getOgrenciler() {
		
		Session session  = sessionFactory.getCurrentSession();
		Query<Ogrenci> query = session.createQuery("from Ogrenci order by isim",Ogrenci.class);
		List<Ogrenci> resultList = query.getResultList();
		
		return resultList;
	}

	@Override
	public Ogrenci getOgrenci(int ogrenciId) {
		Session session  = sessionFactory.getCurrentSession();
		return session.get(Ogrenci.class, ogrenciId);
		
	}

	@Override
	public void saveOgrenci(Ogrenci ogrenci) {
		Session session  = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ogrenci);
		
	}

	@Override
	public int deleteOgrenci(int ogrenciId) {
		Session session  = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Ogrenci where id= :ogrenciId").setParameter("ogrenciId", ogrenciId);
		
		
		return query.executeUpdate();
	}

}
