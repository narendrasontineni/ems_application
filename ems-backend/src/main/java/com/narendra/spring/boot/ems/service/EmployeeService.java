package com.narendra.spring.boot.ems.service;

import java.util.List;

import com.narendra.spring.boot.ems.dto.EmployeeDto;

public interface EmployeeService {

		 EmployeeDto createEmployee(EmployeeDto employeeDto);
		 
		 EmployeeDto getEmployeeById(Long employeeId);
		 
		 List<EmployeeDto> getAllEmployees();
		 
		 EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
		 
		 void deleteEmployee(Long employeeId);
		
	}

