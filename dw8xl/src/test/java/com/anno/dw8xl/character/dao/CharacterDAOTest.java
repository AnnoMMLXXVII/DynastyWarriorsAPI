/**
 * 
 */
package com.anno.dw8xl.character.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

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

	@DisplayName("Test Get All Characters")
	@Test
	void testGetAllCharacters() {
		characters = dao.getAll();
		assertEquals(852,characters.size());
	}
	
	@DisplayName("Test Get All Shu Officers")
	@Test
	void testGetAllShuOfficers() {
		characters = dao.getAllShuOfficers();
		assertEquals(22, characters.size());
	}
	
	
	@DisplayName("Test Get All Shu SubOfficers")
	@Test
	void testGetAllShuSubOfficers() {
		characters = dao.getAllShuSubOfficers();
		assertEquals(112, characters.size());
	}
	
	@DisplayName("Test Get All Wei Officers")
	@Test
	void testGetAllWeiOfficers() {
		characters = dao.getAllWeiOfficers();
		assertEquals(16, characters.size());
	}
	
	
	@DisplayName("Test Get All Wei SubOfficers")
	@Test
	void testGetAllWeiSubOfficers() {
		characters = dao.getAllWeiSubOfficers();
		assertEquals(79, characters.size());
	}
	
	@DisplayName("Test Get All Jin Officers")
	@Test
	void testGetAllJinOfficers() {
		characters = dao.getAllJinOfficers();
		assertEquals(12, characters.size());
	}
	
	
	@DisplayName("Test Get All Jin SubOfficers")
	@Test
	void testGetAllJinSubOfficers() {
		characters = dao.getAllJinSubOfficers();
		assertEquals(208, characters.size());
	}
	
	@DisplayName("Test Get All Other Officers")
	@Test
	void testGetAllOtherOfficers() {
		characters = dao.getAllWuOfficers();
		assertEquals(18, characters.size());
	}
	
	
	@DisplayName("Test Get All Other SubOfficers")
	@Test
	void testGetAllOtherSubOfficers() {
		characters = dao.getAllOtherSubOfficers();
		assertEquals(296, characters.size());
	}

}
