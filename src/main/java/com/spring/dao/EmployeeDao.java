package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public void deleteEmployee(int id);
	public Employee updateEmployee(Employee employee);
	public Employee getEmployee(int id);
}
