package com.anno.warriors.dw8.characters.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.warriors.dw8.character.dao.CharacterDAOInterface;
import com.anno.warriors.dw8.characters.model.CharacterInterface;

@Service("CharacterFacade")
public class CharacterFacade implements CharacterFacadeInterface {

	@Autowired
	private CharacterDAOInterface dao;

	@Override
	public List<CharacterInterface> callingGetAllCharacters() {
		return dao.getAllCharacters();
	}

	@Override
	public List<CharacterInterface> callingGetAllOfficers() {
		return dao.getAllOfficers();
	}

	@Override
	public List<CharacterInterface> callingGetAllSubOfficers() {
		return dao.getAllSubOfficers();
	}

}
