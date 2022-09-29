package com.finzly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.entity.User;
import com.finzly.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping("/Register")
	public ResponseEntity<User> register(@RequestBody User user) {	
		User userDetails = this.service.register(user);
		return new ResponseEntity<User>(userDetails, HttpStatus.CREATED);
	}
	
	@GetMapping("/Users")
	public ResponseEntity<List<User>> Users() {
		List<User> userDetails = this.service.Users();
		return new ResponseEntity<List<User>>(userDetails, HttpStatus.ACCEPTED);
	}
	
}
