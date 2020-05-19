package com.kadir.databinding;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anket")
public class AnketController {
	@Autowired
	private ApplicationContext context;
	@Autowired
	private Anket anket;
	
	@RequestMapping("/showform")
	public String showPersonel(Model model) {

		// Anket anket = new Anket();
		
		model.addAttribute("ank", anket);

		return "anket-form1";
	}

	@RequestMapping("/showform2")
	public String showPersonel2(Model model, @Valid Anket anket1, BindingResult bindingResult) {
		/*anket= new Anket();
		anket.setAdres("afda");
		anket.setEposta("abc@hotmail.com");
		anket.setBolum("aga");
		anket.setOkul("gad");*/

		anket.setUyruk(anket1.getUyruk());
		anket.setIsim(anket1.getIsim());
		anket.setSoyisim(anket1.getSoyisim());
		anket.setCinsiyet(anket1.getCinsiyet());
		anket.setSehir(anket1.getSehir());
		model.addAttribute("ank", anket1);
		

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "anket-form1";
		} else
			return "anket-form2";

	}

	/*
	 * @RequestMapping("/saveform1") public String
	 * savePersonel1(@ModelAttribute("ank") Anket anket1) {
	 * 
	 * return "anket-form2"; }
	 */

	@RequestMapping("/saveform")
	public String savePersonel(Model model, @ModelAttribute("ank2") @Valid Anket anket2, BindingResult bindingResult) {

		model.addAttribute("ank", anket);
		model.addAttribute("ank2", anket2);
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "anket-form2";
		} else
			return "anket-confirm";

	}

}
