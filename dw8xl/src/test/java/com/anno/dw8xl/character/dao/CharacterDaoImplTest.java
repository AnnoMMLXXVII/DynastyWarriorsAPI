package com.anno.dw8xl.character.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.character.model.CharacterI;

class CharacterDaoImplTest {

	private CharacterDaoImpl impl;
	
	@BeforeEach
	void setUp() throws Exception {
		impl = new CharacterDaoImpl();
	}

	@Test
	void testIfPathsAreNull() {
		int size = impl.getAllSubOfficerTextFiles().length;
		assertTrue(size > 0);
	}
	
	@Test
	void testGetAllSubOfficers() {
		List<CharacterI> temp = impl.executeAllSubOfficers();
	}
	
	@Test
	void testGetShuSubOfficers() {
		List<CharacterI> temp = impl.executeShuSubOfficers();
		assertTrue(temp.size() > 0);	
	}

}
