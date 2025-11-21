package com.task.management.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.management.dto.UserDTO;
import com.task.management.model.User;
import com.task.management.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAllUsers(){
		
		List<User> usersList = userService.findAllUsers();
		return new ResponseEntity<>(usersList, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody UserDTO user){
		User userRequest = new User();
		userRequest.setCreatedAt(LocalDateTime.now());
		userRequest.setEmail(user.getEmail());
		userRequest.setName(user.getName());
		userRequest.setPassword(user.getPassword());
		User userSaved= userService.saveUser(userRequest);
		return new ResponseEntity<User>(userSaved, HttpStatus.CREATED);
	}

}
