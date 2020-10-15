package com.dw8xl.restdw8xl.dao;

import java.util.List;

import com.dw8xl.restdw8xl.model.weapon.WeaponI;

/**
 * @author Haku Wei
 *
 */
public interface WeaponDaoI {

	public List<WeaponI> getAllWeapons();
	public WeaponI getWeapon(String name);
	public void updateWeapon(WeaponI weapon);
	public void deleteWeapon(WeaponI weapon);
}
