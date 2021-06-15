package io.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import io.spring.entities.Account;
import io.spring.service.AccountService;

@Controller
public class RegisterController {
	
	@Autowired
	AccountService accountService;

	@GetMapping("/register")
	public String register(Model model){
		model.addAttribute("registerForm", new Account());
		return "register";
	} 
	
	@PostMapping("/register")
	public String registerAcc(@Validated @ModelAttribute("registerForm") Account account,
			BindingResult bindingResult, Model model){
		boolean check = bindingResult.hasErrors();
		if(!check) {
			accountService.save(account);
			model.addAttribute("message", "Save product is successfuly");
			return "register";
		} else {
			return "register";
		}
	} 
	
	 

	
	
}
