package com.anno.warriors.dw8.manager;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.anno.warriors.dw8.manager.images.ParsingImages;

class DW8StructuresTest {

	@Autowired
	private DynastyWarriors8Object<DW8Structures> instance;

	@BeforeEach
	void setUp() throws Exception {
		instance = DW8Structures.getInstance();
	}

	@Test
	void testThatInstanceIsNotNull() {
		assertNotNull(instance);
	}

	@Test
	void testThatInstanceTypeIsEqual() {
		assertTrue(instance.getManagerType() instanceof DW8Structures);
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
