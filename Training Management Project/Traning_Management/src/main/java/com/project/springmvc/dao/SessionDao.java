package com.project.springmvc.dao;

import java.util.List;

import com.project.springmvc.model.TMSSession;

public interface SessionDao 
{
	public void addSession(TMSSession session) throws Exception;
	public TMSSession getSessionById(Integer id) throws Exception;
	public List<TMSSession> getSessionList() throws Exception;
	public void deleteSession(Integer id) throws Exception;
}
