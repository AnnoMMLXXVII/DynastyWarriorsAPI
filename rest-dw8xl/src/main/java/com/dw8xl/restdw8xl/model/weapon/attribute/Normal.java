/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.attribute;

import com.dw8xl.restdw8xl.model.weapon.attribute.level.LevelI;

/**
 * @author Haku Wei
 *
 */
public class Normal extends Attribute {

	/**
	 * @param attribute
	 */
	public Normal(String attribute) {
		super(attribute);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param attribute
	 * @param level
	 */
	public Normal(String attribute, LevelI level) {
		super(attribute, level);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param attribute
	 * @param description
	 * @param level
	 */
	public Normal(String attribute, String description, LevelI level) {
		super(attribute, description, level);
		// TODO Auto-generated constructor stub
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
