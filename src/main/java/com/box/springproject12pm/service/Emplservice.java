package com.box.springproject12pm.service;

import java.util.List;

import com.box.springproject12pm.model.Employee;

public interface Emplservice {
	
	void addEmp(Employee employee);
	
	void deleteEmp(Long id);
	
	void updateEmp(Employee employee);
	
	Employee getEmplById(Long id);
	
	List<Employee> getAllEmps();

}
