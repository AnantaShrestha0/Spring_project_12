package com.box.springproject12pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.box.springproject12pm.model.Department;
import com.box.springproject12pm.service.Department_Service;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private Department_Service department_Service;
	
	@GetMapping("/add")
	public String getdept() {
		
		return "departmetform";
	}
	@PostMapping("/add")
	public String postadddept(@ModelAttribute Department department,Model model) {
		department_Service.addDepth(department);
		return "departmetform";
	}
	
}
