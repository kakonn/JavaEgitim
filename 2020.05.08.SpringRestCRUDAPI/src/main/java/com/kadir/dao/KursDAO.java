package com.kadir.dao;

import java.util.List;

import com.kadir.domain.Kurs;

public interface KursDAO {

	public List<Kurs> getkurslar();

	public Kurs getKurs(int kursId);

}
