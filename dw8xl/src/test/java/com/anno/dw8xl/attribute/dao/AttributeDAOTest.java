package com.anno.dw8xl.attribute.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.Normal;
import com.anno.dw8xl.attribute.model.NullAttribute;
import com.anno.dw8xl.attribute.model.Special;

@TestInstance(Lifecycle.PER_CLASS)
class AttributeDAOTest {

	private AttributeDAOInterface dao;
	private AttributeI normal, special;
	private Collection<AttributeI> attributes;
//	private long before, after;

	@BeforeEach
	void setUp() throws Exception {
		dao = AttributeDAO.getInstance();		
		normal = new Normal("Velocity", "Raises overall attack speed");
		special = new Special("Awareness", "Can block attacks from the rear");
//		before = System.nanoTime();		
	}

	@AfterEach
	void breakDown() {
//		after = System.nanoTime();
//		System.out.printf("Time :\t%8dns\n", (after - before));
	}

	@DisplayName("Specials !Empty")
	@Test
	void testSpecialAttributesListIsNOTEmpty() {
		attributes = dao.executeGetSpecialAttributes();
		assertTrue(!attributes.isEmpty());
	}

	@DisplayName("Normals size is 37")
	@Test
	void testNormalAttributeListSizeIsEqualToExpected() {
		attributes = dao.executeGetNormalAttributes();
		assertEquals(37, attributes.size());
	}

	@DisplayName("Specials size is 13")
	@Test
	void testSpecialAttributeListSizeIsEqualToExpected() {
		attributes = dao.executeGetSpecialAttributes();
		assertEquals(13, attributes.size());
	}

	@DisplayName("All Attributes !Empty")
	@Test
	void testGetAllAttributes() {
		attributes = dao.getAll();
		assertEquals(50, attributes.size());
	}

	@DisplayName("Normals contains Velocity")
	@Test
	void testNormalAttributesListContainsExpected() {
		attributes = dao.getAll();
		assertTrue(attributes.contains(normal));
	}

	@DisplayName("Specials contains Awareness")
	@Test
	void testSpecialAttributesListContainsExpected() {
		attributes = dao.getAll();
		assertTrue(attributes.contains(special));
	}

	@DisplayName("Normals value [Inferno] is NORMAL Type")
	@Test
	void testNormalAttributeTypeIsNormal() {
		attributes = dao.getAll();
		AttributeI actual = attributes.stream().filter(e -> e.getName().equals("Inferno")).findAny().get();
		assertEquals("NORMAL", actual.getRarity().toString());
	}

	@DisplayName("Specials value [Fury] is SPECIAL Type")
	@Test
	void testSpecialAttributeTypeIsSpecial() {
		attributes = dao.getAll();
		AttributeI actual = attributes.stream().filter(e -> e.getName().equals("Fury")).findAny().get();
		assertEquals("SPECIAL", actual.getRarity().toString());
	}

	@DisplayName("Normal Velocity equals Expected")
	@Test
	void testgetAttriubteByNameNormal() {
		Optional<AttributeI> actual = dao.getBy("Velocity");
		assertEquals(normal, actual.get());
	}

	@DisplayName("Special Awareness equals Expected")
	@Test
	void testgetAttriubteByNameSpecial() {
		AttributeI actual = dao.executeGetAttributeByName("Awareness");
		assertThat(special).isEqualTo(actual);
	}

	@DisplayName("Normals remove Velocity")
	@Test
	void testRemoveNormalAttribute() {
		attributes = dao.executeGetNormalAttributes();
		List<AttributeI> expected = new ArrayList<>();
		expected.add(normal);
		dao.executeRemoveAttribute(expected);
		attributes = dao.executeGetNormalAttributes();
		assertFalse(attributes.contains(normal));
	}

	@DisplayName("Specials remove Awareness")
	@Test
	void testRemoveSpecialAttribute() {
		attributes = dao.executeGetSpecialAttributes();
		List<AttributeI> expected = new ArrayList<>();
		expected.add(special);
		dao.executeRemoveAttribute(expected);
		attributes = dao.executeGetSpecialAttributes();
		assertFalse(attributes.contains(special));
	}

	@DisplayName("Specials adds newly Created [Void]")
	@Test
	void testCreateSpecialAttribute_Pass() {
		attributes = dao.executeGetSpecialAttributes();
		AttributeI expected = new Special("Void", "Shall Nullify Enemy Officer's attack by 50%");
		dao.executeCreateAttribute(expected);
		attributes = dao.executeGetSpecialAttributes();
		assertEquals(14, attributes.size());
		assertTrue(attributes.contains(expected));
	}

	@DisplayName("Normals adds newly Created [Void]")
	@Test
	void testCreateNormalAttribute_Pass() {
		attributes = dao.executeGetNormalAttributes();
		AttributeI expected = new Normal("Void", "Shall Nullify Enemy Officer's attack by 50%");
		dao.executeCreateAttribute(expected);
		attributes = dao.executeGetNormalAttributes();
		assertEquals(38, attributes.size());
		assertTrue(attributes.contains(expected));
	}
	
	@DisplayName("Test Add Non-Existent Normal 'Object' and size increases by 1")
	@Test
	void testAddAndReturnsIncreasedMapSize_NORMAL() {
		attributes = dao.getAll();
		int size = attributes.size();
		AttributeI expected = new Normal("VOID", "VOIDS DECRIPTION");
		dao.add(expected);
		attributes = dao.getAll();;
		assertEquals(size+1, attributes.size());
	}
	
	@DisplayName("Test Add Non-Existent Special 'Object' and size increases by 1")
	@Test
	void testAddAndReturnsIncreasedMapSize_SPECIAL() {
		attributes = dao.getAll();
		int size = attributes.size();
		AttributeI expected = new Special("VOID", "VOIDS DECRIPTION");
		dao.add(expected);
		attributes = dao.getAll();;
		assertEquals(size+1, attributes.size());
	}
	
	@DisplayName("Test Add already-Existent Normal 'Object' and size increases by 0")
	@Test
	void testAddExpectedAndReturnsEqualMapSize_NORMAL() {
		attributes = dao.getAll();
		int size = attributes.size();
		dao.add(normal);
		attributes = dao.getAll();;
		assertEquals(size, attributes.size());
	}
	
	@DisplayName("Test Add already-Existent Special 'Object' and size increases by 0")
	@Test
	void testAddExpectedAndReturnsEqualMapSize_SPECIAL() {
		attributes = dao.getAll();
		int size = attributes.size();
		dao.add(special);
		attributes = dao.getAll();;
		assertEquals(size, attributes.size());
	}
	
	@DisplayName("Test Add NullAttribute 'Object' and size increases by 0")
	@Test
	void testAddNullAttributeAndReturnsEqualMapSize() {
		attributes = dao.getAll();
		int size = attributes.size();
		AttributeI expected = new NullAttribute();
		dao.add(expected);
		attributes = dao.getAll();;
		assertEquals(size, attributes.size());
	}
	
	@DisplayName("Test Add Empty String for Normal 'Object' and size increases by 0")
	@Test
	void testAddEmptStringAndReturnsEqualMapSize_NORMAL() {
		attributes = dao.getAll();
		int size = attributes.size();
		AttributeI expected = new Normal("", "");
		dao.add(expected);
		attributes = dao.getAll();;
		assertEquals(size, attributes.size());
	}
	
	@DisplayName("Test Add Empty String for Special 'Object' and size increases by 0")
	@Test
	void testAddWithEmptyStringAndReturnsEqualMapSize() {
		attributes = dao.getAll();
		int size = attributes.size();
		AttributeI expected = new Special("", "");
		dao.add(expected);
		attributes = dao.getAll();;
		assertEquals(size, attributes.size());
	}
	
	@DisplayName("Add Attribute with Null and returns size increases by 0 && Throws")
	@Test
	void testAddNullAndIncreaseSizeByZero() {
		attributes = dao.getAll();
		int size = attributes.size();
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(null);			
		});
		attributes = dao.getAll();
		assertEquals(size, attributes.size());
		assertEquals("Attribute cannot be added due to Null!", e.getMessage());
	}
	
	@DisplayName("Test Remove Normal 'Object' and size decrease by 1")
	@Test
	void testRemoveExpectedAndEqualsExpectedSize_Normal() {
		attributes = dao.getAll();
		int size = attributes.size();
		dao.remove(normal);
		attributes = dao.getAll();;
		assertEquals(size-1, attributes.size());
	}
	
	@DisplayName("Test Remove Special 'Object' and size decrease by 1")
	@Test
	void testRemoveExpectedAndEqualsExpectedSize_Special() {
		attributes = dao.getAll();
		int size = attributes.size();
		dao.remove(special);
		attributes = dao.getAll();;
		assertEquals(size-1, attributes.size());
	}
	
	@DisplayName("Test Remove Non-Existent Normal 'Object' and size decrease by 0")
	@Test
	void testRemoveDNEAndReturnsEqualMapSize_Normal() {
		attributes = dao.getAll();
		int size = attributes.size();
		AttributeI expected = new Normal("VOID", "VOID DESCRIPTION");
		dao.remove(expected);
		attributes = dao.getAll();;
		assertEquals(size, attributes.size());
	}
	
	@DisplayName("Test Remove Non-Existent Special 'Object' and size decrease by 0")
	@Test
	void testRemoveDNEAndReturnsEqualMapSize_Special() {
		attributes = dao.getAll();
		int size = attributes.size();
		AttributeI expected = new Special("VOID", "VOID DESCRIPTION");
		dao.remove(expected);
		attributes = dao.getAll();;
		assertEquals(size, attributes.size());
	}

	
	@DisplayName("Test Remove Empty String for Normal 'Object' and size decrease by 0")
	@Test
	void testRemoveWithEmptyStringAndReturnsEqualMapSize_Normal() {
		attributes = dao.getAll();
		int size = attributes.size();
		AttributeI expected = new Normal("", "");
		dao.remove(expected);
		attributes = dao.getAll();;
		assertEquals(size, attributes.size());
	}
	
	@DisplayName("Test Remove Empty String for Special 'Object' and size decrease by 0")
	@Test
	void testRemoveWithEmptyStringAndReturnsEqualMapSize_Special() {
		attributes = dao.getAll();
		int size = attributes.size();
		AttributeI expected = new Special("", "");
		dao.remove(expected);
		attributes = dao.getAll();;
		assertEquals(size, attributes.size());
	}
	
	@DisplayName("Test Remove Normal Twice and size decrease by 1")
	@Test
	void testRemoveExpectedTwiceAndReturnsEqualMapSize_Normal() {
		attributes = dao.getAll();
		int size = attributes.size();
		dao.remove(normal);
		attributes = dao.getAll();
		dao.remove(normal);
		attributes = dao.getAll();
		assertEquals(size-1, attributes.size());
	}
	
	@DisplayName("Test Remove Special Twice and size decrease by 1")
	@Test
	void testRemoveExpetedTwiceAndReturnsEqualMapSize_Special() {
		attributes = dao.getAll();
		int size = attributes.size();
		dao.remove(special);
		attributes = dao.getAll();;
		dao.remove(special);
		attributes = dao.getAll();;
		assertEquals(size-1, attributes.size());
	}
	
	@DisplayName("Test Remove NullAttribute 'Object' and size decrease by 0")
	@Test
	void testRemoveWithNullAttributeAndReturnsEqualMapSize() {
		attributes = dao.getAll();
		int size = attributes.size();
		AttributeI expected = new NullAttribute();
		dao.remove(expected);
		attributes = dao.getAll();;
		assertEquals(size, attributes.size());
	}
	
	@DisplayName("Remove Attribute as Null and returns size decrease by 0 && Throws")
	@Test
	void testRemoveNullAndDecresaseSizeByZero() {
		attributes = dao.getAll();
		int size = attributes.size();
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.remove(null);			
		});
		attributes = dao.getAll();
		assertEquals(size, attributes.size());
		assertEquals("Attribute cannot be removed due to Null!", e.getMessage());
	}
}
