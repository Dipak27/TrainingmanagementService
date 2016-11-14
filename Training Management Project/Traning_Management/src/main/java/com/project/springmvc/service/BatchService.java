package com.project.springmvc.service;

import java.util.List;

import com.project.springmvc.model.Batch;

public interface BatchService {

	 	Batch getBatchById(Integer id) throws Exception;
     
	    void addBatch(Batch batch)throws Exception;
	     
	    void updateBatch(Batch batch)throws Exception;
	     
	    void deleteBatch(Integer id)throws Exception;
	 
	    List<Batch> findAllBatchs()throws Exception; 
	     
	    Batch findBatchById(Integer id)throws Exception;
	    
}
