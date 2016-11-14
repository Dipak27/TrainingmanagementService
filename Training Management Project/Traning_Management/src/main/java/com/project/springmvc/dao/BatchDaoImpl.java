package com.project.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.project.springmvc.model.Batch;

@Repository("batchDao")
public class BatchDaoImpl extends AbstractDao<Integer, Batch>implements BatchDao
{
	
	public void addBatch(Batch batch) throws Exception {
		persist(batch);
		
	}

	public Batch getBatchById(Integer id) throws Exception {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<Batch> getBatchList() throws Exception {
		return  getSession()                      
				.createQuery("SELECT r FROM Batch r ")
				.list();
		
	}

	public void deleteBatch(Integer id)throws Exception {
		Query query = getSession().createSQLQuery("delete from Batch where batch_id = :id");
        query.setInteger("id", (int) id);
        query.executeUpdate();
		
		
	}

}
