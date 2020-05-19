package com.kadir.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kadir.entity.Konu;
import com.kadir.entity.Kurs;
import com.kadir.entity.Ogretmen;
import com.kadir.entity.OgretmenDetay;

public class HibernateOneToManySergile {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Konu.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		Ogretmen og = session.get(Ogretmen.class, 32);
		Kurs k = og.getKurslar().get(3);
		System.out.println(og.getKurslar());
		Konu ko = k.getKonular().get(0);
		System.out.println("konular: " + k.getKonular());
		
		og.sergile();
		session.getTransaction().commit();
		session.close();
		
		
	}



}
