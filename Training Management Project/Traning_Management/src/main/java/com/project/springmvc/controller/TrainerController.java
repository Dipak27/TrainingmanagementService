package com.project.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.springmvc.model.Trainer;
import com.project.springmvc.service.TrainerService;

@RestController
public class TrainerController 
{

	@Autowired
	TrainerService trainerService;

	@RequestMapping(value = "/trainer/list/", method = RequestMethod.GET)
	public ResponseEntity<List<Trainer>> getTrainerList() throws Exception {
		List<Trainer> trainerList = null;
	
		trainerList = trainerService.findAllTrainers();
		
       return new ResponseEntity<List<Trainer>>(trainerList, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainer/create/", method = RequestMethod.POST)
	public ResponseEntity<Void> addTrainer(@RequestBody Trainer trainer, UriComponentsBuilder ucBuilder) {
		System.out.println(" in Creating requirement " + trainer);
		/*Trainer ad = new Trainer();
		ad.setTrainerEmailId(trainer.getTrainerEmailId());
		ad.setAdminName(trainer.getAdminNam\());
		ad.setAdminPassword(admin.getAdminPassword());*/
		try {
			trainerService.addTrainer(trainer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	 @RequestMapping(value = "/trainer/update/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Trainer> updateTrainer(@PathVariable("id") int id ,@RequestBody Trainer trainer) throws Exception {
			System.out.println(" in updateRequirement " + trainer);
			Trainer tr = trainerService.findTrainerById(id);
			if(tr==null)
			{
				 System.out.println("User with id " + id + " not found");
		            return new ResponseEntity<Trainer>(HttpStatus.NOT_FOUND);
			}
			/*ad.setTrainerEmailId(admin.getAdminEmailId());
			ad.setAdminName(admin.getAdminName());
			ad.setAdminPassword(admin.getAdminPassword());*/
			try {
				trainerService.updateTrainer(tr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return new ResponseEntity<Trainer>(tr, HttpStatus.OK);
		}

	 @RequestMapping(value = "/trainer/detail/{id}", method = RequestMethod.POST)
		public ResponseEntity<Trainer> getTrainer(@PathVariable("id") int id) throws Exception {
			
		 Trainer trainer = null;
		 try {
			 trainer = trainerService.getTrainerById(id);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
	       return new ResponseEntity<Trainer>(trainer, HttpStatus.FOUND);
		}
	
	 
	 @RequestMapping(value = "/trainer/delete/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Trainer> deleteTrainer(@PathVariable("id") int id) throws Exception {
	        
		 Trainer trainer = trainerService.getTrainerById(id);
	        if (trainer == null) {
	          
	            return new ResponseEntity<Trainer>(HttpStatus.NOT_FOUND);
	        }
	        trainerService.deleteTrainer(id);
	        return new ResponseEntity<Trainer>(HttpStatus.OK);
	    }

}
