package com.anno.warriors.dw8.characters.facade;

import java.util.List;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;

public interface CharacterFacadeInterface {

	public List<CharacterInterface<Character>> callingGetAllCharacters();

	public List<CharacterInterface<Character>> callingGetAllOfficers();

	public List<CharacterInterface<Character>> callingGetAllSubOfficers();

	public List<CharacterInterface<Character>> callingGetCharactersByNames(String[] name);

	public List<CharacterInterface<Character>> callingGetOfficersByNames(String[] name);

	public List<CharacterInterface<Character>> callingGetSubOfficersByNames(String[] name);
	
	public CharacterInterface<Character> callingGetOfficerByWeaponType(String type);

}
