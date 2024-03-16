package com.anno.warriors.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.dw8.manager.files.CharacterParseManager;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestInstance(Lifecycle.PER_CLASS)
@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
class WarriorSearcherTest {

	@Autowired
	private WarriorSearcher<Integer> searcher;
	private WarriorSearcher<Character> characterSearcher;
	private WarriorSearcher<Weapon> weaponSearcher;
	private WarriorSorter<Integer> sorter;
	private WarriorSorter<Character> characterSorter;
	private WarriorSorter<Weapon> weaponSorter;
	private List<?> sorted;

	private Random r = new Random();
	private List<Integer> list = new ArrayList<>();
	private List<CharacterInterface<Character>> characters = null;
	private List<WeaponInterface<Weapon>> weapons = null;
	private int testNumber = -1;
	private String searchedKey = "";
	private Integer searchIntegerKey = -1;
	private CharacterInterface<Character> searchCharacterKey = null;
	private WeaponInterface<Weapon> searchWeaponKey = null;
//	private long start, end;

	@BeforeAll
	void beforeAll() throws Exception {
		CharacterParseManager.getInstance();
		characters = DW8Structures.getCharacters();
		weapons = DW8Structures.getWeapons();
	}

	@BeforeEach
	void setUp() throws Exception {
		DW8Structures.getInstance();
		generateRandomNumber();
//		start = System.nanoTime();
//		end = System.nanoTime();
	}

	@AfterEach
	void breakDown() throws Exception {
//		System.out.printf("Test[%d] Searched (%s) Time: %s ms\n", testNumber, searchedKey, ((end - start) * 10E-3));
		testNumber = -1;
	}

	@Test
	void testIfSearchValueReturnsIndex() {
		testNumber = 1;
		sorter = new WarriorSorter<Integer>(list);
		Integer index = getRandomIndex(list.size() - 1);
		searchIntegerKey = list.get(index);

		sorted = sorter.getSortedList();
		searcher = new WarriorSearcher<Integer>((List<Integer>) sorted);

		Integer searched = searcher.search(searchIntegerKey);
		searchedKey = searchIntegerKey.toString();

		assertEquals(searchIntegerKey, searched);
	}

	@Test
	void testIfSearchCharacterObjectsReturnsExpected() {
		testNumber = 2;

		Integer index = getRandomIndex(characters.size() - 1);
		searchCharacterKey = characters.get(index);

		characterSorter = new WarriorSorter(characters);
		characterSearcher = new WarriorSearcher(characterSorter.getSortedList());

		List<Character> searched = characterSearcher.search(searchCharacterKey.getName());
		searchedKey = String.format("%s, %s, %s", searchCharacterKey.getName(), searchCharacterKey.getKingdom(),
				searchCharacterKey.getWeaponType());

		assertEquals(searchCharacterKey.getName(), searched.get(0).getName());
	}

////	@Test
//	void testIfSearchWeaponObjectsReturnsExpected() {
//		testNumber = 3;
//
//		Integer index = getRandomIndex(weapons.size() - 1);
//		searchWeaponKey = weapons.get(index);
//
//		weaponSorter = new WarriorSorter(weapons);
//		weaponSearcher = new WarriorSearcher(weaponSorter.getSortedList());
//
//		List<Weapon> searched = weaponSearcher.search(searchWeaponKey.getName());
//		searchedKey = String.format("%s, %s, %s", searchWeaponKey.getName(), searchWeaponKey.getCategory(),
//				searchWeaponKey.getType());
//
//		assertEquals(searchWeaponKey.getName(), searched.get(0).getName());
//	}
//
////	@Test
//	void testIfSearchWeaponObjectOfOffierTypeReturnsExpected() {
//		testNumber = 4;
////		DW8Manager.getInstance();
////		DW8Manager.invokeMapingOfObjects();
//		characters = DW8Structures.getOfficers();
//		Integer index = getRandomIndex(characters.size() - 1);
//		searchCharacterKey = characters.get(index);
//		index = getRandomIndex(searchCharacterKey.getWeapons().size() - 1);
//		System.out.printf("%s weapon index --> %d\n", searchCharacterKey.getName(), index);
//		searchWeaponKey = searchCharacterKey.getWeapons().get(index);
//
//		weaponSorter = new WarriorSorter(weapons);
//		weaponSearcher = new WarriorSearcher(weaponSorter.getSortedList());
//
//		List<Weapon> searched = weaponSearcher.search(searchWeaponKey.getName());
//		searchedKey = String.format("%s, %s, %s > %s", searchWeaponKey.getName(), searchWeaponKey.getCategory(),
//				searchWeaponKey.getType(), searchCharacterKey.getName());
//
//		assertEquals(searchWeaponKey.getName(), searched.get(0).getName());
//	}
//
////	@Test
//	void testIfSearchWeaponObjectOfOffierTypeReturnsNegativeOne() {
//		testNumber = 5;
////		DW8Manager.getInstance();
////		DW8Manager.invokeMapingOfObjects();
//		characters = DW8Structures.getOfficers();
//
//		Integer index = getRandomIndex(characters.size() - 1);
//		searchCharacterKey = characters.get(index);
//		List<WeaponInterface<Weapon>> charWeapon = searchCharacterKey.getWeapons();
//		assertFalse(charWeapon.isEmpty());
//		searchWeaponKey = searchCharacterKey.getWeapons().get(getRandomIndex(charWeapon.size() - 1));
//
//		weaponSorter = new WarriorSorter(weapons);
//		weaponSearcher = new WarriorSearcher(weaponSorter.getSortedList());
//
//		List<Weapon> searched = weaponSearcher.search("NOTHING");
////		assertTrue(charWeapon.isEmpty());
//		assertTrue(searched.isEmpty());
//	}

	@Test
	void testIfSearchValueReturnsNegativeIndex() {
		testNumber = 6;
		sorter = new WarriorSorter<Integer>(list);
		Integer index = getRandomIndex(list.size() - 1);
		searchIntegerKey = list.get(index);

		sorted = sorter.getSortedList();
		searcher = new WarriorSearcher<Integer>((List<Integer>) sorted);

		Integer searched = searcher.search(-1);
		searchedKey = searchIntegerKey.toString();

		assertNotEquals(searchIntegerKey, searched);
	}

	@Test
	void testIfSortedDescThenSearchValueReturnsNegativeIndex() {
		testNumber = 6;
		sorter = new WarriorSorter<Integer>(list, false);
		Integer index = getRandomIndex(list.size() - 1);
		searchIntegerKey = list.get(index);

		sorted = sorter.getSortedList();
		searcher = new WarriorSearcher<Integer>((List<Integer>) sorted);

		Integer searched = searcher.search(-1);
		searchedKey = searchIntegerKey.toString();

		assertNotEquals(searchIntegerKey, searched);
	}

	private void generateRandomNumber() {
		int rand = Math.abs(r.nextInt(1000));
		for (int i = 0; i < 10; i++) {
			list.add(i, rand);
			rand = Math.abs(r.nextInt(1000));
		}
	}

	private int getRandomIndex(int N) {
		int temp = r.nextInt(N);
		return (temp < 0) ? r.nextInt(N) + 1 : temp;
	}

}
