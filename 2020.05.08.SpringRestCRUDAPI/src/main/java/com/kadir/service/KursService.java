package com.kadir.service;

import java.util.List;

import com.kadir.domain.Kurs;

public interface KursService {

	public List<Kurs> getKurslar();

	public Kurs getKurs(int kursId);

}
