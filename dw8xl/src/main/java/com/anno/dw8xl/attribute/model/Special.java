/**
 * 
 */
package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.rarity.model.Rarity;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author Haku Wei
 *
 */
@JsonTypeName("S")
public class Special extends Attribute {	

	/**
	 * @param name
	 * @param description
	 */
	public Special(String name, String description) {
		super(name, description);
	}

	@Override
	public Rarity getType() {
		return Rarity.SPECIAL;
	}
	
	/**
	 * @return the id
	 */
//	public int getId() {
//		return super.id;
//	}

}
