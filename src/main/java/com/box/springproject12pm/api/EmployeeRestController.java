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
import org.springframework.web.client.RestTemplate;

import com.box.springproject12pm.model.Employee;
import com.box.springproject12pm.service.Emplservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@OpenAPIDefinition(info= @Info(title="Employee REST API",version ="5.0",description="Employee CRUD API"))
public class EmployeeRestController {

	@Autowired
	private Emplservice emplservice;
	
	@GetMapping("/api/empl/list")
	public List<Employee> getAllEmpl() {
		return emplservice.getAllEmps();
		}
	
	@GetMapping("/api/empl/{id}")
	public Employee getEmpl(@PathVariable Long id) {
		return emplservice.getEmplById(id);
	}
	
	@PostMapping("/api/empl/add")
	public String addEmpl(@RequestBody Employee employee) {
		
		emplservice.addEmp(employee);
		return "Added Successfully";
	}
	
	@PutMapping("/api/empl/update")
	public String emplUpdate(@RequestBody Employee employee) {
		emplservice.updateEmp(employee);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/api/empl/delete/{id}")
	public String emplDelete(@PathVariable Long id) {
		emplservice.deleteEmp(id);
		return "Deleted Successfully";
	}
	
	
	@GetMapping("/api/emp/j2o")
	public String jsonToObjectMapping() {
		RestTemplate temp=new RestTemplate();
		Employee emp=temp.getForObject("http://localhost:8080/api/empl/9",Employee.class);
		return "FirstName = "+emp.getFname();
		
	}
	
	
	@GetMapping("/api/emp/ja2oa")
	public String jarrayToObjArray() {
		
		
		RestTemplate temp=new RestTemplate();
		Employee[] emplist=temp.getForObject("http://localhost:8080/api/empl/list", Employee[].class);
		return "FirstName : "+emplist[0].getFname();
	}
}
