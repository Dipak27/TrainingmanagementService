package com.project.springmvc.dao;

import java.util.List;

import com.project.springmvc.model.Batch;

public interface BatchDao 
{
	public void addBatch(Batch technology) throws Exception;
	public Batch getBatchById(Integer id) throws Exception;
	public List<Batch> getBatchList() throws Exception;
	public void deleteBatch(Integer id) throws Exception;

}
