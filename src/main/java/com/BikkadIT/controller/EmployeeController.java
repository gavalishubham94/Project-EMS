package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Employee;
import com.BikkadIT.service.EmployeeServiceI;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	
	
	@PostMapping(value = "/addEmployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		
		Employee employee2 = employeeServiceI.AddEmployee(employee);
		String responce=" Employee details of "+employee2.getEmpName() +" has been saved with EmployeeID  "+employee.getEmpId();
		
		return new ResponseEntity<String> (responce, HttpStatus.OK);
	
	}
	
	@PostMapping(value = "/addAll", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addEmployees(@RequestBody  List<Employee> emps){
		
		List<Employee> employees = employeeServiceI.AddAllEmployees(emps);
		System.out.println(employees);
		String responce="All the employees has been saved succcessfully";
		return new ResponseEntity<String> (responce, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getbyid", consumes = "application/json", produces = "application/json")
     public ResponseEntity<?> getByIdEmp(@RequestBody Employee employee ){
		
		Employee employee1 = employeeServiceI.GetById(employee);
	
		
		if(employee1==null) {
			
			return new ResponseEntity<Employee> (employee1, HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<Employee> (employee1, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAll", produces = "application/json")
    public ResponseEntity<List<Employee>> getAllEmp(){
		
		List<Employee> all = employeeServiceI.getAll();
		
		return (new ResponseEntity<List<Employee>> (all, HttpStatus.OK));
		
	}
	
	
	@GetMapping(value = "/getLessThan", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Employee>> getLessthan(@RequestBody Employee employee){
		
		List<Employee> all = employeeServiceI.getLessThan(employee);
		
		if(all==null) {
			return (new ResponseEntity<List<Employee>> (all, HttpStatus.BAD_REQUEST));
		}
		return (new ResponseEntity<List<Employee>> (all, HttpStatus.OK));
		
	}
	
	@PutMapping(value = "/UpdateEmployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> UpdateEmployee(@RequestBody Employee employee){
		
		Employee employee2 = employeeServiceI.UpdateEmployee(employee);
		
		if(employee2!=null) {
		String responce=" Employee details of "+employee2.getEmpName() +" has been Updated with EmployeeID  "+employee2.getEmpId();
		
		return new ResponseEntity<String> (responce, HttpStatus.OK);
		}
		return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		
	
	}
	
	@PutMapping(value = "/UpdateAll", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> UpdateEmployees(@RequestBody  List<Employee> emps){
		
		List<Employee> employees = employeeServiceI.UpdateAllEmployees(emps);
		System.out.println(employees);
		String responce="All the employees has been Updated succcessfully";
		return new ResponseEntity<String> (responce, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(value = "/deletebyId", consumes = "application/json", produces = "application/json" )
	public ResponseEntity<String> DeleteById(@RequestBody  Employee employee){
		
		employeeServiceI.DeleteById(employee);
		String msg= "Employee with EmployeeId "+employee.getEmpId()+" Deleted Successfully from Database";
		return new ResponseEntity<String> (msg,HttpStatus.OK);

	}
	
	@DeleteMapping(value = "/deleteAll",produces = "application/json")
	public ResponseEntity<String> DeleteAll(){
		employeeServiceI.DeleteAll();
		String responce="All Employees from DataBase has been cleaned Successfully";
		
		return  new ResponseEntity<String>  (responce,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/login", consumes = "application/json", produces="application/json")
	
	public  ResponseEntity<String>  LoginCheck(@RequestBody Employee employee) {
		Employee check = employeeServiceI.LoginCheck(employee);
		
		if(check.getEmpId()==employee.getEmpId() & check.getEmpEmail().equals(employee.getEmpEmail())) {
			
			String msg="Logged in successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
			
			
		}
		else {
		
			String msg="Invalid Id or Email";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	
			
		}
	}
}
