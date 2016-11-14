package com.project.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.EmployeeDao;
import com.project.springmvc.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee getEmployeeById(Integer id) throws Exception {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public void addEmployee(Employee employee) throws Exception {
		employeeDao.addEmployee(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		 Employee entity = employeeDao.getEmployeeById(employee.getEmpId());
	        if(entity!=null){
	            entity.setEmpName(employee.getEmpName());
	            entity.setEmpEmailId(employee.getEmpEmailId());
	            entity.setEmpPassword(employee.getEmpPassword());
	            entity.setEmpLocation(employee.getEmpLocation());
	        }		
	}

	@Override
	public void deleteEmployee(Integer id) throws Exception {
			employeeDao.deleteEmployee(id);
	}

	@Override
	public List<Employee> findAllEmployees() throws Exception {
		return employeeDao.getEmployeeList();
	}

	@Override
	public Employee findEmployeeById(Integer id) throws Exception {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public Employee EmployeeAuthentication(String uname, String pass) throws Exception {
		return employeeDao.employeeAuthentication(uname, pass);
	}

}
