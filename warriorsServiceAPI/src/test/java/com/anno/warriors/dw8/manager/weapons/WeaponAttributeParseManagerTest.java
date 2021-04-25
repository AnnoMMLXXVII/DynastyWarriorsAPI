package com.anno.warriors.dw8.manager.weapons;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.keys.WeaponName_TypesAttributesKey;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.weapons.slots.AttributeSlot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(Lifecycle.PER_CLASS)
class WeaponAttributeParseManagerTest {

	private DynastyWarriors8Object<WeaponAttributeParseManager> instance;
	Map<WeaponName_TypesAttributesKey, List<AttributeSlot>> weapNameTypesKeyAttributesMap;
	private WeaponName_TypesAttributesKey expectedKey = new WeaponName_TypesAttributesKey("Dark Dragon Spear",
			Types.DRAGON_SPEAR);
	private List<AttributeSlot> slots;

	@BeforeAll
	void setupBeforeAll() throws Exception {
		instance = new WeaponAttributeParseManager();
//		WeaponAttributeParseManager.readWeaponAttributesFile(DW8StaticObjects.getDiverWeaponsFiles()[0]);	// reads file twice
		weapNameTypesKeyAttributesMap = WeaponAttributeParseManager.getWeapNameTypesKeyAttributesMap();
	}

	@BeforeEach
	void setUp() throws Exception {
		slots = new ArrayList<>();
	}

	@Test
	void testInstanceStateIsExpected() {
		assertEquals("WeaponAttributeParseManager", instance.getState());
	}

	@Test
	void testWeapNameTypesMapIsNotEmpty() {
		assertFalse(weapNameTypesKeyAttributesMap.isEmpty());
	}

	@Test
	void testWeapNameTypesMapKeyGetValueSizeIsLessThanMax() {
		slots = weapNameTypesKeyAttributesMap.get(expectedKey);
		assertEquals(5, slots.size());
	}

	@Test
	void testFileNotFoundException() {
		Exception e = assertThrows(FileNotFoundException.class, () -> {
			WeaponAttributeParseManager.readWeaponAttributesFile("");
		});
		assertEquals("File Not Found!", e.getMessage());
	}

//	@Test
//	void testWeapNameTypesMapKeyGetValueContainsExpectedWeaponName() {
//		slots = weapNameTypesKeyAttributesMap.get(expectedKey);
//
//		WarriorSorter<AttributeSlot> sorter = new WarriorSorter(slots);
//		WarriorSearcher<AttributeSlot> searcher = new WarriorSearcher(sorter.getSortedList());
//
//		AttributeSlot searched;
//		for (AttributeSlot e : sorter.getSortedList()) {
//			searched = searcher.search(e);
//			assertEquals(e.getName(), searched.getName());
//			assertEquals(e.getLevel(), searched.getLevel());
//		}
//	}

}
