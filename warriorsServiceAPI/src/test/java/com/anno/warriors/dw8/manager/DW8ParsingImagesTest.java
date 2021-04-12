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
import com.anno.warriors.dw8.manager.images.ParsingImages;

class DW8ParsingImagesTest {

	@Autowired
	private DynastyWarriors8Object<ParsingImages> instance;

	@BeforeEach
	void setUp() throws Exception {
		instance = ParsingImages.getInstance();
	}

	@Test
	void testThatInstanceIsNotNull() {
		assertNotNull(instance);
	}

	@Test
	void testThatInstanceTypeIsTrue() {
		assertEquals(instance.getState(), ("ParsingImages"));
	}

	@Test
	void testThatOfficerImageIsNotEmpty() {
		assertTrue(!ParsingImages.getOfficerImages().isEmpty());
	}

	@Test
	void testThatWepaonImageIsNotEmpty() {
		assertTrue(!ParsingImages.getWeaponImages().isEmpty());
	}

	@Test
	void testThatOfficerImageIsTheSameSizeAsDW8Structures() {
		DW8Structures.getInstance();
		Map<String, List<String>> expected = ParsingImages.getOfficerImages();
		Map<String, List<String>> actual = DW8Structures.getOfficerImages();
		assertEquals(actual.size(), expected.size());
	}

	@Test
	void testThatWeaponImageIsTheSameSizeAsDW8Structures() {
		DW8Structures.getInstance();
		Map<OfficerKingdomKey, List<String>> expected = ParsingImages.getWeaponImages();
		Map<OfficerKingdomKey, List<String>> actual = DW8Structures.getWeaponImages();
		assertEquals(actual.size(), expected.size());
	}

	@Test
	void testThatOfficerWeaponMapIsNotEmpty() {
		assertTrue(!ParsingImages.getOfficerWeaponMap().isEmpty());
	}

}
