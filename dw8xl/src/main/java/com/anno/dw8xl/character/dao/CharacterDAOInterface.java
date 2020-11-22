/**
 * 
 */
package com.anno.dw8xl.character.dao;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.dao.DataAccessObjectInterface;

/**
 * @author Haku Wei
 *
 */
public interface CharacterDAOInterface extends DataAccessObjectInterface<CharacterI, Object> {

	public Collection<CharacterI> executeGetAllOfficers();

	public Collection<CharacterI> executeGetOfficersByKingdom(String kingdom);

	public CharacterI executeGetOfficerByType(String type);

	public Collection<CharacterI> executeGetOfficersByCategory(String category);

	public Collection<CharacterI> executeGetOfficersByWeaponNames(String weaponName);

	public CharacterI executeGetOfficerByName(String name);
	
	public CharacterI executeCreateOfficer(CharacterI officer);

	public Collection<CharacterI> executeGetAllSubOfficers();

	public Collection<CharacterI> executeGetSubOfficersByKingdom(String kingdom);

	public Collection<CharacterI> executeGetSubOfficersByName(String name);
	
	public Map<String, Integer> getDuplicates();

	static final Logger log = LoggerFactory.getLogger(CharacterDAO.class);

	static boolean isValidToAdd(CharacterI entity) {
		if (entity == null) {
			log.info("Cannot add Character due to Null Exception...");
			throw new NullPointerException("Character cannot be added due to Null!");
		}
		if (entity.getName().equals("")) {
			log.info("Cannot add Character due to Empty Character Name...");
			return false;
		}
		return true;
	}

	static boolean isValidToRemove(CharacterI entity) {
		if (entity == null) {
			log.info("Cannot remove Character due to Null Exception...");
			throw new NullPointerException("Character cannot be removed due to Null!");
		}
		if (entity.getName().equals("")) {
			log.info("Cannot remove Character due to Empty Character Name...");
			return false;
		}
		return true;
	}

}
