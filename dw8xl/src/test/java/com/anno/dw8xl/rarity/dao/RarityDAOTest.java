/**
 * 
 */
package com.anno.dw8xl.rarity.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.dao.DataAccessObjectInterface;
import com.anno.dw8xl.rarity.model.NullRarity;
import com.anno.dw8xl.rarity.model.Rarity;
import com.anno.dw8xl.rarity.model.RarityI;

/**
 * @author venividivicihofneondeion010101
 *
 */
class RarityDAOTest {

	
	private DataAccessObjectInterface<RarityI, Object> dataAccessObjectInterface;
	private RarityI expected;
	private Collection<RarityI> rarities;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUpBefore() throws Exception {
		dataAccessObjectInterface = RarityDAO.getInstance();
		expected = new Rarity("Normal");
	}

	@DisplayName("Test Get All Rarities Collection is Greater than Zero")
	@Test
	void testGetAllRarities() {
		rarities = dataAccessObjectInterface.getAll();
		assertTrue(rarities.size() > 0);
	}
	
	@DisplayName("Test Get All Rarities Collection contains Expected [Normal]")
	@Test
	void testRaritiesContainsExpected() {
		rarities = dataAccessObjectInterface.getAll();
		assertTrue(rarities.contains(expected));
	}
	
	@DisplayName("Test Get All Rarities Collection Equals Expected [Normal]")
	@Test
	void testRaritiesEqualsExpected() {
		rarities = dataAccessObjectInterface.getAll();
		RarityI actual = rarities.stream().filter(e-> e.getType().equals(expected.getType())).findFirst().get();
		assertEquals(expected, actual);
	}
	
	@DisplayName("Test Get By 'Type' and returned equals Expected [Normal]")
	@Test
	void testGetByTypeAndReturnsExpected() {
		Optional<RarityI> actual = dataAccessObjectInterface.getBy("Normal");
		assertEquals(expected, actual.get());
	}
	
	@DisplayName("Test Get By 'Object' and returned equals Expected [Normal]")
	@Test
	void testGetByExpectedAndReturnsExpected() {
		Optional<RarityI> actual = dataAccessObjectInterface.getBy(expected);
		assertEquals(expected, actual.get());
	}
	
	@DisplayName("Test Get By Non-Existent 'Object' and returned equals Expected [NullRarity]")
	@Test
	void testGetByUnExpectedAndReturnsExpectedNullRarity() {
		Optional<RarityI> actual = dataAccessObjectInterface.getBy(new Rarity("VOID"));
		assertEquals(new NullRarity().getType(), actual.get().getType());
	}
	
	@DisplayName("Test Get By Non-Existent 'Object' and does Not Contain in Rarities Map")
	@Test
	void testGetByUnExpectedAndDoesNotContainInMap() {
		rarities = dataAccessObjectInterface.getAll();
		Optional<RarityI> actual = dataAccessObjectInterface.getBy(new Rarity("VOID"));
		assertFalse(rarities.contains(actual.get()));
	}
	
	@DisplayName("Test Add Non-Existent 'Object' and size increases by 1")
	@Test
	void testAddAndReturnsIncreasedMapSize() {
		rarities = dataAccessObjectInterface.getAll();
		int size = rarities.size();
		RarityI expected = new Rarity("VOID");
		dataAccessObjectInterface.add(expected);
		rarities = dataAccessObjectInterface.getAll();;
		assertEquals(size+1, rarities.size());
	}
	
	@DisplayName("Test Add already-Existent 'Object' and size increases by 0")
	@Test
	void testAddExpectedAndReturnsEqualMapSize() {
		rarities = dataAccessObjectInterface.getAll();
		int size = rarities.size();
		dataAccessObjectInterface.add(expected);
		rarities = dataAccessObjectInterface.getAll();;
		assertEquals(size, rarities.size());
	}
	
	@DisplayName("Test Add NullObject 'Object' and size increases by 0")
	@Test
	void testAddNullObjectAndReturnsEqualMapSize() {
		rarities = dataAccessObjectInterface.getAll();
		int size = rarities.size();
		RarityI expected = new NullRarity();
		dataAccessObjectInterface.add(expected);
		rarities = dataAccessObjectInterface.getAll();;
		assertEquals(size, rarities.size());
	}
	
	@DisplayName("Test Add Empty String 'Object' and size increases by 0")
	@Test
	void testAddEmptStringAndReturnsEqualMapSize() {
		rarities = dataAccessObjectInterface.getAll();
		int size = rarities.size();
		RarityI expected = new Rarity("");
		dataAccessObjectInterface.add(expected);
		rarities = dataAccessObjectInterface.getAll();;
		assertEquals(size, rarities.size());
	}
	
	@DisplayName("Add Rarity with Null and returns size increases by 0 && Throws")
	@Test
	void testAddNullAndIncreaseSizeByZero() {
		rarities = dataAccessObjectInterface.getAll();
		int size = rarities.size();
		Exception e = assertThrows(NullPointerException.class, () -> {
			dataAccessObjectInterface.add(null);			
		});
		rarities = dataAccessObjectInterface.getAll();
		assertEquals(size, rarities.size());
		assertEquals("Rarity cannot be added due to Null!", e.getMessage());
	}
	
	@DisplayName("Remove Rarity with Expected and returns size decreases by 1")
	@Test
	void testRemoveExpectedAndDescreasedSizeByOne() {
		rarities = dataAccessObjectInterface.getAll();
		int size = rarities.size();
		dataAccessObjectInterface.remove(expected);			
		rarities = dataAccessObjectInterface.getAll();
		assertEquals(size-1, rarities.size());
	}
	
	@DisplayName("Remove Expected Rarity Twice and returns size decreases by 1")
	@Test
	void testRemoveExpectedTwiceAndDescreasedSizeByOne() {
		rarities = dataAccessObjectInterface.getAll();
		int size = rarities.size();
		dataAccessObjectInterface.remove(expected);			
		rarities = dataAccessObjectInterface.getAll();
		dataAccessObjectInterface.remove(expected);			
		rarities = dataAccessObjectInterface.getAll();
		assertEquals(size-1, rarities.size());
	}
	
	@DisplayName("Remove Rarity with NullRarity and returns size decreases by 0")
	@Test
	void testRemoveNullRarityAndDescreasedSizeByZero() {
		rarities = dataAccessObjectInterface.getAll();
		int size = rarities.size();
		dataAccessObjectInterface.remove(new NullRarity());			
		rarities = dataAccessObjectInterface.getAll();
		assertEquals(size, rarities.size());
	}
	
	@DisplayName("Remove Rarity with Empty String and returns size decreases by 0")
	@Test
	void testRemoveWithEmtpyStringAndDescreasedSizeByZero() {
		rarities = dataAccessObjectInterface.getAll();
		int size = rarities.size();
		dataAccessObjectInterface.remove(new Rarity(""));			
		rarities = dataAccessObjectInterface.getAll();
		assertEquals(size, rarities.size());
	}
	
	
	@DisplayName("Remove Rarity with Null and returns size decreases by 0 && Throws")
	@Test
	void testRemoveNullAndDescreasedSizeByZero() {
		rarities = dataAccessObjectInterface.getAll();
		int size = rarities.size();
		Exception e = assertThrows(NullPointerException.class, () -> {
			dataAccessObjectInterface.remove(null);			
		});
		rarities = dataAccessObjectInterface.getAll();
		assertEquals(size, rarities.size());
		assertEquals("Rarity cannot be removed due to Null!", e.getMessage());
	}
}
