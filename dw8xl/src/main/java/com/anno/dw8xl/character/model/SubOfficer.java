/**
 * 
 */
package com.anno.dw8xl.character.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.NullType;
import com.anno.dw8xl.type.model.TypeI;

/**
 * @author Haku Wei
 *
 */
@Component
public class SubOfficer extends Character {
	
	public SubOfficer() {}

	/**
	 * @param name
	 * @param kingdom
	 */
	public SubOfficer(String name, KingdomI kingdom) {
		super(name, kingdom);
	}

	@Override
	public TypeI getType() {
		return new NullType();
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