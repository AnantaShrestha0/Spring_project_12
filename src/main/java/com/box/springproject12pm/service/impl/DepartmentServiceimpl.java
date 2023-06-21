package com.box.springproject12pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.springproject12pm.model.Department;
import com.box.springproject12pm.repo.Department_repo;
import com.box.springproject12pm.service.Department_Service;

@Service
public class DepartmentServiceimpl implements Department_Service {
    @Autowired
	private Department_repo department_repo;
	@Override
	public void addDepth(Department dept) {
		// TODO Auto-generated method stub
		department_repo.save(dept);
	}


	@Override
	public Department getDepthById(int id) {
		// TODO Auto-generated method stub
		return department_repo.findById(id).get();
	}

	@Override
	public List<Department> getAllDepth() {
		// TODO Auto-generated method stub
		return department_repo.findAll();
	}

	@Override
	public void update(Department dept) {
		// TODO Auto-generated method stub
		department_repo.save(dept);
		
	}

	@Override
	public void deleteDepth(int id) {
		// TODO Auto-generated method stub
		department_repo.deleteById(id);
		
	}

}
