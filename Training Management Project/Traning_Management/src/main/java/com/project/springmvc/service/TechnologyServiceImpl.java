package com.project.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.TechnologyDao;
import com.project.springmvc.model.Admin;
import com.project.springmvc.model.Technology;

@Service("technologyService")
@Transactional
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	private TechnologyDao technologydao;
	
	@Override
	public Technology getTechnologyById(Integer id) throws Exception {
			return technologydao.getTechnologyById(id);
	}

	@Override
	public void addTechnology(Technology technology) throws Exception {
		technologydao.addTechnology(technology);

	}

	@Override
	public void updateTechnology(Technology technology) throws Exception {
		 Technology entity = technologydao.getTechnologyById(technology.getTechId());
	        if(entity!=null){
	         entity.setTechName(technology.getTechName());
	        }
	       }

	@Override
	public void deleteTechnology(Integer id) throws Exception {
		technologydao.deleteTechnology(id);

	}

	@Override
	public List<Technology> findAllTechnologys() throws Exception {
		return technologydao.getTechnologyList();
		
	}

	@Override
	public Technology findTechnologyById(Integer id) throws Exception {
		return technologydao.getTechnologyById(id);
		
	}

	

}
