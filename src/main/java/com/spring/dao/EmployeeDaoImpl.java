package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		//sessionFactory.getCurrentSession().persist(employee);
		
	}

	public List<Employee> getAllEmployee() {
		List<Employee> employeeList=new ArrayList<Employee>();
		employeeList=sessionFactory.getCurrentSession().createQuery("from Employee").list();
		return employeeList;
	}

	public void deleteEmployee(int id) {
		Employee employ=(Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
		if(null!=employ){
			this.sessionFactory.getCurrentSession().delete(employ);
		}
	}

	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

	public Employee getEmployee(int id) {
		return (Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
	}

}
