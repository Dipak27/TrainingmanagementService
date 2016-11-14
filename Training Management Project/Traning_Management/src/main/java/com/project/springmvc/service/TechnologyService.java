package com.project.springmvc.service;

import java.util.List;

import com.project.springmvc.model.Technology;

public interface TechnologyService {

	 Technology getTechnologyById(Integer id) throws Exception;
     
	    void addTechnology(Technology technology)throws Exception;
	     
	    void updateTechnology(Technology technology)throws Exception;
	     
	    void deleteTechnology(Integer id)throws Exception;
	 
	    List<Technology> findAllTechnologys()throws Exception; 
	     
	    Technology findTechnologyById(Integer id)throws Exception;
	    
}
