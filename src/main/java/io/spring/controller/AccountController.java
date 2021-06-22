package io.spring.controller;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.spring.entities.Account;
import io.spring.model.AccountModel;
import io.spring.service.AccountService;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ServletContext application;

	@ModelAttribute("listSelect")
	public Map<Integer, String> getListSelect() {
		Map<Integer, String> listSelect = new HashMap<Integer, String>();
		listSelect.put(1, "Yes");
		listSelect.put(0, "No");
		return listSelect;
	}

	@GetMapping("")
	public String getAll(Model model, @RequestParam(name = "field", defaultValue = "") String field,
			@RequestParam(name = "page") Optional<Integer> page) {
		model.addAttribute("list", accountService.findAll(page.orElse(0), 4, field));
		return "accountsAdminList";
	}

	@GetMapping("/create")
	public String viewCreate(Model model) {
		model.addAttribute("accountForm", new AccountModel());
		return "accountsAdminCreate";
	}

	@PostMapping("/create")
	public String saveAccount(@Validated @ModelAttribute("accountForm") AccountModel accountModel, BindingResult bindingResult,
			@Parameter(name = "photo") MultipartFile photo, RedirectAttributes rAttributes,
			Model model) throws IllegalAccessException, InvocationTargetException {
		if (!bindingResult.hasErrors()) {
			Account account = new Account();
			String path = application.getRealPath("/");
			try {
				String filePath = path + "/images/" + accountModel.getPhoto().getOriginalFilename();
				accountModel.getPhoto().transferTo(Paths.get(filePath));
			} catch (Exception e) {
				System.err.println("có lỗi tại trycath");
			}
			BeanUtils.copyProperties(account, accountModel);
			account.setPhoto(accountModel.getPhoto().getOriginalFilename());
			rAttributes.addFlashAttribute("message", "Save Account is successfuly with username : " + accountModel.getUsername());
			accountService.save(account);
			return "redirect:/admin/accounts";
		} else {
			return "accountsAdminCreate";
		}
	}
	
	
	@GetMapping("/edit/{username}")
	public String editView(@PathVariable("username") String username, Model model) {
		Optional<Account> account = accountService.findById(username);
		model.addAttribute("accountForm", account.get());
		model.addAttribute("usernameValue", username);
		return "accountsAdminEdit";
	} 
	
	@PostMapping("/edit/{username}")
	public String editAccount(@Validated @ModelAttribute("accountForm") AccountModel accountModel,
			@Parameter(name = "photo") MultipartFile photo, BindingResult bindingResult, RedirectAttributes rAttributes,
			Model model) throws IllegalAccessException, InvocationTargetException {
		String path = application.getRealPath("/");
		try {
			String filePath = path + "/images/" + accountModel.getPhoto().getOriginalFilename();
			accountModel.getPhoto().transferTo(Paths.get(filePath));
		} catch (Exception e) {
			System.err.println("có lỗi tại trycath");
		}
		
		if (!bindingResult.hasErrors()) {
			Account account = new Account();
			BeanUtils.copyProperties(account, accountModel);
			account.setPhoto(accountModel.getPhoto().getOriginalFilename());
			rAttributes.addFlashAttribute("message", "Edit Account is successfuly with username : " + accountModel.getUsername());
			accountService.save(account);
			return "redirect:/admin/accounts";
		} else {
			return "accountsAdminEdit";
		}
	} 
	
	
	@GetMapping("/delete/{username}")
	public String delete(@PathVariable("username") String username, Model model , RedirectAttributes rAttributes){
		accountService.deleteById(username);
		rAttributes.addFlashAttribute("message", "Delete Account is successfuly with username: " + username);
		return "redirect:/admin/accounts";
	} 

}
