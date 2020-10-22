/**
 * 
 */
package com.anno.dw8xl.kingdom.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.kingdom.model.KingdomI;

/**
 * @author Haku Wei
 *
 */
class KingdomDaoImplTest {

	private KingdomDaoImpl impl;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		impl = new KingdomDaoImpl();
	}

	/**
	 * Test method for {@link com.anno.dw8xl.kingdom.dao.KingdomDaoImpl#getAllKingdoms()}.
	 */
	@Test
	void testGetAllKingdoms() {
		List<KingdomI> temps = impl.getAllKingdoms();
		assertTrue(temps.size() > 0);
	}

	/**
	 * Test method for {@link com.anno.dw8xl.kingdom.dao.KingdomDaoImpl#getKingdomByName(java.lang.String)}.
	 */
//	@Test
	void testGetKingdomByName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.anno.dw8xl.kingdom.dao.KingdomDaoImpl#addKingdom(com.anno.dw8xl.kingdom.model.Kingdom)}.
	 */
//	@Test
	void testAddKingdomKingdom() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.anno.dw8xl.kingdom.dao.KingdomDaoImpl#addKingdom(java.lang.String)}.
	 */
//	@Test
	void testAddKingdomString() {
		fail("Not yet implemented");
	}

}
