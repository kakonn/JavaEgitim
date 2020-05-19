package com.kadir.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadir.domain.Kurs;
import com.kadir.service.KursService;

//@RestController
//@RequestMapping("/kurs")
public class KursRestController {
	
	//@Autowired
	private KursService kursService;
	
	
	@GetMapping("/")
	public List<Kurs> kurslar(){
		return kursService.getKurslar();
	}
	
	@GetMapping("/{kursId}")
	public Kurs getKurs(@PathVariable int kursId) {
		
		return kursService.getKurs(kursId);
	}
}
