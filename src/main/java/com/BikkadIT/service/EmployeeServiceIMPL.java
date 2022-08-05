package com.BikkadIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.BikkadIT.model.Employee;
import com.BikkadIT.repository.EmployeeRepository;

@Service
public class EmployeeServiceIMPL implements EmployeeServiceI{

	@Autowired 
	EmployeeRepository repository;
	
	@Override
	public Employee AddEmployee(Employee employee) {

		
	
		Employee employee1 = repository.save(employee);

		return employee1;
		
	}

	@Override
	public List<Employee> AddAllEmployees(List<Employee> emps) {

		List<Employee> employees = repository.saveAll(emps);

		
		return employees;
	}

	
	
	@Override
	public Employee GetById(Employee employee) {
		Employee logincheck = repository.findByEmpIdAndEmpEmail(employee.getEmpId(), employee.getEmpEmail());
		
		if(logincheck==null) {
			
			return null;
			
		}else {
		 Employee employee1 = repository.findByEmpId(employee.getEmpId());
		
		return employee1;
		}
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> all = repository.findAll();
		return all;
	}

	
	@Override
	public List<Employee> getLessThan(Employee employee) {
		
		
		List<Employee> list = repository.findByEmpAgeLessThanEqual(employee.getEmpAge());
		
		return list;
	
	}

	@Override
	public Employee UpdateEmployee(Employee employee) {
     
		Employee employee1 = repository.save(employee);
		return employee1;
	
		
	}

	@Override
	public List<Employee> UpdateAllEmployees(List<Employee> emps) {
		List<Employee> employees = repository.saveAll(emps);
		return employees;
	}

	@Override
	public void DeleteById(Employee employee) {
		repository.deleteById(employee.getEmpId());
		
	}

	@Override
	public void DeleteAll() {
		repository.deleteAll();
	}

	@Override
	public Employee LoginCheck(Employee employee) {
		
		Employee loggedin = repository.findByEmpIdAndEmpEmail(employee.getEmpId(), employee.getEmpEmail());
		
		
		return loggedin;
	}

}
