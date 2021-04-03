/**
 * 
 */
package com.dw8xl.restdw8xl.model.character;

import com.dw8xl.restdw8xl.model.kingdom.KingdomI;
import com.dw8xl.restdw8xl.model.weapon.type.Type;
import com.dw8xl.restdw8xl.model.weapon.type.TypeI;

/**
 * @author Haku Wei
 *
 */
/**
 * @author Haku Wei
 *
 */
public class Officer extends Character {

	private TypeI type;

	/**
	 * @param name
	 * @param dynasty
	 * @param weapon
	 */
	public Officer(String name, KingdomI dynasty, Type type) {
		super(name, dynasty);
		this.type = type;
	}

	@Override
	public TypeI getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Officer " +type;
	}
	
	

	
}
