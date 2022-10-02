package com.finzly.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.entity.LoginRequest;
import com.finzly.service.LoginRequestService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Employee")
public class LoginRequestController {

	@Autowired
	LoginRequestService service;
	
	@PostMapping("/Login")
	public ResponseEntity<HashMap<String, Object>> loginUser(@RequestBody LoginRequest reqLogin){
		ResponseEntity<HashMap<String, Object>> response = this.service.loginUser(reqLogin);
		return response;
	}
}

