/**
 * 
 */
package com.dw8xl.restdw8xl.model.character;

import com.dw8xl.restdw8xl.model.kingdom.KingdomI;
import com.dw8xl.restdw8xl.model.weapon.Weapon;

/**
 * @author Haku Wei
 *
 */
public interface CharacterI {
	
	public void setName(String name);
	public String getName();
	
	public abstract void setDynasty(KingdomI dynasty);
	public abstract KingdomI getDynasty();
	
	public void setWeapon(Weapon weapon);
	public Weapon getWeapon();
}
