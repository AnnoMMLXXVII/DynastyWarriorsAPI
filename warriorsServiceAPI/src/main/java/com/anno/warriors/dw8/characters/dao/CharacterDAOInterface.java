package com.anno.warriors.dw8.characters.dao;

import java.util.List;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.requests.pojos.CharacterPojo;

public interface CharacterDAOInterface {

	public List<CharacterInterface<Character>> getAllCharacters();

	public List<CharacterInterface<Character>> getAllOfficers();

	public List<CharacterInterface<Character>> getAllSubOfficers();

	public List<CharacterInterface<Character>> getCharactersByName(List<CharacterInterface<Character>> paramList,
			String... name);

	public List<CharacterInterface<Character>> getOfficerByWeaponType(List<CharacterInterface<Character>> paramList,
			String... type);

	public List<CharacterInterface<Character>> getAllOfficersByKingdom(List<CharacterInterface<Character>> officers,
			String... kingdom);

	public List<CharacterInterface<Character>> getAllOfficersByWeaponName(List<CharacterInterface<Character>> officers,
			String... weaponNames);

	public List<CharacterInterface<Character>> getAllOfficersByWeaponPower(List<CharacterInterface<Character>> officers,
			int... weaponPower);

	public CharacterInterface<Character> createOfficer(CharacterPojo officer);

}
