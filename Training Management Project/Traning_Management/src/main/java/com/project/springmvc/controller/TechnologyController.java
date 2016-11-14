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

import com.project.springmvc.model.Technology;
import com.project.springmvc.service.TechnologyService;

@RestController
public class TechnologyController 
{
	@Autowired
	TechnologyService technologyService;

	@RequestMapping(value = "/technology/list/", method = RequestMethod.GET)
	public ResponseEntity<List<	Technology>> getTechnologyList() throws Exception {
		List<Technology> technologyList = null;
	
		technologyList = technologyService.findAllTechnologys();
		
       return new ResponseEntity<List<Technology>>(technologyList, HttpStatus.OK);
	}

	@RequestMapping(value = "/technology/create/", method = RequestMethod.POST)
	public ResponseEntity<Void> addTechnology(@RequestBody Technology technology, UriComponentsBuilder ucBuilder) {
		System.out.println(" in Creating requirement " + technology);
	
		try {
			technologyService.addTechnology(technology);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	 @RequestMapping(value = "/technology/update/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Technology> updateTechnology(@PathVariable("id") int id ,@RequestBody Technology technology) throws Exception {
			System.out.println(" in updateRequirement " + technology);
			Technology tech = technologyService.getTechnologyById(id);
			if(tech==null)
			{
				 System.out.println("User with id " + id + " not found");
		            return new ResponseEntity<Technology>(HttpStatus.NOT_FOUND);
			}
		/*	ad.setAdminEmailId(admin.getAdminEmailId());
			ad.setAdminName(admin.getAdminName());
			ad.setAdminPassword(admin.getAdminPassword());*/
			try {
				technologyService.updateTechnology(technology);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return new ResponseEntity<Technology>(tech, HttpStatus.OK);
		}

	 @RequestMapping(value = "/technology/detail/{id}", method = RequestMethod.POST)
		public ResponseEntity<Technology> getTechnology(@PathVariable("id") int id) throws Exception {
			
		 Technology tech = null;
		 try {
				tech = technologyService.getTechnologyById(id);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
	       return new ResponseEntity<Technology>(tech, HttpStatus.FOUND);
		}
	
	 
	 @RequestMapping(value = "/technology/delete/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Technology> deleteTechnology(@PathVariable("id") int id) throws Exception {
	        
		 Technology tech = technologyService.getTechnologyById(id);
	        if (tech == null) {
	          
	            return new ResponseEntity<Technology>(HttpStatus.NOT_FOUND);
	        }
	        technologyService.deleteTechnology(id);
	        return new ResponseEntity<Technology>(HttpStatus.OK);
	    }
}
