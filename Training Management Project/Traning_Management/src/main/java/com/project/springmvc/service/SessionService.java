package com.project.springmvc.service;

import java.util.List;

import com.project.springmvc.model.TMSSession;

public interface SessionService {

	 TMSSession getTMSSessionById(Integer id) throws Exception;
     
	    void addTMSSession(TMSSession session)throws Exception;
	     
	    void updateTMSSession(TMSSession session)throws Exception;
	     
	    void deleteTMSSession(Integer id)throws Exception;
	 
	    List<TMSSession> findAllTMSSessions()throws Exception; 
	     
	    TMSSession findTMSSessionById(Integer id)throws Exception;
	    
}
