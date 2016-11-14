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

import com.project.springmvc.model.Admin;
import com.project.springmvc.model.AdminPojo;
import com.project.springmvc.model.Batch;
import com.project.springmvc.service.AdminService;
import com.project.springmvc.service.BatchService;

@RestController
public class BatchController 
{
	@Autowired
	BatchService batchService;

	@RequestMapping(value = "/batch/list/", method = RequestMethod.GET)
	public ResponseEntity<List<Batch>> getBatchList() throws Exception {
		List<Batch> batchList = null;
	
		batchList = batchService.findAllBatchs();
		
       return new ResponseEntity<List<Batch>>(batchList, HttpStatus.OK);
	}

	@RequestMapping(value = "/batch/create/", method = RequestMethod.POST)
	public ResponseEntity<Void> addBatch(@RequestBody Batch batch, UriComponentsBuilder ucBuilder) {
		System.out.println(" in Creating requirement " + batch);
		Batch ba = new Batch();
	/*	ad.setAdminEmailId(admin.getAdminEmailId());
		ad.setAdminName(admin.getAdminName());
		ad.setAdminPassword(admin.getAdminPassword());*/
		try {
			batchService.addBatch(ba);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	 @RequestMapping(value = "/batch/update/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Batch> updateBatch(@PathVariable("id") int id ,@RequestBody Batch batch) throws Exception {
			System.out.println(" in updateRequirement " + batch);
			Batch ba = batchService.findBatchById(id);
			if(ba==null)
			{
				 System.out.println("User with id " + id + " not found");
		            return new ResponseEntity<Batch>(HttpStatus.NOT_FOUND);
			}
			
			try {
				batchService.updateBatch(ba);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return new ResponseEntity<Batch>(ba, HttpStatus.OK);
		}

	 @RequestMapping(value = "/batch/detail/{id}", method = RequestMethod.POST)
		public ResponseEntity<Batch> getBatch(@PathVariable("id") int id) throws Exception {
			
		 Batch batch = null;
		 try {
				batch = batchService.getBatchById(id);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
	       return new ResponseEntity<Batch>(batch, HttpStatus.FOUND);
		}
	
	 
	 @RequestMapping(value = "/batch/delete/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Batch> deleteBatch(@PathVariable("id") int id) throws Exception {
	        
		 Batch batch = batchService.getBatchById(id);
	        if (batch == null) {
	          
	            return new ResponseEntity<Batch>(HttpStatus.NOT_FOUND);
	        }
	        batchService.deleteBatch(id);
	        return new ResponseEntity<Batch>(HttpStatus.OK);
	    }

}
