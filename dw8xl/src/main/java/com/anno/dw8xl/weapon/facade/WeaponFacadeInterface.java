/**
 * 
 */
package com.anno.dw8xl.weapon.facade;

import java.util.Collection;
import java.util.List;

import com.anno.dw8xl.weapon.model.WeaponI;

/**
 * @author venividivicihofneondeion010101
 *
 */
public interface WeaponFacadeInterface {

	public Collection<WeaponI> getAllWeapons();

	public WeaponI parseWeaponObject(String weapon);

	public Collection<WeaponI> parseWeaponsList(List<WeaponI> weapons);

	public Collection<WeaponI> getFilteredWeapons(String filter, String value, String... option);

}
