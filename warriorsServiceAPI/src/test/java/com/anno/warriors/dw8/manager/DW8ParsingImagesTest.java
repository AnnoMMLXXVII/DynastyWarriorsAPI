package com.anno.warriors.dw8.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;
import com.anno.warriors.dw8.manager.images.ParsingImages;

@TestInstance(Lifecycle.PER_CLASS)
class DW8ParsingImagesTest {

//	@Autowired
	private DynastyWarriors8Object<ParsingImages> instance;

	@BeforeAll
	void beforeAll() throws Exception {
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
	void testThatWeaponImageIsNotEmpty() {
		assertTrue(!ParsingImages.getWeaponImages().isEmpty());
	}

	@Test
	void testThatOfficerImageSizeEqualsExpected() {
		Map<String, List<DynastyWarriors8Image>> expected = ParsingImages.getOfficerImages();
//		Map<String, List<String>> actual = DW8Structures.getOfficerImages();
		assertEquals(65, expected.size());
	}

	@Test
	void testThatWeaponImageSizeEqualsExpected() {
		Map<Types, List<DynastyWarriors8Image>> expected = ParsingImages.getWeaponImages();
//		Map<OfficerKingdomKey, List<String>> actual = DW8Structures.getWeaponImages();
		assertEquals(92, expected.size());
	}

	@Test
	void testThatOfficerWeaponMapIsNotEmpty() {
		assertTrue(!ParsingImages.getWeaponNamePathMap().isEmpty());
	}

}
