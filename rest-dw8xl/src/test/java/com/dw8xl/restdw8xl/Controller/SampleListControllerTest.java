/**
 * 
 */
package com.dw8xl.restdw8xl.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.model.character.SubOfficer;
import com.dw8xl.restdw8xl.model.kingdom.Kingdom;

/**
 * @author Haku Wei
 *
 */
class SampleListControllerTest {

	private SampleListController dao;
	private List<CharacterI> mockSubOfficers;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dao = new SampleListController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	/**
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testparseThroughFileByKingdom() {
		mockSubOfficers = dao.parseThroughSubOfficerTextFileByKingdom(new Kingdom("Jin"));
		assertTrue(mockSubOfficers.size() > 0);
	}
	
	@Test
	void testGetSubOfficerByName() {
		CharacterI temp = new SubOfficer("Chen Jun", new Kingdom("Jin"));
		mockSubOfficers = dao.parseThroughSubOfficerTextFileByKingdom(new Kingdom("Jin"));
		assertTrue(mockSubOfficers.contains(temp));
	}
	
	@Test
	void testGetOfficerByWildcardSearch() {
		String expected = "Jin";
		mockSubOfficers = dao.parseThroughMultipleSubOfficersTextFiles();
		List<CharacterI> wildCardSubOfficers = dao.getSubOfficersByWildCard(expected);
//		wildCardSubOfficers.stream().forEach(so -> {
//			String name = so.getName();
//			String dyn = so.getDynasty().getName();
//			System.out.printf("%s, %s\n", name, dyn);
//		});
		 assertTrue(wildCardSubOfficers.size() > 0);
	}
	
	@Test
	void testGetAllSubOfficers() {
		mockSubOfficers = dao.parseThroughMultipleSubOfficersTextFiles();
		assertTrue(mockSubOfficers.size() > 0);
		Collections.sort(mockSubOfficers, (s1, s2) -> s1.getName().compareTo(s2.getName()));
		mockSubOfficers.stream().forEach(so -> {
			String name = so.getName();
			String dyn = so.getDynasty().getName();
			System.out.printf("(\"%s\", \"%s\"),\n", name, dyn);
		});
	}
	

}
