/**
 * 
 */
package com.dw8xl.restdw8xl.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.service.mock.mapper.SubOfficerMapper;
import com.dw8xl.restdw8xl.service.mock.mapper.SubOfficerMapperI;

/**
 * @author Haku Wei
 *
 */
@SpringBootTest
@Transactional
class SubOfficerDaoIntegrationTest {

	@Autowired 
	private SubOfficerMapperI mapper;
	
	
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
		mapper = new SubOfficerMapper();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReturnedList() {
		List<CharacterI> subs = mapper.queryAllSubOfficers();
		assertNotNull(subs);
	}

}
