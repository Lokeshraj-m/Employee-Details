package com.finzly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.entity.Employee;
import com.finzly.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService eService;

	@PostMapping("/save")
	ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = this.eService.saveEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = this.eService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.ACCEPTED);

	}

	@PutMapping("/update/{employeeId}")
	ResponseEntity<Employee> updateEmployee(@PathVariable int employeeId , @RequestBody Employee employee) {
		Employee updatedEmployee = this.eService.updateEmployee(employeeId,employee);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{employeeId}")
	ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) {
		this.eService.deleteEmployee(employeeId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}