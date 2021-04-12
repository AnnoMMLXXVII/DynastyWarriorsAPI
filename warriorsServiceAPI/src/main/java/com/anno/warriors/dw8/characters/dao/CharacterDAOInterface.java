package com.anno.warriors.dw8.characters.dao;

import java.util.List;

import com.anno.warriors.dw8.characters.model.CharacterInterface;

public interface CharacterDAOInterface {

	public List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>> getAllCharacters();

	public List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>> getAllOfficers();

	public List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>> getAllSubOfficers();

}
