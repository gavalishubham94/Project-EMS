package com.BikkadIT.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {

	public Employee findByEmpId(Integer empid);
	
	public List<Employee> findByEmpAgeLessThanEqual(Integer Age);
	
	public Employee findByEmpIdAndEmpEmail(Integer eid,String Email);
}
