package com.task.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.task.management.model.User;
import com.task.management.repository.UserRepository;

public class UserServiceImpl implements IUserService{
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

}
