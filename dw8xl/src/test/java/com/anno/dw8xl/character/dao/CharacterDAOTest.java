/**
 * 
 */
package com.anno.dw8xl.character.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.character.model.Officer;
import com.anno.dw8xl.character.model.SubOfficer;
import com.anno.dw8xl.kingdom.model.Kingdom;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.Type;
import com.anno.dw8xl.type.model.TypeI;

/**
 * @author venividivicihofneondeion010101
 *
 */
class CharacterDAOTest {

	
	private CharacterDAOInterface dao;
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
		expectedType = new Type("Double Voulge");
		officer = new Officer("Wei Yan", expectedKingdom, expectedType);
		subOfficer = new SubOfficer("Bao Su", expectedKingdom);
	}

	@DisplayName("Test executeGet All Characters")
	// @Test
	void testexecuteGetAllCharacters() {
		characters = dao.getAll();
		assertEquals(852,characters.size());
	}
	
	@DisplayName("Test executeGet All Shu Officers")
	// @Test
	void testexecuteGetAllShuOfficers() {
		characters = dao.executeGetOfficersByKingdom("Shu");
		assertEquals(22, characters.size());
	}
	
	
	@DisplayName("Test executeGet All Shu SubOfficers")
	// @Test
	void testexecuteGetAllShuSubOfficers() {
		characters = dao.executeGetSubOfficersByKingdom("Shu");
		assertEquals(112, characters.size());
	}
	
	@DisplayName("Test executeGet All Wei Officers")
	// @Test
	void testexecuteGetAllWeiOfficers() {
		characters = dao.executeGetOfficersByKingdom("Wei");
		assertEquals(16, characters.size());
	}
	
	
	@DisplayName("Test executeGet All Wei SubOfficers")
	// @Test
	void testexecuteGetAllWeiSubOfficers() {
		characters = dao.executeGetSubOfficersByKingdom("Wei");
		assertEquals(79, characters.size());
	}
	
	@DisplayName("Test executeGet All Jin Officers")
	// @Test
	void testexecuteGetAllJinOfficers() {
		characters = dao.executeGetOfficersByKingdom("Jin");
		assertEquals(12, characters.size());
	}
	
	
	@DisplayName("Test executeGet All Jin SubOfficers")
	// @Test
	void testexecuteGetAllJinSubOfficers() {
		characters = dao.executeGetSubOfficersByKingdom("Jin");
		assertEquals(208, characters.size());
	}
	
	@DisplayName("Test executeGet All Other Officers")
	// @Test
	void testexecuteGetAllOtherOfficers() {
		characters = dao.executeGetOfficersByKingdom("Other");
		assertEquals(10, characters.size());
	}
	
	@DisplayName("Test executeGet All Officers by Weapon Star values")
	 @Test
	void testGetAllOfficersByWeaponStarValues() {
		Integer expectedStar = new Integer(3);
		Collection<CharacterI> expectedOfficersByStar = dao.executeGetOfficersByWeaponStar(expectedStar);
		assertTrue(!expectedOfficersByStar.isEmpty());
	}
	
	
	@DisplayName("Test executeGet All Other SubOfficers")
	// @Test
	void testexecuteGetAllOtherSubOfficers() {
		characters = dao.executeGetSubOfficersByKingdom("Other");
		assertEquals(296, characters.size());
	}
	
	@DisplayName("Test If Duplicates exist")
	// @Test
	void testIfDuplicatesExist() {
		Map<String, Integer> duplicates = dao.getDuplicates();
		assertTrue(duplicates.containsValue(2));
	}
}
