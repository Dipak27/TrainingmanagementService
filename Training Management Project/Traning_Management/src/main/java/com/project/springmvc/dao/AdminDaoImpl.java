package com.project.springmvc.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.project.springmvc.model.Admin;

@Repository("adminDao")
public class AdminDaoImpl extends AbstractDao<Integer, Admin> implements AdminDao
{

	public void addAdmin(Admin admin) throws Exception {
		persist(admin);
	}

	public Admin getAdminById(Integer id) throws Exception {		
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<Admin> getAdminList() throws Exception {
	
		return  getSession()                      
				.createQuery("SELECT r FROM Admin r ")
				.list();

	}

	public void deleteAdmin(Integer id)throws Exception {
		Query query = getSession().createSQLQuery("delete from Admin where admin_id = :id");
        query.setInteger("id", (int) id);
        query.executeUpdate();		
	}

	public Admin adminAuthentication(String uname, String pass) throws Exception {
		
		String hql = "FROM admin a WHERE a.admin_email_id ="+uname+"a.admin_password ="+pass;
		Query query = getSession().createQuery(hql);
		List<?> results = query.list();
		Admin admin = null;
		if(results.isEmpty())
		{
			admin=(Admin) results.get(0);	
		}
		return admin;
	}

	

}
