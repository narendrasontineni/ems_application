package com.narendra.spring.boot.ems.controller;

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

import com.narendra.spring.boot.ems.dto.EmployeeDto;
import com.narendra.spring.boot.ems.service.EmployeeService;
import com.narendra.spring.boot.ems.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	private EmployeeService employeeService;

	// Build add employee REST API
	// http://localhost:8080/api/employees

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
	}

	// Build Get Employee REST API
	// http://localhost:8080/api/employees/4

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);

		return ResponseEntity.ok(employeeDto);
	}

	// Build Get all Employees REST API
	// http://localhost:8080/api/employees
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	// Build Update Employees REST API
	//http://localhost:8080/api/employees/2
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto updatedEmployee) {
		EmployeeDto employeeDto = employeeServiceImpl.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);

	}
	
	// Build delete Employee REST API
	//http://localhost:8080/api/employees/2
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeServiceImpl.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted successfully!.");
		
	}

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

}
