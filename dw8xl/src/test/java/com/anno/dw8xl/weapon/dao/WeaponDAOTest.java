/**
 * 
 */
package com.anno.dw8xl.weapon.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.weapon.model.WeaponI;

/**
 * @author venividivicihofneondeion010101
 *
 */
class WeaponDAOTest {

	private WeaponDAOInterface dao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dao = WeaponDAO.getInstance();
	}

	@DisplayName("Get all Weapons...")
	@Test
	void test() {
		Collection<WeaponI> weapons = dao.getAll();
		weapons.stream().forEach(e -> {
			System.out.printf("%s, %s, %s, %s, %s\n",
					e.getName(), e.getBaseAttack(), e.getLength(), e.getStar(), e.getType().getName());
		});
		assertEquals(156, weapons.size());
	}

}
