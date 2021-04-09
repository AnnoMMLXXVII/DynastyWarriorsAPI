package com.anno.warriors.dw8.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.anno.warriors.dw8.keys.OfficerKingdomKey;

class DW8ParsingImagesTest {

	@Autowired
	private DynastyWarriors8Object<DW8ParsingImages> instance;

	@BeforeEach
	void setUp() throws Exception {
		instance = DW8ParsingImages.getInstance();
	}

	@Test
	void testThatInstanceIsNotNull() {
		assertNotNull(instance);
	}

	@Test
	void testThatInstanceTypeIsTrue() {
		assertTrue(instance.getManagerType() instanceof DW8ParsingImages);
	}

	@Test
	void testThatOfficerImageIsNotEmpty() {
		assertTrue(!DW8ParsingImages.getOfficerImages().isEmpty());
	}

	@Test
	void testThatWepaonImageIsNotEmpty() {
		assertTrue(!DW8ParsingImages.getWeaponImages().isEmpty());
	}

	@Test
	void testThatOfficerImageIsTheSameSizeAsDW8Structures() {
		DW8Structures.getInstance();
		Map<String, List<String>> expected = DW8ParsingImages.getOfficerImages();
		Map<String, List<String>> actual = DW8Structures.getOfficerImages();
		assertEquals(actual.size(), expected.size());
	}

	@Test
	void testThatWeaponImageIsTheSameSizeAsDW8Structures() {
		DW8Structures.getInstance();
		Map<OfficerKingdomKey, List<String>> expected = DW8ParsingImages.getWeaponImages();
		Map<OfficerKingdomKey, List<String>> actual = DW8Structures.getWeaponImages();
		assertEquals(actual.size(), expected.size());
	}

	@Test
	void testThatOfficerWeaponMapIsNotEmpty() {
		assertTrue(!DW8ParsingImages.getOfficerWeaponMap().isEmpty());
	}

}
