package com.spring.service;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public void deleteEmployee(int id);
	public Employee getEmployee(int id);
	public Employee updateEmployee(Employee employee);
}
