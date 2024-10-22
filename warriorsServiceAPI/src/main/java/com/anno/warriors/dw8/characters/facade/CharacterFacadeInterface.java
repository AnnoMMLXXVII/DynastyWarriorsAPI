package com.anno.warriors.dw8.characters.facade;

import java.util.List;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.requests.pojos.CharacterPojo;

public interface CharacterFacadeInterface {

	public List<CharacterInterface<Character>> callingGetAllCharacters();

	public List<CharacterInterface<Character>> callingGetAllOfficers();

	public List<CharacterInterface<Character>> callingGetAllSubOfficers();

	public List<CharacterInterface<Character>> callingGetCharactersByNames(String[] name);

	public List<CharacterInterface<Character>> callingGetOfficersByNames(String[] name);

	public List<CharacterInterface<Character>> callingGetSubOfficersByNames(String[] name);

	public List<CharacterInterface<Character>> callingGetOfficerByWeaponType(String... type);

	public List<CharacterInterface<Character>> callingGetAllOfficerByKingdom(String... kingdom);

	public List<CharacterInterface<Character>> callingGetAllOfficerByWeaponName(String... weaponNames);

	public List<CharacterInterface<Character>> callingGetAllOfficerByWeaponPower(int... weaponPower);
	
	public CharacterInterface<Character> callingCreateOfficer(CharacterPojo officer);

}
