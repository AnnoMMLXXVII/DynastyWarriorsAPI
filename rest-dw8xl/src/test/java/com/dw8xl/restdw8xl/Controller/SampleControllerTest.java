/**
 * 
 */
package com.dw8xl.restdw8xl.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Haku Wei
 *
 */
class SampleControllerTest {

	private SampleController dao;
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
		dao = new SampleController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void testOfficerIsNotNull() {
		assertNotNull(dao.getOfficer());
	}
	
	@Test
	void testOfficerNameEqualsExpected() {
		assertEquals("Zhao Yun", dao.getOfficer().getName());
	}
	
	@Test
	void testOfficerKingdomEqualsExpected() {
		assertEquals("Shu", dao.getOfficer().getDynasty().getName());
	}
	
//	@Test
//	void testOfficerWeaponNameEqualsExpected() {
//		assertEquals("Dark Dragon Spear", dao.getOfficer().getWeapon().getName());
//	}
//	
//	@Test
//	void testOfficerWeaponAttributeEqualsExpected() {
//		assertEquals("Thunder", dao.getOfficer().getWeapon().getAttributes().get(0).getAttribute());
//	}
//	
//	@Test
//	void testOfficerWeaponAttributeLevelEqualsExpected() {
//		assertEquals(10, dao.getOfficer().getWeapon().getAttributes().get(1).getLevel().getLevel());
//	}
//	
//	@Test
//	void testOfficerWeaponStarEqualsExpected() {
//		assertEquals(6, dao.getOfficer().getWeapon().getStar());
//	}
	
	
	

}
