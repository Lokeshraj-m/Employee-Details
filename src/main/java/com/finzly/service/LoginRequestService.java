package com.finzly.service;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;

import com.finzly.entity.LoginRequest;

public interface LoginRequestService {
	
	public ResponseEntity<HashMap<String, Object>>  loginUser(LoginRequest reqLogin);

}
