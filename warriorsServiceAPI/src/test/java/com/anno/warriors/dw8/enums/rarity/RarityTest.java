package com.anno.warriors.dw8.enums.rarity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RarityTest {

	private Rarity expected;

	@BeforeEach
	void setUp() throws Exception {
		expected = Rarity.NORMAL;
	}

	@Test
	void testRarityEnumStateNameMatchesExpected() {
		assertEquals("Rarity", expected.getState());
	}

	@Test
	void testRaritySizeIsFive() {
		Rarity[] rarities = Rarity.values();
		assertEquals(5, rarities.length);
	}

	@Test
	void testRarityMatchesExpected_NORMAL() {
		assertEquals(Rarity.returnCorrectEnum("Normal"), expected);
	}

	@Test
	void testRarityMatchesExpected_RARE() {
		expected = Rarity.RARE;
		assertEquals(Rarity.returnCorrectEnum("Rare"), expected);
	}

	@Test
	void testRarityMatchesExpected_UNIQUE() {
		expected = Rarity.UNIQUE;
		assertEquals(Rarity.returnCorrectEnum("Unique"), expected);
	}

	@Test
	void testRarityMatchesExpected_XTREME() {
		expected = Rarity.EXTREME;
		assertEquals(Rarity.returnCorrectEnum("Xtreme"), expected);
	}

	@Test
	void testRarityMatchesExpected_SPECIAL() {
		expected = Rarity.SPECIAL;
		assertEquals(Rarity.returnCorrectEnum("Special"), expected);
	}

	@Test
	void testRarityDoesNOTMatchesExpected() {
		assertNotEquals(Rarity.returnCorrectEnum("Xtreme"), expected);
	}

	@Test
	void testRarityGetValueMatchesExpected_Normal() {
		expected = Rarity.NORMAL;
		assertEquals("Normal", expected.getValue());
	}

	@Test
	void testRarityGetValueMatchesExpected_Rare() {
		expected = Rarity.RARE;
		assertEquals("Rare", expected.getValue());
	}

	@Test
	void testRarityGetValueMatchesExpected_Unique() {
		expected = Rarity.UNIQUE;
		assertEquals("Unique", expected.getValue());
	}

	@Test
	void testRarityGetValueMatchesExpected_Xtreme() {
		expected = Rarity.EXTREME;
		assertEquals("Xtreme", expected.getValue());
	}

	@Test
	void testRarityGetValueMatchesExpected_Special() {
		expected = Rarity.SPECIAL;
		assertEquals("Special", expected.getValue());
	}

	@Test
	void testRarityGetValueDoesNOTMatchesExpected() {
		expected = Rarity.NORMAL;
		assertNotEquals("normal", expected.getValue());
	}

}
