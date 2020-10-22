/**
 * 
 */
package com.dw8xl.restdw8xl.dao;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.temp.OfficerImplTemp;

/**
 * @author Haku Wei
 *
 */
public class OfficerDao implements OfficerDaoI {

	@Autowired
	private OfficerImplTemp impl;
	
	@Override
	public List<CharacterI> getAllOfficers() throws FileNotFoundException {
		return impl.getAllOfficerFiles();
	}

	@Override
	public CharacterI getOfficer(String name) {
		return null;
	}

	@Override
	public void updateOfficer(CharacterI officer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOfficer(CharacterI officer) {
		// TODO Auto-generated method stub
		
	}

}
