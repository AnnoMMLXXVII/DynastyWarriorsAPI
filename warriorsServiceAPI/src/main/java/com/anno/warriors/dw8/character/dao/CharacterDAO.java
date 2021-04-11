package com.anno.warriors.dw8.character.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.manager.DW8Structures;

@Repository
public class CharacterDAO implements CharacterDAOInterface {

//			Dependency Classes --> DW8Structures

	@Override
	public List<CharacterInterface> getAllCharacters() {
		return DW8Structures.getCharacters();
	}

	@Override
	public List<CharacterInterface> getAllOfficers() {
		return DW8Structures.getOfficers();
	}

	@Override
	public List<CharacterInterface> getAllSubOfficers() {
		return DW8Structures.getSubOfficers();
	}

}
