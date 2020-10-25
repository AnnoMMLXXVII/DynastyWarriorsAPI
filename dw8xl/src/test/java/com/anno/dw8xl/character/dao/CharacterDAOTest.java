/**
 * 
 */
package com.anno.dw8xl.character.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.character.model.Officer;
import com.anno.dw8xl.character.model.SubOfficer;
import com.anno.dw8xl.dao.DAO;
import com.anno.dw8xl.kingdom.model.Kingdom;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.Type;
import com.anno.dw8xl.type.model.TypeI;

/**
 * @author venividivicihofneondeion010101
 *
 */
class CharacterDAOTest {

	
	private DAO<CharacterI, Object> dao;
	private CharacterI officer;
	private CharacterI subOfficer;
	private KingdomI expectedKingdom;
	private TypeI expectedType;
	private Collection<CharacterI> characters;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dao = CharacterDAO.getInstance();
		expectedKingdom = new Kingdom("Shu");
		expectedType = new Type("Dragon Spear");
		officer = new Officer("Zhao Yun", expectedKingdom, expectedType);
		subOfficer = new SubOfficer("Bao Su", expectedKingdom);
		characters = dao.getAll();

	}

	@DisplayName("Get All Characters list size is Greater than Zero")
	@Test
	void testGetAllCharacters() {
		assertTrue(characters.size() > 0);
	}
	
	@DisplayName("Expected Officer exists in All Characters")
	@Test
	void testExpectedOfficer() {
		Optional<CharacterI> actual = characters.stream().filter(e -> e.getName().equals(officer.getName())).findFirst();
		assertEquals(officer.toString(), actual.get().toString());
	}
	
	@DisplayName("Expected SubOfficer exists in All Characters")
	@Test
	void testExpectedSubOfficer() {
		assertTrue(characters.contains(subOfficer));
	}
	

}
