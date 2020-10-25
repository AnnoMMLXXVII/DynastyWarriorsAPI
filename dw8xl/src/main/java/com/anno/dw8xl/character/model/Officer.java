/**
 * 
 */
package com.anno.dw8xl.character.model;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.TypeI;

/**
 * @author Haku Wei
 *
 */
public class Officer extends Character {

	private TypeI type;
	
	public Officer() {
	}
	
	/**
	 * @param name
	 * @param kingdom
	 * @param type
	 */
	public Officer(String name, KingdomI kingdom, TypeI type) {
		super(name, kingdom);
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
		return super.toString() + ", " + type.toString();
	}
	
	
}
