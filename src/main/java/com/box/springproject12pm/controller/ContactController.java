package com.box.springproject12pm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.springproject12pm.util.MailUtil;

@Controller
public class ContactController {

	@Autowired
	private MailUtil mailUtil;
	
	@GetMapping("/contact")
	public String getContact(HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return "login";
		}
		return "ContactForm";
	}
	
	@PostMapping("/contact")
	public String postContact(@RequestParam String toEmail,@RequestParam String subject,@RequestParam String message,HttpSession session) {
		
		if(session.getAttribute("validuser")==null) {
			return "login";
		}
		mailUtil.sendEmail(toEmail,subject,message);
		return "ContactForm";
	}
}
