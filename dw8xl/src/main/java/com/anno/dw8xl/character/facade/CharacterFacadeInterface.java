/**
 * 
 */
package com.anno.dw8xl.character.facade;

import java.util.Collection;

import com.anno.dw8xl.character.model.CharacterI;

/**
 * @author venividivicihofneondeion010101
 *
 */
public interface CharacterFacadeInterface {

	public Collection<CharacterI> getAllCharacters();

	public Collection<CharacterI> getAllOfficers();

	public Collection<CharacterI> getAllSubOfficers();

	public Collection<CharacterI> getOfficerByKingdom(String kingdom);

	public CharacterI getOfficerByName(String name);

	public CharacterI getOfficerByWeaponType(String type);
	
	public CharacterI addOfficer(String officer);

	public Collection<CharacterI> getOfficerByWeaponCategory(String category);

	public Collection<CharacterI> getOfficerByWeaponName(String weaponName);

	public Collection<CharacterI> getSubOfficerByKingdom(String kingdom);

	public Collection<CharacterI> getSubOfficerByName(String name);

}
