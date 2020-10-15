/**
 * 
 */
package com.dw8xl.restdw8xl.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.service.mock.mapper.SubOfficerMapperI;

/**
 * @author Haku Wei
 *
 */
@Repository
public class SubOfficerDao implements SubOfficerDaoI {
	
	private final static Logger log = LoggerFactory.getLogger(SubOfficerDao.class);
	
	@Autowired
	SubOfficerMapperI mapper;
	
	@Override
	public List<CharacterI> getAllSubOfficers() {
		return mapper.queryAllSubOfficers();
	}

	@Override
	public CharacterI getSubOfficer(String name) {
		List<CharacterI> temps = mapper.queryAllSubOfficers();
		return temps.stream().filter(s -> s.getName().equals(name)).collect(Collectors.toList()).get(0);
	}

	@Override
	public void updateSubOfficer(CharacterI SubOfficer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubOfficer(CharacterI SubOfficer) {
		// TODO Auto-generated method stub
		
	}

}
