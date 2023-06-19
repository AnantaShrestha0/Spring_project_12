package com.box.springproject12pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.box.springproject12pm.model.User;
import com.box.springproject12pm.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userserv;

	
	@GetMapping("/login")
	public String getlogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String postlogin(@ModelAttribute User user,Model model) {
		
		User username=userserv.login_username(user.getUsername());
		List<User> password=userserv.login_password(user.getPassword());
		if(username==null) {
			model.addAttribute("username_error","Username not found");
			return "login";
		}
		if(password.size() == 0) {
			model.addAttribute("password_error","Password not match");
			return "login";
		}
		model.addAttribute("name",username.getFname());
		return "profile";
	}
	
	@GetMapping("/signup")
	public String getsignup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postsignup(@ModelAttribute User user,Model model) {
		String com=user.getConformpassword();
		if(user.getPassword().equals(com)) {
		User us=userserv.signup_find_username(user.getUsername());
		if(us==null) {
			userserv.signup(user);
			return "login";
		}
		model.addAttribute("same_username_found", "This username is already used.");
		}
		model.addAttribute("same_username_found", "Password not match.");
		return "signup";
	}
}
