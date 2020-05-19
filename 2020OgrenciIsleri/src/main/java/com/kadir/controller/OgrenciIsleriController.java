package com.kadir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.kadir.domain.Kitap;
import com.kadir.domain.OgrenciIsleri;
import com.kadir.service.OgrenciIsleriService;

@Controller
@RequestMapping("/ogrenci")
public class OgrenciIsleriController {
	
	static final String serverUrl = "http://localhost:8088/2020Kutuphane/kitap/";
	static RestTemplate restTemplete = new RestTemplate();

	public static List<Kitap> getKitaplar(int ogrenciNo) {
		ResponseEntity<List<Kitap>> respEntity = restTemplete.exchange(serverUrl + ogrenciNo, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Kitap>>() {
				});
		return respEntity.getBody();
	}
	
	@Autowired
	OgrenciIsleriService ogrenciIsleriService;

	@GetMapping("/list")
	public String aktifOgrenci(Model model) {
		
		List<OgrenciIsleri> aktifOgrenciler = ogrenciIsleriService.getOgrenciler();
		model.addAttribute("ogrenciler",aktifOgrenciler);

		return "ogrenci-list";
	}
	
	@GetMapping("/mezun-et")
	public String mezunEt(@RequestParam int ogrenciNo,@ModelAttribute OgrenciIsleri ogrenci) {
		
		List<Kitap> kitap = getKitaplar(ogrenciNo);
		System.out.println("kitapp"+kitap);
		if(!kitap.isEmpty()) {
			
			return "ogrenci-hata";
		}else {
			ogrenci.setAktif(false);
			System.out.println("ogrenciii"+ogrenci);
			ogrenciIsleriService.update(ogrenci);
		return "redirect:/ogrenci/list";
		}
	}

}
