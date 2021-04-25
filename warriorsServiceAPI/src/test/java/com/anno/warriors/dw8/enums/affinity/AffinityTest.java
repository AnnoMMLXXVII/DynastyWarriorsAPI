package com.anno.warriors.dw8.enums.affinity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AffinityTest {

	private Affinity expected;

	@BeforeEach
	void setUp() throws Exception {
		expected = Affinity.HEAVEN;
	}
	
	@Test
	void testAffinityEnumStateNameMatchesExpected() {
		assertEquals("Affinity", expected.getState());
	}

	@Test
	void testAffinitySizeIsThree() {
		Affinity[] affinities = Affinity.values();
		assertEquals(3, affinities.length);
	}

	@Test
	void testAffinityMatchesExpected_HEAVEN() {
		assertEquals(Affinity.returnCorrectEnum("Heaven"), expected);
	}

	@Test
	void testAffinityMatchesExpected_EARTH() {
		expected = Affinity.EARTH;
		assertEquals(Affinity.returnCorrectEnum("Earth"), expected);
	}

	@Test
	void testAffinityMatchesExpected_MAN() {
		expected = Affinity.MAN;
		assertEquals(Affinity.returnCorrectEnum("Man"), expected);
	}

	@Test
	void testAffinityDoesNotMatchesExpected() {
		assertNotEquals(Affinity.returnCorrectEnum("NOTHING"), expected);
	}

	@Test
	void testAffinityGetValueMatchesExpectedString_HEAVEN() {
		assertEquals("Heaven", expected.getValue());
	}

	@Test
	void testAffinityGetValueMatchesExpectedString_EARTH() {
		assertEquals("Earth", Affinity.EARTH.getValue());
	}

	@Test
	void testAffinityGetValueMatchesExpectedString_MAN() {
		assertEquals("Man", Affinity.MAN.getValue());
	}

	@Test
	void testAffinityGetValueDoesNOTMatchesExpectedString() {
		assertNotEquals("man", Affinity.MAN.getValue());
	}

}
