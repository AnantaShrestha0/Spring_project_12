package com.box.springproject12pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@GetMapping("/list")
	public String getAll(Model model) {
		
		model.addAttribute("deptlist", department_Service.getAllDepth());
		return "DepartmentListForm";
	}
	
	@GetMapping("/edit")
	public String postedit(@RequestParam int id,Model model) {
		model.addAttribute("deptObject",department_Service.getDepthById(id));
		return "DepartmentEditForm";
	}
	
	@GetMapping("/view")
	public String getview(@RequestParam int id,Model model) {
		model.addAttribute("deptObject",department_Service.getDepthById(id));
		return "DepartmentviewForm";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Department department) {
		department_Service.addDepth(department);
		return "redirect:/department/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		department_Service.deleteDepth(id);
		return "redirect:/department/list";
	}
	
}
