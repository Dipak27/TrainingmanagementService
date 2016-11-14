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
import com.project.springmvc.model.TMSSession;
import com.project.springmvc.service.AdminService;
import com.project.springmvc.service.SessionService;

@RestController
public class SessionController 
{
	@Autowired
		SessionService sessionService;

	@RequestMapping(value = "/session/list/", method = RequestMethod.GET)
	public ResponseEntity<List<TMSSession>> getTMSSessionList() throws Exception {
		List<TMSSession> tmsSession = null;
	
		tmsSession = sessionService.findAllTMSSessions();
		
       return new ResponseEntity<List<TMSSession>>(tmsSession, HttpStatus.OK);
	}

	@RequestMapping(value = "/session/create/", method = RequestMethod.POST)
	public ResponseEntity<Void> addTMSSession(@RequestBody TMSSession tmsSession, UriComponentsBuilder ucBuilder) {
		System.out.println(" in Creating requirement " + tmsSession);
		TMSSession tms = new TMSSession();
		/*ad.setAdminEmailId(admin.getAdminEmailId());
		ad.setAdminName(admin.getAdminName());
		ad.setAdminPassword(admin.getAdminPassword());*/
		try {
			sessionService.addTMSSession(tms);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	 @RequestMapping(value = "/session/update/{id}", method = RequestMethod.PUT)
		public ResponseEntity<TMSSession> updateTMSSession(@PathVariable("id") int id ,@RequestBody AdminPojo admin) throws Exception {
			System.out.println(" in updateRequirement " + admin);
			TMSSession tms = sessionService.getTMSSessionById(id);
			if(tms==null)
			{
				 System.out.println("User with id " + id + " not found");
		            return new ResponseEntity<TMSSession>(HttpStatus.NOT_FOUND);
			}
			/*ad.setAdminEmailId(admin.getAdminEmailId());
			ad.setAdminName(admin.getAdminName());
			ad.setAdminPassword(admin.getAdminPassword());*/
			try {
				sessionService.addTMSSession(tms);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return new ResponseEntity<TMSSession>(tms, HttpStatus.OK);
		}

	 @RequestMapping(value = "/session/detail/{id}", method = RequestMethod.POST)
		public ResponseEntity<TMSSession> getTMSSession(@PathVariable("id") int id) throws Exception {
			
		 TMSSession tmsSession = null;
		 try {
			 tmsSession = sessionService.getTMSSessionById(id);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
	       return new ResponseEntity<TMSSession>(tmsSession, HttpStatus.FOUND);
		}
	
	 
	 @RequestMapping(value = "/session/delete/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<TMSSession> deleteTMSSession(@PathVariable("id") int id) throws Exception {
	        
		 TMSSession tmsSession = sessionService.getTMSSessionById(id);
	        if (tmsSession == null) {
	          
	            return new ResponseEntity<TMSSession>(HttpStatus.NOT_FOUND);
	        }
	        sessionService.deleteTMSSession(id);
	        return new ResponseEntity<TMSSession>(HttpStatus.OK);
	    }
}
