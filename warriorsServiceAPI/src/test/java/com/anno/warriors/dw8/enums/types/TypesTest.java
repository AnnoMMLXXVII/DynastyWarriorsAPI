package com.anno.warriors.dw8.enums.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TypesTest {

	private Types expected;

	@BeforeEach
	void setUp() throws Exception {
		expected = Types.DRAGON_SPEAR;
	}

	@Test
	void testTypesEnumStateNameMatchesExpected() {
		assertEquals("Types", expected.getState());
	}

	@Test
	void testTypesSizeIsExpected() {
		Types[] types = Types.values();
		assertEquals(95, types.length);
	}

	@Test
	void testTypesMatchesExpected_Dragon_Spear() {
		assertEquals(Types.returnCorrectEnum("Dragon Spear"), expected);
	}

	@Test
	void testTypesDoesNotMatchesExpected() {
		assertNotEquals(Types.returnCorrectEnum("Sword and Shield"), expected);
	}

	@Test
	void testTypesIsReturnedAsNull() {
		assertNull(Types.returnCorrectEnum(null));
	}

	@Test
	void testTypesIsReturnedAsNullWhenEmptyString() {
		assertNull(Types.returnCorrectEnum(""));
	}

}
