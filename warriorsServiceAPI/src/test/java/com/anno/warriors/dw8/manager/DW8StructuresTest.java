package com.anno.warriors.dw8.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import com.anno.warriors.dw8.manager.images.ParsingImages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(Lifecycle.PER_CLASS)
class DW8StructuresTest {

	@Autowired
	private DynastyWarriors8Object<DW8Structures> instance;

	@BeforeAll
	void setUp() throws Exception {
		instance = DW8Structures.getInstance();
	}

	@Test
	void testThatInstanceIsNotNull() {
		assertNotNull(instance);
	}

	@Test
	void testThatInstanceTypeIsEqual() {
		assertEquals(instance.getState(), "DW8Structures");
	}

	@Test
	void testThatAttributePathIsNotEmpty() {
		assertTrue(!DW8Structures.getAttributePath().isEmpty());
	}

	@Test
	void testThatOfficerPathIsNotEmpty() {
		assertTrue(!DW8Structures.getOfficerPath().isEmpty());
	}

	@Test
	void testThatSubOfficerPathIsNotEmpty() {
		assertTrue(!DW8Structures.getSubOfficerPath().isEmpty());
	}

	@Test
	void testThatDasherPathIsNotEmpty() {
		assertTrue(!DW8Structures.getDasherPath().isEmpty());
	}

	@Test
	void testThatDiverPathIsNotEmpty() {
		assertTrue(!DW8Structures.getDiverPath().isEmpty());
	}

	@Test
	void testThatShadowPathIsNotEmpty() {
		assertTrue(!DW8Structures.getShadowPath().isEmpty());
	}

	@Test
	void testThatWhirlWindPathIsNotEmpty() {
		assertTrue(!DW8Structures.getWhirlwindPath().isEmpty());
	}

	@Test
	void testThatOfficerImagesPathIsNotEmpty() {
		ParsingImages.getInstance();
		assertTrue(!DW8Structures.getOfficerImages().isEmpty());
	}

	@Test
	void testThatWeaponImagesPathIsNotEmpty() {
		ParsingImages.getInstance();
		assertTrue(!DW8Structures.getWeaponImages().isEmpty());
	}

	@Test
	void testThatAllPathsIsNotEmpty() {
		assertTrue(!DW8Structures.getAllPaths().isEmpty());
	}

}
