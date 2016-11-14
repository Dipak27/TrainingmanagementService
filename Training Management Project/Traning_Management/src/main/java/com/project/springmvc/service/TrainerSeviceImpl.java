package com.project.springmvc.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.springmvc.dao.TrainerDao;
import com.project.springmvc.model.Trainer;

@Service("trainerService")
@Transactional
public class TrainerSeviceImpl implements TrainerService {
	
	@Autowired 
	private TrainerDao trainerDao;
	
	@Override
	public Trainer getTrainerById(Integer id) throws Exception {
		
		return trainerDao.getTrainerById(id);
	}

	@Override
	public void addTrainer(Trainer trainer) throws Exception {
		trainerDao.addTrainer(trainer);	
	}

	@Override
	public void updateTrainer(Trainer trainer) throws Exception {
		 Trainer entity = trainerDao.getTrainerById(trainer.getTrainerId());
	        if(entity!=null){
	        	entity.setTrainerName(trainer.getTrainerName());
	        	entity.setTrainerLocation(trainer.getTrainerLocation());
	        	entity.setTrainerEmailId(trainer.getTrainerEmailId());
	        	entity.setTrainerPassword(trainer.getTrainerPassword());
	        	entity.setTrainerTechnologies(trainer.getTrainerTechnologies());
	          
	        }

	}

	@Override
	public void deleteTrainer(Integer id) throws Exception {
		trainerDao.deleteTrainer(id);	

	}

	@Override
	public List<Trainer> findAllTrainers() throws Exception {
		return trainerDao.getTrainerList();
	}

	@Override
	public Trainer findTrainerById(Integer id) throws Exception {
			
		return trainerDao.getTrainerById(id);
	}

	@Override
	public Trainer TrainerAuthentication(String uname, String pass) throws Exception {
		//for future use
		return null;
	}

}
