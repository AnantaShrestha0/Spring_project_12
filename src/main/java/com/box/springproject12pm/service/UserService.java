package com.box.springproject12pm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.box.springproject12pm.model.User;


public interface UserService {

	void signup(User user);
	
	User login_username(String username);
	List<User> login_password(String password);
	
	User signup_find_username(String username);
	
}
