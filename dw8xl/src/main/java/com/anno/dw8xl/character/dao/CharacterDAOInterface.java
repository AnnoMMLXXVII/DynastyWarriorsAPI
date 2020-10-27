/**
 * 
 */
package com.anno.dw8xl.character.dao;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.dao.DataAccessObjectInterface;

/**
 * @author Haku Wei
 *
 */
public interface CharacterDAOInterface extends DataAccessObjectInterface<CharacterI, Object> {

	public Collection<CharacterI> getAllOfficers();

	public Collection<CharacterI> getAllShuOfficers();

	public Collection<CharacterI> getAllWuOfficers();

	public Collection<CharacterI> getAllWeiOfficers();

	public Collection<CharacterI> getAllJinOfficers();

	public Collection<CharacterI> getAllOtherOfficers();

	public Collection<CharacterI> getAllSubOfficers();

	public Collection<CharacterI> getAllShuSubOfficers();

	public Collection<CharacterI> getAllWuSubOfficers();

	public Collection<CharacterI> getAllWeiSubOfficers();

	public Collection<CharacterI> getAllJinSubOfficers();

	public Collection<CharacterI> getAllOtherSubOfficers();

	static final Logger log = LoggerFactory.getLogger(CharacterDAO.class);

	static boolean isValidToAdd(CharacterI entity) {
		if (entity == null) {
			log.info("Cannot add Character due to Null Exception...");
			throw new NullPointerException("Character cannot be added due to Null!");
		}
		if (entity.getName().equals("")) {
			log.info("Cannot add Character due to Empty Kingdom...");
			return false;
		}
		return true;
	}

	static boolean isValidToRemov(CharacterI entity) {
		if (entity == null) {
			log.info("Cannot remove Character due to Null Exception...");
			throw new NullPointerException("Character cannot be removed due to Null!");
		}
		if (entity.getName().equals("")) {
			log.info("Cannot remove Character due to Empty Kingdom...");
			return false;
		}
		return true;
	}

}
