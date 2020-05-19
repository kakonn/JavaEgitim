package com.kadir.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kadir.entity.Konu;
import com.kadir.entity.Kurs;
import com.kadir.entity.Ogretmen;
import com.kadir.entity.OgretmenDetay;

public class HibernateOneToMany {

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
		
		Kurs kurs = new Kurs("Java12",600,og);
		kurs.addKonu(new Konu("OOP", "Inherirancei, Poliforfizm.."));
		kurs.addKonu(new Konu("Basics", "Kontroller, Donguler.."));
		
		

		
		session.save(kurs);
		session.getTransaction().commit();
		session.close();
		
		

	}



}
