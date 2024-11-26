package com.narendra.spring.boot.ems.mapper;

import org.springframework.stereotype.Component;

import com.narendra.spring.boot.ems.dto.EmployeeDto;
import com.narendra.spring.boot.ems.entity.Employee;

@Component
public class EmployeeMapper {
	
	public  static EmployeeDto mapToEmployeeDto(Employee employee) {
		
		return new EmployeeDto(employee.getId(),
				               employee.getFirstname(),
				               employee.getLastName(),
				               employee.getEmail());
	}
	
	
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		
		return new Employee(employeeDto.getId(),
				        employeeDto.getFirstName(),
				        employeeDto.getLastName(),
				        employeeDto.getEmail());
	}

	
}
