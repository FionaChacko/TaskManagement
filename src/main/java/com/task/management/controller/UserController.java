package com.task.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.management.model.User;
import com.task.management.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	public ResponseEntity<List<User>> findAllUsers(){
		
		List<User> usersList = userService.findAllUsers();
		return new ResponseEntity<>(usersList, HttpStatus.OK);
	}

}
