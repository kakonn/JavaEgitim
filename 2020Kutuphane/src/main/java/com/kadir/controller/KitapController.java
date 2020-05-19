package com.kadir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.kadir.domain.Kitap;
import com.kadir.domain.OgrenciIsleri;
import com.kadir.service.KitapService;

@Controller
@RequestMapping("/kitaplar")
public class KitapController {

	static final String serverUrl = "http://localhost:8088/2020OgrenciIsleri/students/";
	static RestTemplate restTemplete = new RestTemplate();

	private static OgrenciIsleri getOgrenci(int ogrenciNo) {
		return restTemplete.getForObject(serverUrl + "/" + ogrenciNo, OgrenciIsleri.class);

	}

	@Autowired
	KitapService kitapService;

	@GetMapping("/list")
	public String kitaplar(Model model) {

		List<Kitap> kitaplar = kitapService.getKitaplar();
		model.addAttribute("kitaplar", kitaplar);
		return "kitap-list";
	}

	@GetMapping("/kitap-ekle")
	public String kitapVer(@RequestParam int kitapId, Model model) {

		Kitap kitap = kitapService.getKitap(kitapId);
		model.addAttribute("kitaplar", kitap);

		return "kitap-form";
	}

	
	@PostMapping("/kitap-teslim")
	public String kitapTeslim(@ModelAttribute("kitaplar") Kitap kitap, ModelMap modelMap,Model model) {

		System.out.println(kitap.getOgrenci().getOgrenciNo());

		OgrenciIsleri ogrenci = getOgrenci(kitap.getOgrenci().getOgrenciNo());
		if (ogrenci != null) {
			if(ogrenci.isAktif()) {
				System.out.println(ogrenci.isAktif());
				System.out.println(kitap.getId());
			kitapService.saveOrUpdate(ogrenci, kitap);
			
			return "redirect:/kitaplar/list";
			}else {
				modelMap.put("hata", "Öðrenci Mezun !");
				model.addAttribute("kitaplar", kitap);
				return "kitap-form";
			}
		} else {
			modelMap.put("hata", "Öðrenci Bulunmamaktadýr !");
			model.addAttribute("kitaplar", kitap);
			return "kitap-form";
		}

	}
}
