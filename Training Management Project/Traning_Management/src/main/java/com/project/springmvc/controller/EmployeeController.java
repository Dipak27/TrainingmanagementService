package com.project.springmvc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.project.springmvc.model.Employee;
import com.project.springmvc.service.EmployeePojo;
import com.project.springmvc.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employee/list/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeeList() throws Exception {
		List<Employee> employeeList = null;
	
		employeeList = employeeService.findAllEmployees();
		
       return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/create/", method = RequestMethod.POST)
	public ResponseEntity<Void> addEmployee(@RequestBody EmployeePojo employee, UriComponentsBuilder ucBuilder) {
		System.out.println(" in Creating requirement " + employee);
		Employee emp = new Employee();
		emp.setEmpId(employee.getEmpId());
		emp.setEmpName(employee.getEmpName());
		emp.setEmpEmailId(employee.getEmpEmailId());
		emp.setEmpPassword(employee.getEmpPassword());
		emp.setEmpLocation(employee.getEmpLocation());
		try {
			employeeService.addEmployee(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	 @RequestMapping(value = "/employee/update/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id ,@RequestBody EmployeePojo employee) throws Exception {
			System.out.println(" in updateRequirement " + employee);
			Employee emp = employeeService.getEmployeeById(id);
			if(emp==null)
			{
				 System.out.println("User with id " + id + " not found");
		            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			}
			emp.setEmpId(employee.getEmpId());
			emp.setEmpName(employee.getEmpName());
			emp.setEmpEmailId(employee.getEmpEmailId());
			emp.setEmpPassword(employee.getEmpPassword());
			emp.setEmpLocation(employee.getEmpLocation());
			try {
				employeeService.updateEmployee(emp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}

	 @RequestMapping(value = "/employee/detail/{id}", method = RequestMethod.POST)
		public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) throws Exception {
			
		 Employee employee = null;
		 try {
				employee = employeeService.getEmployeeById(id);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
	       return new ResponseEntity<Employee>(employee, HttpStatus.FOUND);
		}
	
	 
	 @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) throws Exception {
	        
	        Employee employee = employeeService.getEmployeeById(id);
	        if (employee == null) {
	          
	            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	        }
	        employeeService.deleteEmployee(id);
	        return new ResponseEntity<Employee>(HttpStatus.OK);
	    }


}
