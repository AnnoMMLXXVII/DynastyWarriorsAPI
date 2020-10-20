package com.anno.dw8xl.attribute.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.Normal;
import com.anno.dw8xl.attribute.model.Special;

class AttributeDAOTest {

	private static AttributeDAO_I dao;
	private AttributeI normal, special;
	private long before, after;

	@BeforeEach
	void setUp() throws Exception {
		dao = AttributeDAO.getInstance();
		normal = new Normal("Velocity", "Raises overall attack speed");
		special = new Special("Awareness", "Can block attacks from the rear");
		before = System.nanoTime();
	}

	@AfterEach
	void breakDown() {
		after = System.nanoTime();
		System.out.printf("Time :\t%8dns\n", (after - before));
	}

	@DisplayName("Normals !Empty")
	@Test
	void testNormalAttributesListIsNOTEmpty() {
		List<AttributeI> attributes = dao.getNormalAttributes();
		assertTrue(!attributes.isEmpty());
	}

	@DisplayName("Specials !Empty")
	@Test
	void testSpecialAttributesListIsNOTEmpty() {
		List<AttributeI> attributes = dao.getSpecialAttributes();
		assertTrue(!attributes.isEmpty());
	}

	@DisplayName("Normals size is 37")
	@Test
	void testNormalAttributeListSizeIsEqualToExpected() {
		List<AttributeI> attributes = dao.getNormalAttributes();
		assertEquals(37, attributes.size());
	}

	@DisplayName("Specials size is 13")
	@Test
	void testSpecialAttributeListSizeIsEqualToExpected() {
		List<AttributeI> attributes = dao.getSpecialAttributes();
		assertEquals(13, attributes.size());
	}

	@DisplayName("All Attributes !Empty")
	@Test
	void testGetAllAttributes() {
		List<AttributeI> attributes = dao.getAllAttributes();
		assertEquals(50, attributes.size());
	}

	@DisplayName("Normals contains Velocity")
	@Test
	void testNormalAttributesListContainsExpected() {
		List<AttributeI> attributes = dao.getNormalAttributes();
		assertTrue(attributes.contains(normal));
	}

	@DisplayName("Specials contains Awareness")
	@Test
	void testSpecialAttributesListContainsExpected() {
		List<AttributeI> attributes = dao.getSpecialAttributes();
		assertTrue(attributes.contains(special));
	}

	@DisplayName("Normals value [Inferno] is NORMAL Type")
	@Test
	void testNormalAttributeTypeIsNormal() {
		List<AttributeI> attributes = dao.getNormalAttributes();
		AttributeI actual = attributes.stream().filter(e -> e.getName().equals("Inferno")).findAny().get();
		assertEquals("NORMAL", actual.getType().toString());
	}

	@DisplayName("Specials value [Fury] is SPECIAL Type")
	@Test
	void testSpecialAttributeTypeIsSpecial() {
		List<AttributeI> attributes = dao.getSpecialAttributes();
		AttributeI actual = attributes.stream().filter(e -> e.getName().equals("Fury")).findAny().get();
		assertEquals("SPECIAL", actual.getType().toString());
	}

	@DisplayName("Normal Velocity equals Expected")
	@Test
	void testgetAttriubteByNameNormal() {
		AttributeI actual = dao.getAttributeByName("Velocity");
		assertEquals(normal, actual);
	}

	@DisplayName("Special Awareness equals Expected")
	@Test
	void testgetAttriubteByNameSpecial() {
		AttributeI actual = dao.getAttributeByName("Awareness");
		assertThat(special).isEqualTo(actual);
	}

	@DisplayName("Normals remove Velocity")
	@Test
	void testRemoveNormalAttribute() {
		List<AttributeI> attributes = dao.getNormalAttributes();
		dao.removeAttribute(normal);
		attributes = dao.getNormalAttributes();
		assertFalse(attributes.contains(normal));
	}

	@DisplayName("Specials remove Awareness")
	@Test
	void testRemoveSpecialAttribute() {
		List<AttributeI> attributes = dao.getSpecialAttributes();
		dao.removeAttribute(special);
		attributes = dao.getSpecialAttributes();
		assertFalse(attributes.contains(special));
	}

	@DisplayName("Specials adds newly Created [Void]")
	@Test
	void testCreateSpecialAttribute_Pass() {
		List<AttributeI> attributes = dao.getSpecialAttributes();
		AttributeI expected = new Special("Void", "Shall Nullify Enemy Officer's attack by 50%");
		dao.createAttribute(expected);
		attributes = dao.getSpecialAttributes();
		assertEquals(14, attributes.size());
		assertTrue(attributes.contains(expected));
	}

	@DisplayName("Normals adds newly Created [Void]")
	@Test
	void testCreateNormalAttribute_Pass() {
		List<AttributeI> attributes = dao.getNormalAttributes();
		AttributeI expected = new Normal("Void", "Shall Nullify Enemy Officer's attack by 50%");
		dao.createAttribute(expected);
		attributes = dao.getNormalAttributes();
		assertEquals(38, attributes.size());
		assertTrue(attributes.contains(expected));
	}

	@DisplayName("Specials FAILS to adds newly Created - EMPTY")
	@Test
	void testCreateSpecialAttribute_FAIL_onEmpty() {
		List<AttributeI> attributes = dao.getSpecialAttributes();
		AttributeI expected = new Special("", "");
		dao.createAttribute(expected);
		attributes = dao.getSpecialAttributes();
		assertEquals(13, attributes.size());
		assertFalse(attributes.contains(expected));
	}

	@DisplayName("Normals FAILS to adds newly Created - EMPTY")
	@Test
	void testCreateNormalAttribute_FAIL_onEmpty() {
		List<AttributeI> attributes = dao.getNormalAttributes();
		AttributeI expected = new Normal("", "");
		dao.createAttribute(expected);
		attributes = dao.getNormalAttributes();
		assertEquals(37, attributes.size());
		assertFalse(attributes.contains(expected));
	}

	@DisplayName("Specials FAILS to adds newly Created - NULL")
	@Test
	void testCreateSpecialAttribute_FAIL_onNUll() {
		List<AttributeI> attributes = dao.getSpecialAttributes();
		AttributeI expected = null;
		dao.createAttribute(expected);
		attributes = dao.getSpecialAttributes();
		assertEquals(13, attributes.size());
		assertFalse(attributes.contains(expected));
	}

	@DisplayName("Normals FAILS to adds newly Created - EMPTY")
	@Test
	void testCreateNormalAttribute_FAIL_onNull() {
		List<AttributeI> attributes = dao.getNormalAttributes();
		AttributeI expected = new Special("", "");
		dao.createAttribute(expected);
		attributes = dao.getNormalAttributes();
		assertEquals(37, attributes.size());
		assertFalse(attributes.contains(expected));
	}
}
