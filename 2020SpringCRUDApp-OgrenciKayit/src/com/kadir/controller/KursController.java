package com.kadir.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kadir.entity.Kurs;
import com.kadir.entity.Ogretmen;
import com.kadir.entity.User;
import com.kadir.service.KursServisi;

@Controller
@RequestMapping("/kurs")
public class KursController {

	@Autowired
	User user;

	@Autowired
	KursServisi kursServisi;

	@GetMapping("/list")
	public String kursListele(Model model, HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {
			System.out.println("user" + user);
			List<Kurs> kursList = kursServisi.getKurslar();
			model.addAttribute("kurslar", kursList);

			return "kurs-list";
		}
	}

	@GetMapping("/kurs-ekle")
	public String kursEkle(Model model, HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");
	
		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {

			Kurs kurs = new Kurs();
			model.addAttribute("kurs", kurs);

			return "kurs-form";
		}
	}

	@PostMapping("/kurs-kaydet")
	public String kursKaydet(@ModelAttribute Kurs kurs) {
		kursServisi.kursKaydet(kurs);

		return "redirect:/kurs/list";
	}

	@GetMapping("/kurs-guncelle")
	public String kursGuncelle(@RequestParam("kursId") int kursId, Model model, HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");
	
		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {
			Kurs kurs = kursServisi.getKurs(kursId);
			model.addAttribute("kurs", kurs);

			return "kurs-form";
		}
	}

	@GetMapping("/kurs-sil")
	public String kursSil(@RequestParam("kursId") int kursId, HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {
			kursServisi.kursSil(kursId);

			return "redirect:/kurs/list";
		}
	}
	
	@ModelAttribute("ogretmenler")
	public Map<Integer, String> getDepartment() {

		List<Ogretmen> ogretmenList = kursServisi.getOgretmenler();
		Map<Integer, String> ogretmenMap = new HashMap<Integer, String>();
		for (Ogretmen ogretmen : ogretmenList) {
			// if (department.getManager() != null)
			ogretmenMap.put(ogretmen.getId(), ogretmen.getFirstName()+ogretmen.getLastName());
		}

		return ogretmenMap;
	}
}
