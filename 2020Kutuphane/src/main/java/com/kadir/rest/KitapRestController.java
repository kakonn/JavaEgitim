package com.kadir.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadir.domain.Kitap;
import com.kadir.service.KitapService;

@RestController
@RequestMapping("/kitap")
public class KitapRestController {
	
	@Autowired
	KitapService kitapService;
	
	@GetMapping("/{ogrenciNo}")
	public List<Kitap> getOgrenci(@PathVariable int ogrenciNo){
		
		
		return kitapService.getKitapp(ogrenciNo);
	}
}
