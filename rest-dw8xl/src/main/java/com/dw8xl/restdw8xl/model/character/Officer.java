/**
 * 
 */
package com.dw8xl.restdw8xl.model.character;

import com.dw8xl.restdw8xl.model.kingdom.KingdomI;
import com.dw8xl.restdw8xl.model.weapon.Weapon;
import com.dw8xl.restdw8xl.model.weapon.WeaponI;

/**
 * @author Haku Wei
 *
 */
public class Officer extends Character{

	private WeaponI weapon;

	/**
	 * @param name
	 * @param dynasty
	 * @param weapon
	 */
	public Officer(String name, KingdomI dynasty, WeaponI weapon) {
		super(name, dynasty);
		this.weapon = weapon;
	}

	@Override
	public WeaponI getWeapon() {
		return weapon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Officer other = (Officer) obj;
		if (weapon == null) {
			if (other.weapon != null)
				return false;
		} else if (!weapon.equals(other.weapon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Officer [weapon=" + weapon + "]";
	}

	
	
	
}
