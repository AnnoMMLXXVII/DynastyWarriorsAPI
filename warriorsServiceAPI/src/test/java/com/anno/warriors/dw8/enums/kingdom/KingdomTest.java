package com.anno.warriors.dw8.enums.kingdom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KingdomTest {

	private Kingdom expected;

	@BeforeEach
	void setUp() throws Exception {
		expected = Kingdom.SHU;
	}
	
	@Test
	void testKingdomEnumStateNameMatchesExpected() {
		assertEquals("Kingdom", expected.getState());
	}

	@Test
	void testKingdomSizeIsFive() {
		Kingdom[] kingdoms = Kingdom.values();
		assertEquals(5, kingdoms.length);
	}

	@Test
	void testKingdomMatchesExpected_SHU() {
		assertEquals(Kingdom.returnCorrectEnum("Shu"), expected);
	}

	@Test
	void testKingdomMatchesExpected_WU() {
		expected = Kingdom.WU;
		assertEquals(Kingdom.returnCorrectEnum("Wu"), expected);
	}

	@Test
	void testKingdomMatchesExpected_WEI() {
		expected = Kingdom.WEI;
		assertEquals(Kingdom.returnCorrectEnum("Wei"), expected);
	}

	@Test
	void testKingdomMatchesExpected_JIN() {
		expected = Kingdom.JIN;
		assertEquals(Kingdom.returnCorrectEnum("Jin"), expected);
	}

	@Test
	void testKingdomMatchesExpected_OTHER() {
		expected = Kingdom.OTHER;
		assertEquals(Kingdom.returnCorrectEnum("Other"), expected);
	}

	@Test
	void testKingdomDoesNOTMatchesExpected() {
		expected = Kingdom.WU;
		assertNotEquals(Kingdom.returnCorrectEnum("shu"), expected);
	}

	@Test
	void testKingdomGetValueMatchesExpected_SHU() {
		expected = Kingdom.SHU;
		assertEquals("Shu", expected.getValue());
	}

	@Test
	void testKingdomGetValueMatchesExpected_WU() {
		expected = Kingdom.WU;
		assertEquals("Wu", expected.getValue());
	}

	@Test
	void testKingdomGetValueMatchesExpected_WEI() {
		expected = Kingdom.WEI;
		assertEquals("Wei", expected.getValue());
	}

	@Test
	void testKingdomGetValueMatchesExpected_JIN() {
		expected = Kingdom.JIN;
		assertEquals("Jin", expected.getValue());
	}

	@Test
	void testKingdomGetValueMatchesExpected_OTHER() {
		expected = Kingdom.OTHER;
		assertEquals("Other", expected.getValue());
	}

	@Test
	void testKingdomGetValueDoesNOTMatchExpected() {
		expected = Kingdom.OTHER;
		assertNotEquals("other", expected.getValue());
	}
}
