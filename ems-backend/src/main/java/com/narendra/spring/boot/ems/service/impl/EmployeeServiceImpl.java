package com.narendra.spring.boot.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.narendra.spring.boot.ems.dto.EmployeeDto;
import com.narendra.spring.boot.ems.entity.Employee;
import com.narendra.spring.boot.ems.exception.ResourceNotFoundException;
import com.narendra.spring.boot.ems.mapper.EmployeeMapper;
import com.narendra.spring.boot.ems.repository.EmployeeRepository;
import com.narendra.spring.boot.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);

		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee= employeeRepository.findById(employeeId)
				.orElseThrow(() -> 
				         new ResourceNotFoundException("Employee not exist with given id " + employeeId));

		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees =  employeeRepository.findAll();
		
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with given id " + employeeId));
		employee.setFirstname(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		Employee updatedEmployeeobj = employeeRepository.save(employee);    
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeobj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with given id " + employeeId));
		employeeRepository.deleteById(employeeId);
	}

	

}
