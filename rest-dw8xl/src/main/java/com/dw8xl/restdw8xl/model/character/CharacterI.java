/**
 * 
 */
package com.dw8xl.restdw8xl.model.character;

import com.dw8xl.restdw8xl.model.kingdom.KingdomI;
import com.dw8xl.restdw8xl.model.weapon.WeaponI;

/**
 * @author Haku Wei
 *
 */
public interface CharacterI {
	
	public void setName(String name);
	public String getName();
	
	public void setDynasty(KingdomI dynasty);
	public KingdomI getDynasty();
	
	public abstract WeaponI getWeapon();

}
