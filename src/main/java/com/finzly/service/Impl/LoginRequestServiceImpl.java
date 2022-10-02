package com.finzly.service.Impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.entity.Employee;
import com.finzly.entity.LoginRequest;
import com.finzly.repository.EmployeeRepo;
import com.finzly.service.LoginRequestService;

@Service
public class LoginRequestServiceImpl implements LoginRequestService {

	

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public ResponseEntity<HashMap<String, Object>> loginUser(LoginRequest reqLogin) {

		HashMap<String, Object> response = new HashMap<>();

		Employee empDetails = this.employeeRepo.findOneByEmailAndPassword(reqLogin.getEmail(), reqLogin.getPassword());
		if (empDetails == null) {
			response.put("msg", "Invalid User");
			response.put("Employee", empDetails);
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.ACCEPTED);
		} else {
			empDetails.setPassword("********");
			response.put("msg", "Valid User");
			response.put("Employee", empDetails);
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.ACCEPTED);
		}
	}
}
