package com.anno.warriors.dw8.character.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.manager.DW8Structures;

@Repository
public class CharacterDAO implements CharacterDAOInterface {

//			Dependency Classes --> DW8Structures
	private static Logger logger = LoggerFactory.getLogger(CharacterDAO.class);

	@Override
	public List<CharacterInterface> getAllCharacters() {
		logger.debug("GET - All Characters");
		return DW8Structures.getCharacters();
	}

	@Override
	public List<CharacterInterface> getAllOfficers() {
		logger.debug("GET - All Officers");
		return DW8Structures.getOfficers();
	}

	@Override
	public List<CharacterInterface> getAllSubOfficers() {
		logger.debug("GET - All SubOfficers");
		return DW8Structures.getSubOfficers();
	}

}
