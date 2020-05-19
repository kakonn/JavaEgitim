package com.kadir.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.kadir.entity.Kurs;
import com.kadir.entity.Ogrenci;
import com.kadir.entity.Ogretmen;
import com.kadir.entity.OgretmenDetay;

public class HibernateManyToMany {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Ogrenci.class)
				.buildSessionFactory();

	/*	// create session
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
	//	Ogretmen og = session.get(Ogretmen.class, 32);
		
		Kurs kurs = session.get(Kurs.class, 43);
		
		Ogrenci ogrenci1 = new Ogrenci("Kadir", "Kondur", 299);
		Ogrenci ogrenci2 = new Ogrenci("Ali", "Bak", 8117);
		
		kurs.addOgrenci(ogrenci1);
		kurs.addOgrenci(ogrenci2);
		
		
		session.save(kurs);
		session.getTransaction().commit();
		session.close();
		*/
		
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
	//	Ogretmen og = session.get(Ogretmen.class, 32);
		Ogrenci ogrenci = session.get(Ogrenci.class, 1);
		Kurs kurs = session.get(Kurs.class, 7);
		
		
		ogrenci.addKurs(kurs);
		
		
		session.save(ogrenci);
		session.getTransaction().commit();
		session.close();
		

	}



}
