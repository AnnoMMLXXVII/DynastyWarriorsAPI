package com.anno.warriors.dw8.enums.types;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anno.warriors.dw8.shared.DW8Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

	@Test
	void validateAllTypesMatchFile() {
		File file = new File(DW8Constants.TYPE_FILE);
		try (Scanner z = new Scanner(new FileReader(file))) {
			while (z.hasNextLine()) {
				String line = z.nextLine();
				String[] lineArr = line.split(",");
				System.out.printf("%s(\"%s\"),\n", Types.returnCorrectEnum(lineArr[1].trim()), lineArr[1].trim());
				assertNotNull(Types.returnCorrectEnum(lineArr[1].trim()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
