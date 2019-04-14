package com.fges.rizomm.m1.bakery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fges.rizomm.m1.bakery.entites.User;
import com.fges.rizomm.m1.bakery.service.UserService;


@Controller
public class AuthentificationController {

	@Autowired
	UserService userService;
	
	
	@GetMapping(value = { "/login" })
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}

	@GetMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user); 
		modelAndView.setViewName("register"); // resources/template/register.html
		return modelAndView;
	}
	
	@GetMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home"); // resources/template/home.html
		return modelAndView;
	}
	
	@PostMapping(value="/register")
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		// check for validation
		if(bindingResult.hasErrors())
		{
			modelAndView.addObject("successMessage", "Please correct the errors in form !");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		// we will save the user if no binding errors

		/*else if(userService.isUserAlreadyPresent(user)){
			modelAndView.addObject("successMessage", "User already exists.");	}*/
		 else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User is registred successfully");	

		}
		
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}
}
