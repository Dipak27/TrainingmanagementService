package com.project.springmvc.dao;

import java.util.List;

import com.project.springmvc.model.Technology;

public interface TechnologyDao 
{
	public void addTechnology(Technology technology) throws Exception;
	public Technology getTechnologyById(Integer id) throws Exception;
	public List<Technology> getTechnologyList() throws Exception;
	public void deleteTechnology(Integer id) throws Exception;
}
