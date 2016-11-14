package com.project.springmvc.dao;

import java.util.List;

import com.project.springmvc.model.Employee;

public interface EmployeeDao 
{
	public void addEmployee(Employee employee) throws Exception;
	public Employee getEmployeeById(Integer id) throws Exception;
	public List<Employee> getEmployeeList() throws Exception;
	public void deleteEmployee(Integer id) throws Exception;
	public Employee employeeAuthentication(String uname ,String pass) throws Exception;

}
