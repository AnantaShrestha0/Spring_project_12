package com.box.springproject12pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.springproject12pm.model.Employee;
import com.box.springproject12pm.repo.Employe_repo;
import com.box.springproject12pm.service.Emplservice;

@Service
public class emplserviceimpl implements Emplservice{

	@Autowired
	private Employe_repo employe_repo;
	
	
	@Override
	public void addEmp(Employee employee) {
		// TODO Auto-generated method stub
		employe_repo.save(employee);
	}
	
	@Override
	public void deleteEmp(Long id) {
		// TODO Auto-generated method stub
		employe_repo.deleteById(id);
		
	}

	@Override
	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employe_repo.save(employee);
		
	}

	@Override
	public Employee getEmplById(Long id) {
		// TODO Auto-generated method stub
		return employe_repo.findById(id).get();
		
	}

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		employe_repo.findAll();
		return null;
	}

	

	

}
