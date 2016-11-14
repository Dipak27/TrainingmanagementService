package com.project.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.SessionDao;
import com.project.springmvc.model.Admin;
import com.project.springmvc.model.TMSSession;

@Service("tmsService")
@Transactional
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionDao sessionDao;
	
	@Override
	public TMSSession getTMSSessionById(Integer id) throws Exception {
		return sessionDao.getSessionById(id);
	}

	@Override
	public void addTMSSession(TMSSession session) throws Exception {
		sessionDao.addSession(session);

	}

	@Override
	public void updateTMSSession(TMSSession session) throws Exception {
		 TMSSession entity = sessionDao.getSessionById(session.getSessionId());
	        if(entity!=null){
	        	entity.setSessionConducted(session.getSessionConducted());
	        	entity.setSessionDate(session.getSessionDate());
	        	entity.setSessionEndTime(session.getSessionEndTime());
	        	entity.setSessionStartTime(session.getSessionStartTime());
	        }
	}

	@Override
	public void deleteTMSSession(Integer id) throws Exception {
		sessionDao.deleteSession(id);

	}

	@Override
	public List<TMSSession> findAllTMSSessions() throws Exception {
		return sessionDao.getSessionList();
		
	}

	@Override
	public TMSSession findTMSSessionById(Integer id) throws Exception {
	
		return sessionDao.getSessionById(id);
	}




}
