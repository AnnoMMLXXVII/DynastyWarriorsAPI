/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.classifications;

import java.util.ArrayList;
import java.util.List;

import com.dw8xl.restdw8xl.model.weapon.Weapon;
import com.dw8xl.restdw8xl.model.weapon.WeaponI;
import com.dw8xl.restdw8xl.model.weapon.affinity.AffinityDNE;
import com.dw8xl.restdw8xl.model.weapon.affinity.AffinityI;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryDNE;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryI;
import com.dw8xl.restdw8xl.model.weapon.length.Length;
import com.dw8xl.restdw8xl.model.weapon.type.Type;

/**
 * @author Haku Wei
 *
 */
public class Normal extends Weapon {

	private Length length;
	
	/**
	 * 
	 */
	public Normal() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 * @param baseAttk
	 * @param length
	 * @param star
	 * @param type
	 */
	public Normal(String name, Integer baseAttk, Length length, Integer star, Type type) {
		super(name, baseAttk, star, type);
		this.length = length;
	}

	@Override
	public AffinityI getAffinity() {
		return new AffinityDNE();
	}

	@Override
	public CategoryI getCategory() {
		return new CategoryDNE();
	}

	@Override
	public List<AttributeI> getAttributes() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	
	@Override
	public WeaponI getInstance() {
		return this;
	}

	/**
	 * @return the length
	 */
	public Length getLength() {
		return length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((length == null) ? 0 : length.hashCode());
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
		Normal other = (Normal) obj;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Normal [length=" + length + "]";
	}
	
}
