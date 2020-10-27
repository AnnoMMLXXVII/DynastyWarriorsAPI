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

	public String getAllOfficers();

	public String getAllSubOfficers();

	public Collection<CharacterI> getOfficerByKingdom(String kingdom);

	public Collection<CharacterI> getSubOfficerByKingdom(String kingdom);

}
