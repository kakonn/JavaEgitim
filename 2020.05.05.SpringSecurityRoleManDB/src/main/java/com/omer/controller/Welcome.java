package com.omer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {

	@RequestMapping("/")
	public String homePage()
	{
		
		return "home";
	}
	
	@RequestMapping("/test")
	public String test()
	{
		
		return "welcome";
	}
}
