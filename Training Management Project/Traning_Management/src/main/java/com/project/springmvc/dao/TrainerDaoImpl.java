package com.project.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springmvc.model.Trainer;


@Repository("trainerDao")
public class TrainerDaoImpl extends	AbstractDao<Integer, Trainer> implements TrainerDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;

	public boolean addTrainer(Trainer trainer) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(trainer);
		tx.commit();
		session.close();

		return false;
	}

	public Trainer getTrainerById(Integer id) throws Exception {
		Trainer tr = (Trainer)getSession()                      
		.createQuery("SELECT r FROM Trainer r where trainerId = :id").setInteger("id",id)
		.uniqueResult();
		return tr;
	}

	@SuppressWarnings("unchecked")
	public List<Trainer> getTrainerList() throws Exception {
		return  getSession()                      
				.createQuery("SELECT r FROM Trainer r ")
				.list();
	}

	public boolean deleteTrainer(Integer id)throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Trainer.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}



}
