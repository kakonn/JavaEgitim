package com.kadir.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadir.dao.KursDAO;
import com.kadir.domain.Kurs;

//@Repository
public class KursDAOImpl implements KursDAO {
	
	//@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Kurs> getkurslar() {
		Session session = sessionFactory.getCurrentSession();
		Query<Kurs> query = session.createQuery("from Kurs ",Kurs.class);
		List<Kurs> resultList = query.getResultList();
		
		return resultList;
	}

	@Override
	public Kurs getKurs(int kursId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Kurs.class, kursId);
	}

}
