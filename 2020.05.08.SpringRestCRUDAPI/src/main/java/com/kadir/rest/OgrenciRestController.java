package com.kadir.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadir.domain.Ogrenci;
import com.kadir.service.OgrenciService;

@RestController
@RequestMapping("students")
public class OgrenciRestController {
	
	@Autowired
	private OgrenciService ogrenciService;
	
	
	public OgrenciService getOgrenciService() {
		return ogrenciService;
	}


	public void setOgrenciService(OgrenciService ogrenciService) {
		this.ogrenciService = ogrenciService;
	}

	@GetMapping("/")
	public List<Ogrenci> ogrenciler(){
		
		
		return ogrenciService.getOgrenciler();
	}
	
	@GetMapping("/{ogrenciId}")
	public Ogrenci getOgrenci(@PathVariable int ogrenciId){
		
		
		return ogrenciService.getOgrenci(ogrenciId);
	}
	
	@PostMapping("/")
	public Ogrenci addOgrenci(@RequestBody Ogrenci ogrenci) {
		ogrenciService.addOgrenci(ogrenci);
		return ogrenci;
	}
	
	@PutMapping("/")
	public Ogrenci updateOgrenci(@RequestBody Ogrenci ogrenci) {
		ogrenciService.updateOgrenci(ogrenci);
		return ogrenci;
	}
	
	@DeleteMapping("/{ogrenciId}")
	public String deleteOgrenci(@PathVariable int ogrenciId) {
		int sonuc = ogrenciService.deleteOgrenci(ogrenciId);
		
		if(sonuc > 0)
		return sonuc + "kayýt Sildum";
		else
			return ogrenciId +"li kayýt bulunamadý";
	}
}
