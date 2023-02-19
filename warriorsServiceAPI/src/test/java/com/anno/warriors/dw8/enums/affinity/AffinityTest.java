package com.anno.warriors.dw8.enums.affinity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.assertj.core.api.Assertions.assertThat;

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
		assertThat("Affinity").as("Enum State is not Affinity").isEqualTo(expected.getState());
	}

	@Test
	void testAffinitySizeIsThree() {
		Affinity[] affinities = Affinity.values();
		assertThat(affinities.length).as("Affinity Count is not 3").isEqualTo(3);
	}

	@Test
	void testAffinityMatchesExpected_HEAVEN() {
		assertThat(Affinity.returnCorrectEnum("Heaven")).as("Affinity Heaven did not return").isEqualTo(expected);
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
