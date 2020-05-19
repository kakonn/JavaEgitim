package com.kadir.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.kadir.entity.User;
import com.kadir.entity.UserLogin;
import com.kadir.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		UserLogin userLogin = new UserLogin();
		model.addAttribute("user-login", userLogin);
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@GetMapping("/welcome")
	public String welcomePage(HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");
		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {
			return "welcome";
		}
	}

	@PostMapping("/register-success")
	public String registerSuccess(@ModelAttribute("user-login") UserLogin userLogin,
			@Valid @ModelAttribute("user") User user, BindingResult bindingResult1, Model model, ModelMap modelMap) {
		// model.addAttribute("user-login" + new UserLogin());
		if (bindingResult1.hasErrors()) {
			return "login";
		} 
		List<User> userList = userservice.getUsers();
		for (User user2 : userList) {
			if(user.getEmail().equals(user2.getEmail())) {
				return "login";
			}
		}
			modelMap.put("basarili", "Kayit Basarili");
			userservice.registerUser(user);
			userLogin.setEmail("");
			userLogin.setPassword("");
			return "login";

		

	}

	@PostMapping("/login-success")
	public String loginSuccess(@ModelAttribute("user") User user,
			@ModelAttribute("user-login") @Valid UserLogin userLogin, BindingResult bindingResult2, ModelMap modelMap,
			Model model, HttpSession oturum) {

		// model.addAttribute("user" + new User());

		if (bindingResult2.hasErrors()) {
			return "login";
		} else {

			// System.out.println("user " + userLogin.getEmail() + userLogin.getPassword());
			user = getUserservice().validateUserLogin(userLogin.getEmail(), userLogin.getPassword());

			if (user != null) {

				oturum.setAttribute("oturumIsim", user.getName());
				//modelMap.put("aa", user.getName());
				return "welcome";
			} else {
				modelMap.put("error", "Invalid Account");
				return "login";
			}
		}

	}

	@RequestMapping("/endsession")
	public String nextHandlingMethod2(SessionStatus status, HttpSession oturum) {
		//if(oturum.getAttribute("oturumIsim") != null) {
		status.setComplete();
		oturum.invalidate();
	//	}
		// System.out.println(oturum.getAttribute("oturum-email"));
		return "redirect:/user/login";
	}
}
