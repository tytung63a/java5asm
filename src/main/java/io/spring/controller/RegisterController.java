package io.spring.controller;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.spring.entities.Account;
import io.spring.model.AccountModel;
import io.spring.service.AccountService;

@Controller
public class RegisterController {

	@Autowired
	AccountService accountService;

	@Autowired
	private ServletContext application;

	@Autowired
	MailSender mailSender;

	@GetMapping("/register")
	public String viewCreate(Model model) {
		model.addAttribute("registerForm", new AccountModel());
		return "register";
	}

	public void sendEmail(String from, String to, String subject, String content) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		mailSender.send(mailMessage);
	}

	@PostMapping("/register")
	public String saveAccount(@Validated @ModelAttribute("registerForm") AccountModel accountModel,
			BindingResult bindingResult, @Parameter(name = "photo") MultipartFile photo, RedirectAttributes rAttributes,
			Model model) throws IllegalAccessException, InvocationTargetException {

		if (!bindingResult.hasErrors() && accountService.existsById(accountModel.getUsername())) {
			model.addAttribute("message", "????ng k?? th???t b???i. T??i kho???n ???? t???n t???i : " + accountModel.getUsername());
			return "register";
		} else if (!bindingResult.hasErrors()) {
			Account account = new Account();
			String path = application.getRealPath("/");
			try {
				String filePath = path + "/images/" + accountModel.getPhoto().getOriginalFilename();
				accountModel.getPhoto().transferTo(Paths.get(filePath));
			} catch (Exception e) {
				System.err.println("c?? l???i t???i trycath");
			}
			BeanUtils.copyProperties(account, accountModel);
			account.setPhoto(accountModel.getPhoto().getOriginalFilename());
			model.addAttribute("message",
					"Register Account is successfuly with username : " + accountModel.getUsername());
			accountService.save(account);
			String tieude = "????ng K?? T??i Kho???n Th??nh C??ng";
			String noidung = "Dear " + accountModel.getFullname() + "\nB???n v???a ????ng k?? t??i kho???n th??nh c??ng\n"
					+ "T??i kho???n : " + accountModel.getUsername() + "\nM???t Kh???u : " + accountModel.getPassword();
			sendEmail("maihuongtungson@gmail.com", accountModel.getEmail(), tieude, noidung);
			return "register";
		} else {
			return "register";
		}
	}

}
