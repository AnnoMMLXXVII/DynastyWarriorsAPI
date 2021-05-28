package com.anno.warriors.dw8.characters.dao;

import java.util.List;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;

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

	public List<CharacterInterface<Character>> getAllOfficersByWeaponStar(List<CharacterInterface<Character>> officers,
			int... weaponStar);

	public List<CharacterInterface<Character>> getAllOfficersByWeaponRarity(List<CharacterInterface<Character>> officers,
			String... weaponRarity);

	public List<CharacterInterface<Character>> getAllOfficersByWeaponCategory(
			List<CharacterInterface<Character>> officers, String... weaponCategory);

	public List<CharacterInterface<Character>> getAllOfficersByWeaponAffinity(
			List<CharacterInterface<Character>> officers, String... weaponAffinity);

	public List<CharacterInterface<Character>> getAllOfficersByWeaponLength(List<CharacterInterface<Character>> officers,
			String... weaponLength);


}
