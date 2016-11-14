package com.project.springmvc.dao;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.project.springmvc.model.Technology;

@Repository("technologyDao")
public class TechnologyDaoImpl extends AbstractDao<Integer, Technology>implements TechnologyDao
{
	

	public void addTechnology(Technology technology) throws Exception {
		persist(technology);
	}

	public Technology getTechnologyById(Integer id) throws Exception {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<Technology> getTechnologyList() throws Exception {
		return  getSession()                      
				.createQuery("SELECT r FROM Technology r ")
				.list();
	}

	public void deleteTechnology(Integer id)throws Exception {
		Query query = getSession().createSQLQuery("delete from Technology where tech_id = :id");
        query.setInteger("id", (int) id);
        query.executeUpdate();
	}
}
