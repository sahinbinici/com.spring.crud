package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

@Transactional
@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeDao empDao;

	@Transactional
	public void addEmployee(Employee employee) {
		empDao.addEmployee(employee);
		
	}

	@Transactional
	public List<Employee> getAllEmployee() {
		return empDao.getAllEmployee();
		
	}

	@Transactional
	public void deleteEmployee(int id) {
		empDao.deleteEmployee(id);
		
	}

	public Employee getEmployee(int id) {
		return empDao.getEmployee(id);
	}

	public Employee updateEmployee(Employee employee) {
		return empDao.updateEmployee(employee);
	}

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	
	

}
