package io.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class SendMailController {
	@Autowired
	MailSender mailSender;
	
	
	@GetMapping("/sendmail")
	public String sendMail(Model model) {
		return "sendmail";
		
	}
	
	@PostMapping("/sendmail")
	public String sendMail(@RequestParam String emailnhan, @RequestParam String tieude,
			@RequestParam String noidung, Model model) {
		model.addAttribute("message", "Send Email is successfuly");
		sendEmail("maihuongtungson@gmail.com", emailnhan, tieude, noidung);
		return "sendmail";

	}
	
	public void sendEmail(String from, String to, String subject, String content) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		
		mailSender.send(mailMessage);
	}
}
