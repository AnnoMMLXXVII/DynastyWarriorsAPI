/**
 * 
 */
package com.anno.dw8xl.kingdom.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.anno.dw8xl.kingdom.model.Kingdom;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author venividivicihofneondeion010101
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
class KingdomDAOTest {

	private KingdomDAOInterface dao;
	private KingdomI expected;
	private Collection<KingdomI> kingdoms;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
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

	@DisplayName("Get By String")
	@Test
	void testGetBy_String() {
		kingdoms = dao.getAll();
		Optional<KingdomI> temp = dao.getBy("Shu");
		if (temp.isPresent()) {
			assertEquals(temp.get().getName(), expected.getName());
		}
	}

	@DisplayName("Kingdoms - Get By String - FALSE")
	@Test
	void testCompareErroredKingdomWithListUsingContains_FALSE() {
		kingdoms = dao.getAll();
		Optional<KingdomI> temp = dao.getBy("Shus");
		if(temp.isPresent()) {
			assertFalse(kingdoms.contains(temp.get()));			
		}
	}

	@DisplayName("Kingdoms - Get By String - TRUE")
	@Test
	void testCompareErroredKingdomWithListUsingContains_TRUE() {
		kingdoms = dao.getAll();
		Optional<KingdomI> temp = dao.getBy("Shu");
		assertTrue(kingdoms.contains(temp.get()));
	}
	
	@DisplayName("Add Kingdoms with Empty name and returns size increases by 0")
	@Test
	void testAddEmptyStringAndIncreaseSizeByZero() {
		kingdoms = dao.getAll();
		int size = kingdoms.size();
		dao.add(new Kingdom(""));
		kingdoms = dao.getAll();
		assertEquals(size, kingdoms.size());
	}
	
	@DisplayName("Add Kingdoms with [VOID] name and returns size increases by 1")
	@Test
	void testAddVOIDStringAndIncreaseSizeByOne() {
		kingdoms = dao.getAll();
		int size = kingdoms.size();
		dao.add(new Kingdom("VOID"));
		kingdoms = dao.getAll();
		assertEquals(size+1, kingdoms.size());
	}
	
	@DisplayName("Add Kingdoms with Null and returns size increases by 0 && Throws")
	@Test
	void testAddNullAndIncreaseSizeByZero() {
		kingdoms = dao.getAll();
		int size = kingdoms.size();
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(null);			
		});
		kingdoms = dao.getAll();
		assertEquals(size, kingdoms.size());
		assertEquals("Kngdom cannot be added due to Null!", e.getMessage());
	}
	
	@DisplayName("Remove List of Kingdoms _ Happy Path") 
	@Test
	void testRemoveKingdoms() throws JsonProcessingException {
		KingdomI[] arr = {
			expected
		};
		kingdoms = dao.getAll();
		int size = kingdoms.size();
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		json = mapper.writeValueAsString(arr);
		System.out.println(json);
		dao.executeRemoveKingdom(json);
		kingdoms = dao.getAll();
		assertNotEquals(size, kingdoms.size());
	}

}
