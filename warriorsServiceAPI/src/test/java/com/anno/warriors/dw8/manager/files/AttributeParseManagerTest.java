package com.anno.warriors.dw8.manager.files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.anno.warriors.dw8.enums.attribute.AttributeInterface;
import com.anno.warriors.dw8.enums.attribute.NormalAttributes;
import com.anno.warriors.dw8.enums.attribute.SpecialAttributes;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;

class AttributeParseManagerTest {

	@Autowired
	private DynastyWarriors8Object<AttributeParseManager> instance;
	private List<AttributeInterface> list;
	private Map<String, List<AttributeInterface>> mapped;
	private AttributeInterface normal = NormalAttributes.THORNS;
	private AttributeInterface special = SpecialAttributes.RIGIDITY;

	@BeforeEach
	void setUp() throws Exception {
		instance = AttributeParseManager.getInstance();
	}

	@Test
	void testMetaTypeMatches() {
		assertTrue(instance.getObjectType() instanceof DynastyWarriors8Object<?>);
	}

	@Test
	void testAttributesListIsNotEmpty() {
		list = AttributeParseManager.getAttributes();
		assertTrue(!list.isEmpty());
	}

	@Test
	void testAttributesListContainsExpected() {
		list = AttributeParseManager.getAttributes();
		assertTrue(list.contains(normal));
		assertTrue(list.contains(special));
	}

	@Test
	void testNormalAttributesListIsNotEmpty() {
		list = AttributeParseManager.getNormalAttributes();
		assertTrue(!list.isEmpty());
	}

	@Test
	void testNormalAttributesListContainsExpected() {
		list = AttributeParseManager.getNormalAttributes();
		assertTrue(list.contains(normal));
	}

	@Test
	void testNormalAttributesListDoesNOTContainExpected() {
		list = AttributeParseManager.getNormalAttributes();
		assertFalse(list.contains(special));
	}

	@Test
	void testSpecialAttributesListIsNotEmpty() {
		list = AttributeParseManager.getSpecialAttributes();
		assertTrue(!list.isEmpty());
	}

	@Test
	void testSpecialAttributesListContainsExpected() {
		list = AttributeParseManager.getSpecialAttributes();
		assertTrue(list.contains(special));
	}

	@Test
	void testSpecialAttributesListDoesNOTContainExpected() {
		list = AttributeParseManager.getSpecialAttributes();
		assertFalse(list.contains(normal));
	}

	@Test
	void testMappedAttributesContainsExpected_Normal() {
		mapped = AttributeParseManager.getMappedListAttributes();
		Optional<AttributeInterface> opt = mapped.get("Normal").stream()
				.filter(e -> e.getName().equalsIgnoreCase(normal.getName())).findAny();
		AttributeInterface actual = null;
		if (opt.isPresent()) {
			actual = opt.get();
		}
		assertEquals(actual, normal);
	}

	@Test
	void testMappedAttributesContainsExpected_Special() {
		mapped = AttributeParseManager.getMappedListAttributes();
		Optional<AttributeInterface> opt = mapped.get("Special").stream()
				.filter(e -> e.getName().equalsIgnoreCase(special.getName())).findAny();
		AttributeInterface actual = null;
		if (opt.isPresent()) {
			actual = opt.get();
		}
		assertEquals(actual, special);
	}

	@Test
	void testMappedAttributesDoesNotContainsExpected_GetNormal_SearchSpecial() {
		mapped = AttributeParseManager.getMappedListAttributes();
		Optional<AttributeInterface> opt = mapped.get("Normal").stream()
				.filter(e -> e.getName().equalsIgnoreCase(special.getName())).findAny();
		assertFalse(opt.isPresent());
	}

	@Test
	void testMappedAttributesDoesNotContainsExpected_GetSpecial_SearchNormal() {
		mapped = AttributeParseManager.getMappedListAttributes();
		Optional<AttributeInterface> opt = mapped.get("Special").stream()
				.filter(e -> e.getName().equalsIgnoreCase(normal.getName())).findAny();
		assertFalse(opt.isPresent());
	}
}
