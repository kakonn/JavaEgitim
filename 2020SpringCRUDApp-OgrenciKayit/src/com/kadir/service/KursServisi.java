package com.kadir.service;

import java.util.List;

import com.kadir.entity.Kurs;
import com.kadir.entity.Ogretmen;

public interface KursServisi {

	public List<Kurs> getKurslar();

	public void kursKaydet(Kurs kurs);

	public Kurs getKurs(int kursId);

	public void kursSil(int kursId);

	public List<Ogretmen> getOgretmenler();






	

	

}
