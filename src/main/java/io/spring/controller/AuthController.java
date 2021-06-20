package io.spring.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
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
import io.spring.utils.Const;

@Controller
public class AuthController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = {"/login"})
	public String loginView(Model model, HttpSession httpSession){
		httpSession.setAttribute(Const.USER_LOGGED, null);
		model.addAttribute("account", new Account());
		return "login";
	}
	
	@GetMapping(value = {"/homepage"})
	public String homePage(Model model){
		return "homePageUser";
	}
	
	@PostMapping(value = {"/login"})
	public String checkLogin(@Validated @ModelAttribute("account") Account account, BindingResult bindingResult ,HttpSession httpSession) throws IllegalAccessException, InvocationTargetException{
		try {
			Optional<Account> accountData = accountService.findById(account.getUsername());  //lấy username bên form để tìm trong database
			System.err.println("user silent : " + account.getUsername());
			System.err.println("pass silent : " + account.getPassword());
			System.err.println("pass data : " + accountData.get().getPassword());
			System.err.println("admin is : " + accountData.get().getAdmin().toString());

			if(!bindingResult.hasErrors() && account.getPassword().equals(accountData.get().getPassword()) && 
					accountData.get().getAdmin() == true) { 						//so sánh bên pass bên form v
				Account account2 = new Account();
				BeanUtils.copyProperties(account2, accountData);
				httpSession.setAttribute(Const.USER_LOGGED, account2);
				return "redirect:/admin/accounts";
			}
			
			else if (!bindingResult.hasErrors() && account.getPassword().equals(accountData.get().getPassword()) && 
					accountData.get().getAdmin() == false) {
				Account account2 = new Account();
				BeanUtils.copyProperties(account2, accountData);
				httpSession.setAttribute(Const.USER_LOGGED, null);
				return "redirect:/homepage";
			}
			
			 else {
				httpSession.setAttribute(Const.USER_LOGGED, null);
				return "login";
			}
		} catch (Exception e) {
			System.err.println("lỗi ko findid");
			return "login";
		}
		

	}
}