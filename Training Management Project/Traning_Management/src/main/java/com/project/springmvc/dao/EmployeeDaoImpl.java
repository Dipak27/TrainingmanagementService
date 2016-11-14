package com.project.springmvc.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.project.springmvc.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer,Employee> implements EmployeeDao{

	@Override
	public void addEmployee(Employee employee) throws Exception {
		persist(employee);
		
	}

	@Override
	public Employee getEmployeeById(Integer id) throws Exception {
		
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeList() throws Exception {
		
		return  getSession()                      
				.createQuery("SELECT r FROM Employee r ")
				.list();

	}

	@Override
	public void deleteEmployee(Integer id) throws Exception {
		Query query = getSession().createSQLQuery("delete from Employee where emp_id = :id");
        query.setInteger("id", (int) id);
        query.executeUpdate();
		
	}

	@Override
	public Employee employeeAuthentication(String uname, String pass) throws Exception {
		String hql = "FROM employee a WHERE a.emp_email_id ="+uname+"a.emp_password ="+pass;
		Query query = getSession().createQuery(hql);
		List<?> results = query.list();
		Employee emp = null;
		if(results.isEmpty())
		{
			emp=(Employee) results.get(0);	
		}
		return emp;
	}

}
