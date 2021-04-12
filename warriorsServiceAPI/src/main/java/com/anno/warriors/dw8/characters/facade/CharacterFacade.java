package com.anno.warriors.dw8.characters.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.warriors.dw8.characters.dao.CharacterDAOInterface;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.shared.WarriorSorter;

@Service("CharacterFacade")
public class CharacterFacade implements CharacterFacadeInterface {

	@Autowired
	private CharacterDAOInterface dao;

	@Override
	public List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>> callingGetAllCharacters() {
		return new WarriorSorter(dao.getAllCharacters()).getSortedList();
	}

	@Override
	public List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>> callingGetAllOfficers() {
		return new WarriorSorter(dao.getAllOfficers()).getSortedList();
	}

	@Override
	public List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>> callingGetAllSubOfficers() {
		return new WarriorSorter(dao.getAllSubOfficers()).getSortedList();
	}

}
