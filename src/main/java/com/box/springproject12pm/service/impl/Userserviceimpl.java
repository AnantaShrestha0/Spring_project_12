package com.box.springproject12pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.springproject12pm.model.User;
import com.box.springproject12pm.repo.UserRepository;
import com.box.springproject12pm.service.UserService;


@Service
public class Userserviceimpl implements UserService{

	@Autowired
	private UserRepository userrepo;
	
	@Override
	public void signup(User user) {
		// TODO Auto-generated method stub
		userrepo.save(user);
	}

	@Override
	public User login_username(String username) {
		// TODO Auto-generated method stub
	    User user=userrepo.findByUsername(username);
		return user;
	}

	@Override
	public User signup_find_username(String username) {
		// TODO Auto-generated method stub
		  User user=userrepo.findByUsername(username);
		return user;
	}

	@Override
	public List<User> login_password(String password) {
		// TODO Auto-generated method stub
		  
		return userrepo.findByPassword(password);
	}
	
	

}
