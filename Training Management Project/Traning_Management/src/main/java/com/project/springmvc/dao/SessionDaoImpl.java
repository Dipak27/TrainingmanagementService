package com.project.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.project.springmvc.model.TMSSession;

@Repository("sessionDao")
public class SessionDaoImpl extends AbstractDao<Integer, TMSSession> implements SessionDao {

	@Override
	public void addSession(TMSSession session) throws Exception {
			persist(session);		
	}

	@Override
	public TMSSession getSessionById(Integer id) throws Exception {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TMSSession> getSessionList() throws Exception {
		return  getSession()                      
				.createQuery("SELECT r FROM TMSSession r ")
				.list();
	}

	@Override
	public void deleteSession(Integer id) throws Exception {
		Query query = getSession().createSQLQuery("delete from TMSSession where session_id = :id");
        query.setInteger("id", (int) id);
        query.executeUpdate();
		
	}

}
