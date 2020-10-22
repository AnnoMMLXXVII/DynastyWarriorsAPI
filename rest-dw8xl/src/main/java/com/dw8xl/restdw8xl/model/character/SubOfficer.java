package com.dw8xl.restdw8xl.model.character;

import com.dw8xl.restdw8xl.model.kingdom.KingdomI;
import com.dw8xl.restdw8xl.model.weapon.type.TypeDNE;
import com.dw8xl.restdw8xl.model.weapon.type.TypeI;

/**
 * @author Haku Wei
 *
 */
/**
 * @author Haku Wei
 *
 */
public class SubOfficer extends Character {

	private String name;
	private KingdomI dynasty;
	
	public SubOfficer() {};
	
	/**
	 * @param name
	 * @param dynasty
	 */
	public SubOfficer(String name, KingdomI dynasty) {
		super(name, dynasty);
	}

	@Override
	public TypeI getType() {
		return new TypeDNE();
	}

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
		SubOfficer other = (SubOfficer) obj;
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
		return "SubOfficer [name=" + name + ", dynasty=" + dynasty + "]";
	}
	
	

}
