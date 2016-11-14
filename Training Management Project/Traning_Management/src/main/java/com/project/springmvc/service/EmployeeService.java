package com.project.springmvc.service;

import java.util.List;

import com.project.springmvc.model.Employee;



public interface EmployeeService {

	 Employee getEmployeeById(Integer id) throws Exception;
     
	    void addEmployee(Employee employee)throws Exception;
	     
	    void updateEmployee(Employee employee)throws Exception;
	     
	    void deleteEmployee(Integer id)throws Exception;
	 
	    List<Employee> findAllEmployees()throws Exception; 
	     
	    Employee findEmployeeById(Integer id)throws Exception;
	    
	    Employee EmployeeAuthentication(String uname ,String pass)throws Exception;
}
