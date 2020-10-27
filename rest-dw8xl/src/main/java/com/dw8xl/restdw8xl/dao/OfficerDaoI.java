/**
 * 
 */
package com.dw8xl.restdw8xl.dao;

import java.io.FileNotFoundException;
import java.util.List;

import com.dw8xl.restdw8xl.model.character.CharacterI;

/**
 * @author Haku Wei
 *
 */
public interface OfficerDaoI {

	public List<CharacterI> getAllOfficers() throws FileNotFoundException;
	public CharacterI getOfficer(String name) throws FileNotFoundException;
	public void updateOfficer(CharacterI officer) throws FileNotFoundException;
	public void deleteOfficer(CharacterI officer) throws FileNotFoundException;
	
}
