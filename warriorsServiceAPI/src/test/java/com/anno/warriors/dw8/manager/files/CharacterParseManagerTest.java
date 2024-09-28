package com.anno.warriors.dw8.manager.files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.characters.model.Officer;
import com.anno.warriors.dw8.characters.model.SubOfficer;
import com.anno.warriors.dw8.enums.affinity.Affinity;
import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.rarity.Rarity;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.MapDependencyManager;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;
import com.anno.warriors.dw8.weapons.slots.AttributeSlot;
import com.anno.warriors.dw8.weapons.slots.PowerAttribute;
import com.anno.warriors.dw8.weapons.slots.PowerlessAttribute;
import com.anno.warriors.shared.WarriorSorter;

@TestInstance(Lifecycle.PER_CLASS)
@SuppressWarnings({ "unchecked", "rawtypes" })
class CharacterParseManagerTest {

	private DynastyWarriors8Object<CharacterParseManager> instance;
	private List<CharacterInterface<Character>> characterList;
	private List<CharacterInterface<Character>> officerList;
	private List<CharacterInterface<Character>> subOfficerList;
	private List<CharacterInterface<Character>> list;
	private Map<Kingdom, List<CharacterInterface<Character>>> charactersMappedByKingdomMap;

	@BeforeAll
	void beforeAll() throws Exception {
		instance = CharacterParseManager.getInstance();
	}

	@BeforeEach
	void setUp() throws Exception {
		characterList = CharacterParseManager.getCharacters();
		officerList = CharacterParseManager.getOfficers();
		subOfficerList = CharacterParseManager.getSubOfficers();
		charactersMappedByKingdomMap = CharacterParseManager.getKingdomCharacterMap();
	}

	@AfterEach
	void breakDown() throws Exception {
//		characterList.clear();
//		officerList.clear();
//		subOfficerList.clear();
//		charactersMappedByKingdomMap.clear();
	}

	@Test
	void testInstanceMatchesExpected() {
		assertEquals(instance.getState(), "CharacterParseManager");
	}

	@Test
	void testCharacterListIsNotEmpty() {
		assertFalse(characterList.isEmpty());
	}

	@Test
	void testCharacter_OfficerListIsNotEmpty() {
		assertFalse(officerList.isEmpty());
	}

	@Test
	void testCharacter_SuOfficerListIsNotEmpty() {
		assertFalse(subOfficerList.isEmpty());
	}

	@Test
	void testCharacterList_ByKingdomIsNotEmpty() {
		list = charactersMappedByKingdomMap.get(Kingdom.OTHER);
		assertNotNull(list); // checks if the list is null
	}

	@Test
	void testCharacterValuesInReturnedList_ByKingdomIsNotEmpty() {
		list = charactersMappedByKingdomMap.get(Kingdom.WEI);
		assertNotNull(list.stream().map(e -> e != null)); // checks if each value in the list is not null
	}

	@Test
	void testCharacterValuesInReturnedList_ByKingdomMatchesOfficersNameInList() {
		List<CharacterInterface<Character>> localList = officerList.stream()
				.filter(e -> e.getKingdom().equals(Kingdom.WEI)).collect(Collectors.toList());

		list = charactersMappedByKingdomMap.get(Kingdom.WEI);
		list = list.stream().filter(e -> e instanceof Officer).collect(Collectors.toList());

		WarriorSorter<Character> localSorter = new WarriorSorter(localList);
		WarriorSorter<Character> classSorter = new WarriorSorter(list);

		for (int i = 0; i < localSorter.getSortedList().size(); i++) {
			assertEquals(localSorter.getSortedList().get(i).compareTo(classSorter.getSortedList().get(i)), 0);
		}

	}

	@Test
	void testCharacterValuesInReturnedList_ByKingdomDoesNOTMatchesOfficersNameInList() {
		List<CharacterInterface<Character>> localList = officerList.stream()
				.filter(e -> e.getKingdom().equals(Kingdom.JIN)).collect(Collectors.toList());

		list = charactersMappedByKingdomMap.get(Kingdom.WU);
		list = list.stream().filter(e -> e instanceof Officer).collect(Collectors.toList());

		WarriorSorter<Character> localSorter = new WarriorSorter(localList);
		WarriorSorter<Character> classSorter = new WarriorSorter(list);

		for (int i = 0; i < localSorter.getSortedList().size(); i++) {
			assertNotEquals(localSorter.getSortedList().get(i).compareTo(classSorter.getSortedList().get(i)), 0);
		}
	}

	@Test
	void testCharacterValuesInReturnedList_ByKingdomMatchesSubOfficersNameInList() {
		List<CharacterInterface<Character>> localList = subOfficerList.stream()
				.filter(e -> e.getKingdom().equals(Kingdom.SHU)).collect(Collectors.toList());

		list = charactersMappedByKingdomMap.get(Kingdom.SHU);
		list = list.stream().filter(e -> e instanceof SubOfficer).collect(Collectors.toList());

		WarriorSorter<Character> localSorter = new WarriorSorter(localList);
		WarriorSorter<Character> classSorter = new WarriorSorter(list);

		for (int i = 0; i < localSorter.getSortedList().size(); i++) {
			assertEquals(localSorter.getSortedList().get(i).compareTo(classSorter.getSortedList().get(i)), 0);
		}
	}

	@Test
	void testCharacterValuesInReturnedList_ByKingdomDoesNOTMatchesSubOfficersNameInList() {
		List<CharacterInterface<Character>> localList = subOfficerList.stream()
				.filter(e -> e.getKingdom().equals(Kingdom.JIN)).collect(Collectors.toList());

		list = charactersMappedByKingdomMap.get(Kingdom.WU);
		list = list.stream().filter(e -> e instanceof SubOfficer).collect(Collectors.toList());

		WarriorSorter<Character> localSorter = new WarriorSorter(localList);
		WarriorSorter<Character> classSorter = new WarriorSorter(list);

		for (int i = 0; i < localSorter.getSortedList().size(); i++) {
			assertNotEquals(localSorter.getSortedList().get(i).compareTo(classSorter.getSortedList().get(i)), 0);
		}
	}

	@Test
	void testCharacterValues_ByNameMatchesExpectedValuesWithoutMapping() {
		// Before mapping Images and Weapons
		String expectedName = "Zhao Yun";
		Optional<CharacterInterface<Character>> opt = officerList.stream()
				.filter(e -> e.getName().equalsIgnoreCase(expectedName)).findFirst();

		assertTrue(opt.isPresent());
		CharacterInterface<Character> actual = opt.get();
//		System.out.println("Test[11] --> " + actual.toString());
		assertEquals(actual.getName(), expectedName);
		assertEquals(actual.getKingdom(), Kingdom.SHU);
		assertEquals(actual.getImage().size(), 0);
		assertEquals(actual.getWeaponType(), Types.DRAGON_SPEAR);

		List<WeaponInterface<Weapon>> actualWeapons = actual.getWeapons();
		actualWeapons.clear();
		assertEquals(actualWeapons.size(), 0);
	}

	@Test
	void testCharacterValues_ByNameMatchesExpectedValuesWithMapping() {
		String expectedName = "Zhao Yun";
		MapDependencyManager.getInstance();
		Optional<CharacterInterface<Character>> opt = CharacterParseManager.getOfficers().stream()
				.filter(e -> e.getName().equalsIgnoreCase(expectedName)).findFirst();

		assertTrue(opt.isPresent());

		CharacterInterface<Character> actual = opt.get();
		assertEquals(actual.getName(), expectedName);
		assertEquals(actual.getKingdom(), Kingdom.SHU);
		assertEquals(actual.getImage().get(0), "src/main/resources/Officer_Images/Zhao_Yun_1.jpg");
		assertEquals(actual.getImage().get(1), "src/main/resources/Officer_Images/Zhao_Yun_2.jpg");
		assertEquals(actual.getWeaponType(), Types.DRAGON_SPEAR);

		List<WeaponInterface<Weapon>> actualWeapons = actual.getWeapons();
		assertEquals(actualWeapons.size(), 10);

		WeaponInterface<Weapon> actualWeapon = actualWeapons.get(0);
		assertNotNull(actualWeapon);
		assertEquals(actualWeapon.getName(), "Dragon Fang");
		assertEquals(actualWeapon.getPower(), 15);
		assertEquals(actualWeapon.getStar(), 1);
		assertEquals(actualWeapon.getType(), actual.getWeaponType());
		assertEquals(actualWeapon.getRarity(), Rarity.NORMAL);
		assertEquals(actualWeapon.getCategory(), Category.DIVER);
		assertEquals(actualWeapon.getImage(), "N/A");
		assertEquals(actualWeapon.getLength(), "9'10\"");
		assertEquals(actualWeapon.getState(), "Normal");
		assertEquals(actualWeapon.getAttributeSlots().size(), 0);
		assertNull(actualWeapon.getAffinity());

	}

	@Test
	void testCharacterValues_ByNameMatchesExpectedAttributeSlotsWithMapping() {
		String expectedName = "Zhao Yun";
		MapDependencyManager.getInstance();
		Optional<CharacterInterface<Character>> opt = DW8Structures.getOfficers().stream()
				.filter(e -> e.getName().equalsIgnoreCase(expectedName)).findFirst();

		assertTrue(opt.isPresent());

		CharacterInterface<Character> actual = opt.get();
		assertEquals(actual.getName(), expectedName);

		List<WeaponInterface<Weapon>> actualWeapons = actual.getWeapons();
		assertEquals(actualWeapons.size(), 10);

		WeaponInterface<Weapon> actualWeapon = actualWeapons.get(actualWeapons.size() - 1);
		assertNotNull(actualWeapon);
		assertEquals(actualWeapon.getName(), "Dark Dragon Spear");
		assertEquals(actualWeapon.getPower(), 62);
		assertEquals(actualWeapon.getStar(), 6);
		assertEquals(actualWeapon.getType(), Types.DRAGON_SPEAR);
		assertEquals(actualWeapon.getRarity(), Rarity.EXTREME);
		assertEquals(actualWeapon.getCategory(), Category.DIVER);
		assertEquals(actualWeapon.getImage(),
				"src/main/resources/Weapon-Pictures/6-Star/shu/Dark_Dragon_Spear-6-Yun.png");
		assertEquals(actualWeapon.getLength(), "");
		assertEquals(actualWeapon.getState(), "Extreme");
		assertEquals(actualWeapon.getAffinity(), Affinity.HEAVEN);

		List<AttributeSlot> slots = actualWeapon.getAttributeSlots();
		assertEquals(slots.size(), 5);

		AttributeSlot slot = slots.get(0);
		assertTrue(slot instanceof PowerAttribute);
		assertEquals(slot.getLevel(), 10);
		assertEquals(slot.getName(), "Venom");
		assertEquals(slot.getState(), "Normal");

		AttributeSlot slot2 = slots.get(1);
		assertTrue(slot2 instanceof PowerlessAttribute);
		assertEquals(slot2.getLevel(), 0);
		assertEquals(slot2.getName(), "Swiftness");
		assertEquals(slot2.getState(), "Special");
	}

}
