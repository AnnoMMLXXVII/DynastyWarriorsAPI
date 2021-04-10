package com.anno.warriors.dw8.enums.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

	private Category expected;

	@BeforeEach
	void setUp() throws Exception {
		expected = Category.DASHER;
	}

	@Test
	void testCategorySizeIsFour() {
		Category[] categories = Category.values();
		assertEquals(4, categories.length);
	}

	@Test
	void testCategoryMatchesExpected_DASHER() {
		assertEquals(Category.returnCorrectEnum("Dasher"), expected);
	}

	@Test
	void testCategoryMatchesExpected_DIVER() {
		expected = Category.DIVER;
		assertEquals(Category.returnCorrectEnum("Diver"), expected);
	}

	@Test
	void testCategoryMatchesExpected_SHADOW() {
		expected = Category.SHADOW_SPRINTER;
		assertEquals(Category.returnCorrectEnum("Shadow Sprinter"), expected);
	}

	@Test
	void testCategoryMatchesExpected_Whirlwind() {
		expected = Category.WHIRLD_WIND;
		assertEquals(Category.returnCorrectEnum("Whirl Wind"), expected);
	}

	@Test
	void testCategoryDoesNotMatchesExpected() {
		assertNotEquals(Category.returnCorrectEnum("diver"), expected);
	}

	@Test
	void testCategoryGetValueMatchesExpected_Dasher() {
		assertEquals("Dasher", expected.getValue());
	}

	@Test
	void testCategoryGetValueMatchesExpected_Diver() {
		expected = Category.DIVER;
		assertEquals("Diver", expected.getValue());
	}

	@Test
	void testCategoryGetValueMatchesExpected_Shadow() {
		expected = Category.SHADOW_SPRINTER;
		assertEquals("Shadow Sprinter", expected.getValue());
	}

	@Test
	void testCategoryGetValueMatchesExpected_WhirlWind() {
		expected = Category.WHIRLD_WIND;
		assertEquals("Whirl Wind", expected.getValue());
	}

	@Test
	void testCategoryGetValueDoesNOTMatchesExpected() {
		expected = Category.WHIRLD_WIND;
		assertNotEquals("Whirl wind", expected.getValue());
	}

}
