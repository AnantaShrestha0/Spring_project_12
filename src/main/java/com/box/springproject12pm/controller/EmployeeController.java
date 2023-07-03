package com.box.springproject12pm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.box.springproject12pm.model.Employee;
import com.box.springproject12pm.service.Department_Service;
import com.box.springproject12pm.service.Emplservice;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
	private Emplservice emplservice;
	
    @Autowired
    private Department_Service department_Service;
	
	@GetMapping("/add")
	public String geEmployee(Model model,HttpSession session) {
		
		if(session.getAttribute("validuser")==null) {
			return "login";
		}
		
		model.addAttribute("dptlist", department_Service.getAllDepth());
		return "EmployeeForm";
	}
	
	@PostMapping("/add")
	public String postEmplyee(@ModelAttribute Employee employee,HttpSession session) {
		
		if(session.getAttribute("validuser")==null) {
			return "login";
		}
		
		emplservice.addEmp(employee);
		return "redirect:/employee/add";
	}
	
	@GetMapping("/list")
	public String geEmployeelist(Model model,HttpSession session) {
		
		if(session.getAttribute("validuser")==null) {
			return "login";
		}
		
		model.addAttribute("emplist",emplservice.getAllEmps());
		return "EmployeeListForm";
	}
}
