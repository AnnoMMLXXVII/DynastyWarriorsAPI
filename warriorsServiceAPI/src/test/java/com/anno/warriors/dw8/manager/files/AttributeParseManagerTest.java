package com.anno.warriors.dw8.manager.files;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.anno.warriors.dw8.manager.DynastyWarriors8Object;

class AttributeParseManagerTest {

	@Autowired
	private DynastyWarriors8Object<AttributeParseManager> instance;
	
	@BeforeEach
	void setUp() throws Exception {
		instance = AttributeParseManager.getInstance();
	}

	@Test
	void testMetaTypeMatches() {
		assertTrue(instance.getManagerType() instanceof DynastyWarriors8Object<?>);
	}

}
