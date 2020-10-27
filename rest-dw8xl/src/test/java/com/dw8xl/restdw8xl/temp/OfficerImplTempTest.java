/**
 * 
 */
package com.dw8xl.restdw8xl.temp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.model.character.Officer;
import com.dw8xl.restdw8xl.model.kingdom.Kingdom;
import com.dw8xl.restdw8xl.model.kingdom.KingdomI;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryDNE;
import com.dw8xl.restdw8xl.model.weapon.type.Type;
import com.dw8xl.restdw8xl.model.weapon.type.TypeI;

/**
 * @author Haku Wei
 *
 */
class OfficerImplTempTest {

	
	private OfficerImplTemp temp;
	private List<CharacterI> officers;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		temp = new OfficerImplTemp();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.dw8xl.restdw8xl.temp.OfficerImplTemp#getAllOfficerFiles()}.
	 */
	@Test
	void testGetAllOfficerFiles() throws FileNotFoundException {
		officers = temp.getAllOfficerFiles();
		officers.stream().forEach(o -> {
			String name = o.getName();
			KingdomI king = o.getDynasty();
			TypeI type = o.getType();
			System.out.printf("(\"%s\" ,\"%s\" , \"%s\"),\n", name, king.getName(), type.getType());
		});
		assertNotNull(temp.getAllOfficerFiles());
	}
	
	@Test
	void testParseThroughOfficerURLsByKingdom() {
		String actual = temp.parseURLByKingdom(new Kingdom("Shu"));
		List<String> paths = Arrays.asList(temp.getAllOfficerURLs());
		assertTrue(paths.contains(actual));
		
	}

	/**
	 * Test method for {@link com.dw8xl.restdw8xl.temp.OfficerImplTemp#getShuOfficers()}.
	 */
	@Test
	void testGetShuOfficers() throws FileNotFoundException {
		assertNotNull(temp.getShuOfficers());
	}

	/**
	 * Test method for {@link com.dw8xl.restdw8xl.temp.OfficerImplTemp#getWuOfficers()}.
	 */
	@Test
	void testGetWuOfficers() throws FileNotFoundException {
		assertNotNull(temp.getWuOfficers());
	}

	/**
	 * Test method for {@link com.dw8xl.restdw8xl.temp.OfficerImplTemp#getWeiOfficers()}.
	 */
	@Test
	void testGetWeiOfficers() throws FileNotFoundException {
		assertNotNull(temp.getWeiOfficers());
	}

	/**
	 * Test method for {@link com.dw8xl.restdw8xl.temp.OfficerImplTemp#getJinOfficers()}.
	 */
	@Test
	void testGetJinOfficers() throws FileNotFoundException {
		assertNotNull(temp.getJinOfficers());
	}

	/**
	 * Test method for {@link com.dw8xl.restdw8xl.temp.OfficerImplTemp#getOtherOfficers()}.
	 */
	@Test
	void testGetOtherOfficers() throws FileNotFoundException {
		assertNotNull(temp.getOtherOfficers());
	}

	/**
	 * Test method for {@link com.dw8xl.restdw8xl.temp.OfficerImplTemp#findOfficerByName(java.lang.String)}.
	 */
	@Test
	void testFindOfficerByName() {
		CharacterI expected = new Officer("Zhao Yun", new Kingdom("Shu"), new Type("Dragon Spear", new CategoryDNE()));
		CharacterI actual = temp.findOfficerByName("Zhao Yun");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.dw8xl.restdw8xl.temp.OfficerImplTemp#findOfficerByType(com.dw8xl.restdw8xl.model.weapon.type.TypeI)}.
	 */
	@Test
	void testFindOfficerByType() {
		CharacterI expected = new Officer("Zhao Yun", new Kingdom("Shu"), new Type("Dragon Spear", new CategoryDNE()));
		TypeI actual = new Type("Dragon Spear", new CategoryDNE());
		assertEquals(expected, temp.findOfficerByType(actual));
	}

}
