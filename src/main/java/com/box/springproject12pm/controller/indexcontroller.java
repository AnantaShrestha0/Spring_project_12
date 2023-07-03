package com.box.springproject12pm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class indexcontroller {

	@GetMapping("/")
	public String indexpage(HttpSession session) {
		return "index";
	}
}
