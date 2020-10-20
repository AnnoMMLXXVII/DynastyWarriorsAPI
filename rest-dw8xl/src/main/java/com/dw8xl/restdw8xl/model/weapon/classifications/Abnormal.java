/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.classifications;

import java.util.List;

import com.dw8xl.restdw8xl.model.weapon.Weapon;
import com.dw8xl.restdw8xl.model.weapon.WeaponI;
import com.dw8xl.restdw8xl.model.weapon.affinity.AffinityI;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryI;
import com.dw8xl.restdw8xl.model.weapon.type.Type;

/**
 * @author Haku Wei
 *
 */
public abstract class Abnormal extends Weapon {

	private AffinityI affinity;
	private List<AttributeI> attributes;
	private CategoryI category;
	/**
	 * 
	 */
	public Abnormal() {}

	/**
	 * @param name
	 * @param baseAttk
	 * @param star
	 * @param type
	 */
	public Abnormal(String name, Integer baseAttk, AffinityI affinity, Integer star, Type type) {
		super(name, baseAttk, star, type);
		this.affinity = affinity;
	}
	
	/**
	 * @param name
	 * @param baseAttk
	 * @param affinity
	 * @param star
	 * @param type
	 * @param attributes
	 */
	public Abnormal(String name, Integer baseAttk, AffinityI affinity, Integer star, Type type, List<AttributeI> attributes) {
		super(name, baseAttk, star, type);
		this.affinity = affinity;
		this.attributes = attributes;
	}
	
	/**
	 * @param name
	 * @param baseAttk
	 * @param affinity
	 * @param star
	 * @param type
	 * @param attributes
	 * @param category
	 */
	public Abnormal(String name, Integer baseAttk, AffinityI affinity, Integer star, Type type, List<AttributeI> attributes, CategoryI category) {
		super(name, baseAttk, star, type);
		this.affinity = affinity;
		this.attributes = attributes;
		this.category = category;
	}

	@Override
	public AffinityI getAffinity() {
		return affinity;
	}

	
	public CategoryI getCategory() {
		return category;
	}

	@Override
	public List<AttributeI> getAttributes() {
		return attributes;
	}
	
	public abstract WeaponI getInstance();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((affinity == null) ? 0 : affinity.hashCode());
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
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
		Abnormal other = (Abnormal) obj;
		if (affinity == null) {
			if (other.affinity != null)
				return false;
		} else if (!affinity.equals(other.affinity))
			return false;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Abnormal [affinity=" + affinity + ", attributes=" + attributes + "]";
	}

}
