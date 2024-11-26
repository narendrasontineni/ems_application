package com.narendra.spring.boot.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narendra.spring.boot.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
