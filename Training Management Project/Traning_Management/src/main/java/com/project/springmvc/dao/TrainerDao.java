/**
 * 
 */
package com.project.springmvc.dao;

import java.util.List;

import com.project.springmvc.model.Trainer;
/**
 * @author vivekna
 *
 */
public interface TrainerDao 
{
	public boolean addTrainer(Trainer trainer) throws Exception;
	public Trainer getTrainerById(Integer id) throws Exception;
	public List<Trainer> getTrainerList() throws Exception;
	public boolean deleteTrainer(Integer id) throws Exception;

}
