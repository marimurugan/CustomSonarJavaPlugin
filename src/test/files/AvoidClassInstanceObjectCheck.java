package com.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.model.Employee;

public class EmployeeService {

	public Object myObj=null;
	
	public Integer myJObj=null;
	
	public Object myDesiredVariable;
	
	
	 static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	
	
	private Employee employee;

	// constructor is used for autowire by constructor
	public EmployeeService(Employee emp) {
		System.out.println("Autowiring by constructor used");
		this.employee = emp;
	}

	// default constructor to avoid BeanInstantiationException for autowire
	// byName or byType
	public EmployeeService() {
		System.out.println("Default Constructor used");
	}

	// used for autowire byName and byType
	public void setEmployee(Employee emp) {
		this.employee = emp;
	}

	public Employee getEmployee() {
		return this.employee;
	}
	
	
	int myMethod(int my)
	{
		return my;
	}
	
}
