package com.box.springproject12pm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexcontroller {

	@GetMapping("/")
	public String indexpage() {
		return "index";
	}
}
