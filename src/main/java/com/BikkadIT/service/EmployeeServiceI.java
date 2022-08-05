package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.model.Employee;

public interface EmployeeServiceI {

	public Employee AddEmployee(Employee employee);
		
	public List<Employee> AddAllEmployees(List<Employee> emps);
	
	public Employee GetById(Employee employee);
	
	public List<Employee> getAll();
	
	public List<Employee> getLessThan(Employee employee);
	
	public Employee UpdateEmployee(Employee employee);
	
	public List<Employee> UpdateAllEmployees(List<Employee> emps);
	
	public void DeleteById(Employee employee);
	
	public void DeleteAll();
	
	public Employee LoginCheck(Employee employee);
}
