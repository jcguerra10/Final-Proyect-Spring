package com.icesi.store.finalproyect.controller;

import com.icesi.store.finalproyect.model.product.UserApp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LogInController {

	@GetMapping("/login")
	public String login(UserApp ua) {
		
		return "login";
	}
	
	/*
	@PostMapping("/login")
	public String postLogin(UserApp ua) {
		System.out.println(">>>>>>>>");
		return "redirect:index";
	}
	*/
}
