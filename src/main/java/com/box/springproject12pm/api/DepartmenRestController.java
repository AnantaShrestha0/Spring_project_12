package com.box.springproject12pm.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.box.springproject12pm.model.Department;
import com.box.springproject12pm.service.Department_Service;

@RestController
public class DepartmenRestController {

	@Autowired
	private Department_Service department_Service;
	
	
	@GetMapping("/api/dept/list")
	public List<Department> getAll() {
		return department_Service.getAllDepth();
	}
	
	@GetMapping("api/dept/{id}")
	public Department getdept(@PathVariable int id) {
		return department_Service.getDepthById(id);
	}
	
	@PostMapping("/api/dept/add")
	public String adddept(@RequestBody Department department) {
		department_Service.addDepth(department);
		
		return "Added successfully";
	}
	
	@PutMapping("/api/dept/update")
	public String deptUpdate(@RequestBody Department department) {
		department_Service.update(department);
		return "Updated Successfully";
	}
	
	
	@DeleteMapping("/api/dept/{id}")
	public String deptDelete(@PathVariable int id) {
		department_Service.deleteDepth(id);
		return "Deleted Successfully";
	}
	
	
	
	
	
	
}
