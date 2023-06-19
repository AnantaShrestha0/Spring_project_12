package com.box.springproject12pm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.springproject12pm.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsernameAndPassword(String username,String password);

	User findByUsername(String username);

	List<User> findByPassword(String password);

}
