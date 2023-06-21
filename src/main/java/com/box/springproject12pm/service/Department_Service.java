package com.box.springproject12pm.service;

import java.util.List;

import com.box.springproject12pm.model.Department;

public interface Department_Service {

	void addDepth(Department dept);
	void deleteDepth(int id);
	Department getDepthById(int id);
	List<Department> getAllDepth();
	void update(Department dept);
}
