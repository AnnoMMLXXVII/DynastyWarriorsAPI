package com.anno.dw8xl.affinity.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.affinity.model.Affinity;
import com.anno.dw8xl.affinity.model.AffinityI;

class AffinityDAOTest {

	private AffinityDAO_I dao;
	private AffinityI expected;
	@BeforeEach
	void setUp() throws Exception {
		dao = AffinityDAO.getInstance();
		expected = new Affinity("Heaven");
	}

	@Test
	void testGetAllAffinities() {
		List<AffinityI> affinities = dao.getAllAffinities();
		assertEquals(3, affinities.size());
	}
	
	@Test
	void testGetAffinityByName() {
		AffinityI actual = dao.getAffinityByName("Heaven");
		assertEquals(expected, actual);
	}
	
	@Test
	void testUpdateAffinity() {
		List<AffinityI> affinities = dao.getAllAffinities();
		dao.updateAffinity("Heaven", "Heavens");
		assertEquals(3, affinities.size());
		affinities = dao.getAllAffinities();
		AffinityI temp = new Affinity("Heavens");
		assertEquals(3, affinities.size());
		assertTrue(affinities.contains(temp));
	}
	
	@Test
	void testDeleteAffinity() {
		List<AffinityI> affinities = dao.getAllAffinities();
		dao.removeAffinity("Heaven");
		affinities = dao.getAllAffinities();
		assertEquals(2, affinities.size());
	}
	
	@Test
	void testCreateAffinity() {
		List<AffinityI> affinities = dao.getAllAffinities();
		dao.createAffinity("Void");
		affinities = dao.getAllAffinities();
		assertEquals(4, affinities.size());
	}
	

}
