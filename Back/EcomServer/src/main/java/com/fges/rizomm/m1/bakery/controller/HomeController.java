package com.fges.rizomm.m1.bakery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping(value="/")
	public ModelAndView welcome()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome"); // resources/template/welcome.html
		return modelAndView;
		
	}
}
