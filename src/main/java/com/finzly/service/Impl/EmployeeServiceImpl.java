package com.finzly.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.entity.Employee;
import com.finzly.exception.ResourceEmptyException;
import com.finzly.repository.EmployeeRepo;
import com.finzly.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = this.employeeRepo.findAll();
		return employees;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		Employee savedEmployee = this.employeeRepo.save(employee);
		return savedEmployee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeeOpt = employeeRepo.findById(employee.getId());
		if (employeeOpt.isPresent()) {
			this.employeeRepo.save(employee);
			return employee;
		} else {
			throw new ResourceEmptyException();
		}

	}

	@Override
	public Employee deleteEmployee(Integer employeeId) {
		Optional<Employee> deletedEmployeeOpt = employeeRepo.findById(employeeId);
		if (deletedEmployeeOpt.isPresent()) {
			this.employeeRepo.deleteById(employeeId);
			return deletedEmployeeOpt.get();
		} else {
			throw new ResourceEmptyException();
		}
	}

}
