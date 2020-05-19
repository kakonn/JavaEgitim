package com.kadir.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kadir.entity.Ogretmen;
import com.kadir.entity.OgretmenDetay;

public class HibernateOneToOneDeleteOgretmenDetay {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		OgretmenDetay ogrDty = session.get(OgretmenDetay.class, 22);
		Ogretmen og =session.get(Ogretmen.class, 22);
		og.setOgretmenDetay(null);
		session.delete(ogrDty);
		session.getTransaction().commit();
		session.close();

	}

}
