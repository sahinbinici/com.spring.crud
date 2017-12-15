package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@Controller
public class EmployeeController {

	private static final Logger logger=Logger.getLogger(EmployeeController.class);
	
	public EmployeeController(){
		System.out.println("EmployeController()");
	}
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value="/")
	public ModelAndView listEmployee(ModelAndView model)throws IOException{
		List<Employee> listEmploye=empService.getAllEmployee();
		model.addObject("listEmploye", listEmploye);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value="/newEmployee",method=RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model){
		Employee emp=new Employee();
		model.addObject("emp",emp);
		model.setViewName("EmployeeForm");
		return model;
	}
	
	@RequestMapping(value="/saveEmployee",method=RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee){
		if(employee.getId()==0){
			empService.addEmployee(employee);
		}else{
			empService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/deleteEmployee",method=RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request){
		int employeeId=Integer.parseInt(request.getParameter("id"));
		empService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/editEmployee",method=RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("id"));
		Employee emp=empService.getEmployee(id);
		ModelAndView model=new ModelAndView("emp");
		return model;
	}
}
