/**
 * 
 */
package com.anno.dw8xl.kingdom.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.dao.DAO;
import com.anno.dw8xl.kingdom.model.Kingdom;
import com.anno.dw8xl.kingdom.model.KingdomI;

/**
 * @author venividivicihofneondeion010101
 *
 */
class KingdomDAOTest {

	private DAO<KingdomI, Object> dao;
	private KingdomI expected;
	private Collection<KingdomI> kingdoms;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dao = KingdomDAO.getInstance();
		expected = new Kingdom("Shu");
	}

	@DisplayName("Get All Kingdoms returns > 0")
	@Test
	void testGetALLKingdoms() {
		kingdoms = dao.getAll();
		assertTrue(kingdoms.size() > 0);
	}
	
	@DisplayName("Kingdoms contains expected [Shu]")
	@Test
	void testGetExpectedValue() {
		kingdoms = dao.getAll();
		assertTrue(kingdoms.contains(expected));
	}
	
	@DisplayName("Get By Object")
	@Test
	void testGetBy_Object() {
		kingdoms = dao.getAll();
		Optional<KingdomI> temp = dao.getBy(expected);
		assertEquals(temp.get(), expected);
	}
	
	
	@DisplayName("Get By String")
	@Test
	void testGetBy_String() {
		kingdoms = dao.getAll();
		Optional<KingdomI> temp = dao.getBy("Shu");
		assertEquals(temp.get(), expected);
	}
	
	
	@DisplayName("Kingdoms - Get By String - FALSE")
	@Test
	void testCompareErroredKingdomWithListUsingContains_FALSE() {
		kingdoms = dao.getAll();
		Optional<KingdomI> temp = dao.getBy("Shus");
		assertFalse(kingdoms.contains(temp.get()));
	}
	
	@DisplayName("Kingdoms - Get By String - TRUE")
	@Test
	void testCompareErroredKingdomWithListUsingContains_TRUE() {
		kingdoms = dao.getAll();
		Optional<KingdomI> temp = dao.getBy("Shu");
		assertTrue(kingdoms.contains(temp.get()));
	}
	
	@DisplayName("Kingdoms - Get By Object- FALSE")
	@Test
	void testCompareObjectErroredKingdomWithListUsingContains_FALSE() {
		kingdoms = dao.getAll();
		Optional<KingdomI> temp = dao.getBy(new Kingdom("VOID"));
		assertFalse(kingdoms.contains(temp.get()));
	}
	
	@DisplayName("Kingdoms - Get By Object - TRUE")
	@Test
	void testCompareObjectErroredKingdomWithListUsingContains_TRUE() {
		kingdoms = dao.getAll();
		Optional<KingdomI> temp = dao.getBy(expected);
		assertTrue(kingdoms.contains(temp.get()));
	}
	
	
	

}
