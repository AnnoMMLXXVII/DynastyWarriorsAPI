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
/**
 * @author Haku Wei
 *
 */
public abstract class Character implements CharacterI {

	private String name;
	private KingdomI dynasty;
	
	public Character(String name, KingdomI dynasty) {
		this.name = name;
		this.dynasty = dynasty;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setDynasty(KingdomI dynasty) {
		this.dynasty = dynasty;
	}

	@Override
	public KingdomI getDynasty() {
		// TODO Auto-generated method stub
		return dynasty;
	}


	public abstract WeaponI getWeapon();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dynasty == null) ? 0 : dynasty.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (dynasty == null) {
			if (other.dynasty != null)
				return false;
		} else if (!dynasty.equals(other.dynasty))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", dynasty=" + dynasty + "]";
	}

	
	
}
