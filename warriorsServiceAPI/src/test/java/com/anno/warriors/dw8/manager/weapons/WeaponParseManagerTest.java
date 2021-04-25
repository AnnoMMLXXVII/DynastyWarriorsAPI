package com.anno.warriors.dw8.manager.weapons;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.anno.warriors.dw8.enums.affinity.Affinity;
import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.rarity.Rarity;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(Lifecycle.PER_CLASS)
class WeaponParseManagerTest {

	private DynastyWarriors8Object<WeaponParseManager> instance;
	private List<WeaponInterface<Weapon>> weapons;
	private List<String> weaponNames;
	private List<WeaponInterface<Weapon>> temp;
	private Map<Category, List<WeaponInterface<Weapon>>> categoryWeaponsMap;
	private Map<Types, List<WeaponInterface<Weapon>>> typesWeaponListMap;
	private Map<String, List<WeaponInterface<Weapon>>> weaponNameWeaponsMap;

	private Category expectedCategory = Category.DIVER;
	private Types expectedTypes = Types.DRAGON_SPEAR;
	private String expectedWeaponName = "Dark Dragon Spear";

	@BeforeAll
	void beforeAll() throws Exception {
		instance = WeaponParseManager.getInstance();
	}

	@BeforeEach
	void setUp() throws Exception {
		weapons = WeaponParseManager.getWeapons();
		weaponNames = WeaponParseManager.getWeaponNames();
		categoryWeaponsMap = WeaponParseManager.getCategoryWeaponsMap();
		typesWeaponListMap = WeaponParseManager.getTypesWeaponListMap();
		weaponNameWeaponsMap = WeaponParseManager.getWeaponNameWeaponsMap();
	}

	@AfterAll
	void breakDown() throws Exception {
		weaponNameWeaponsMap.clear();
		typesWeaponListMap.clear();
		categoryWeaponsMap.clear();
		weaponNames.clear();
		weapons.clear();
	}

	@Test
	void testInstanceIsNotNull() {
		assertNotNull(instance);
	}

	@Test
	void testInstanceStateEqualsExpected() {
		assertEquals("WeaponParseManager", instance.getState());
	}

	@Test
	void testWeaponsIsNotEmpty() {
		assertTrue(!weapons.isEmpty());
	}

	@Test
	void testWeaponNamesIsNotEmpty() {
		assertTrue(!weaponNames.isEmpty());
	}

	@Test
	void testCategoryWeaponMapIsNotEmpty() {
		assertTrue(!categoryWeaponsMap.isEmpty());
	}

	@Test
	void testTypesWeaponListMapIsNotEmpty() {
		assertTrue(!typesWeaponListMap.isEmpty());
	}

	@Test
	void testWeaponNameWeaponsMapIsNotEmpty() {
		assertTrue(!weaponNameWeaponsMap.isEmpty());
	}

	@Test
	void testCategoryWeaponMapValueIsNotEmpty() {
		temp = categoryWeaponsMap.get(expectedCategory);
		assertTrue(!temp.isEmpty());
	}

	@Test
	void testTypesWeaponListMapValueIsNotEmpty() {
		temp = typesWeaponListMap.get(expectedTypes);
		assertTrue(!temp.isEmpty());
	}

	@Test
	void testWeaponNameWeaponMapValueIsNotEmpty() {
		temp = weaponNameWeaponsMap.get(expectedWeaponName);
		assertTrue(!temp.isEmpty());
	}

	@Test
	void testWeaponNameWeaponMapValueListSizeISGreaterThanOne() {
		temp = weaponNameWeaponsMap.get("Heavenly Dragon");
		assertTrue(temp.size() > 1);
	}

	@Test
	void testWeaponNameWeaponMapValueMatchesExpectedValues() {
//		Dark Dragon Spear : 
//		[Weapon [name=Dark Dragon Spear, power=62, star=6, type=DRAGON_SPEAR, rarity=EXTREME, category=DIVER affinity=HEAVEN]]
		temp = weaponNameWeaponsMap.get(expectedWeaponName);
		assertTrue(!temp.isEmpty());
		WeaponInterface<Weapon> actual = temp.get(0);
		assertEquals(expectedWeaponName, actual.getName());
		assertEquals(62, actual.getPower());
		assertEquals(6, actual.getStar());
		assertEquals(Types.DRAGON_SPEAR, actual.getType());
		assertEquals(Rarity.EXTREME, actual.getRarity());
		assertEquals(Category.DIVER, actual.getCategory());
		assertEquals(Affinity.HEAVEN, actual.getAffinity());
	}

	@Test
	void testCategoryWeaponMapValueListLengthMatchesExpectedAfterFilteringByStarSix() {
		temp = categoryWeaponsMap.get(expectedCategory);
		List<WeaponInterface<Weapon>> sixStars = temp.stream().filter(e -> e.getStar() == (6))
				.collect(Collectors.toList());
		assertTrue(temp.size() > sixStars.size());
		assertEquals(9, sixStars.size());
	}

	@Test
	void testCategoryWeaponMapValueListStreamFilterToGetReturnsEmpty() {
		temp = categoryWeaponsMap.get(expectedCategory);
		Optional<WeaponInterface<Weapon>> weapon = temp.stream().filter(e -> e.getName().equals("Nothing")).findFirst();
		assertFalse(weapon.isPresent());
	}

	@Test
	void testCategoryWeaponMapValueListStreamFilterToGetReturnsAndMatchesExpected() {
		temp = categoryWeaponsMap.get(expectedCategory);
		Optional<WeaponInterface<Weapon>> weapon = temp.stream().filter(e -> e.getName().equals(expectedWeaponName))
				.findFirst();
		assertTrue(weapon.isPresent());
		WeaponInterface<Weapon> actual = weapon.get();
		assertEquals(expectedWeaponName, actual.getName());
		assertEquals(62, actual.getPower());
		assertEquals(6, actual.getStar());
		assertEquals(Types.DRAGON_SPEAR, actual.getType());
		assertEquals(Rarity.EXTREME, actual.getRarity());
		assertEquals(Category.DIVER, actual.getCategory());
		assertEquals(Affinity.HEAVEN, actual.getAffinity());
	}

	@Test
	void testTypesWeaponMapValueListStreamFilterToGetReturnsEmpty() {
		temp = typesWeaponListMap.get(expectedTypes);
		Optional<WeaponInterface<Weapon>> weapon = temp.stream().filter(e -> e.getName().equals("NOTHING")).findFirst();
		assertFalse(weapon.isPresent());
	}

	@Test
	void testTypesWeaponMapValueListStreamFilterToGetReturnsAndMatchesExpected() {
		temp = typesWeaponListMap.get(expectedTypes);
		Optional<WeaponInterface<Weapon>> weapon = temp.stream().filter(e -> e.getName().equals(expectedWeaponName))
				.findFirst();
		assertTrue(weapon.isPresent());
		WeaponInterface<Weapon> actual = weapon.get();
		assertEquals(expectedWeaponName, actual.getName());
		assertEquals(62, actual.getPower());
		assertEquals(6, actual.getStar());
		assertEquals(Types.DRAGON_SPEAR, actual.getType());
		assertEquals(Rarity.EXTREME, actual.getRarity());
		assertEquals(Category.DIVER, actual.getCategory());
		assertEquals(Affinity.HEAVEN, actual.getAffinity());
	}

}
