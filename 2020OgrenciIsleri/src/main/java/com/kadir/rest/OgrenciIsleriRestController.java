package com.kadir.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadir.domain.OgrenciIsleri;
import com.kadir.service.OgrenciIsleriService;

@RestController
@RequestMapping("students")
public class OgrenciIsleriRestController {
	
	@Autowired
	OgrenciIsleriService ogrenciIsleriService;
	
	@GetMapping("/")
	public List<OgrenciIsleri> ogrenciler(){
		
		
		return ogrenciIsleriService.getOgrenciler(); 
	}
	
	@GetMapping("/{ogrenciNo}")
	public OgrenciIsleri getOgrenci(@PathVariable int ogrenciNo){
		
		
		return ogrenciIsleriService.getOgrenci(ogrenciNo);
	}
}
	