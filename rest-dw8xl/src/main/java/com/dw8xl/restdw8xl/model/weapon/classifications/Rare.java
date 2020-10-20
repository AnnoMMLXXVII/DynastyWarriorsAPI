/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.classifications;

import java.util.List;

import com.dw8xl.restdw8xl.model.weapon.WeaponI;
import com.dw8xl.restdw8xl.model.weapon.affinity.AffinityI;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryI;
import com.dw8xl.restdw8xl.model.weapon.type.Type;

/**
 * @author Haku Wei
 *
 */
/**
 * @author Haku Wei
 *
 */
public class Rare extends Abnormal{
	/**
	 * 
	 */
	public Rare() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 * @param baseAttk
	 * @param affinity
	 * @param star
	 * @param type
	 */
	public Rare(String name, Integer baseAttk, AffinityI affinity, Integer star, Type type) {
		super(name, baseAttk, affinity, star, type);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param baseAttk
	 * @param affinity
	 * @param star
	 * @param type
	 * @param attributes
	 */
	public Rare(String name, Integer baseAttk, AffinityI affinity, Integer star, Type type,
			List<AttributeI> attributes) {
		super(name, baseAttk, affinity, star, type, attributes);
		// TODO Auto-generated constructor stub
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
	public Rare(String name, Integer baseAttk, AffinityI affinity, Integer star, Type type, List<AttributeI> attributes,
			CategoryI category) {
		super(name, baseAttk, affinity, star, type, attributes, category);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public WeaponI getInstance() {
		return this;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	

	
}
