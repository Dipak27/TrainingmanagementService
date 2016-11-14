package com.project.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.BatchDao;
import com.project.springmvc.model.Admin;
import com.project.springmvc.model.Batch;

@Service("batchService")
@Transactional
public class BatchServiceImpl implements BatchService{

	@Autowired
	private BatchDao batchDao;
	
	@Override
	public Batch getBatchById(Integer id) throws Exception {
	return batchDao.getBatchById(id);
		
	}

	@Override
	public void addBatch(Batch batch) throws Exception {
		batchDao.addBatch(batch);
		
	}

	@Override
	public void updateBatch(Batch batch) throws Exception {
		 Batch entity = batchDao.getBatchById(batch.getBatchId());
	        if(entity!=null){
	           entity.setBatchName(batch.getBatchName());
	           entity.setBatchStartDate(batch.getBatchStartDate());
	           entity.setBatchLocation(batch.getBatchLocation());
	           entity.setBatchTechnologies(batch.getBatchTechnologies());
	           entity.setBatchType(batch.getBatchType());
	           entity.setBatchEndDate(batch.getBatchEndDate());
	         
	        }
		
	}

	@Override
	public void deleteBatch(Integer id) throws Exception {
		batchDao.deleteBatch(id);
		
	}

	@Override
	public List<Batch> findAllBatchs() throws Exception {
		return batchDao.getBatchList();
	}

	@Override
	public Batch findBatchById(Integer id) throws Exception {
	return batchDao.getBatchById(id);
		
	}

	

}
