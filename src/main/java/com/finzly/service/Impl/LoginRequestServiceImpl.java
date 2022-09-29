package com.finzly.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.entity.Employee;
import com.finzly.entity.LoginRequest;
import com.finzly.entity.User;
import com.finzly.repository.EmployeeRepo;
import com.finzly.repository.UserRepo;
import com.finzly.service.LoginRequestService;
@Service
public class LoginRequestServiceImpl implements LoginRequestService{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	EmployeeRepo employeeRepo; 

	@Override
	public ResponseEntity<HashMap<String, Object>> loginUser(LoginRequest reqLogin) {
		
		Optional<Employee> employee = null;
		HashMap<String, Object> response = new HashMap<>();
		
		User userDetails = this.userRepo.findOneByEmailAndPassword(reqLogin.getEmail(),reqLogin.getPassword());
		if(userDetails == null ) {
			response.put("msg", "Invalid User");
			response.put("Employee", employee);
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}else {
			List<Employee> employeeDetails = this.employeeRepo.findAll();
			response.put("msg", "Valid User");
			response.put("Employee", employeeDetails);
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.ACCEPTED);
		}
	}
}

