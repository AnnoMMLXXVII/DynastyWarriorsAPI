/**
 * 
 */
package com.dw8xl.restdw8xl.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.model.character.SubOfficer;
import com.dw8xl.restdw8xl.model.kingdom.Kingdom;
import com.dw8xl.restdw8xl.model.weapon.WeaponI;
import com.dw8xl.restdw8xl.model.weapon.affinity.Affinity;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;
import com.dw8xl.restdw8xl.model.weapon.attribute.Normal;
import com.dw8xl.restdw8xl.model.weapon.attribute.Special;
import com.dw8xl.restdw8xl.model.weapon.attribute.level.Level;
import com.dw8xl.restdw8xl.model.weapon.category.Category;
import com.dw8xl.restdw8xl.model.weapon.classifications.Rare;
import com.dw8xl.restdw8xl.model.weapon.type.Type;

/**
 * @author Haku Wei
 *
 */
class SampleListControllerTest {

	private SampleListController dao;
	private List<CharacterI> mockSubOfficers;
	private List<AttributeI> expectedAttributes;
	private WeaponI expected, expectedWeapon;
	private AttributeI expectedAttribute;
	
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
		dao = new SampleListController();
		
		expectedAttributes = new ArrayList<>();
		expectedAttribute = new Normal("Barricade", new Level(7));
		expectedAttributes.add(expectedAttribute);
		
		expectedAttribute = new Special("Fury");
		expectedAttributes.add(expectedAttribute);
		
		expectedAttribute = new Normal("Fear", new Level(8));
		expectedAttributes.add(expectedAttribute);
		
		expected = new Rare(
				"Flying Formation", 22, new Affinity("Earth"), new Integer(2), new Type("Spear", new Category("Whirlwind"))
				);
		
		expectedWeapon = new Rare(
				"Flying Formation", 22, new Affinity("Earth"), new Integer(2), new Type("Spear", new Category("Whirlwind")),
				expectedAttributes
				);
	}

	/**
	 * @throws java.lang.Exception
	 */
	/**
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testParseThroughOfficers() {
		
	}
	
	@Test
	void testParseThroughWeaponAttributeLevel() {
		Map<String, List<AttributeI>> mapped = dao.parseThroughWeaponAttributeLevelTextFiles();
		assertFalse(mapped.isEmpty());
	}
	
	@Test
	void testParseThroughWeaponAttributeLevelMapKeyEqualsExpected() {
		String expected = "Flying Formation";
		Map<String, List<AttributeI>> mapped = dao.parseThroughWeaponAttributeLevelTextFiles();
		assertTrue(mapped.containsKey(expected));
	}
	
	@Test
	void testParseThroughWeaponAttributeLevelMapValueAttributeAtIndexZeroEqualsExpected() {
		String expected = "Flying Formation";
		Map<String, List<AttributeI>> mapped = dao.parseThroughWeaponAttributeLevelTextFiles();
		List<AttributeI> attributes = mapped.get(expected);
		AttributeI attribute = attributes.get(2);
		assertEquals(expectedAttribute, attribute);
	}
	
	@Test
	void testParseThroughRareWeaponSizeIsGreaterThanZero() {
		Map<String, List<AttributeI>> mapped = dao.parseThroughWeaponAttributeLevelTextFiles();
		String path = "whirlwind\\RareWeapons.txt";
		List<WeaponI> weapons = dao.parseThroughRareWeaponTextFile(path, mapped);
		assertTrue(weapons.size() > 0);
	}
	
	@Test
	void testParseThroughRareWeaponListAttriubtesIsNotEmpty() {
		Map<String, List<AttributeI>> mapped = dao.parseThroughWeaponAttributeLevelTextFiles();
		String path = "whirlwind\\RareWeapons.txt";
		List<WeaponI> weapons = dao.parseThroughRareWeaponTextFile(path, mapped);
		assertTrue(!weapons.isEmpty());
	}
	
	@Test
	void testParseThroughRareWeaponListAttributesMappedKeyMatchesWeaponName() {
		Map<String, List<AttributeI>> mapped = dao.parseThroughWeaponAttributeLevelTextFiles();
		String path = "whirlwind\\RareWeapons.txt";
		List<WeaponI> weapons = dao.parseThroughRareWeaponTextFile(path, mapped);
		assertTrue(mapped.containsKey(weapons.get(0).getName()));
	}
	
	@Test
	void testParseThroughRareWeaponListAttributesWeaponAttributesEqualsExpected() {
		Map<String, List<AttributeI>> mapped = dao.parseThroughWeaponAttributeLevelTextFiles();
		String path = "whirlwind\\RareWeapons.txt";
		List<WeaponI> weapons = dao.parseThroughRareWeaponTextFile(path, mapped);
		List<AttributeI> attributes = weapons.get(0).getAttributes();
		assertEquals(expectedAttributes, attributes);
	}
	
	@Test
	void testParseThroughRareWeaponListWeaponIsNotNull() {
		Map<String, List<AttributeI>> mapped = dao.parseThroughWeaponAttributeLevelTextFiles();
		String path = "whirlwind\\RareWeapons.txt";
		List<WeaponI> weapons = dao.parseThroughRareWeaponTextFile(path, mapped);
		WeaponI weapon = weapons.get(0).getInstance();
		assertNotNull(weapon);
	}
	
	@Test
	void testparseThroughFileByKingdom() {
		mockSubOfficers = dao.parseThroughSubOfficerTextFileByKingdom(new Kingdom("Jin"));
		assertTrue(mockSubOfficers.size() > 0);
	}
	
	@Test
	void testGetSubOfficerByName() {
		CharacterI temp = new SubOfficer("Chen Jun", new Kingdom("Jin"));
		mockSubOfficers = dao.parseThroughSubOfficerTextFileByKingdom(new Kingdom("Jin"));
		assertTrue(mockSubOfficers.contains(temp));
	}
	
	@Test
	void testGetOfficerByWildcardSearch() {
		String expected = "Jin";
		mockSubOfficers = dao.parseThroughMultipleSubOfficersTextFiles();
		List<CharacterI> wildCardSubOfficers = dao.getSubOfficersByWildCard(expected);
		 assertTrue(wildCardSubOfficers.size() > 0);
	}
	
	@Test
	void testGetAllSubOfficers() {
		mockSubOfficers = dao.parseThroughMultipleSubOfficersTextFiles();
		assertTrue(mockSubOfficers.size() > 0);
		Collections.sort(mockSubOfficers, (s1, s2) -> s1.getName().compareTo(s2.getName()));
<<<<<<< HEAD
<<<<<<< HEAD
		mockSubOfficers.stream().forEach(so -> {
			String name = so.getName();
			String dyn = so.getDynasty().getName();
			System.out.printf("(%s, %s),\n", name, dyn);
		});
=======
>>>>>>> fb26b208abdcac342fb35ffa201dc52e9be5477b
=======
		mockSubOfficers.stream().forEach(s -> {
			String name = s.getName();
			String king = s.getDynasty().getName();
			System.out.printf("(\"%s\", \"%s),\n", name, king);

		});
>>>>>>> c4e7535990a0e359f7a4d2b5584829013e608fdd
	}
	

}
