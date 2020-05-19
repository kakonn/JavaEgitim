package com.kadir.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kadir.entity.Ogrenci;
import com.kadir.service.OgrenciServisi;

@Controller
@RequestMapping("/ogrenci")
public class OgrenciController {

	@Autowired
	OgrenciServisi ogrenciServisi;

	// @PostMapping("/list") //form verilerini gonderirken

	// method verilmezse post ile gelinse bile sayfaya kabul et olur
	// @RequestMapping(path = "/list",method = RequestMethod.GET)
	// kýsa hali
	@GetMapping("/list") // sayfa gecisleri icin
	public String listOgrenci(Model model, HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");
		
		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {

			List<Ogrenci> ogrList = ogrenciServisi.getOgrenciler();
			model.addAttribute("ogrenciler", ogrList);
			return "ogrenci-list";
		}
	}

	@GetMapping("/ogrenci-ekle")
	public String ogrenciEkle(Model model, HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");
		
		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {
			Ogrenci ogr = new Ogrenci();
			model.addAttribute("ogrenci", ogr);

			return "ogrenci-form";
		}
	}

	@GetMapping("/ogrenci-guncelle")
	public String ogrenciGuncelle(@RequestParam("ogrenciId") int ogrId, Model model, HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");
	
		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {
			Ogrenci ogr = ogrenciServisi.getOgrenci(ogrId);
			model.addAttribute("ogrenci", ogr);

			return "ogrenci-form";
		}
	}

	@GetMapping("/ogrenci-sil")
	public String ogrenciSil(@RequestParam("ogrenciId") int ogrId, HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {
			ogrenciServisi.deleteOgrenci(ogrId);

			return "redirect:/ogrenci/list";
		}
	}

	@PostMapping("/ogrenci-kaydet")
	public String ogrenciKaydet(@ModelAttribute("ogrenci") Ogrenci ogr) {

		ogrenciServisi.saveOgrenci(ogr);

		return "redirect:/ogrenci/list";
	}

}
