/**
 * 
 */
package com.anno.dw8xl.weapon.facade;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.weapon.dao.WeaponDAOInterface;
import com.anno.dw8xl.weapon.model.WeaponI;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Service("weaponFacade")
public class WeaponFacade implements WeaponFacadeInterface {

	@Autowired
	private WeaponDAOInterface dao;
	
	@Override
	public Collection<WeaponI> getAllWeapons() {
		return dao.getAll();
	}

}
