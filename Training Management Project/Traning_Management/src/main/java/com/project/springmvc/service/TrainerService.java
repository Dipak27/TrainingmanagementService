package com.project.springmvc.service;

import java.util.List;

import com.project.springmvc.model.Trainer;

public interface TrainerService {

	 Trainer getTrainerById(Integer id) throws Exception;
     
	    void addTrainer(Trainer trainer)throws Exception;
	     
	    void updateTrainer(Trainer trainer)throws Exception;
	     
	    void deleteTrainer(Integer id)throws Exception;
	 
	    List<Trainer> findAllTrainers()throws Exception; 
	     
	    Trainer findTrainerById(Integer id)throws Exception;
	    
	    Trainer TrainerAuthentication(String uname ,String pass)throws Exception;
}
