package com.anno.warriors.dw8.manager.files;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(Lifecycle.PER_CLASS)
class TypeParseManagerTest {

	@Autowired
	private DynastyWarriors8Object<TypeParseManager> instance;
	private Types expected;
	private Category testCategory;
	private List<Types> types;
	private Map<Category, List<Types>> map;

//	@BeforeAll
	void setUp() throws Exception {
		instance = TypeParseManager.getInstance();

	}

@Test
	void testInstanceIsNotNull() {
		assertNotNull(instance);
	}

@Test
	void testThatInstanceTypeIsTrue() {
		assertEquals(instance.getState(), "TypeParseManager");
	}

@Test
	void testTypesListIsNotEmpty() {
		types = TypeParseManager.getTypes();
		assertFalse(types.isEmpty());
	}

@Test
	void testTypesListContainsExpected() {
		expected = Types.TRISHULA;
//		System.out.println(expected.toString());s
		types = TypeParseManager.getTypes();
		Optional<Types> opt = types.stream().filter(e -> e.getValue().equals(expected.getValue())).findFirst();
		Types actual = null;
		if (opt.isPresent()) {
			actual = opt.get();
		}
		assertEquals(actual, expected);
	}

@Test
	void testTypesListDoesNotContainsExpected() {
		types = TypeParseManager.getTypes();
		Optional<Types> opt = types.stream().filter(e -> e.name().equals("NOTHING")).findFirst();
		assertEquals(opt, Optional.empty());
	}

@Test
	void testMapCategory_Whirlwind_containsExpected() {
		expected = Types.MACE;
		testCategory = Category.returnCorrectEnum("Whirl Wind");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertTrue(types.contains(expected));
	}

@Test
	void testMapCategory_Whirlwind_DoesNotContainsExpected() {
		expected = Types.TRISHULA;
		testCategory = Category.returnCorrectEnum("Whirl Wind");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertFalse(types.contains(expected));
	}

@Test
	void testMapCategory_Dasher_containsExpected() {
		expected = Types.TRISHULA;
		testCategory = Category.returnCorrectEnum("Dasher");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertTrue(types.contains(expected));
	}

@Test
	void testMapCategory_Dasher_DoesNotContainsExpected() {
		expected = Types.GENERALS_SWORD;
		testCategory = Category.returnCorrectEnum("Dasher");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertFalse(types.contains(expected));
	}

@Test
	void testMapCategory_Diver_containsExpected() {
		expected = Types.DRAGON_SPEAR;
		testCategory = Category.returnCorrectEnum("Diver");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertTrue(types.contains(expected));
	}

@Test
	void testMapCategory_Diver_DoesNotContainsExpected() {
		expected = Types.TRISHULA;
		testCategory = Category.returnCorrectEnum("Diver");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertFalse(types.contains(expected));
	}

	@Test
	void testMapCategory_ShadowSprinter_containsExpected() {
		expected = Types.FLAIL;
		testCategory = Category.returnCorrectEnum("Shadow Sprinter");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertTrue(types.contains(expected));
	}

@Test
	void testMapCategory_ShadowSprinter_DoesNotContainsExpected() {
		expected = Types.TRISHULA;
		testCategory = Category.returnCorrectEnum("Shadow Sprinter");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertFalse(types.contains(expected));
	}

@Test
	void testMapCategory_Diver_TypesListNotNull() {
		testCategory = Category.returnCorrectEnum("Diver");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertNotNull(types.stream().map(e -> e != null));
	}

@Test
	void testMapCategory_Dasher_TypesListNotNull() {
		testCategory = Category.returnCorrectEnum("Dasher");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertNotNull(types.stream().map(e -> e != null));
	}

@Test
	void testMapCategory_Shadow_TypesListNotNull() {
		testCategory = Category.returnCorrectEnum("Shadow Sprinter");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertNotNull(types.stream().map(e -> e != null));
	}

@Test
	void testMapCategory_WhirlWind_TypesListNotNull() {
		testCategory = Category.returnCorrectEnum("Whirl Wind");
		map = TypeParseManager.getMappedTypes();
		types = map.get(testCategory);
		assertNotNull(types.stream().map(e -> e != null));
	}

}
