package com.anno.warriors.dw8.characters.dao;

import java.util.List;
import java.util.Optional;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;

public interface CharacterDAOInterface {

	public List<CharacterInterface<Character>> getAllCharacters();

	public List<CharacterInterface<Character>> getAllOfficers();

	public List<CharacterInterface<Character>> getAllSubOfficers();

	public List<CharacterInterface<Character>> getCharactersByName(List<CharacterInterface<Character>> paramList,
			String... name);

	public Optional<CharacterInterface<Character>> getOfficerByWeaponType(List<CharacterInterface<Character>> paramList,
			String type);

}