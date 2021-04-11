package com.anno.warriors.dw8.character.dao;

import java.util.List;

import com.anno.warriors.dw8.characters.model.CharacterInterface;

public interface CharacterDAOInterface {

	public List<CharacterInterface> getAllCharacters();

	public List<CharacterInterface> getAllOfficers();

	public List<CharacterInterface> getAllSubOfficers();

}
