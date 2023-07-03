package com.box.springproject12pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.springproject12pm.model.User;
import com.box.springproject12pm.service.UserService;
import com.box.springproject12pm.util.MailUtil;

@Controller
public class OtpController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MailUtil mailUtil;
	
	@GetMapping("/forgot")
	public String getforgot() {
		return "Forgotemail";
	}
	
	@PostMapping("/forgot")
	public String postforgot(@RequestParam String email,Model model) {
		User user=userService.login_username(email);
		if(user==null) {
			model.addAttribute("username_error", "Invalid username");
			return "Forgotemail";
		}
		String toEmail=user.getGmail();
		String subject ="OTP";
		String message="1234";
		mailUtil.sendEmail(toEmail,subject,message);
		
		return "OTPform";
	}
	
	@PostMapping("/optsend")
	public String postopt(@RequestParam String otp0,@RequestParam String otp1,@RequestParam String otp2,@RequestParam String otp3,Model model) {
	     String usersendotp=otp0+otp1+otp2+otp3;
		if(usersendotp.equals("1234")) {
		
			return "login";
		}
	
		
		return "signup";
	}
	
}
